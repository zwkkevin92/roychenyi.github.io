package com.cx.wxs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysLink entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_link", catalog = "wxs")
public class SysLink implements java.io.Serializable {

	// Fields

	private Integer linkId;
	private String name;
	private String linkUrl;
	private Integer linkType;
	private Timestamp createTime;
	private Short status;
	private Short sortOrder;

	// Constructors

	/** default constructor */
	public SysLink() {
	}

	/** full constructor */
	public SysLink(String name, String linkUrl, Integer linkType,
			Timestamp createTime, Short status, Short sortOrder) {
		this.name = name;
		this.linkUrl = linkUrl;
		this.linkType = linkType;
		this.createTime = createTime;
		this.status = status;
		this.sortOrder = sortOrder;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "link_id", unique = true, nullable = false)
	public Integer getLinkId() {
		return this.linkId;
	}

	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

	@Column(name = "name", length = 10)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "link_url", length = 200)
	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	@Column(name = "link_type")
	public Integer getLinkType() {
		return this.linkType;
	}

	public void setLinkType(Integer linkType) {
		this.linkType = linkType;
	}

	@Column(name = "create_time", length = 19)
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

	@Column(name = "sort_order")
	public Short getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Short sortOrder) {
		this.sortOrder = sortOrder;
	}

}