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
 * BBacklist entity. @author MyEclipse Persistence Tools
 * 黑名单表
 */
@Entity
@Table(name = "b_backlist", catalog = "wxs")
public class BBacklist implements java.io.Serializable {

	// Fields

	private Integer blacklistId;
	private UUser UUserByUserId;
	private UUser UUserByBackId;
	private Integer blType;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public BBacklist() {
	}

	/** minimal constructor */
	public BBacklist(UUser UUserByUserId, UUser UUserByBackId) {
		this.UUserByUserId = UUserByUserId;
		this.UUserByBackId = UUserByBackId;
	}

	/** full constructor */
	public BBacklist(UUser UUserByUserId, UUser UUserByBackId, Integer blType,
			Timestamp addTime) {
		this.UUserByUserId = UUserByUserId;
		this.UUserByBackId = UUserByBackId;
		this.blType = blType;
		this.addTime = addTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "blacklist_id", unique = true, nullable = false)
	public Integer getBlacklistId() {
		return this.blacklistId;
	}

	public void setBlacklistId(Integer blacklistId) {
		this.blacklistId = blacklistId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUserByUserId() {
		return this.UUserByUserId;
	}

	public void setUUserByUserId(UUser UUserByUserId) {
		this.UUserByUserId = UUserByUserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "back_id", nullable = false)
	public UUser getUUserByBackId() {
		return this.UUserByBackId;
	}

	public void setUUserByBackId(UUser UUserByBackId) {
		this.UUserByBackId = UUserByBackId;
	}

	@Column(name = "bl_type")
	public Integer getBlType() {
		return this.blType;
	}

	public void setBlType(Integer blType) {
		this.blType = blType;
	}

	@Column(name = "add_time", length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}