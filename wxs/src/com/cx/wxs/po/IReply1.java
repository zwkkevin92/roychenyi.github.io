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
 * IReply1 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "i_reply1", catalog = "wxs")
public class IReply1 implements java.io.Serializable {

	// Fields

	private Integer ireplyId;
	private IImage IImage;
	private UUser UUser;
	private Short clientType;
	private Short ownerOnly;
	private Timestamp writeTime;
	private Short status;
	private Set<IReply2> IReply2s = new HashSet<IReply2>(0);

	// Constructors

	/** default constructor */
	public IReply1() {
	}

	/** minimal constructor */
	public IReply1(IImage IImage, UUser UUser) {
		this.IImage = IImage;
		this.UUser = UUser;
	}

	/** full constructor */
	public IReply1(IImage IImage, UUser UUser, Short clientType,
			Short ownerOnly, Timestamp writeTime, Short status,
			Set<IReply2> IReply2s) {
		this.IImage = IImage;
		this.UUser = UUser;
		this.clientType = clientType;
		this.ownerOnly = ownerOnly;
		this.writeTime = writeTime;
		this.status = status;
		this.IReply2s = IReply2s;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ireply_id", unique = true, nullable = false)
	public Integer getIreplyId() {
		return this.ireplyId;
	}

	public void setIreplyId(Integer ireplyId) {
		this.ireplyId = ireplyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "image_id", nullable = false)
	public IImage getIImage() {
		return this.IImage;
	}

	public void setIImage(IImage IImage) {
		this.IImage = IImage;
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

	@Column(name = "write_time", length = 0)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "IReply1")
	public Set<IReply2> getIReply2s() {
		return this.IReply2s;
	}

	public void setIReply2s(Set<IReply2> IReply2s) {
		this.IReply2s = IReply2s;
	}

}