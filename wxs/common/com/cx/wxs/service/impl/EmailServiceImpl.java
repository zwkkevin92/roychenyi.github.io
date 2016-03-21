package com.cx.wxs.service.impl;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.cx.wxs.bean.EmailDto;
import com.cx.wxs.bean.EmailInfo;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.enums.EmailType;
import com.cx.wxs.service.EmailService;
import com.cx.wxs.utils.EmailSender;



/**
 * @author 陈义
 * @date   2016-3-20 下午8:21:08
 */
@Service("emailService")
public class EmailServiceImpl implements EmailService{

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.EmailService#sendEmail(com.cx.wxs.dto.UUserDto, com.cx.wxs.bean.EmailInfo)
	 */
	@Override
	public void sendEmail(final EmailInfo emailInfo) {
		// TODO Auto-generated method stub
		final EmailDto eUsersDto = getEmail();
		if(eUsersDto!=null){
			//开启一个线程，去发送邮件
			new Thread(new Runnable() {

				@Override
				public void run() {
					EmailSender eSender = new EmailSender(
							eUsersDto.getEuser(),eUsersDto.getEpwd(), 
							eUsersDto.getSmtp(),eUsersDto.getPort().toString(),
							emailInfo.getReceiver());
					eSender.initProperties();//初始化邮件配置，注意，调用此函数前，必须传入发送邮件的账号及密码
					eSender.setReceiver();//设置收件人信息，注意，调用此函数前，收件人列表必须不能为空
					try {
						eSender.setMessage(emailInfo.getTitle(), emailInfo.getContent());
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					eSender.sendEmail();
				}
			}).start();
		}
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.EmailService#sendEmail(java.lang.String, java.lang.String[], java.lang.String, com.cx.wxs.enums.EmailType)
	 */
	@Override
	public void sendEmail(String title, String[] receivers, String content,
			EmailType service) {
		// TODO Auto-generated method stub
		EmailDto emailDto=new EmailDto();
		
		emailDto.setEmailType(service);
		EmailInfo emailInfo = new EmailInfo();
		emailInfo.setContent(content);
		emailInfo.setReceiver(receivers);
		emailInfo.setTitle(title);
		sendEmail(emailInfo);
		
	}

	
	@Override
	public EmailDto getEmail() {
		// TODO Auto-generated method stub
		String path="/email.properties";
		InputStream in = getClass().getResourceAsStream(path);
		Properties properties=new Properties();
		EmailDto emailDto=new EmailDto();
		try{
		properties.load(in);
	    emailDto.setEuser(properties.getProperty("mail.username"));
	    emailDto.setEpwd(properties.getProperty("mail.password"));
	    emailDto.setSmtp(properties.getProperty("mail.smtp"));
	    emailDto.setPort(Integer.parseInt(properties.getProperty("mail.port")));
	    return emailDto;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] avg){
		EmailServiceImpl e=new EmailServiceImpl();
		String[] str=new String[]{"852416288@qq.com"};
		e.sendEmail("测试", str, "测试测试！！！！<a href='www.baidu.com'>nihao<a/>", EmailType.SYSTEM);
	}

}
