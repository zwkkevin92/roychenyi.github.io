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
 * DAnnex entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "d_annex", catalog = "wxs")
public class DAnnex implements java.io.Serializable {

	// Fields

	private Integer annexId;
	private DDiary DDiary;
	private UUser UUser;
	private BSite BSite;
	private Timestamp uploadTime;
	private Integer downloadCount;
	private Short status;
	private Short validate;
	private String url;
	private String path;
	private String fileName;
	private String fileDescription;
	private Integer size;
	private Timestamp lastTime;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;

	// Constructors

	/** default constructor */
	public DAnnex() {
	}

	/** minimal constructor */
	public DAnnex(DDiary DDiary, UUser UUser, BSite BSite) {
		this.DDiary = DDiary;
		this.UUser = UUser;
		this.BSite = BSite;
	}

	/** full constructor */
	public DAnnex(DDiary DDiary, UUser UUser, BSite BSite,
			Timestamp uploadTime, Integer downloadCount, Short status,
			Short validate, String url, String path, String fileName,
			String fileDescription, Integer size, Timestamp lastTime,
			Integer ext1, Integer ext2, String ext3, String ext4) {
		this.DDiary = DDiary;
		this.UUser = UUser;
		this.BSite = BSite;
		this.uploadTime = uploadTime;
		this.downloadCount = downloadCount;
		this.status = status;
		this.validate = validate;
		this.url = url;
		this.path = path;
		this.fileName = fileName;
		this.fileDescription = fileDescription;
		this.size = size;
		this.lastTime = lastTime;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "annex_id", unique = true, nullable = false)
	public Integer getAnnexId() {
		return this.annexId;
	}

	public void setAnnexId(Integer annexId) {
		this.annexId = annexId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "diary_id", nullable = false)
	public DDiary getDDiary() {
		return this.DDiary;
	}

	public void setDDiary(DDiary DDiary) {
		this.DDiary = DDiary;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_id", nullable = false)
	public BSite getBSite() {
		return this.BSite;
	}

	public void setBSite(BSite BSite) {
		this.BSite = BSite;
	}

	@Column(name = "upload_time", length = 0)
	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Column(name = "download_count")
	public Integer getDownloadCount() {
		return this.downloadCount;
	}

	public void setDownloadCount(Integer downloadCount) {
		this.downloadCount = downloadCount;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "validate")
	public Short getValidate() {
		return this.validate;
	}

	public void setValidate(Short validate) {
		this.validate = validate;
	}

	@Column(name = "url", length = 256)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "path", length = 256)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "file_name", length = 256)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "file_description", length = 1024)
	public String getFileDescription() {
		return this.fileDescription;
	}

	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}

	@Column(name = "size")
	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Column(name = "last_time", length = 0)
	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
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