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
 * WStatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "w_status", catalog = "wxs")
public class WStatus implements java.io.Serializable {

	// Fields

	private Integer wstatusId;
	private WWxs WWxs;
	private Timestamp time;
	private Integer uvCount;
	private Integer pvCount;
	private Integer type;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public WStatus() {
	}

	/** minimal constructor */
	public WStatus(WWxs WWxs) {
		this.WWxs = WWxs;
	}

	/** full constructor */
	public WStatus(WWxs WWxs, Timestamp time, Integer uvCount, Integer pvCount,
			Integer type, Timestamp updateTime) {
		this.WWxs = WWxs;
		this.time = time;
		this.uvCount = uvCount;
		this.pvCount = pvCount;
		this.type = type;
		this.updateTime = updateTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "wstatus_id", unique = true, nullable = false)
	public Integer getWstatusId() {
		return this.wstatusId;
	}

	public void setWstatusId(Integer wstatusId) {
		this.wstatusId = wstatusId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wxs_id", nullable = false)
	public WWxs getWWxs() {
		return this.WWxs;
	}

	public void setWWxs(WWxs WWxs) {
		this.WWxs = WWxs;
	}

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "uv_count")
	public Integer getUvCount() {
		return this.uvCount;
	}

	public void setUvCount(Integer uvCount) {
		this.uvCount = uvCount;
	}

	@Column(name = "pv_count")
	public Integer getPvCount() {
		return this.pvCount;
	}

	public void setPvCount(Integer pvCount) {
		this.pvCount = pvCount;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "update_time", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}