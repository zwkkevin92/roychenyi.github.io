package com.cx.wxs.po;

import java.sql.Timestamp;
import java.util.HashSet;
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
 * VReply1 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_reply1", catalog = "wxs")
public class VReply1 implements java.io.Serializable {

	// Fields

	private Integer vreplyId;
	private VVote VVote;
	private UUser UUser;
	private Short clientType;
	private Short ownerOnly;
	private Timestamp writeTime;
	private Short status;
	private Set<VReply2> VReply2s = new HashSet<VReply2>(0);

	// Constructors

	/** default constructor */
	public VReply1() {
	}

	/** minimal constructor */
	public VReply1(VVote VVote, UUser UUser) {
		this.VVote = VVote;
		this.UUser = UUser;
	}

	/** full constructor */
	public VReply1(VVote VVote, UUser UUser, Short clientType, Short ownerOnly,
			Timestamp writeTime, Short status, Set<VReply2> VReply2s) {
		this.VVote = VVote;
		this.UUser = UUser;
		this.clientType = clientType;
		this.ownerOnly = ownerOnly;
		this.writeTime = writeTime;
		this.status = status;
		this.VReply2s = VReply2s;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "vreply_id", unique = true, nullable = false)
	public Integer getVreplyId() {
		return this.vreplyId;
	}

	public void setVreplyId(Integer vreplyId) {
		this.vreplyId = vreplyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vote_id", nullable = false)
	public VVote getVVote() {
		return this.VVote;
	}

	public void setVVote(VVote VVote) {
		this.VVote = VVote;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "VReply1")
	public Set<VReply2> getVReply2s() {
		return this.VReply2s;
	}

	public void setVReply2s(Set<VReply2> VReply2s) {
		this.VReply2s = VReply2s;
	}

}