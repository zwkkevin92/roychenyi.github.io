package com.cx.wxs.po;

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
 * SysProvince entity. @author MyEclipse Persistence Tools
 * 登录记录
 */
@Entity
@Table(name = "sys_province", catalog = "wxs")
public class SysProvince implements java.io.Serializable {

	// Fields

	private Integer provinceId;
	private String name;
	private String description;
	private List<SysCity> sysCities = new ArrayList<SysCity>(0);
	private List<SysSchool> sysSchools = new ArrayList<SysSchool>(0);

	// Constructors

	/** default constructor */
	public SysProvince() {
	}

	/** full constructor */
	public SysProvince(String name, String description, List<SysCity> sysCities,
			List<SysSchool> sysSchools) {
		this.name = name;
		this.description = description;
		this.sysCities = sysCities;
		this.sysSchools = sysSchools;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "province_id", unique = true, nullable = false)
	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysProvince")
	public List<SysCity> getSysCities() {
		return this.sysCities;
	}

	public void setSysCities(List<SysCity> sysCities) {
		this.sysCities = sysCities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysProvince")
	public List<SysSchool> getSysSchools() {
		return this.sysSchools;
	}

	public void setSysSchools(List<SysSchool> sysSchools) {
		this.sysSchools = sysSchools;
	}

}