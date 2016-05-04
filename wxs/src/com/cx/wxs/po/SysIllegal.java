package com.cx.wxs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * SysIllegal entity. @author MyEclipse Persistence Tools
 * 非法词汇表
 */
@Entity
@Table(name = "sys_illegal", catalog = "wxs", uniqueConstraints = @UniqueConstraint(columnNames = "word"))
public class SysIllegal implements java.io.Serializable {

	// Fields

	private Integer illegalId;
	private String word;
	private String newword;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Short nullify;

	// Constructors

	/** default constructor */
	public SysIllegal() {
	}

	/** minimal constructor */
	public SysIllegal(String word) {
		this.word = word;
	}

	/** full constructor */
	public SysIllegal(String word, String newword, Timestamp createTime,
			Timestamp updateTime, Short nullify) {
		this.word = word;
		this.newword = newword;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.nullify = nullify;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "illegal_id", unique = true, nullable = false)
	public Integer getIllegalId() {
		return this.illegalId;
	}

	public void setIllegalId(Integer illegalId) {
		this.illegalId = illegalId;
	}

	@Column(name = "word", unique = true, nullable = false, length = 10)
	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Column(name = "newword", length = 10)
	public String getNewword() {
		return this.newword;
	}

	public void setNewword(String newword) {
		this.newword = newword;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "nullify")
	public Short getNullify() {
		return this.nullify;
	}

	public void setNullify(Short nullify) {
		this.nullify = nullify;
	}

}