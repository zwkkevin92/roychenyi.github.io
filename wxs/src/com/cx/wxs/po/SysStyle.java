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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SysStyle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_style", catalog = "wxs")
public class SysStyle implements java.io.Serializable {

	// Fields

	private Integer styleId;
	private String name;
	private String path;
	private Short status;
	private Timestamp createTime;
	private String cover;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;
	private Set<BSite> BSites = new HashSet<BSite>(0);

	// Constructors

	/** default constructor */
	public SysStyle() {
	}

	/** full constructor */
	public SysStyle(String name, String path, Short status,
			Timestamp createTime, String cover, Integer ext1, Integer ext2,
			String ext3, String ext4, Set<BSite> BSites) {
		this.name = name;
		this.path = path;
		this.status = status;
		this.createTime = createTime;
		this.cover = cover;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.BSites = BSites;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "style_id", unique = true, nullable = false)
	public Integer getStyleId() {
		return this.styleId;
	}

	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "path", length = 256)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "create_time", length = 0)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "cover", length = 50)
	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysStyle")
	public Set<BSite> getBSites() {
		return this.BSites;
	}

	public void setBSites(Set<BSite> BSites) {
		this.BSites = BSites;
	}

}