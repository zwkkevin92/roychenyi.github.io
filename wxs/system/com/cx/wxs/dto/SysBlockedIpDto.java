package com.cx.wxs.dto;

import java.sql.Timestamp;

import com.cx.wxs.base.BeanBase;

/**
 * @author 陈义
 * @date   2015-12-9 上午10:49:52
 */
public class SysBlockedIpDto extends BeanBase{
	
	// Fields

		private Integer blockedipId;
		private String ip;
		private String ipmask;
		private Integer blockedType;
		private Timestamp time;
		private Short status;
		private Timestamp updateTime;

		// Constructors

		/** default constructor */
		public SysBlockedIpDto() {
		}

		/** full constructor */
		public SysBlockedIpDto(String ip, String ipmask, Integer blockedType,
				Timestamp time, Short status, Timestamp updateTime) {
			this.ip = ip;
			this.ipmask = ipmask;
			this.blockedType = blockedType;
			this.time = time;
			this.status = status;
			this.updateTime = updateTime;
		}

		public Integer getBlockedipId() {
			return blockedipId;
		}

		public void setBlockedipId(Integer blockedipId) {
			this.blockedipId = blockedipId;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public String getIpmask() {
			return ipmask;
		}

		public void setIpmask(String ipmask) {
			this.ipmask = ipmask;
		}

		public Integer getBlockedType() {
			return blockedType;
		}

		public void setBlockedType(Integer blockedType) {
			this.blockedType = blockedType;
		}

		public Timestamp getTime() {
			return time;
		}

		public void setTime(Timestamp time) {
			this.time = time;
		}

		public Short getStatus() {
			return status;
		}

		public void setStatus(Short status) {
			this.status = status;
		}

		public Timestamp getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(Timestamp updateTime) {
			this.updateTime = updateTime;
		}
		
		

}
