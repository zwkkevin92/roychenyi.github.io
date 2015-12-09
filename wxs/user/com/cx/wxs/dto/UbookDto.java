package com.cx.wxs.dto;

import java.sql.Timestamp;

import com.cx.wxs.base.BeanBase;


/**
 * @author 陈义
 * @date   2015-12-3 下午4:08:40
 */
public class UbookDto extends BeanBase{
	
	// Fields
		private Integer ubookId;
		private UuserDto UuserDto;
		private String name;
		private String bookDetaik;
		private String cover;
		private Timestamp time;
		private Integer ext1;
		private Integer ext2;
		private String ext3;
		private String ext4;
		
		public UbookDto() {
			super();
		}

		public UbookDto(Integer ubookId, UuserDto uuserDto,
				String name, String bookDetaik, String cover, Timestamp time,
				Integer ext1, Integer ext2, String ext3, String ext4) {
			super();
			this.ubookId = ubookId;
			this.UuserDto = uuserDto;
			this.name = name;
			this.bookDetaik = bookDetaik;
			this.cover = cover;
			this.time = time;
			this.ext1 = ext1;
			this.ext2 = ext2;
			this.ext3 = ext3;
			this.ext4 = ext4;
		}

		public Integer getUbookId() {
			return ubookId;
		}

		public void setUbookId(Integer ubookId) {
			this.ubookId = ubookId;
		}

		

		public UuserDto getUuserDto() {
			return UuserDto;
		}

		public void setUuserDto(UuserDto uuserDto) {
			UuserDto = uuserDto;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBookDetaik() {
			return bookDetaik;
		}

		public void setBookDetaik(String bookDetaik) {
			this.bookDetaik = bookDetaik;
		}

		public String getCover() {
			return cover;
		}

		public void setCover(String cover) {
			this.cover = cover;
		}

		public Timestamp getTime() {
			return time;
		}

		public void setTime(Timestamp time) {
			this.time = time;
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
