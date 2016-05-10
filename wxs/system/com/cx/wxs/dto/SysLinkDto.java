package com.cx.wxs.dto;

import java.sql.Timestamp;

import com.cx.wxs.base.BeanBase;

/**
 * @author 陈义
 * @date   2015-12-9 上午11:12:11
 */
public class SysLinkDto extends BeanBase{
	private Integer linkId;
	private String name;
	private String linkUrl;
	private Integer linkType;
	private Timestamp createTime;
	private Short status;
	private Short sortOrder;
	public SysLinkDto(){
		super();
	}
	public SysLinkDto(Integer linkId, String name, String linkUrl,
			Integer linkType, Timestamp createTime, Short status,
			Short sortOrder) {
		super();
		this.linkId = linkId;
		this.name = name;
		this.linkUrl = linkUrl;
		this.linkType = linkType;
		this.createTime = createTime;
		this.status = status;
		this.sortOrder = sortOrder;
	}
	public Integer getLinkId() {
		return linkId;
	}
	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public Integer getLinkType() {
		return linkType;
	}
	public void setLinkType(Integer linkType) {
		this.linkType = linkType;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public Short getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Short sortOrder) {
		this.sortOrder = sortOrder;
	}
	

}
