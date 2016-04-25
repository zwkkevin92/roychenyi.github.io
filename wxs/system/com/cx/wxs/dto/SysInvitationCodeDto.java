package com.cx.wxs.dto;

import java.sql.Timestamp;

import com.cx.wxs.base.BeanBase;

/**
 * @author 陈义
 * @date   2015-12-9 上午11:10:53
 */
public class SysInvitationCodeDto extends BeanBase{
	// Fields

		private Integer codeId;
		private Integer userId;
		private Integer wxsId;
		private String code;
		private Timestamp regTime;
		private String clientAgent;
		private String clientIp;
		private Short clientType;
		private Short status;
		private Short flag;
		public SysInvitationCodeDto(){
			super();
		}
		public SysInvitationCodeDto(Integer codeId, Integer userId,
				Integer wxsId, String code, Timestamp regTime,
				String clientAgent, String clientIp, Short clientType,
				Short status, Short flag) {
			super();
			this.codeId = codeId;
			this.userId = userId;
			this.wxsId = wxsId;
			this.code = code;
			this.regTime = regTime;
			this.clientAgent = clientAgent;
			this.clientIp = clientIp;
			this.clientType = clientType;
			this.status = status;
			this.flag = flag;
		}
		public Integer getCodeId() {
			return codeId;
		}
		public void setCodeId(Integer codeId) {
			this.codeId = codeId;
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public Integer getWxsId() {
			return wxsId;
		}
		public void setWxsId(Integer wxsId) {
			this.wxsId = wxsId;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public Timestamp getRegTime() {
			return regTime;
		}
		public void setRegTime(Timestamp regTime) {
			this.regTime = regTime;
		}
		public String getClientAgent() {
			return clientAgent;
		}
		public void setClientAgent(String clientAgent) {
			this.clientAgent = clientAgent;
		}
		public String getClientIp() {
			return clientIp;
		}
		public void setClientIp(String clientIp) {
			this.clientIp = clientIp;
		}
		public Short getClientType() {
			return clientType;
		}
		public void setClientType(Short clientType) {
			this.clientType = clientType;
		}
		public Short getStatus() {
			return status;
		}
		public void setStatus(Short status) {
			this.status = status;
		}
		public Short getFlag() {
			return flag;
		}
		public void setFlag(Short flag) {
			this.flag = flag;
		}
		

}
