package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;

/**
 * @author 陈义
 * @date   2015-12-9 上午10:56:39
 */
public class SysProvinceDto extends BeanBase{

	private Integer provinceId;
	private String name;
	private String description;
	
	public SysProvinceDto(){
		super();
	}
	public SysProvinceDto(Integer provinceId, String name, String description) {
		super();
		this.provinceId = provinceId;
		this.name = name;
		this.description = description;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
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
	
	
}
