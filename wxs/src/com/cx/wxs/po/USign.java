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
 * USign entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "u_sign", catalog = "wxs")
public class USign implements java.io.Serializable {

	// Fields

	private Integer signId;
	private UUser UUser;
	private String content;
	private Timestamp createTime;
	private Short status;
	private Set<UUser> UUsers = new HashSet<UUser>(0);

	// Constructors

	/** default constructor */
	public USign() {
	}

	/** minimal constructor */
	public USign(UUser UUser, String content) {
		this.UUser = UUser;
		this.content = content;
	}

	/** full constructor */
	public USign(UUser UUser, String content, Timestamp createTime,
			Short status, Set<UUser> UUsers) {
		this.UUser = UUser;
		this.content = content;
		this.createTime = createTime;
		this.status = status;
		this.UUsers = UUsers;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sign_id", unique = true, nullable = false)
	public Integer getSignId() {
		return this.signId;
	}

	public void setSignId(Integer signId) {
		this.signId = signId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@Column(name = "content", nullable = false, length = 140)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "create_time", length = 0)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "USign")
	public Set<UUser> getUUsers() {
		return this.UUsers;
	}

	public void setUUsers(Set<UUser> UUsers) {
		this.UUsers = UUsers;
	}

}