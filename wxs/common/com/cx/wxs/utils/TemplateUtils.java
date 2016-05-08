package com.cx.wxs.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * 获取发送验证邮箱的一些的模板
 * @author 陈义
 * @date   2016-3-24 上午10:26:11
 */
public class TemplateUtils {
	/***
	 * 获取html模板的内容
	 * @param tmp  模板文件的路径
	 * @return
	 * @throws IOException
	 * @author 陈义
	 * @throws FileNotFoundException 
	 * @date   2016-3-24上午10:27:37
	 */
	public static String getTemplate(String tmp) {
		
//		ServletContext sc = getServlet().getServletContext();
		 String path=Thread.currentThread().getContextClassLoader().getResource("").toString();  
		 String osStr=getOSinfo();
		 if(osStr.startsWith("Linux")){
			 path=path.replace("file:", ""); //去掉file:  
			 path=path.replace("classes/", "");
//			 path=path.substring(1);
			 tmp=path+tmp;
		 }else if(osStr.startsWith("Windows")){			 
			 path=path.replace('/', '\\'); // 将/换成\  
			 path=path.replace("file:", ""); //去掉file:  
			 path=path.replace("classes\\", "");
			 path=path.substring(1);
			 tmp=path+tmp;
		 }
		File file=new File(tmp);
		StringBuffer template = new StringBuffer(512);
		if(file.exists()&&file.isFile()){		
			try{
			InputStream in = new FileInputStream(file);
			BufferedReader reader = null;
			try{
				reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
				do{
					String line = reader.readLine();
					if(line==null)
						break;
					template.append(line);
					template.append("\r\n");
				}while(true);
			}finally{
				if(in!=null){
					try{
						in.close();
					}catch(Exception e){}
				}
				if(reader!=null){
					try{
						reader.close();
					}catch(Exception e){}
				}
			}}catch(Exception e){
				e.printStackTrace();
			}
			return template.toString();
		}else{
			System.out.println("未找到该文件");
			return template.toString();
		}
		
	}
	
	/**
	 * 获取忘记密码提示内容模板
	 * @return
	 * @throws IOException
	 */
	public static String getPasswordTipTemplate() {
		return getTemplate("vm/conf/password_tip.html");
		
	}

	/***
	 * 注册邮箱验证模板
	 * @return
	 * @author 陈义
	 * @date   2016-3-24上午10:44:51
	 */
	public static String getRegisterCheckTemplate(){
		return getTemplate("vm/conf/register_check.html");
	}
	/***
	 * 信息提醒，系统提醒网站的内容推荐
	 * @return
	 * @author 陈义
	 * @date   2016-3-24上午10:47:58
	 */
	public static String getInfoRemindTemplate(){
		return getTemplate("/WEB-INF/vm/conf/info_remind.html");
	}
	/***
	 * 消息提醒，提示一些重要的消息
	 * @return
	 * @author 陈义
	 * @date   2016-3-24上午10:51:31
	 */
	public static  String getMessageRemindTemplate(){
		return getTemplate("vm/conf/message_remind.html");
	}
	/**
	 * 获取系统信息
	 * @author 陈义
	 * @date   2016年5月8日 下午7:53:25
	 * @return
	 */
	public  static String getOSinfo(){
		return System.getProperty("os.name");
	}
   
	
	public static void main(String avg[]){
		

		TemplateUtils templateUtils=new TemplateUtils();
		System.out.println(templateUtils.getOSinfo());
		System.out.println(templateUtils.getMessageRemindTemplate());
		String template=templateUtils.getRegisterCheckTemplate();
		String notify_content = MessageFormat.format(template,
				"陈怡", "2", "3");
		System.out.println(notify_content);
	}
}
