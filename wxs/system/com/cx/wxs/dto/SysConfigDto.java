package com.cx.wxs.dto;

import java.sql.Timestamp;

import com.cx.wxs.base.BeanBase;

/**
 * @author 陈义
 * @date   2015-12-9 上午11:09:10
 */
public class SysConfigDto extends BeanBase{

	// Fields

		private Integer configId;
		private String configName;
		private String value;
		private Timestamp createTime;
		private Timestamp lastTime;
		public SysConfigDto(){
			super();
		}
		public SysConfigDto(Integer configId, String configName, String value,
				Timestamp createTime, Timestamp lastTime) {
			super();
			this.configId = configId;
			this.configName = configName;
			this.value = value;
			this.createTime = createTime;
			this.lastTime = lastTime;
		}
		public Integer getConfigId() {
			return configId;
		}
		public void setConfigId(Integer configId) {
			this.configId = configId;
		}
		public String getConfigName() {
			return configName;
		}
		public void setConfigName(String configName) {
			this.configName = configName;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Timestamp getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Timestamp createTime) {
			this.createTime = createTime;
		}
		public Timestamp getLastTime() {
			return lastTime;
		}
		public void setLastTime(Timestamp lastTime) {
			this.lastTime = lastTime;
		}
		
}
