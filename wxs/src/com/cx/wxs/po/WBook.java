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
 * WBook entity. @author MyEclipse Persistence Tools
 * 文学社书刊
 */
@Entity
@Table(name = "w_book", catalog = "wxs")
public class WBook implements java.io.Serializable {

	// Fields

	private Integer wbookId;
	private WWxs WWxs;
	private String name;
	private String bookDateil;
	private String cover;
	private Timestamp createTime;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;

	// Constructors

	/** default constructor */
	public WBook() {
	}

	/** minimal constructor */
	public WBook(WWxs WWxs) {
		this.WWxs = WWxs;
	}

	/** full constructor */
	public WBook(WWxs WWxs, String name, String bookDateil, String cover,
			Timestamp createTime, Integer ext1, Integer ext2, String ext3,
			String ext4) {
		this.WWxs = WWxs;
		this.name = name;
		this.bookDateil = bookDateil;
		this.cover = cover;
		this.createTime = createTime;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "wbook_id", unique = true, nullable = false)
	public Integer getWbookId() {
		return this.wbookId;
	}

	public void setWbookId(Integer wbookId) {
		this.wbookId = wbookId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wxs_id", nullable = false)
	public WWxs getWWxs() {
		return this.WWxs;
	}

	public void setWWxs(WWxs WWxs) {
		this.WWxs = WWxs;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "book_dateil", length = 65535)
	public String getBookDateil() {
		return this.bookDateil;
	}

	public void setBookDateil(String bookDateil) {
		this.bookDateil = bookDateil;
	}

	@Column(name = "cover", length = 50)
	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Column(name = "create_time", length = 19)
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