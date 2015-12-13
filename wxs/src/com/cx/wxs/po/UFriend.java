package com.cx.wxs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UFriend entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "u_friend", catalog = "wxs")
public class UFriend implements java.io.Serializable {

	// Fields

	private Integer id;
	private UUser UUserByUserId;
	private UUser UUserByFriendId;
	private UFriendGroup UFriendGroup;
	private Integer friendType;
	private Integer friendRole;
	private Timestamp addTime;
	private Short status;

	// Constructors

	/** default constructor */
	public UFriend() {
	}

	/** minimal constructor */
	public UFriend(Integer id, UUser UUserByUserId, UUser UUserByFriendId,
			UFriendGroup UFriendGroup, Integer friendType, Timestamp addTime) {
		this.id = id;
		this.UUserByUserId = UUserByUserId;
		this.UUserByFriendId = UUserByFriendId;
		this.UFriendGroup = UFriendGroup;
		this.friendType = friendType;
		this.addTime = addTime;
	}

	/** full constructor */
	public UFriend(Integer id, UUser UUserByUserId, UUser UUserByFriendId,
			UFriendGroup UFriendGroup, Integer friendType, Integer friendRole,
			Timestamp addTime, Short status) {
		this.id = id;
		this.UUserByUserId = UUserByUserId;
		this.UUserByFriendId = UUserByFriendId;
		this.UFriendGroup = UFriendGroup;
		this.friendType = friendType;
		this.friendRole = friendRole;
		this.addTime = addTime;
		this.status = status;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	@JoinColumn(name = "friend_id", nullable = false)
	public UUser getUUserByFriendId() {
		return this.UUserByFriendId;
	}

	public void setUUserByFriendId(UUser UUserByFriendId) {
		this.UUserByFriendId = UUserByFriendId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id", nullable = false)
	public UFriendGroup getUFriendGroup() {
		return this.UFriendGroup;
	}

	public void setUFriendGroup(UFriendGroup UFriendGroup) {
		this.UFriendGroup = UFriendGroup;
	}

	@Column(name = "friend_type", nullable = false)
	public Integer getFriendType() {
		return this.friendType;
	}

	public void setFriendType(Integer friendType) {
		this.friendType = friendType;
	}

	@Column(name = "friend_role")
	public Integer getFriendRole() {
		return this.friendRole;
	}

	public void setFriendRole(Integer friendRole) {
		this.friendRole = friendRole;
	}

	@Column(name = "add_time", nullable = false, length = 0)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

}