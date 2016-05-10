package com.cx.wxs.dto;

import java.sql.Timestamp;

import com.cx.wxs.base.BeanBase;

/**
 * @author 陈义
 * @date   2015-12-9 上午11:16:32
 */
public class SysRankDto extends BeanBase{
	// Fields

		private Integer rankId;
		private String name;
		private Integer rankHigh;
		private Integer rankLow;
		private String rankLogo;
		private Timestamp time;
		private Integer ext1;
		private Integer ext2;
		private String ext3;
		private String ext4;
		public SysRankDto(){
			super();
		}
		public SysRankDto(Integer rankId, String name, Integer rankHigh,
				Integer rankLow, String rankLogo, Timestamp time, Integer ext1,
				Integer ext2, String ext3, String ext4) {
			super();
			this.rankId = rankId;
			this.name = name;
			this.rankHigh = rankHigh;
			this.rankLow = rankLow;
			this.rankLogo = rankLogo;
			this.time = time;
			this.ext1 = ext1;
			this.ext2 = ext2;
			this.ext3 = ext3;
			this.ext4 = ext4;
		}
		public Integer getRankId() {
			return rankId;
		}
		public void setRankId(Integer rankId) {
			this.rankId = rankId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getRankHigh() {
			return rankHigh;
		}
		public void setRankHigh(Integer rankHigh) {
			this.rankHigh = rankHigh;
		}
		public Integer getRankLow() {
			return rankLow;
		}
		public void setRankLow(Integer rankLow) {
			this.rankLow = rankLow;
		}
		public String getRankLogo() {
			return rankLogo;
		}
		public void setRankLogo(String rankLogo) {
			this.rankLogo = rankLogo;
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
