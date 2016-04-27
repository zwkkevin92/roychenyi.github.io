package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;

/**
 * @author 陈义
 * @date   2015-12-9 上午11:01:32
 */
public class SysSchoolDto extends BeanBase{
	private Integer schoolId;
	private SysProvinceDto sysProvinceDto;
	private SysCityDto sysCityDto;
	private String name;
	private String description;
	private String address;
	private Short post;
	
	public SysSchoolDto(){
		super();
	}
	public SysSchoolDto(Integer schoolId, SysProvinceDto sysProvinceDto,
			SysCityDto sysCityDto, String name, String description,
			String address, Short post) {
		super();
		this.schoolId = schoolId;
		this.sysProvinceDto = sysProvinceDto;
		this.sysCityDto = sysCityDto;
		this.name = name;
		this.description = description;
		this.address = address;
		this.post = post;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public SysProvinceDto getSysProvinceDto() {
		return sysProvinceDto;
	}
	public void setSysProvinceDto(SysProvinceDto sysProvinceDto) {
		this.sysProvinceDto = sysProvinceDto;
	}
	public SysCityDto getSysCityDto() {
		return sysCityDto;
	}
	public void setSysCityDto(SysCityDto sysCityDto) {
		this.sysCityDto = sysCityDto;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Short getPost() {
		return post;
	}
	public void setPost(Short post) {
		this.post = post;
	}
	
	

}
