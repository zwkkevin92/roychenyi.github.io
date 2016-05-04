package com.cx.wxs.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SSound entity. @author MyEclipse Persistence Tools
 * 声音
 */
@Entity
@Table(name = "s_sound", catalog = "wxs")
public class SSound implements java.io.Serializable {

	// Fields

	private Integer soundId;
	private UUser UUser;
	private SBox SBox;
	private String title;
	private String content;
	private String url;
	private String fileName;
	private String filePath;
	private Timestamp time;
	private Short status;
	private Integer viewCount;
	private Integer downloadCount;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;
	private Set<SReply1> SReply1s = new HashSet<SReply1>(0);
	private Set<SUpvote> SUpvotes = new HashSet<SUpvote>(0);
	private Set<SAccess> SAccesses = new HashSet<SAccess>(0);

	// Constructors

	/** default constructor */
	public SSound() {
	}

	/** minimal constructor */
	public SSound(UUser UUser, SBox SBox) {
		this.UUser = UUser;
		this.SBox = SBox;
	}

	/** full constructor */
	public SSound(UUser UUser, SBox SBox, String title, String content,
			String url, String fileName, String filePath, Timestamp time,
			Short status, Integer viewCount, Integer downloadCount,
			Integer ext1, Integer ext2, String ext3, String ext4,
			Set<SReply1> SReply1s, Set<SUpvote> SUpvotes, Set<SAccess> SAccesses) {
		this.UUser = UUser;
		this.SBox = SBox;
		this.title = title;
		this.content = content;
		this.url = url;
		this.fileName = fileName;
		this.filePath = filePath;
		this.time = time;
		this.status = status;
		this.viewCount = viewCount;
		this.downloadCount = downloadCount;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.SReply1s = SReply1s;
		this.SUpvotes = SUpvotes;
		this.SAccesses = SAccesses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sound_id", unique = true, nullable = false)
	public Integer getSoundId() {
		return this.soundId;
	}

	public void setSoundId(Integer soundId) {
		this.soundId = soundId;
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
	@JoinColumn(name = "box_id", nullable = false)
	public SBox getSBox() {
		return this.SBox;
	}

	public void setSBox(SBox SBox) {
		this.SBox = SBox;
	}

	@Column(name = "title", length = 20)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 1024)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "url", length = 256)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "file_name", length = 100)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "file_path", length = 200)
	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "view_count")
	public Integer getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	@Column(name = "download_count")
	public Integer getDownloadCount() {
		return this.downloadCount;
	}

	public void setDownloadCount(Integer downloadCount) {
		this.downloadCount = downloadCount;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "SSound")
	public Set<SReply1> getSReply1s() {
		return this.SReply1s;
	}

	public void setSReply1s(Set<SReply1> SReply1s) {
		this.SReply1s = SReply1s;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "SSound")
	public Set<SUpvote> getSUpvotes() {
		return this.SUpvotes;
	}

	public void setSUpvotes(Set<SUpvote> SUpvotes) {
		this.SUpvotes = SUpvotes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "SSound")
	public Set<SAccess> getSAccesses() {
		return this.SAccesses;
	}

	public void setSAccesses(Set<SAccess> SAccesses) {
		this.SAccesses = SAccesses;
	}

}