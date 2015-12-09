package com.cx.wxs.dto;

import java.sql.Timestamp;

import com.cx.wxs.base.BeanBase;


/**
 * @author 陈义
 * @date   2015-12-9 上午11:14:36
 */
public class SysLoginRecordDto extends BeanBase{
	// Fields

		private Integer recordId;
		private UuserDto uuserDto;
		private Timestamp createTime;
		private String clientAgent;
		private String clientIp;
		private Short clientType;
		public SysLoginRecordDto(){
			super();
		}
		public SysLoginRecordDto(Integer recordId, UuserDto uuserDto,
				Timestamp createTime, String clientAgent, String clientIp,
				Short clientType) {
			super();
			this.recordId = recordId;
			this.uuserDto=uuserDto;
			this.createTime = createTime;
			this.clientAgent = clientAgent;
			this.clientIp = clientIp;
			this.clientType = clientType;
		}
		public Integer getRecordId() {
			return recordId;
		}
		public void setRecordId(Integer recordId) {
			this.recordId = recordId;
		}
		
		public UuserDto getUuserDto() {
			return uuserDto;
		}
		public void setUuserDto(UuserDto uuserDto) {
			this.uuserDto = uuserDto;
		}
		public Timestamp getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Timestamp createTime) {
			this.createTime = createTime;
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
		

}
