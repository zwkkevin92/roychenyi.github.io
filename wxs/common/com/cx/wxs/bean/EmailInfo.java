package com.cx.wxs.bean;

/**
 *邮件信息
 * @author 陈义
 * @date   2016-3-20 下午8:18:35
 */
public class EmailInfo {

	private String title;   //标题
	private String content;   //内容
	private String[] receiver;  //接收者
	public EmailInfo() {}

	public EmailInfo(String title, String content, String[] receiver) {
		this.title = title;
		this.content = content;
		this.receiver = receiver;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String[] getReceiver() {
		return receiver;
	}
	public void setReceiver(String[] receiver) {
		this.receiver = receiver;
	}
	
}
