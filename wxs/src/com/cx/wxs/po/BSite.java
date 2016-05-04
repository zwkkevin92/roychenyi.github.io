package com.cx.wxs.po;

import java.sql.Timestamp;
import java.util.ArrayList;
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
 * BSite entity. @author MyEclipse Persistence Tools
 * 站点表
 */
@Entity
@Table(name = "b_site", catalog = "wxs")
public class BSite implements java.io.Serializable {

	// Fields

	private Integer siteId;
	private SysStyle sysStyle;
	private UUser UUser;
	private String name;
	private String title;
	private String siteUrl;
	private String siteDetail;
	private String logo;  
	private Short flag;
	private Timestamp createTime;
	private Timestamp lastTime;
	private Short mode;
	private String accessCode;
	private String indexName;
	private String diaryName;
	private String soundName;
	private String imageName;
	private String friendName;
	private Integer siteType;
	private Short status;
	private List<MGuestbook> MGuestbooks = new ArrayList<MGuestbook>(0);
	private List<UUser> UUsers = new ArrayList<UUser>(0);
	private List<DCatalog> DCatalogs = new ArrayList<DCatalog>(0);
	private List<DAnnex> DAnnexes = new ArrayList<DAnnex>(0);
	private List<BStatus> BStatuses = new ArrayList<BStatus>(0);
	private List<IAlbum> IAlbums = new ArrayList<IAlbum>(0);
	private List<DDiary> DDiaries = new ArrayList<DDiary>(0);
	private List<BTag> BTags = new ArrayList<BTag>(0);
	private List<BConfig> BConfigs = new ArrayList<BConfig>(0);
	private List<BAccess> BAccesses = new ArrayList<BAccess>(0);
	private List<IImage> IImages = new ArrayList<IImage>(0);

	// Constructors

	/** default constructor */
	public BSite() {
	}

	/** minimal constructor */
	public BSite(SysStyle sysStyle, UUser UUser, String name, String title,
			String siteUrl) {
		this.sysStyle = sysStyle;
		this.UUser = UUser;
		this.name = name;
		this.title = title;
		this.siteUrl = siteUrl;
	}

	/** full constructor */
	public BSite(SysStyle sysStyle, UUser UUser, String name, String title,
			String siteUrl, String siteDetail, String logo, Short flag,
			Timestamp createTime, Timestamp lastTime, Short mode,
			String accessCode, String indexName, String diaryName,
			String soundName, String imageName, String friendName,
			Integer siteType, Short status, List<MGuestbook> MGuestbooks,
			List<UUser> UUsers, List<DCatalog> DCatalogs, List<DAnnex> DAnnexes,
			List<BStatus> BStatuses, List<IAlbum> IAlbums, List<DDiary> DDiaries,
			List<BTag> BTags, List<BConfig> BConfigs, List<BAccess> BAccesses,
			List<IImage> IImages) {
		this.sysStyle = sysStyle;
		this.UUser = UUser;
		this.name = name;
		this.title = title;
		this.siteUrl = siteUrl;
		this.siteDetail = siteDetail;
		this.logo = logo;
		this.flag = flag;
		this.createTime = createTime;
		this.lastTime = lastTime;
		this.mode = mode;
		this.accessCode = accessCode;
		this.indexName = indexName;
		this.diaryName = diaryName;
		this.soundName = soundName;
		this.imageName = imageName;
		this.friendName = friendName;
		this.siteType = siteType;
		this.status = status;
		this.MGuestbooks = MGuestbooks;
		this.UUsers = UUsers;
		this.DCatalogs = DCatalogs;
		this.DAnnexes = DAnnexes;
		this.BStatuses = BStatuses;
		this.IAlbums = IAlbums;
		this.DDiaries = DDiaries;
		this.BTags = BTags;
		this.BConfigs = BConfigs;
		this.BAccesses = BAccesses;
		this.IImages = IImages;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "site_id", unique = true, nullable = false)
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "style_id", nullable = false)
	public SysStyle getSysStyle() {
		return this.sysStyle;
	}

	public void setSysStyle(SysStyle sysStyle) {
		this.sysStyle = sysStyle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "title", nullable = false, length = 10)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "site_url", nullable = false, length = 100)
	public String getSiteUrl() {
		return this.siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	@Column(name = "site_detail", length = 250)
	public String getSiteDetail() {
		return this.siteDetail;
	}

	public void setSiteDetail(String siteDetail) {
		this.siteDetail = siteDetail;
	}

	@Column(name = "logo", length = 50)
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Column(name = "flag")
	public Short getFlag() {
		return this.flag;
	}

	public void setFlag(Short flag) {
		this.flag = flag;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "last_time", length = 19)
	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

	@Column(name = "mode")
	public Short getMode() {
		return this.mode;
	}

	public void setMode(Short mode) {
		this.mode = mode;
	}

	@Column(name = "access_code", length = 50)
	public String getAccessCode() {
		return this.accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	@Column(name = "index_name", length = 10)
	public String getIndexName() {
		return this.indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	@Column(name = "diary_name", length = 10)
	public String getDiaryName() {
		return this.diaryName;
	}

	public void setDiaryName(String diaryName) {
		this.diaryName = diaryName;
	}

	@Column(name = "sound_name", length = 10)
	public String getSoundName() {
		return this.soundName;
	}

	public void setSoundName(String soundName) {
		this.soundName = soundName;
	}

	@Column(name = "image_name", length = 10)
	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Column(name = "friend_name", length = 10)
	public String getFriendName() {
		return this.friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	@Column(name = "site_type")
	public Integer getSiteType() {
		return this.siteType;
	}

	public void setSiteType(Integer siteType) {
		this.siteType = siteType;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "BSite")
	public List<MGuestbook> getMGuestbooks() {
		return this.MGuestbooks;
	}

	public void setMGuestbooks(List<MGuestbook> MGuestbooks) {
		this.MGuestbooks = MGuestbooks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "BSite")
	public List<UUser> getUUsers() {
		return this.UUsers;
	}

	public void setUUsers(List<UUser> UUsers) {
		this.UUsers = UUsers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "BSite")
	public List<DCatalog> getDCatalogs() {
		return this.DCatalogs;
	}

	public void setDCatalogs(List<DCatalog> DCatalogs) {
		this.DCatalogs = DCatalogs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "BSite")
	public List<DAnnex> getDAnnexes() {
		return this.DAnnexes;
	}

	public void setDAnnexes(List<DAnnex> DAnnexes) {
		this.DAnnexes = DAnnexes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "BSite")
	public List<BStatus> getBStatuses() {
		return this.BStatuses;
	}

	public void setBStatuses(List<BStatus> BStatuses) {
		this.BStatuses = BStatuses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "BSite")
	public List<IAlbum> getIAlbums() {
		return this.IAlbums;
	}

	public void setIAlbums(List<IAlbum> IAlbums) {
		this.IAlbums = IAlbums;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "BSite")
	public List<DDiary> getDDiaries() {
		return this.DDiaries;
	}

	public void setDDiaries(List<DDiary> DDiaries) {
		this.DDiaries = DDiaries;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "BSite")
	public List<BTag> getBTags() {
		return this.BTags;
	}

	public void setBTags(List<BTag> BTags) {
		this.BTags = BTags;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "BSite")
	public List<BConfig> getBConfigs() {
		return this.BConfigs;
	}

	public void setBConfigs(List<BConfig> BConfigs) {
		this.BConfigs = BConfigs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "BSite")
	public List<BAccess> getBAccesses() {
		return this.BAccesses;
	}

	public void setBAccesses(List<BAccess> BAccesses) {
		this.BAccesses = BAccesses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "BSite")
	public List<IImage> getIImages() {
		return this.IImages;
	}

	public void setIImages(List<IImage> IImages) {
		this.IImages = IImages;
	}

}