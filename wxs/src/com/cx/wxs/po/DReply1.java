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
 * DReply1 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "d_reply1", catalog = "wxs")
public class DReply1 implements java.io.Serializable {

	// Fields

	private Integer dreplyId;
	private DDiary DDiary;
	private UUser UUser;
	private Short clientType;
	private Short ownerOnly;
	private Timestamp writeTime;
	private Short status;
	private List<DReply2> DReply2s = new ArrayList<DReply2>(0);

	// Constructors

	/** default constructor */
	public DReply1() {
	}

	/** minimal constructor */
	public DReply1(DDiary DDiary, UUser UUser) {
		this.DDiary = DDiary;
		this.UUser = UUser;
	}

	/** full constructor */
	public DReply1(DDiary DDiary, UUser UUser, Short clientType,
			Short ownerOnly, Timestamp writeTime, Short status,
			List<DReply2> DReply2s) {
		this.DDiary = DDiary;
		this.UUser = UUser;
		this.clientType = clientType;
		this.ownerOnly = ownerOnly;
		this.writeTime = writeTime;
		this.status = status;
		this.DReply2s = DReply2s;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "dreply_id", unique = true, nullable = false)
	public Integer getDreplyId() {
		return this.dreplyId;
	}

	public void setDreplyId(Integer dreplyId) {
		this.dreplyId = dreplyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "diary_id", nullable = false)
	public DDiary getDDiary() {
		return this.DDiary;
	}

	public void setDDiary(DDiary DDiary) {
		this.DDiary = DDiary;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "DReply1")
	public List<DReply2> getDReply2s() {
		return this.DReply2s;
	}

	public void setDReply2s(List<DReply2> DReply2s) {
		this.DReply2s = DReply2s;
	}

}