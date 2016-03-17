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
 * SBox entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "s_box", catalog = "wxs")
public class SBox implements java.io.Serializable {

	// Fields

	private Integer boxId;
	private UUser UUser;
	private String name;
	private String description;
	private Timestamp createTime;
	private Integer soundCount;
	private Short sortOrder;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;
	private Set<SSound> SSounds = new HashSet<SSound>(0);

	// Constructors

	/** default constructor */
	public SBox() {
	}

	/** minimal constructor */
	public SBox(UUser UUser) {
		this.UUser = UUser;
	}

	/** full constructor */
	public SBox(UUser UUser, String name, String description,
			Timestamp createTime, Integer soundCount, Short sortOrder,
			Integer ext1, Integer ext2, String ext3, String ext4,
			Set<SSound> SSounds) {
		this.UUser = UUser;
		this.name = name;
		this.description = description;
		this.createTime = createTime;
		this.soundCount = soundCount;
		this.sortOrder = sortOrder;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.SSounds = SSounds;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "box_id", unique = true, nullable = false)
	public Integer getBoxId() {
		return this.boxId;
	}

	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
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

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "sound_count")
	public Integer getSoundCount() {
		return this.soundCount;
	}

	public void setSoundCount(Integer soundCount) {
		this.soundCount = soundCount;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "SBox")
	public Set<SSound> getSSounds() {
		return this.SSounds;
	}

	public void setSSounds(Set<SSound> SSounds) {
		this.SSounds = SSounds;
	}

}