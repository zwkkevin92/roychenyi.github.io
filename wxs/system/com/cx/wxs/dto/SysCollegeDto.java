package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;

/**
 * @author 陈义
 * @date   2015-12-9 上午11:00:42
 */
public class SysCollegeDto extends BeanBase{
	
	// Fields

		private Integer collegeId;
		private SysSchoolDto sysSchoolDto;
		private String name;
		private String description;
		public SysCollegeDto() {
			super();
		}
		public SysCollegeDto(Integer collegeId, SysSchoolDto sysSchoolDto,
				String name, String description) {
			super();
			this.collegeId = collegeId;
			this.sysSchoolDto = sysSchoolDto;
			this.name = name;
			this.description = description;
		}
		public Integer getCollegeId() {
			return collegeId;
		}
		public void setCollegeId(Integer collegeId) {
			this.collegeId = collegeId;
		}
		public SysSchoolDto getSysSchoolDto() {
			return sysSchoolDto;
		}
		public void setSysSchoolDto(SysSchoolDto sysSchoolDto) {
			this.sysSchoolDto = sysSchoolDto;
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
