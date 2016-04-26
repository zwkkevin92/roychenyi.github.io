package com.cx.wxs.dto;

import java.sql.Timestamp;

import com.cx.wxs.base.BeanBase;

/**
 * @author 陈义
 * @date   2015-12-9 上午11:04:04
 */
public class SysStyleDto extends BeanBase{
	private Integer styleId;
	private String name;
	private String path;
	private Short status;
	private Timestamp createTime;
	private String cover;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;
	
	public SysStyleDto(){
		super();
	}

	public SysStyleDto(Integer styleId, String name, String path, Short status,
			Timestamp createTime, String cover, Integer ext1, Integer ext2,
			String ext3, String ext4) {
		super();
		this.styleId = styleId;
		this.name = name;
		this.path = path;
		this.status = status;
		this.createTime = createTime;
		this.cover = cover;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
	}

	public Integer getStyleId() {
		return styleId;
	}

	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Integer getExt1() {
		return ext1;
	}

	public void setExt1(Integer ext1) {
		this.ext1 = ext1;
	}

	public Integer getExt2() {
		return ext2;
	}

	public void setExt2(Integer ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public String getExt4() {
		return ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}
	
	

}
