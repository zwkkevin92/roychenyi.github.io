package com.cx.wxs.servlet;



import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
* 邮件传输队列
* 所有待发送的邮件都通过该类写入队列，有专门的邮件传输线程负责发送
* TODO: 实现二级队列: 内存以及磁盘,以加快处理效率
* @author 陈义
* @date   2015-11-25 下午5:12:06
*/
public class MailTransportQueue {
	private final static Log log = LogFactory.getLog(MailTransportQueue.class);
	
	private final static String EML = ".eml";
	private final static String ERR = ".err";

	private static MailTransportQueue queue;
	
	/**
	 * 获取邮件传输队列的实例
	 * @param path
	 * @return
	 */
	public synchronized final static MailTransportQueue getInstance(String path){
		if(queue == null){
			queue = new MailTransportQueue(path);
		}
		return queue;
	}
	
	private String path; //队列所在的目录
	
	protected MailTransportQueue(String path){
		this.path = path;
		if(this.path.endsWith(File.separator))
			this.path += File.separator;
		File f = new File(this.path);
		if(!f.exists())
			f.mkdirs();
	}
	
	/**
	 * 写入待发邮件到队列中
	 * @param sid
	 * @param mail
	 * @return 返回邮件在队列中的文件名(唯一标识)
	 * @throws IOException 
	 * @throws MessagingException 
	 */
	public String write(int sid, MimeMessage mail) throws IOException, MessagingException{
		int tryCount = 0;
		do{
			StringBuffer fn = new StringBuffer(path);
			fn.append(System.currentTimeMillis());
			fn.append('_');
			fn.append(sid);
			fn.append(EML);
			File f = new File(fn.toString());
			if(f.exists()){
				tryCount ++;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					break;
				}
			}
			else if(f.createNewFile()){
				FileOutputStream fos = new FileOutputStream(f);
				try{
					mail.writeTo(fos);
					return f.getPath();
				}finally{
					fos.close();
				}
			}
			break;
		}while(tryCount < 10);
		
		return null;
	}
	
	/**
	 * 从队列中取待发邮件
	 * @param mails 输入参数,用于返回待发邮件
	 * @param ident 输入参数,用于返回对应邮件的标识
	 * @param max_count 最多返回多少邮件
	 * @return 返回队列中邮件总数
	 * @throws IOException 
	 */
	public int read(Session ssn, List<MimeMessage> mails, List<String> ident, int max_count) throws IOException{
		File fs = new File(path);
		File[] mailfiles = fs.listFiles(new FileFilter(){
			public boolean accept(File f) {
				if(f.length() > 0 && f.getName().endsWith(EML))
					return true;
				return false;
			}});
		if(mails!=null){
			for(int i=0;i<mailfiles.length&&i<max_count;i++){
				FileInputStream fis = null;
				try{
					fis = new FileInputStream(mailfiles[i]);
					mails.add(new MimeMessage(ssn, fis));
					if(ident!=null)
						ident.add(mailfiles[i].getPath());
					fis.close();
					fis = null;
					mailfiles[i].delete();
				}catch(MessagingException e){
					String newfile = mailfiles[i].getPath() + ERR;
					mailfiles[i].renameTo(new File(newfile));
					log.error("mail cache file destroy, rename to " + newfile, e);
				}catch(IOException e){
					String newfile = mailfiles[i].getPath() + ERR;
					mailfiles[i].renameTo(new File(newfile));
					log.error("IO Exception when read mail cache , rename to " + newfile, e);
				}finally{
					if(fis!=null)
						fis.close();
				}
			}
		}
		return mailfiles.length;		
	}
		
	/**
	 * 返回队列中待发邮件数
	 * @return
	 */
	public int queueSize(){
		File fs = new File(path);
		try{
			return fs.list(fnFilter).length;
		}finally{
			fs = null;
		}
	}
	
	/**
	 * 邮件缓存文件过滤器
	 * @see com.liusoft.dlog4j.MailTransportQueue#queueSize()
	 */
	private static FilenameFilter fnFilter = new FilenameFilter(){
		public boolean accept(File path, String fn) {
			return fn.endsWith(EML);
		}};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

