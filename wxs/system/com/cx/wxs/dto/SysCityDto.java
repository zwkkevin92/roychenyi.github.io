package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;

/**
 * @author 陈义
 * @date   2015-12-9 上午10:51:38
 */
public class SysCityDto extends BeanBase{
	
	private Integer cityId;
	private SysProvinceDto sysProvinceDto;
	private String name;
	private String description;
	
	public SysCityDto(){
		super();
	}
	public SysCityDto(Integer cityId, SysProvinceDto sysProvinceDto, String name,
			String description) {
		super();
		this.cityId = cityId;
		this.sysProvinceDto = sysProvinceDto;
		this.name = name;
		this.description = description;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public SysProvinceDto getSysProvinceDto() {
		return sysProvinceDto;
	}
	public void setSysProvinceDto(SysProvinceDto sysProvinceDto) {
		this.sysProvinceDto = sysProvinceDto;
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
