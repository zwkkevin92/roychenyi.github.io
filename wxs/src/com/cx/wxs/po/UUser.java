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
 * UUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "u_user", catalog = "wxs")
public class UUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private USign USign;
	private BSite BSite;
	private SysRank sysRank;
	private String username;
	private String password;
	private String nickname;
	private Integer roleId;
	private Short sex;
	private Timestamp birth;
	private String email;
	private String homepage;
	private String qq;
	private String mobile;
	private Integer provinceId;
	private Integer cityId;
	private Integer schoolId;
	private Integer collegeId;
	private String class_;
	private String portrait;
	private Timestamp regtime;
	private Timestamp lastTime;
	private String lastIp;
	private Short keepDay;
	private Short onlineStatus;
	private Integer rank;
	private Integer articleCount;
	private Integer articleReplyCount;
	private Integer topicCount;
	private Integer topicReplyCount;
	private Integer imageCount;
	private Integer imageReplyCount;
	private Integer guestbookCount;
	private Integer tagCount;
	private Integer fans;
	private Integer follows;
	private Integer popedom;
	private Integer codeId;
	private Set<DDiary> DDiaries = new HashSet<DDiary>(0);
	private Set<VVote> VVotes = new HashSet<VVote>(0);
	private Set<DUpvote> DUpvotes = new HashSet<DUpvote>(0);
	private Set<DReply1> DReply1s = new HashSet<DReply1>(0);
	private Set<IReply2> IReply2sForUserId = new HashSet<IReply2>(0);
	private Set<SSound> SSounds = new HashSet<SSound>(0);
	private Set<USign> USigns = new HashSet<USign>(0);
	private Set<SReply2> SReply2sForCommentator = new HashSet<SReply2>(0);
	private Set<BAccess> BAccesses = new HashSet<BAccess>(0);
	private Set<VUpvote> VUpvotes = new HashSet<VUpvote>(0);
	private Set<IImage> IImages = new HashSet<IImage>(0);
	private Set<VReply1> VReply1s = new HashSet<VReply1>(0);
	private Set<DCatalog> DCatalogs = new HashSet<DCatalog>(0);
	private Set<MAffiche> MAffiches = new HashSet<MAffiche>(0);
	private Set<DReply2> DReply2sForCommentator = new HashSet<DReply2>(0);
	private Set<WAccess> WAccesses = new HashSet<WAccess>(0);
	private Set<BSite> BSites = new HashSet<BSite>(0);
	private Set<SUpvote> SUpvotes = new HashSet<SUpvote>(0);
	private Set<IReply1> IReply1s = new HashSet<IReply1>(0);
	private Set<IUpvote> IUpvotes = new HashSet<IUpvote>(0);
	private Set<SysLoginRecord> sysLoginRecords = new HashSet<SysLoginRecord>(0);
	private Set<SBox> SBoxes = new HashSet<SBox>(0);
	private Set<VReply2> VReply2sForCommentator = new HashSet<VReply2>(0);
	private Set<SReply2> SReply2sForUserId = new HashSet<SReply2>(0);
	private Set<UFriendGroup> UFriendGroups = new HashSet<UFriendGroup>(0);
	private Set<MGuestbook> MGuestbooks = new HashSet<MGuestbook>(0);
	private Set<IAlbum> IAlbums = new HashSet<IAlbum>(0);
	private Set<SAccess> SAccesses = new HashSet<SAccess>(0);
	private Set<VReply2> VReply2sForUserId = new HashSet<VReply2>(0);
	private Set<VCount> VCounts = new HashSet<VCount>(0);
	private Set<DAnnex> DAnnexes = new HashSet<DAnnex>(0);
	private Set<UBook> UBooks = new HashSet<UBook>(0);
	private Set<IAccess> IAccesses = new HashSet<IAccess>(0);
	private Set<BBacklist> BBacklistsForUserId = new HashSet<BBacklist>(0);
	private Set<DReply2> DReply2sForUserId = new HashSet<DReply2>(0);
	private Set<MMessage> MMessagesForUserId = new HashSet<MMessage>(0);
	private Set<VAccess> VAccesses = new HashSet<VAccess>(0);
	private Set<SysInvitationCode> sysInvitationCodes = new HashSet<SysInvitationCode>(
			0);
	private Set<MMessage> MMessagesForReceiveId = new HashSet<MMessage>(0);
	private Set<MReply> MReplies = new HashSet<MReply>(0);
	private Set<IReply2> IReply2sForCommentator = new HashSet<IReply2>(0);
	private Set<SReply1> SReply1s = new HashSet<SReply1>(0);
	private Set<DAccess> DAccesses = new HashSet<DAccess>(0);
	private Set<BBacklist> BBacklistsForBackId = new HashSet<BBacklist>(0);

	// Constructors

	/** default constructor */
	public UUser() {
	}

	/** minimal constructor */
	public UUser(String username, String password, String nickname,
			Integer roleId) {
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.roleId = roleId;
	}

	/** full constructor */
	public UUser(USign USign, BSite BSite, SysRank sysRank, String username,
			String password, String nickname, Integer roleId, Short sex,
			Timestamp birth, String email, String homepage, String qq,
			String mobile, Integer provinceId, Integer cityId,
			Integer schoolId, Integer collegeId, String class_,
			String portrait, Timestamp regtime, Timestamp lastTime,
			String lastIp, Short keepDay, Short onlineStatus,Integer rank,
			Integer articleCount, Integer articleReplyCount,
			Integer topicCount, Integer topicReplyCount, Integer imageCount,
			Integer imageReplyCount, Integer guestbookCount, Integer tagCount,
			Integer fans,Integer follows, Integer popedom, Integer codeId, Set<DDiary> DDiaries,
			Set<VVote> VVotes, Set<DUpvote> DUpvotes, Set<DReply1> DReply1s,
			Set<IReply2> IReply2sForUserId, Set<SSound> SSounds,
			Set<USign> USigns, Set<SReply2> SReply2sForCommentator,
			Set<BAccess> BAccesses, Set<VUpvote> VUpvotes, Set<IImage> IImages,
			Set<VReply1> VReply1s, Set<DCatalog> DCatalogs,
			Set<MAffiche> MAffiches, Set<DReply2> DReply2sForCommentator,
			Set<WAccess> WAccesses, Set<BSite> BSites, Set<SUpvote> SUpvotes,
			Set<IReply1> IReply1s, Set<IUpvote> IUpvotes,
			Set<SysLoginRecord> sysLoginRecords, Set<SBox> SBoxes,
			Set<VReply2> VReply2sForCommentator,
			Set<SReply2> SReply2sForUserId, Set<UFriendGroup> UFriendGroups,
			Set<MGuestbook> MGuestbooks, Set<IAlbum> IAlbums,
			Set<SAccess> SAccesses, Set<VReply2> VReply2sForUserId,
			Set<VCount> VCounts, Set<DAnnex> DAnnexes, Set<UBook> UBooks,
			Set<IAccess> IAccesses, Set<BBacklist> BBacklistsForUserId,
			Set<DReply2> DReply2sForUserId, Set<MMessage> MMessagesForUserId,
			Set<VAccess> VAccesses, Set<SysInvitationCode> sysInvitationCodes,
			Set<MMessage> MMessagesForReceiveId, Set<MReply> MReplies,
			Set<IReply2> IReply2sForCommentator, Set<SReply1> SReply1s,
			Set<DAccess> DAccesses, Set<BBacklist> BBacklistsForBackId) {
		this.USign = USign;
		this.BSite = BSite;
		this.sysRank = sysRank;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.roleId = roleId;
		this.sex = sex;
		this.birth = birth;
		this.email = email;
		this.homepage = homepage;
		this.qq = qq;
		this.mobile = mobile;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.schoolId = schoolId;
		this.collegeId = collegeId;
		this.class_ = class_;
		this.portrait = portrait;
		this.regtime = regtime;
		this.lastTime = lastTime;
		this.lastIp = lastIp;
		this.keepDay = keepDay;
		this.onlineStatus = onlineStatus;
		this.rank=rank;
		this.articleCount = articleCount;
		this.articleReplyCount = articleReplyCount;
		this.topicCount = topicCount;
		this.topicReplyCount = topicReplyCount;
		this.imageCount = imageCount;
		this.imageReplyCount = imageReplyCount;
		this.guestbookCount = guestbookCount;
		this.tagCount = tagCount;
		this.fans=fans;
		this.follows=follows;
		this.popedom = popedom;
		this.codeId = codeId;
		this.DDiaries = DDiaries;
		this.VVotes = VVotes;
		this.DUpvotes = DUpvotes;
		this.DReply1s = DReply1s;
		this.IReply2sForUserId = IReply2sForUserId;
		this.SSounds = SSounds;
		this.USigns = USigns;
		this.SReply2sForCommentator = SReply2sForCommentator;
		this.BAccesses = BAccesses;
		this.VUpvotes = VUpvotes;
		this.IImages = IImages;
		this.VReply1s = VReply1s;
		this.DCatalogs = DCatalogs;
		this.MAffiches = MAffiches;
		this.DReply2sForCommentator = DReply2sForCommentator;
		this.WAccesses = WAccesses;
		this.BSites = BSites;
		this.SUpvotes = SUpvotes;
		this.IReply1s = IReply1s;
		this.IUpvotes = IUpvotes;
		this.sysLoginRecords = sysLoginRecords;
		this.SBoxes = SBoxes;
		this.VReply2sForCommentator = VReply2sForCommentator;
		this.SReply2sForUserId = SReply2sForUserId;
		this.UFriendGroups = UFriendGroups;
		this.MGuestbooks = MGuestbooks;
		this.IAlbums = IAlbums;
		this.SAccesses = SAccesses;
		this.VReply2sForUserId = VReply2sForUserId;
		this.VCounts = VCounts;
		this.DAnnexes = DAnnexes;
		this.UBooks = UBooks;
		this.IAccesses = IAccesses;
		this.BBacklistsForUserId = BBacklistsForUserId;
		this.DReply2sForUserId = DReply2sForUserId;
		this.MMessagesForUserId = MMessagesForUserId;
		this.VAccesses = VAccesses;
		this.sysInvitationCodes = sysInvitationCodes;
		this.MMessagesForReceiveId = MMessagesForReceiveId;
		this.MReplies = MReplies;
		this.IReply2sForCommentator = IReply2sForCommentator;
		this.SReply1s = SReply1s;
		this.DAccesses = DAccesses;
		this.BBacklistsForBackId = BBacklistsForBackId;
	}

	
	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sign_id")
	public USign getUSign() {
		return this.USign;
	}

	public void setUSign(USign USign) {
		this.USign = USign;
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
	@JoinColumn(name = "rank_id")
	public SysRank getSysRank() {
		return this.sysRank;
	}

	public void setSysRank(SysRank sysRank) {
		this.sysRank = sysRank;
	}

	@Column(name = "username", nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "nickname", nullable = false, length = 20)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "role_id", nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "sex")
	public Short getSex() {
		return this.sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	@Column(name = "birth", length = 19)
	public Timestamp getBirth() {
		return this.birth;
	}

	public void setBirth(Timestamp birth) {
		this.birth = birth;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "homepage", length = 100)
	public String getHomepage() {
		return this.homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	@Column(name = "qq", length = 16)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "mobile", length = 16)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "province_id")
	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	@Column(name = "city_id")
	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Column(name = "school_id")
	public Integer getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	@Column(name = "college_id")
	public Integer getCollegeId() {
		return this.collegeId;
	}

	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}

	@Column(name = "class", length = 10)
	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	@Column(name = "portrait", length = 100)
	public String getPortrait() {
		return this.portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	@Column(name = "regtime", length = 19)
	public Timestamp getRegtime() {
		return this.regtime;
	}

	public void setRegtime(Timestamp regtime) {
		this.regtime = regtime;
	}

	@Column(name = "last_time", length = 19)
	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

	@Column(name = "last_ip", length = 48)
	public String getLastIp() {
		return this.lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	@Column(name = "keep_day")
	public Short getKeepDay() {
		return this.keepDay;
	}

	public void setKeepDay(Short keepDay) {
		this.keepDay = keepDay;
	}

	@Column(name = "online_status")
	public Short getOnlineStatus() {
		return this.onlineStatus;
	}

	public void setOnlineStatus(Short onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
	
	@Column(name="rank")
	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@Column(name = "article_count")
	public Integer getArticleCount() {
		return this.articleCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}

	@Column(name = "article_reply_count")
	public Integer getArticleReplyCount() {
		return this.articleReplyCount;
	}

	public void setArticleReplyCount(Integer articleReplyCount) {
		this.articleReplyCount = articleReplyCount;
	}

	@Column(name = "topic_count")
	public Integer getTopicCount() {
		return this.topicCount;
	}

	public void setTopicCount(Integer topicCount) {
		this.topicCount = topicCount;
	}

	@Column(name = "topic_reply_count")
	public Integer getTopicReplyCount() {
		return this.topicReplyCount;
	}

	public void setTopicReplyCount(Integer topicReplyCount) {
		this.topicReplyCount = topicReplyCount;
	}

	@Column(name = "image_count")
	public Integer getImageCount() {
		return this.imageCount;
	}

	public void setImageCount(Integer imageCount) {
		this.imageCount = imageCount;
	}

	@Column(name = "image_reply_count")
	public Integer getImageReplyCount() {
		return this.imageReplyCount;
	}

	public void setImageReplyCount(Integer imageReplyCount) {
		this.imageReplyCount = imageReplyCount;
	}

	@Column(name = "guestbook_count")
	public Integer getGuestbookCount() {
		return this.guestbookCount;
	}

	public void setGuestbookCount(Integer guestbookCount) {
		this.guestbookCount = guestbookCount;
	}

	@Column(name = "tag_count")
	public Integer getTagCount() {
		return this.tagCount;
	}

	public void setTagCount(Integer tagCount) {
		this.tagCount = tagCount;
	}
	
	@Column(name="fans")
	public Integer getFans() {
		return fans;
	}

	public void setFans(Integer fans) {
		this.fans = fans;
	}

	@Column(name="follows")
	public Integer getFollows() {
		return follows;
	}

	/**
	 * @param follows the follows to set
	 */
	public void setFollows(Integer follows) {
		this.follows = follows;
	}

	@Column(name = "popedom")
	public Integer getPopedom() {
		return this.popedom;
	}

	public void setPopedom(Integer popedom) {
		this.popedom = popedom;
	}

	@Column(name = "coid_id")
	public Integer getCodeId() {
		return this.codeId;
	}

	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<DDiary> getDDiaries() {
		return this.DDiaries;
	}

	public void setDDiaries(Set<DDiary> DDiaries) {
		this.DDiaries = DDiaries;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<VVote> getVVotes() {
		return this.VVotes;
	}

	public void setVVotes(Set<VVote> VVotes) {
		this.VVotes = VVotes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<DUpvote> getDUpvotes() {
		return this.DUpvotes;
	}

	public void setDUpvotes(Set<DUpvote> DUpvotes) {
		this.DUpvotes = DUpvotes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<DReply1> getDReply1s() {
		return this.DReply1s;
	}

	public void setDReply1s(Set<DReply1> DReply1s) {
		this.DReply1s = DReply1s;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUserByUserId")
	public Set<IReply2> getIReply2sForUserId() {
		return this.IReply2sForUserId;
	}

	public void setIReply2sForUserId(Set<IReply2> IReply2sForUserId) {
		this.IReply2sForUserId = IReply2sForUserId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<SSound> getSSounds() {
		return this.SSounds;
	}

	public void setSSounds(Set<SSound> SSounds) {
		this.SSounds = SSounds;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<USign> getUSigns() {
		return this.USigns;
	}

	public void setUSigns(Set<USign> USigns) {
		this.USigns = USigns;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUserByCommentator")
	public Set<SReply2> getSReply2sForCommentator() {
		return this.SReply2sForCommentator;
	}

	public void setSReply2sForCommentator(Set<SReply2> SReply2sForCommentator) {
		this.SReply2sForCommentator = SReply2sForCommentator;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<BAccess> getBAccesses() {
		return this.BAccesses;
	}

	public void setBAccesses(Set<BAccess> BAccesses) {
		this.BAccesses = BAccesses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "VVote")
	public Set<VUpvote> getVUpvotes() {
		return this.VUpvotes;
	}

	public void setVUpvotes(Set<VUpvote> VUpvotes) {
		this.VUpvotes = VUpvotes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<IImage> getIImages() {
		return this.IImages;
	}

	public void setIImages(Set<IImage> IImages) {
		this.IImages = IImages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<VReply1> getVReply1s() {
		return this.VReply1s;
	}

	public void setVReply1s(Set<VReply1> VReply1s) {
		this.VReply1s = VReply1s;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<DCatalog> getDCatalogs() {
		return this.DCatalogs;
	}

	public void setDCatalogs(Set<DCatalog> DCatalogs) {
		this.DCatalogs = DCatalogs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<MAffiche> getMAffiches() {
		return this.MAffiches;
	}

	public void setMAffiches(Set<MAffiche> MAffiches) {
		this.MAffiches = MAffiches;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUserByCommentator")
	public Set<DReply2> getDReply2sForCommentator() {
		return this.DReply2sForCommentator;
	}

	public void setDReply2sForCommentator(Set<DReply2> DReply2sForCommentator) {
		this.DReply2sForCommentator = DReply2sForCommentator;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<WAccess> getWAccesses() {
		return this.WAccesses;
	}

	public void setWAccesses(Set<WAccess> WAccesses) {
		this.WAccesses = WAccesses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<BSite> getBSites() {
		return this.BSites;
	}

	public void setBSites(Set<BSite> BSites) {
		this.BSites = BSites;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<SUpvote> getSUpvotes() {
		return this.SUpvotes;
	}

	public void setSUpvotes(Set<SUpvote> SUpvotes) {
		this.SUpvotes = SUpvotes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<IReply1> getIReply1s() {
		return this.IReply1s;
	}

	public void setIReply1s(Set<IReply1> IReply1s) {
		this.IReply1s = IReply1s;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<IUpvote> getIUpvotes() {
		return this.IUpvotes;
	}

	public void setIUpvotes(Set<IUpvote> IUpvotes) {
		this.IUpvotes = IUpvotes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<SysLoginRecord> getSysLoginRecords() {
		return this.sysLoginRecords;
	}

	public void setSysLoginRecords(Set<SysLoginRecord> sysLoginRecords) {
		this.sysLoginRecords = sysLoginRecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<SBox> getSBoxes() {
		return this.SBoxes;
	}

	public void setSBoxes(Set<SBox> SBoxes) {
		this.SBoxes = SBoxes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUserByCommentator")
	public Set<VReply2> getVReply2sForCommentator() {
		return this.VReply2sForCommentator;
	}

	public void setVReply2sForCommentator(Set<VReply2> VReply2sForCommentator) {
		this.VReply2sForCommentator = VReply2sForCommentator;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUserByUserId")
	public Set<SReply2> getSReply2sForUserId() {
		return this.SReply2sForUserId;
	}

	public void setSReply2sForUserId(Set<SReply2> SReply2sForUserId) {
		this.SReply2sForUserId = SReply2sForUserId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<UFriendGroup> getUFriendGroups() {
		return this.UFriendGroups;
	}

	public void setUFriendGroups(Set<UFriendGroup> UFriendGroups) {
		this.UFriendGroups = UFriendGroups;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<MGuestbook> getMGuestbooks() {
		return this.MGuestbooks;
	}

	public void setMGuestbooks(Set<MGuestbook> MGuestbooks) {
		this.MGuestbooks = MGuestbooks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<IAlbum> getIAlbums() {
		return this.IAlbums;
	}

	public void setIAlbums(Set<IAlbum> IAlbums) {
		this.IAlbums = IAlbums;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<SAccess> getSAccesses() {
		return this.SAccesses;
	}

	public void setSAccesses(Set<SAccess> SAccesses) {
		this.SAccesses = SAccesses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUserByUserId")
	public Set<VReply2> getVReply2sForUserId() {
		return this.VReply2sForUserId;
	}

	public void setVReply2sForUserId(Set<VReply2> VReply2sForUserId) {
		this.VReply2sForUserId = VReply2sForUserId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<VCount> getVCounts() {
		return this.VCounts;
	}

	public void setVCounts(Set<VCount> VCounts) {
		this.VCounts = VCounts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<DAnnex> getDAnnexes() {
		return this.DAnnexes;
	}

	public void setDAnnexes(Set<DAnnex> DAnnexes) {
		this.DAnnexes = DAnnexes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<UBook> getUBooks() {
		return this.UBooks;
	}

	public void setUBooks(Set<UBook> UBooks) {
		this.UBooks = UBooks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<IAccess> getIAccesses() {
		return this.IAccesses;
	}

	public void setIAccesses(Set<IAccess> IAccesses) {
		this.IAccesses = IAccesses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUserByUserId")
	public Set<BBacklist> getBBacklistsForUserId() {
		return this.BBacklistsForUserId;
	}

	public void setBBacklistsForUserId(Set<BBacklist> BBacklistsForUserId) {
		this.BBacklistsForUserId = BBacklistsForUserId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUserByUserId")
	public Set<DReply2> getDReply2sForUserId() {
		return this.DReply2sForUserId;
	}

	public void setDReply2sForUserId(Set<DReply2> DReply2sForUserId) {
		this.DReply2sForUserId = DReply2sForUserId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUserByUserId")
	public Set<MMessage> getMMessagesForUserId() {
		return this.MMessagesForUserId;
	}

	public void setMMessagesForUserId(Set<MMessage> MMessagesForUserId) {
		this.MMessagesForUserId = MMessagesForUserId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<VAccess> getVAccesses() {
		return this.VAccesses;
	}

	public void setVAccesses(Set<VAccess> VAccesses) {
		this.VAccesses = VAccesses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<SysInvitationCode> getSysInvitationCodes() {
		return this.sysInvitationCodes;
	}

	public void setSysInvitationCodes(Set<SysInvitationCode> sysInvitationCodes) {
		this.sysInvitationCodes = sysInvitationCodes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUserByReceiveId")
	public Set<MMessage> getMMessagesForReceiveId() {
		return this.MMessagesForReceiveId;
	}

	public void setMMessagesForReceiveId(Set<MMessage> MMessagesForReceiveId) {
		this.MMessagesForReceiveId = MMessagesForReceiveId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<MReply> getMReplies() {
		return this.MReplies;
	}

	public void setMReplies(Set<MReply> MReplies) {
		this.MReplies = MReplies;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUserByCommentator")
	public Set<IReply2> getIReply2sForCommentator() {
		return this.IReply2sForCommentator;
	}

	public void setIReply2sForCommentator(Set<IReply2> IReply2sForCommentator) {
		this.IReply2sForCommentator = IReply2sForCommentator;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<SReply1> getSReply1s() {
		return this.SReply1s;
	}

	public void setSReply1s(Set<SReply1> SReply1s) {
		this.SReply1s = SReply1s;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUser")
	public Set<DAccess> getDAccesses() {
		return this.DAccesses;
	}

	public void setDAccesses(Set<DAccess> DAccesses) {
		this.DAccesses = DAccesses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "UUserByBackId")
	public Set<BBacklist> getBBacklistsForBackId() {
		return this.BBacklistsForBackId;
	}

	public void setBBacklistsForBackId(Set<BBacklist> BBacklistsForBackId) {
		this.BBacklistsForBackId = BBacklistsForBackId;
	}

}