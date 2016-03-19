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
 * UBook entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "u_book", catalog = "wxs")
public class UBook implements java.io.Serializable {

	// Fields

	private Integer ubookId;
	private UUser UUser;
	private Integer name;
	private String bookDetaik;
	private String cover;
	private Timestamp time;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;

	// Constructors

	/** default constructor */
	public UBook() {
	}

	/** minimal constructor */
	public UBook(UUser UUser, Integer name) {
		this.UUser = UUser;
		this.name = name;
	}

	/** full constructor */
	public UBook(UUser UUser, Integer name, String bookDetaik, String cover,
			Timestamp time, Integer ext1, Integer ext2, String ext3, String ext4) {
		this.UUser = UUser;
		this.name = name;
		this.bookDetaik = bookDetaik;
		this.cover = cover;
		this.time = time;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ubook_id", unique = true, nullable = false)
	public Integer getUbookId() {
		return this.ubookId;
	}

	public void setUbookId(Integer ubookId) {
		this.ubookId = ubookId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@Column(name = "name", nullable = false)
	public Integer getName() {
		return this.name;
	}

	public void setName(Integer name) {
		this.name = name;
	}

	@Column(name = "book_detaik", length = 65535)
	public String getBookDetaik() {
		return this.bookDetaik;
	}

	public void setBookDetaik(String bookDetaik) {
		this.bookDetaik = bookDetaik;
	}

	@Column(name = "cover", length = 50)
	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
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