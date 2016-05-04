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
 * BStatus entity. @author MyEclipse Persistence Tools
 * 状态表
 */
@Entity
@Table(name = "b_status", catalog = "wxs")
public class BStatus implements java.io.Serializable {

	// Fields

	private Integer bstatusId;
	private BSite BSite;
	private Timestamp time;
	private Integer uvCount;
	private Integer pvCount;
	private Short type;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public BStatus() {
	}

	/** minimal constructor */
	public BStatus(BSite BSite, Timestamp time) {
		this.BSite = BSite;
		this.time = time;
	}

	/** full constructor */
	public BStatus(BSite BSite, Timestamp time, Integer uvCount,
			Integer pvCount, Short type, Timestamp updateTime) {
		this.BSite = BSite;
		this.time = time;
		this.uvCount = uvCount;
		this.pvCount = pvCount;
		this.type = type;
		this.updateTime = updateTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "bstatus_id", unique = true, nullable = false)
	public Integer getBstatusId() {
		return this.bstatusId;
	}

	public void setBstatusId(Integer bstatusId) {
		this.bstatusId = bstatusId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_id", nullable = false)
	public BSite getBSite() {
		return this.BSite;
	}

	public void setBSite(BSite BSite) {
		this.BSite = BSite;
	}

	@Column(name = "time", nullable = false, length = 19)
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
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
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