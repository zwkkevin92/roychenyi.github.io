package com.cx.wxs.po;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SReply1 entity. @author MyEclipse Persistence Tools
 * 评论
 */
@Entity
@Table(name = "s_reply1", catalog = "wxs")
public class SReply1 implements java.io.Serializable {

	// Fields

	private Integer sreplyId;
	private UUser UUser;
	private SSound SSound;
	private Short clientType;
	private Short ownerOnly;
	private Timestamp writeTime;
	private Short status;
	private List<SReply2> SReply2s = new ArrayList<SReply2>(0);

	// Constructors

	/** default constructor */
	public SReply1() {
	}

	/** minimal constructor */
	public SReply1(UUser UUser, SSound SSound) {
		this.UUser = UUser;
		this.SSound = SSound;
	}

	/** full constructor */
	public SReply1(UUser UUser, SSound SSound, Short clientType,
			Short ownerOnly, Timestamp writeTime, Short status,
			List<SReply2> SReply2s) {
		this.UUser = UUser;
		this.SSound = SSound;
		this.clientType = clientType;
		this.ownerOnly = ownerOnly;
		this.writeTime = writeTime;
		this.status = status;
		this.SReply2s = SReply2s;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sreply_id", unique = true, nullable = false)
	public Integer getSreplyId() {
		return this.sreplyId;
	}

	public void setSreplyId(Integer sreplyId) {
		this.sreplyId = sreplyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sound_id", nullable = false)
	public SSound getSSound() {
		return this.SSound;
	}

	public void setSSound(SSound SSound) {
		this.SSound = SSound;
	}

	@Column(name = "client_type")
	public Short getClientType() {
		return this.clientType;
	}

	public void setClientType(Short clientType) {
		this.clientType = clientType;
	}

	@Column(name = "owner_only")
	public Short getOwnerOnly() {
		return this.ownerOnly;
	}

	public void setOwnerOnly(Short ownerOnly) {
		this.ownerOnly = ownerOnly;
	}

	@Column(name = "write_time", length = 19)
	public Timestamp getWriteTime() {
		return this.writeTime;
	}

	public void setWriteTime(Timestamp writeTime) {
		this.writeTime = writeTime;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "SReply1")
	public List<SReply2> getSReply2s() {
		return this.SReply2s;
	}

	public void setSReply2s(List<SReply2> SReply2s) {
		this.SReply2s = SReply2s;
	}

}