package com.cx.wxs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_config", catalog = "wxs")
public class SysConfig implements java.io.Serializable {

	// Fields

	private Integer configId;
	private String configName;
	private String value;
	private Timestamp createTime;
	private Timestamp lastTime;

	// Constructors

	/** default constructor */
	public SysConfig() {
	}

	/** full constructor */
	public SysConfig(String configName, String value, Timestamp createTime,
			Timestamp lastTime) {
		this.configName = configName;
		this.value = value;
		this.createTime = createTime;
		this.lastTime = lastTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "config_id", unique = true, nullable = false)
	public Integer getConfigId() {
		return this.configId;
	}

	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	@Column(name = "config_name", length = 20)
	public String getConfigName() {
		return this.configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	@Column(name = "value", length = 36)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "create_time", length = 0)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "last_time", length = 0)
	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

}