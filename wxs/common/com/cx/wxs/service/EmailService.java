package com.cx.wxs.service;

import com.cx.wxs.bean.EmailDto;
import com.cx.wxs.bean.EmailInfo;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.enums.EmailType;



public interface EmailService {
	/***
	 * 
	 * @param uuserDto  收件人的信息
	 * @param emailInfo 邮件内容
	 * @author 陈义
	 * @date   2016-3-20下午8:11:07
	 */
	public void sendEmail(final EmailInfo emailInfo);


	/***
	 * 发送右键
	 * @param title  标题
	 * @param receivers  接受者
	 * @param content   内容
	 * @param service    邮件类型
	 * @author 陈义
	 * @date   2016-3-20下午8:22:09
	 */
	public void sendEmail(String title, String[] receivers, String content,EmailType service);
		
	/***
	 * 获取右键发送的基本信息
	 * @return
	 * @author 陈义
	 * @date   2016-3-20下午8:42:35
	 */
	public  EmailDto getEmail();
	
}
