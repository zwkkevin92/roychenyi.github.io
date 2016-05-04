package com.cx.wxs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BTag entity. @author MyEclipse Persistence Tools
 * 标签表
 */
@Entity
@Table(name = "b_tag", catalog = "wxs")
public class BTag implements java.io.Serializable {

	// Fields

	private Integer tagId;
	private BSite BSite;
	private DDiary DDiary;
	private Short refType;
	private Timestamp time;
	private String tagName;

	// Constructors

	/** default constructor */
	public BTag() {
	}

	/** minimal constructor */
	public BTag(BSite BSite, DDiary DDiary) {
		this.BSite = BSite;
		this.DDiary = DDiary;
	}

	/** full constructor */
	public BTag(BSite BSite, DDiary DDiary, Short refType, Timestamp time,
			String tagName) {
		this.BSite = BSite;
		this.DDiary = DDiary;
		this.refType = refType;
		this.time = time;
		this.tagName = tagName;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tag_id", unique = true, nullable = false)
	public Integer getTagId() {
		return this.tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_id", nullable = false)
	public BSite getBSite() {
		return this.BSite;
	}

	public void setBSite(BSite BSite) {
		this.BSite = BSite;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ref_id", nullable = false)
	public DDiary getDDiary() {
		return this.DDiary;
	}

	public void setDDiary(DDiary DDiary) {
		this.DDiary = DDiary;
	}

	@Column(name = "ref_type")
	public Short getRefType() {
		return this.refType;
	}

	public void setRefType(Short refType) {
		this.refType = refType;
	}

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "tag_name", length = 20)
	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}