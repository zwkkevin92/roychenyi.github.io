package com.cx.wxs.po;

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
 * SysCity entity. @author MyEclipse Persistence Tools
 * 系统
 * 城市
 */
@Entity
@Table(name = "sys_city", catalog = "wxs")
public class SysCity implements java.io.Serializable {

	// Fields

	private Integer cityId;
	private SysProvince sysProvince;
	private String name;
	private String description;
	private Set<SysSchool> sysSchools = new HashSet<SysSchool>(0);

	// Constructors

	/** default constructor */
	public SysCity() {
	}

	/** minimal constructor */
	public SysCity(SysProvince sysProvince, String name) {
		this.sysProvince = sysProvince;
		this.name = name;
	}

	/** full constructor */
	public SysCity(SysProvince sysProvince, String name, String description,
			Set<SysSchool> sysSchools) {
		this.sysProvince = sysProvince;
		this.name = name;
		this.description = description;
		this.sysSchools = sysSchools;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "city_id", unique = true, nullable = false)
	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "province_id", nullable = false)
	public SysProvince getSysProvince() {
		return this.sysProvince;
	}

	public void setSysProvince(SysProvince sysProvince) {
		this.sysProvince = sysProvince;
	}

	@Column(name = "name", nullable = false, length = 20)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysCity")
	public Set<SysSchool> getSysSchools() {
		return this.sysSchools;
	}

	public void setSysSchools(Set<SysSchool> sysSchools) {
		this.sysSchools = sysSchools;
	}

}