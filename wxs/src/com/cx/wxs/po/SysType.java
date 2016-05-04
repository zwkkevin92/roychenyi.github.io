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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SysType entity. @author MyEclipse Persistence Tools
 * 文字类型
 */
@Entity
@Table(name = "sys_type", catalog = "wxs")
public class SysType implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private String name;
	private String value;
	private Timestamp createTime;
	private Timestamp lastTime;
	private Integer parentId;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;
	private List<DDiary> DDiaries = new ArrayList<DDiary>(0);

	// Constructors

	/** default constructor */
	public SysType() {
	}

	/** full constructor */
	public SysType(String name, String value, Timestamp createTime,
			Timestamp lastTime, Integer parentId, Integer ext1, Integer ext2,
			String ext3, String ext4, List<DDiary> DDiaries) {
		this.name = name;
		this.value = value;
		this.createTime = createTime;
		this.lastTime = lastTime;
		this.parentId = parentId;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.DDiaries = DDiaries;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "type_id", unique = true, nullable = false)
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "value", length = 36)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "last_time", length = 19)
	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysType")
	public List<DDiary> getDDiaries() {
		return this.DDiaries;
	}

	public void setDDiaries(List<DDiary> DDiaries) {
		this.DDiaries = DDiaries;
	}

}