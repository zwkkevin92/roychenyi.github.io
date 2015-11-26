package com.cx.wxs.po;

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
 * UFriendGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "u_friend_group", catalog = "wxs")
public class UFriendGroup implements java.io.Serializable {

	// Fields

	private Integer groupId;
	private UUser UUser;
	private String name;
	private Integer groupType;
	private Integer groupCount;
	private Set<UFriend> UFriends = new HashSet<UFriend>(0);

	// Constructors

	/** default constructor */
	public UFriendGroup() {
	}

	/** minimal constructor */
	public UFriendGroup(UUser UUser, String name) {
		this.UUser = UUser;
		this.name = name;
	}

	/** full constructor */
	public UFriendGroup(UUser UUser, String name, Integer groupType,
			Integer groupCount, Set<UFriend> UFriends) {
		this.UUser = UUser;
		this.name = name;
		this.groupType = groupType;
		this.groupCount = groupCount;
		this.UFriends = UFriends;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "group_id", unique = true, nullable = false)
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@Column(name = "name", nullable = false, length = 10)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "group_type")
	public Integer getGroupType() {
		return this.groupType;
	}

	public void setGroupType(Integer groupType) {
		this.groupType = groupType;
	}

	@Column(name = "group_count")
	public Integer getGroupCount() {
		return this.groupCount;
	}

	public void setGroupCount(Integer groupCount) {
		this.groupCount = groupCount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UFriendGroup")
	public Set<UFriend> getUFriends() {
		return this.UFriends;
	}

	public void setUFriends(Set<UFriend> UFriends) {
		this.UFriends = UFriends;
	}

}