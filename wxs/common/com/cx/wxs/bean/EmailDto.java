package com.cx.wxs.bean;

import com.cx.wxs.enums.EmailType;



/**
 * @author 陈义
 * @date   2016-3-20 下午8:33:59
 */
public class EmailDto {

	private Integer eid;
	private String euser;
	private String epwd;
	private String smtp;
	private Integer port;
	private Integer time;
	private String remark;
	private String type;
	private EmailType emailType;
	
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	
	public String getSmtp() {
		return smtp;
	}
	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getEuser() {
		return euser;
	}
	public void setEuser(String euser) {
		this.euser = euser;
	}
	public String getEpwd() {
		return epwd;
	}
	public void setEpwd(String epwd) {
		this.epwd = epwd;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public EmailType getEmailType() {
		return emailType;
	}
	public void setEmailType(EmailType emailType) {
		this.emailType = emailType;
	}
}
