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
 * WConfig entity. @author MyEclipse Persistence Tools
 * 文学社-配置
 */
@Entity
@Table(name = "w_config", catalog = "wxs")
public class WConfig implements java.io.Serializable {

	// Fields

	private Integer wconfigId;
	private WWxs WWxs;
	private String configKey;
	private String value;
	private Timestamp createTime;
	private Timestamp lastTime;

	// Constructors

	/** default constructor */
	public WConfig() {
	}

	/** minimal constructor */
	public WConfig(WWxs WWxs) {
		this.WWxs = WWxs;
	}

	/** full constructor */
	public WConfig(WWxs WWxs, String configKey, String value,
			Timestamp createTime, Timestamp lastTime) {
		this.WWxs = WWxs;
		this.configKey = configKey;
		this.value = value;
		this.createTime = createTime;
		this.lastTime = lastTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "wconfig_id", unique = true, nullable = false)
	public Integer getWconfigId() {
		return this.wconfigId;
	}

	public void setWconfigId(Integer wconfigId) {
		this.wconfigId = wconfigId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wxs_id", nullable = false)
	public WWxs getWWxs() {
		return this.WWxs;
	}

	public void setWWxs(WWxs WWxs) {
		this.WWxs = WWxs;
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