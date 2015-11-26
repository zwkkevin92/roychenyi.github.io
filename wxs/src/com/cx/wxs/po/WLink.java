package com.cx.wxs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * WLink entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "w_link", catalog = "wxs")
public class WLink implements java.io.Serializable {

	// Fields

	private Integer wlinkId;
	private WWxs WWxs;
	private String name;
	private String linkUrl;
	private String logo;
	private Integer linkType;
	private Timestamp createTime;
	private Short status;
	private Short sortOrder;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;

	// Constructors

	/** default constructor */
	public WLink() {
	}

	/** minimal constructor */
	public WLink(WWxs WWxs) {
		this.WWxs = WWxs;
	}

	/** full constructor */
	public WLink(WWxs WWxs, String name, String linkUrl, String logo,
			Integer linkType, Timestamp createTime, Short status,
			Short sortOrder, Integer ext1, Integer ext2, String ext3,
			String ext4) {
		this.WWxs = WWxs;
		this.name = name;
		this.linkUrl = linkUrl;
		this.logo = logo;
		this.linkType = linkType;
		this.createTime = createTime;
		this.status = status;
		this.sortOrder = sortOrder;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "wlink_id", unique = true, nullable = false)
	public Integer getWlinkId() {
		return this.wlinkId;
	}

	public void setWlinkId(Integer wlinkId) {
		this.wlinkId = wlinkId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wxs_id", nullable = false)
	public WWxs getWWxs() {
		return this.WWxs;
	}

	public void setWWxs(WWxs WWxs) {
		this.WWxs = WWxs;
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

	@Column(name = "logo", length = 50)
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Column(name = "link_type")
	public Integer getLinkType() {
		return this.linkType;
	}

	public void setLinkType(Integer linkType) {
		this.linkType = linkType;
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

	@Column(name = "sort_order")
	public Short getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Short sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Column(name = "ext1")
	public Integer getExt1() {
		return this.ext1;
	}

	public void setExt1(Integer ext1) {
		this.ext1 = ext1;
	}

	@Column(name = "ext2")
	public Integer getExt2() {
		return this.ext2;
	}

	public void setExt2(Integer ext2) {
		this.ext2 = ext2;
	}

	@Column(name = "ext3", length = 1024)
	public String getExt3() {
		return this.ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	@Column(name = "ext4", length = 1024)
	public String getExt4() {
		return this.ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

}