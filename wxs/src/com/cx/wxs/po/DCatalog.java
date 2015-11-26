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
 * DCatalog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "d_catalog", catalog = "wxs")
public class DCatalog implements java.io.Serializable {

	// Fields

	private Integer catalogId;
	private UUser UUser;
	private BSite BSite;
	private String catalogName;
	private String description;
	private Timestamp createTime;
	private Integer articleCount;
	private Integer catalogType;
	private String verifyCode;
	private Short sortOrder;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;
	private Set<DDiary> DDiaries = new HashSet<DDiary>(0);

	// Constructors

	/** default constructor */
	public DCatalog() {
	}

	/** minimal constructor */
	public DCatalog(UUser UUser, BSite BSite, String catalogName) {
		this.UUser = UUser;
		this.BSite = BSite;
		this.catalogName = catalogName;
	}

	/** full constructor */
	public DCatalog(UUser UUser, BSite BSite, String catalogName,
			String description, Timestamp createTime, Integer articleCount,
			Integer catalogType, String verifyCode, Short sortOrder,
			Integer ext1, Integer ext2, String ext3, String ext4,
			Set<DDiary> DDiaries) {
		this.UUser = UUser;
		this.BSite = BSite;
		this.catalogName = catalogName;
		this.description = description;
		this.createTime = createTime;
		this.articleCount = articleCount;
		this.catalogType = catalogType;
		this.verifyCode = verifyCode;
		this.sortOrder = sortOrder;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.DDiaries = DDiaries;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "catalog_id", unique = true, nullable = false)
	public Integer getCatalogId() {
		return this.catalogId;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_id", nullable = false)
	public BSite getBSite() {
		return this.BSite;
	}

	public void setBSite(BSite BSite) {
		this.BSite = BSite;
	}

	@Column(name = "catalog_name", nullable = false, length = 20)
	public String getCatalogName() {
		return this.catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "create_time", length = 0)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "article_count")
	public Integer getArticleCount() {
		return this.articleCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}

	@Column(name = "catalog_type")
	public Integer getCatalogType() {
		return this.catalogType;
	}

	public void setCatalogType(Integer catalogType) {
		this.catalogType = catalogType;
	}

	@Column(name = "verifyCode", length = 20)
	public String getVerifyCode() {
		return this.verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "DCatalog")
	public Set<DDiary> getDDiaries() {
		return this.DDiaries;
	}

	public void setDDiaries(Set<DDiary> DDiaries) {
		this.DDiaries = DDiaries;
	}

}