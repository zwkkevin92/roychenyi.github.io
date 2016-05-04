package com.cx.wxs.po;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
 * IAlbum entity. @author MyEclipse Persistence Tools
 * 相册
 */
@Entity
@Table(name = "i_album", catalog = "wxs")
public class IAlbum implements java.io.Serializable {

	// Fields

	private Integer albumId;
	private UUser UUser;
	private BSite BSite;
	private String name;
	private String description;
	private Integer ablumType;
	private Integer ablumCount;
	private String accessQuestion;
	private String verifycode;
	private Timestamp createTime;
	private Short sortOrder;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;
	private List<IImage> IImages = new ArrayList<IImage>(0);

	// Constructors

	/** default constructor */
	public IAlbum() {
	}

	/** minimal constructor */
	public IAlbum(UUser UUser) {
		this.UUser = UUser;
	}

	/** full constructor */
	public IAlbum(UUser UUser, BSite BSite, String name, String description,
			Integer ablumType, Integer ablumCount, String accessQuestion,
			String verifycode, Timestamp createTime, Short sortOrder,
			Integer ext1, Integer ext2, String ext3, String ext4,
			List<IImage> IImages) {
		this.UUser = UUser;
		this.BSite = BSite;
		this.name = name;
		this.description = description;
		this.ablumType = ablumType;
		this.ablumCount = ablumCount;
		this.accessQuestion = accessQuestion;
		this.verifycode = verifycode;
		this.createTime = createTime;
		this.sortOrder = sortOrder;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.IImages = IImages;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "album_id", unique = true, nullable = false)
	public Integer getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_id")
	public BSite getBSite() {
		return this.BSite;
	}

	public void setBSite(BSite BSite) {
		this.BSite = BSite;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "ablum_type")
	public Integer getAblumType() {
		return this.ablumType;
	}

	public void setAblumType(Integer ablumType) {
		this.ablumType = ablumType;
	}

	@Column(name = "ablum_count")
	public Integer getAblumCount() {
		return this.ablumCount;
	}

	public void setAblumCount(Integer ablumCount) {
		this.ablumCount = ablumCount;
	}

	@Column(name = "access_question", length = 200)
	public String getAccessQuestion() {
		return this.accessQuestion;
	}

	public void setAccessQuestion(String accessQuestion) {
		this.accessQuestion = accessQuestion;
	}

	@Column(name = "verifycode", length = 50)
	public String getVerifycode() {
		return this.verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "IAlbum")
	public List<IImage> getIImages() {
		return this.IImages;
	}

	public void setIImages(List<IImage> IImages) {
		this.IImages = IImages;
	}

}