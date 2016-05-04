package com.cx.wxs.po;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
 * IImage entity. @author MyEclipse Persistence Tools
 * 图片
 */
@Entity
@Table(name = "i_image", catalog = "wxs")
public class IImage implements java.io.Serializable {

	// Fields

	private Integer imageId;
	private UUser UUser;
	private BSite BSite;
	private IAlbum IAlbum;
	private String name;
	private String content;
	private String fileName;
	private String filePath;
	private String url;
	private String previewUrl;
	private String tag;
	private Timestamp time;
	private Short year;
	private Short mount;
	private Short day;
	private Short width;
	private Short height;
	private Integer imageType;
	private Short clientType;
	private String clientIp;
	private String clientAgent;
	private Short status;
	private Integer replyCount;
	private Integer viewCount;
	private Integer downloadCount;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;
	private List<IAccess> IAccesses = new ArrayList<IAccess>(0);
	private List<IUpvote> IUpvotes = new ArrayList<IUpvote>(0);
	private List<IReply1> IReply1s = new ArrayList<IReply1>(0);

	// Constructors

	/** default constructor */
	public IImage() {
	}

	/** minimal constructor */
	public IImage(UUser UUser, IAlbum IAlbum) {
		this.UUser = UUser;
		this.IAlbum = IAlbum;
	}

	/** full constructor */
	public IImage(UUser UUser, BSite BSite, IAlbum IAlbum, String name,
			String content, String fileName, String filePath, String url,
			String previewUrl, String tag, Timestamp time, Short year,
			Short mount, Short day, Short width, Short height,
			Integer imageType, Short clientType, String clientIp,
			String clientAgent, Short status, Integer replyCount,
			Integer viewCount, Integer downloadCount, Integer ext1,
			Integer ext2, String ext3, String ext4, List<IAccess> IAccesses,
			List<IUpvote> IUpvotes, List<IReply1> IReply1s) {
		this.UUser = UUser;
		this.BSite = BSite;
		this.IAlbum = IAlbum;
		this.name = name;
		this.content = content;
		this.fileName = fileName;
		this.filePath = filePath;
		this.url = url;
		this.previewUrl = previewUrl;
		this.tag = tag;
		this.time = time;
		this.year = year;
		this.mount = mount;
		this.day = day;
		this.width = width;
		this.height = height;
		this.imageType = imageType;
		this.clientType = clientType;
		this.clientIp = clientIp;
		this.clientAgent = clientAgent;
		this.status = status;
		this.replyCount = replyCount;
		this.viewCount = viewCount;
		this.downloadCount = downloadCount;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.IAccesses = IAccesses;
		this.IUpvotes = IUpvotes;
		this.IReply1s = IReply1s;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "image_id", unique = true, nullable = false)
	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
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
	@JoinColumn(name = "site_id")
	public BSite getBSite() {
		return this.BSite;
	}

	public void setBSite(BSite BSite) {
		this.BSite = BSite;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "album_id", nullable = false)
	public IAlbum getIAlbum() {
		return this.IAlbum;
	}

	public void setIAlbum(IAlbum IAlbum) {
		this.IAlbum = IAlbum;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "content", length = 1024)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "file_name", length = 100)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "file_path", length = 256)
	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Column(name = "url", length = 256)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "preview_url", length = 256)
	public String getPreviewUrl() {
		return this.previewUrl;
	}

	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}

	@Column(name = "tag", length = 100)
	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "year")
	public Short getYear() {
		return this.year;
	}

	public void setYear(Short year) {
		this.year = year;
	}

	@Column(name = "mount")
	public Short getMount() {
		return this.mount;
	}

	public void setMount(Short mount) {
		this.mount = mount;
	}

	@Column(name = "day")
	public Short getDay() {
		return this.day;
	}

	public void setDay(Short day) {
		this.day = day;
	}

	@Column(name = "width")
	public Short getWidth() {
		return this.width;
	}

	public void setWidth(Short width) {
		this.width = width;
	}

	@Column(name = "height")
	public Short getHeight() {
		return this.height;
	}

	public void setHeight(Short height) {
		this.height = height;
	}

	@Column(name = "image_type")
	public Integer getImageType() {
		return this.imageType;
	}

	public void setImageType(Integer imageType) {
		this.imageType = imageType;
	}

	@Column(name = "client_type")
	public Short getClientType() {
		return this.clientType;
	}

	public void setClientType(Short clientType) {
		this.clientType = clientType;
	}

	@Column(name = "client_ip", length = 50)
	public String getClientIp() {
		return this.clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	@Column(name = "client_agent", length = 250)
	public String getClientAgent() {
		return this.clientAgent;
	}

	public void setClientAgent(String clientAgent) {
		this.clientAgent = clientAgent;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "reply_count")
	public Integer getReplyCount() {
		return this.replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "IImage")
	public List<IAccess> getIAccesses() {
		return this.IAccesses;
	}

	public void setIAccesses(List<IAccess> IAccesses) {
		this.IAccesses = IAccesses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "IImage")
	public List<IUpvote> getIUpvotes() {
		return this.IUpvotes;
	}

	public void setIUpvotes(List<IUpvote> IUpvotes) {
		this.IUpvotes = IUpvotes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "IImage")
	public List<IReply1> getIReply1s() {
		return this.IReply1s;
	}

	public void setIReply1s(List<IReply1> IReply1s) {
		this.IReply1s = IReply1s;
	}

}