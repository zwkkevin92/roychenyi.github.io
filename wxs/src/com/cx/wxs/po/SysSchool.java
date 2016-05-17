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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SysSchool entity. @author MyEclipse Persistence Tools
 * 学校
 */
@Entity
@Table(name = "sys_school", catalog = "wxs")
public class SysSchool implements java.io.Serializable {

	// Fields

	private Integer schoolId;
	private SysProvince sysProvince;
	private SysCity sysCity;
	private String name;
	private String description;
	private String address;
	private Short post;
	private List<WWxs> WWxses=new ArrayList<WWxs>(0);
	private List<SysCollege> sysColleges = new ArrayList<SysCollege>(0);

	// Constructors

	/** default constructor */
	public SysSchool() {
	}

	/** full constructor */
	public SysSchool(SysProvince sysProvince, SysCity sysCity, String name,
			String description, String address, Short post,List<WWxs> WWxses,
			List<SysCollege> sysColleges) {
		this.sysProvince = sysProvince;
		this.sysCity = sysCity;
		this.name = name;
		this.description = description;
		this.address = address;
		this.post = post;
		this.WWxses=WWxses;
		this.sysColleges = sysColleges;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "school_id", unique = true, nullable = false)
	public Integer getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "province_id")
	public SysProvince getSysProvince() {
		return this.sysProvince;
	}

	public void setSysProvince(SysProvince sysProvince) {
		this.sysProvince = sysProvince;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	public SysCity getSysCity() {
		return this.sysCity;
	}

	public void setSysCity(SysCity sysCity) {
		this.sysCity = sysCity;
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

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "post")
	public Short getPost() {
		return this.post;
	}

	public void setPost(Short post) {
		this.post = post;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysSchool")
	public List<WWxs> getWWxses() {
		return this.WWxses;
	}

	public void setWWxses(List<WWxs> WWxses) {
		this.WWxses = WWxses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysSchool")
	public List<SysCollege> getSysColleges() {
		return this.sysColleges;
	}

	public void setSysColleges(List<SysCollege> sysColleges) {
		this.sysColleges = sysColleges;
	}

}