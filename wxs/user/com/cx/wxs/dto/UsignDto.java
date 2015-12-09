package com.cx.wxs.dto;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.cx.wxs.base.BeanBase;
import com.cx.wxs.po.UUser;

/**
 * @author 陈义
 * @date   2015-12-3 下午4:03:21
 */
public class UsignDto extends BeanBase{

	// Fields

		private Integer signId;
		private UuserDto uuserDto;
		private String content;
		private Timestamp createTime;
		private Short status;

		public UsignDto() {
			super();
		}
		public UsignDto(Integer signId,UuserDto uuserDto,
				String content, Timestamp createTime, Short status) {
			super();
			this.signId = signId;
			this.uuserDto=uuserDto;
			this.content = content;
			this.createTime = createTime;
			this.status = status;
		}
		public Integer getSignId() {
			return signId;
		}
		public void setSignId(Integer signId) {
			this.signId = signId;
		}
		
		public UuserDto getUuserDto() {
			return uuserDto;
		}
		public void setUuserDto(UuserDto uuserDto) {
			this.uuserDto = uuserDto;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Timestamp getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Timestamp createTime) {
			this.createTime = createTime;
		}
		public Short getStatus() {
			return status;
		}
		public void setStatus(Short status) {
			this.status = status;
		}

		
		
}
