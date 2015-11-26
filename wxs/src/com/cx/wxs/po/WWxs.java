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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * WWxs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "w_wxs", catalog = "wxs")
public class WWxs implements java.io.Serializable {

	// Fields

	private Integer wxsId;
	private Integer account;
	private String password;
	private String name;
	private String title;
	private String wxsUrl;
	private String wxsDetail;
	private String logo;
	private Integer styleId;
	private Short flag;
	private Timestamp createTime;
	private Timestamp lastTime;
	private Short mode;
	private String accessCode;
	private String indexName;
	private String diaryName;
	private String soundName;
	private String imageName;
	private Integer siteType;
	private Short status;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;
	private Set<WBook> WBooks = new HashSet<WBook>(0);
	private Set<WConfig> WConfigs = new HashSet<WConfig>(0);
	private Set<WLink> WLinks = new HashSet<WLink>(0);
	private Set<WStatus> WStatuses = new HashSet<WStatus>(0);
	private Set<SysInvitationCode> sysInvitationCodes = new HashSet<SysInvitationCode>(
			0);

	// Constructors

	/** default constructor */
	public WWxs() {
	}

	/** minimal constructor */
	public WWxs(Integer account, String password) {
		this.account = account;
		this.password = password;
	}

	/** full constructor */
	public WWxs(Integer account, String password, String name, String title,
			String wxsUrl, String wxsDetail, String logo, Integer styleId,
			Short flag, Timestamp createTime, Timestamp lastTime, Short mode,
			String accessCode, String indexName, String diaryName,
			String soundName, String imageName, Integer siteType, Short status,
			Integer ext1, Integer ext2, String ext3, String ext4,
			Set<WBook> WBooks, Set<WConfig> WConfigs, Set<WLink> WLinks,
			Set<WStatus> WStatuses, Set<SysInvitationCode> sysInvitationCodes) {
		this.account = account;
		this.password = password;
		this.name = name;
		this.title = title;
		this.wxsUrl = wxsUrl;
		this.wxsDetail = wxsDetail;
		this.logo = logo;
		this.styleId = styleId;
		this.flag = flag;
		this.createTime = createTime;
		this.lastTime = lastTime;
		this.mode = mode;
		this.accessCode = accessCode;
		this.indexName = indexName;
		this.diaryName = diaryName;
		this.soundName = soundName;
		this.imageName = imageName;
		this.siteType = siteType;
		this.status = status;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.WBooks = WBooks;
		this.WConfigs = WConfigs;
		this.WLinks = WLinks;
		this.WStatuses = WStatuses;
		this.sysInvitationCodes = sysInvitationCodes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "wxs_id", unique = true, nullable = false)
	public Integer getWxsId() {
		return this.wxsId;
	}

	public void setWxsId(Integer wxsId) {
		this.wxsId = wxsId;
	}

	@Column(name = "account", nullable = false)
	public Integer getAccount() {
		return this.account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	@Column(name = "password", nullable = false, length = 48)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "title", length = 10)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "wxs_url", length = 100)
	public String getWxsUrl() {
		return this.wxsUrl;
	}

	public void setWxsUrl(String wxsUrl) {
		this.wxsUrl = wxsUrl;
	}

	@Column(name = "wxs_detail", length = 65535)
	public String getWxsDetail() {
		return this.wxsDetail;
	}

	public void setWxsDetail(String wxsDetail) {
		this.wxsDetail = wxsDetail;
	}

	@Column(name = "logo", length = 200)
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Column(name = "style_id")
	public Integer getStyleId() {
		return this.styleId;
	}

	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}

	@Column(name = "flag")
	public Short getFlag() {
		return this.flag;
	}

	public void setFlag(Short flag) {
		this.flag = flag;
	}

	@Column(name = "create_time", length = 0)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "last_time", length = 0)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "WWxs")
	public Set<WBook> getWBooks() {
		return this.WBooks;
	}

	public void setWBooks(Set<WBook> WBooks) {
		this.WBooks = WBooks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "WWxs")
	public Set<WConfig> getWConfigs() {
		return this.WConfigs;
	}

	public void setWConfigs(Set<WConfig> WConfigs) {
		this.WConfigs = WConfigs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "WWxs")
	public Set<WLink> getWLinks() {
		return this.WLinks;
	}

	public void setWLinks(Set<WLink> WLinks) {
		this.WLinks = WLinks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "WWxs")
	public Set<WStatus> getWStatuses() {
		return this.WStatuses;
	}

	public void setWStatuses(Set<WStatus> WStatuses) {
		this.WStatuses = WStatuses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "WWxs")
	public Set<SysInvitationCode> getSysInvitationCodes() {
		return this.sysInvitationCodes;
	}

	public void setSysInvitationCodes(Set<SysInvitationCode> sysInvitationCodes) {
		this.sysInvitationCodes = sysInvitationCodes;
	}

}