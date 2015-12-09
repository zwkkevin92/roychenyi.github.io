package com.cx.wxs.dto;

import java.util.HashSet;
import java.util.Set;

import com.cx.wxs.base.BeanBase;
import com.cx.wxs.po.UFriend;
import com.cx.wxs.po.UUser;

/**
 * @author 陈义
 * @date   2015-12-3 下午4:49:41
 */
public class UfriendGroupDto extends BeanBase{

	private Integer groupId;
	private UuserDto UUserDto;
	private String name;
	private Integer groupType;
	private Integer groupCount;

	public UfriendGroupDto(){
		super();
	}
	
	public UfriendGroupDto(Integer groupId, UuserDto uUserDto, String name,
			Integer groupType, Integer groupCount) {
		super();
		this.groupId = groupId;
		UUserDto = uUserDto;
		this.name = name;
		this.groupType = groupType;
		this.groupCount = groupCount;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGroupType() {
		return groupType;
	}
	public void setGroupType(Integer groupType) {
		this.groupType = groupType;
	}
	public Integer getGroupCount() {
		return groupCount;
	}
	public void setGroupCount(Integer groupCount) {
		this.groupCount = groupCount;
	}

	public UuserDto getUUserDto() {
		return UUserDto;
	}

	public void setUUserDto(UuserDto uUserDto) {
		UUserDto = uUserDto;
	}

	
	
	
}
