package com.cx.wxs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysTopic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_topic", catalog = "wxs")
public class SysTopic implements java.io.Serializable {

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

	// Constructors

	/** default constructor */
	public SysTopic() {
	}

	/** full constructor */
	public SysTopic(Integer userId, String topicKey, String description,
			Integer topicIndex, Timestamp createTime, Integer ext1,
			Integer ext2, String ext3, String ext4) {
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

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "topic_id", unique = true, nullable = false)
	public Integer getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "topic_key", length = 20)
	public String getTopicKey() {
		return this.topicKey;
	}

	public void setTopicKey(String topicKey) {
		this.topicKey = topicKey;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "topic_index")
	public Integer getTopicIndex() {
		return this.topicIndex;
	}

	public void setTopicIndex(Integer topicIndex) {
		this.topicIndex = topicIndex;
	}

	@Column(name = "create_time", length = 0)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "ext1")
	public Integer getExt1() {
		return this.ext1;
	}

	public void setExt1(Integer ext1) {
		this.ext1 = ext1;
	}

	@Column(name = "ext2")
	public Integer getExt2() {
		return this.ext2;
	}

	public void setExt2(Integer ext2) {
		this.ext2 = ext2;
	}

	@Column(name = "ext3", length = 1024)
	public String getExt3() {
		return this.ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	@Column(name = "ext4", length = 1024)
	public String getExt4() {
		return this.ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

}