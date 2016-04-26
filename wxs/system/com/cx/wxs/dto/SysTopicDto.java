package com.cx.wxs.dto;

import java.sql.Timestamp;

import com.cx.wxs.base.BeanBase;

/**
 * @author 陈义
 * @date   2015-12-9 上午11:05:36
 */
public class SysTopicDto extends BeanBase{

	// Fields

		private Integer topicId;
		private Integer userId;
		private String topicKey;
		private String description;
		private Integer topicIndex;
		private Timestamp createTime;
		private Integer ext1;
		private Integer ext2;
		private String ext3;
		private String ext4;
		
		public SysTopicDto(){
			super();
		}

		public SysTopicDto(Integer topicId, Integer userId, String topicKey,
				String description, Integer topicIndex, Timestamp createTime,
				Integer ext1, Integer ext2, String ext3, String ext4) {
			super();
			this.topicId = topicId;
			this.userId = userId;
			this.topicKey = topicKey;
			this.description = description;
			this.topicIndex = topicIndex;
			this.createTime = createTime;
			this.ext1 = ext1;
			this.ext2 = ext2;
			this.ext3 = ext3;
			this.ext4 = ext4;
		}

		public Integer getTopicId() {
			return topicId;
		}

		public void setTopicId(Integer topicId) {
			this.topicId = topicId;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public String getTopicKey() {
			return topicKey;
		}

		public void setTopicKey(String topicKey) {
			this.topicKey = topicKey;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getTopicIndex() {
			return topicIndex;
		}

		public void setTopicIndex(Integer topicIndex) {
			this.topicIndex = topicIndex;
		}

		public Timestamp getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Timestamp createTime) {
			this.createTime = createTime;
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
