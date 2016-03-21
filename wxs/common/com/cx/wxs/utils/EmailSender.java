package com.cx.wxs.utils;



import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;



/***
 * 邮件发送工具
 * @author 陈义
 *
 * @date   2015-11-25
 */
public class EmailSender {
	private static Logger logger = Logger.getLogger(EmailSender.class);
	private Session session;
	private Message message;
	private MimeMultipart multipart;
	private String user;
	private String pass;
	private String smtp;
	private String port;
	private String[] receiver;
	public EmailSender(){

	}
	/**
	 * 实例化邮件工具类
	 * @param user 邮件账号
	 * @param pass 邮件密码
	 * @param smtp smtp服务器
	 * @param port 端口号
	 */
	public EmailSender(String  user, String pass, String smtp, String port) {
		this.user = user;
		this.pass = pass;
		this.smtp = smtp;
		this.port = port;
	}
	/***
	 * 
	 * @param user 发件人账号
	 * @param pass 密码
	 * @param smtp SMTP服务器
	 * @param port 端口
	 * @param receiver 收件人列表
	 */
	public EmailSender(String user, String pass, String smtp, String port,
			String[] receiver) {
		this.user = user;
		this.pass = pass;
		this.smtp = smtp;
		this.port = port;
		this.receiver = receiver;
	}
	/**
	 * 初始化邮件属性基本信息
	 */
	public void initProperties(){
		Properties props = new Properties();
		//邮件服务器 
		props.setProperty("mail.smtp.host", this.smtp);
		//邮件服务器端口
		props.setProperty("mail.smtp.port", this.port);
		props.setProperty("mail.smtp.auth", "true");//是否验证
		this.session = Session.getInstance(props);
		this.message = new MimeMessage(session);
		this.multipart = new MimeMultipart("mixed");
		MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
        mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
        CommandMap.setDefaultCommandMap(mc);
	}

	/**
	 * 设置收件人
	 */
	public void setReceiver(){
		try {
			Address[] address = new InternetAddress[receiver.length];
			for (int i = 0; i < receiver.length; i++) {
				address[i] = new InternetAddress(receiver[i]);
			}
			this.message.setRecipients(Message.RecipientType.TO, address);
		} catch (AddressException e) {
			logger.info("AddressException---设置收件人异常："+e.getMessage());
		} catch (MessagingException e) {
			logger.info("MessagingException---设置收件人异常："+e.getMessage());
		}
	}
	
	/***
	 *  设置邮件发送内容
	 * @param title 邮件标题
	 * @param content  邮件内容
	 * @author 陈义
	 * @throws UnsupportedEncodingException 
	 * @date   2015-11-25下午4:39:48
	 */
	public void setMessage(String title,String content) throws UnsupportedEncodingException{
		try {
			//设置发信人
			String nick="";
			nick=javax.mail.internet.MimeUtility.encodeText("文学社平台");
			this.message.setFrom(new InternetAddress(nick+"<"+this.user+">"));
			//设置标题
			this.message.setSubject(title);
			//设置邮件内容,纯文本的话用setText()就行，但有附件就显示不出来内容
			MimeBodyPart body = new MimeBodyPart();
			body.setContent(content,"text/html;charset=utf-8");
			this.multipart.addBodyPart(body);
		} catch (AddressException e) {
			logger.info("AddressException---设置发信件内容信息异常："+e.getMessage());
		} catch (MessagingException e) {
			logger.info("MessagingException---设置发信件内容信息异常："+e.getMessage());
		}
	}
	/***
	 * 发送邮件
	 * @return 成功返回ture，失败返回flase
	 * @author 陈义
	 * @date   2015-11-25下午4:38:35
	 */
	public boolean sendEmail(){
		try {
			
			//发送时间
			this.message.setSentDate(new Date());
			//发送的内容，文本和附件
			this.message.setContent(this.multipart);
			this.message.saveChanges();
			//创建邮件发送对象，并指定其使用SMTP协议发送邮件  
			Transport transport = this.session.getTransport("smtp");
			//连接、登录邮箱
			transport.connect(this.smtp,this.user,this.pass);
			Address[] addresses = this.message.getAllRecipients();
			if(addresses!=null&&addresses.length>0){
				//发送邮件
				transport.sendMessage(this.message,addresses);
			}
			//关闭、退出邮箱
			transport.close();
			return true;
		} catch (NoSuchProviderException e) {
			logger.info("NoSuchProviderException---发送邮件异常："+e.getMessage());
		} catch (MessagingException e) {
			logger.info("MessagingException---发送邮件异常："+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	/***
	 * 设置邮件地址
	 * @param user
	 * @author 陈义
	 * @date   2015-11-25下午4:37:51
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/***
	 * 设置发件人密码
	 * @param pass
	 * @author 陈义
	 * @date   2015-11-25下午4:37:28
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	/***
	 * 设置STMP服务器
	 * @param smtp
	 * @author 陈义
	 * @date   2015-11-25下午4:36:57
	 */
	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}
	/***
	 * 设置端口
	 * @param port
	 * @author 陈义
	 * @date   2015-11-25下午4:32:07
	 */
	public void setPort(String port) {
		this.port = port;
	}
	/***
	 * 设置收件人列表
	 * @param receiver
	 * @author 陈义
	 * @date   2015-11-25下午4:36:27
	 */
	public void setReceiver(String[] receiver) {
		this.receiver = receiver;
	}

	public static  void main(String[] avg) throws IOException{
     
	}
}

