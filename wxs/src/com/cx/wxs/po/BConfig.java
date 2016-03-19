package com.cx.wxs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "b_config", catalog = "wxs")
public class BConfig implements java.io.Serializable {

	// Fields

	private Integer bconfigId;
	private BSite BSite;
	private String configKey;
	private String value;
	private Timestamp createTime;
	private Timestamp lastTime;

	// Constructors

	/** default constructor */
	public BConfig() {
	}

	/** minimal constructor */
	public BConfig(BSite BSite) {
		this.BSite = BSite;
	}

	/** full constructor */
	public BConfig(BSite BSite, String configKey, String value,
			Timestamp createTime, Timestamp lastTime) {
		this.BSite = BSite;
		this.configKey = configKey;
		this.value = value;
		this.createTime = createTime;
		this.lastTime = lastTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "bconfig_id", unique = true, nullable = false)
	public Integer getBconfigId() {
		return this.bconfigId;
	}

	public void setBconfigId(Integer bconfigId) {
		this.bconfigId = bconfigId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_id", nullable = false)
	public BSite getBSite() {
		return this.BSite;
	}

	public void setBSite(BSite BSite) {
		this.BSite = BSite;
	}

	@Column(name = "config_key", length = 20)
	public String getConfigKey() {
		return this.configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	@Column(name = "value", length = 36)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "last_time", length = 19)
	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

}