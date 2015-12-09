package com.cx.wxs.dto;

import java.sql.Timestamp;

import com.cx.wxs.base.BeanBase;

/**
 * @author 陈义
 * @date   2015-12-3 下午4:12:39
 */
public class UfriendDto extends BeanBase{

	private Integer id;
	private UfriendGroupDto ufriendGroupDto;
	private Integer userId;
	private Integer friendId;
	private Integer friendType;
	private Integer friendRole;
	private Timestamp addTime;
	private Short status;
	
	public UfriendDto(){
		
	}
	
	public UfriendDto(Integer id, UfriendGroupDto ufriendGroupDto,
			Integer userId, Integer friendId, Integer friendType,
			Integer friendRole, Timestamp addTime, Short status) {
		super();
		this.id = id;
		this.ufriendGroupDto = ufriendGroupDto;
		this.userId = userId;
		this.friendId = friendId;
		this.friendType = friendType;
		this.friendRole = friendRole;
		this.addTime = addTime;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public UfriendGroupDto getUfriendGroupDto() {
		return ufriendGroupDto;
	}

	public void setUfriendGroupDto(UfriendGroupDto ufriendGroupDto) {
		this.ufriendGroupDto = ufriendGroupDto;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFriendId() {
		return friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	public Integer getFriendType() {
		return friendType;
	}

	public void setFriendType(Integer friendType) {
		this.friendType = friendType;
	}

	public Integer getFriendRole() {
		return friendRole;
	}

	public void setFriendRole(Integer friendRole) {
		this.friendRole = friendRole;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}
	
	
	
	
}
