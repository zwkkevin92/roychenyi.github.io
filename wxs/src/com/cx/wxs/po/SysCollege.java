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
 * SysCollege entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_college", catalog = "wxs")
public class SysCollege implements java.io.Serializable {

	// Fields

	private Integer collegeId;
	private SysSchool sysSchool;
	private String name;
	private String description;
	private Set<UUser> UUsers = new HashSet<UUser>(0);

	// Constructors

	/** default constructor */
	public SysCollege() {
	}

	/** full constructor */
	public SysCollege(SysSchool sysSchool, String name, String description,
			Set<UUser> UUsers) {
		this.sysSchool = sysSchool;
		this.name = name;
		this.description = description;
		this.UUsers = UUsers;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "college_id", unique = true, nullable = false)
	public Integer getCollegeId() {
		return this.collegeId;
	}

	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "school_id")
	public SysSchool getSysSchool() {
		return this.sysSchool;
	}

	public void setSysSchool(SysSchool sysSchool) {
		this.sysSchool = sysSchool;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysCollege")
	public Set<UUser> getUUsers() {
		return this.UUsers;
	}

	public void setUUsers(Set<UUser> UUsers) {
		this.UUsers = UUsers;
	}

}