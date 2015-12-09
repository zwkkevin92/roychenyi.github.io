package com.cx.wxs.dto;

import java.sql.Timestamp;


import com.cx.wxs.base.BeanBase;
import com.cx.wxs.po.SysCity;
import com.cx.wxs.po.SysCollege;
import com.cx.wxs.po.SysInvitationCode;
import com.cx.wxs.po.SysProvince;
import com.cx.wxs.po.SysRank;
import com.cx.wxs.po.SysSchool;
import com.cx.wxs.po.BSite;
import com.cx.wxs.dto.UsignDto;

/**
 * @author 陈义
 * @date   2015-12-8 下午3:23:09
 */
public class UuserDto extends BeanBase{
	
	private Integer userId;
	private UsignDto usignDto;
	private BSite BSite;
	private SysCollege sysCollege;
	private SysInvitationCode sysInvitationCode;
	private SysProvince sysProvince;
	private SysRank sysRank;
	private SysCity sysCity;
	private SysSchool sysSchool;
	private Integer siteId;
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
	private String class_;
	private String portrait;
	private Timestamp regtime;
	private Timestamp lastTime;
	private String lastIp;
	private Short keepDay;
	private Short onlineStatus;
	private Integer articleCount;
	private Integer articleReplyCount;
	private Integer topicCount;
	private Integer topicReplyCount;
	private Integer imageCount;
	private Integer imageReplyCount;
	private Integer guestbookCount;
	private Integer tagCount;
	private Integer popedom;


	// Constructors

		/** default constructor */
		public UuserDto() {
		}

		/** minimal constructor */
		public UuserDto(UsignDto usignDto, BSite BSite, SysInvitationCode sysInvitationCode,
				Integer siteId, String username, String password, String nickname,
				Integer roleId, Short sex) {
			this.usignDto = usignDto;
			this.BSite = BSite;
			this.sysInvitationCode = sysInvitationCode;
			this.siteId = siteId;
			this.username = username;
			this.password = password;
			this.nickname = nickname;
			this.roleId = roleId;
			this.sex = sex;
		}

		
		
		public UuserDto(Integer userId, UsignDto usignDto,
				BSite bSite, SysCollege sysCollege,
				SysInvitationCode sysInvitationCode, SysProvince sysProvince,
				SysRank sysRank, SysCity sysCity, SysSchool sysSchool,
				Integer siteId, String username, String password,
				String nickname, Integer roleId, Short sex, Timestamp birth,
				String email, String homepage, String qq, String mobile,
				String class_, String portrait, Timestamp regtime,
				Timestamp lastTime, String lastIp, Short keepDay,
				Short onlineStatus, Integer articleCount,
				Integer articleReplyCount, Integer topicCount,
				Integer topicReplyCount, Integer imageCount,
				Integer imageReplyCount, Integer guestbookCount,
				Integer tagCount, Integer popedom) {
			super();
			this.userId = userId;
			this.usignDto=usignDto;
			this.BSite = bSite;
			this.sysCollege = sysCollege;
			this.sysInvitationCode = sysInvitationCode;
			this.sysProvince = sysProvince;
			this.sysRank = sysRank;
			this.sysCity = sysCity;
			this.sysSchool = sysSchool;
			this.siteId = siteId;
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
			this.class_ = class_;
			this.portrait = portrait;
			this.regtime = regtime;
			this.lastTime = lastTime;
			this.lastIp = lastIp;
			this.keepDay = keepDay;
			this.onlineStatus = onlineStatus;
			this.articleCount = articleCount;
			this.articleReplyCount = articleReplyCount;
			this.topicCount = topicCount;
			this.topicReplyCount = topicReplyCount;
			this.imageCount = imageCount;
			this.imageReplyCount = imageReplyCount;
			this.guestbookCount = guestbookCount;
			this.tagCount = tagCount;
			this.popedom = popedom;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

	
		public UsignDto getUsignDto() {
			return usignDto;
		}

		public void setUsignDto(UsignDto usignDto) {
			this.usignDto = usignDto;
		}

		public BSite getBSite() {
			return BSite;
		}

		public void setBSite(BSite bSite) {
			BSite = bSite;
		}

		public SysCollege getSysCollege() {
			return sysCollege;
		}

		public void setSysCollege(SysCollege sysCollege) {
			this.sysCollege = sysCollege;
		}

		public SysInvitationCode getSysInvitationCode() {
			return sysInvitationCode;
		}

		public void setSysInvitationCode(SysInvitationCode sysInvitationCode) {
			this.sysInvitationCode = sysInvitationCode;
		}

		public SysProvince getSysProvince() {
			return sysProvince;
		}

		public void setSysProvince(SysProvince sysProvince) {
			this.sysProvince = sysProvince;
		}

		public SysRank getSysRank() {
			return sysRank;
		}

		public void setSysRank(SysRank sysRank) {
			this.sysRank = sysRank;
		}

		public SysCity getSysCity() {
			return sysCity;
		}

		public void setSysCity(SysCity sysCity) {
			this.sysCity = sysCity;
		}

		public SysSchool getSysSchool() {
			return sysSchool;
		}

		public void setSysSchool(SysSchool sysSchool) {
			this.sysSchool = sysSchool;
		}

		public Integer getSiteId() {
			return siteId;
		}

		public void setSiteId(Integer siteId) {
			this.siteId = siteId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public Integer getRoleId() {
			return roleId;
		}

		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}

		public Short getSex() {
			return sex;
		}

		public void setSex(Short sex) {
			this.sex = sex;
		}

		public Timestamp getBirth() {
			return birth;
		}

		public void setBirth(Timestamp birth) {
			this.birth = birth;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getHomepage() {
			return homepage;
		}

		public void setHomepage(String homepage) {
			this.homepage = homepage;
		}

		public String getQq() {
			return qq;
		}

		public void setQq(String qq) {
			this.qq = qq;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getClass_() {
			return class_;
		}

		public void setClass_(String class_) {
			this.class_ = class_;
		}

		public String getPortrait() {
			return portrait;
		}

		public void setPortrait(String portrait) {
			this.portrait = portrait;
		}

		public Timestamp getRegtime() {
			return regtime;
		}

		public void setRegtime(Timestamp regtime) {
			this.regtime = regtime;
		}

		public Timestamp getLastTime() {
			return lastTime;
		}

		public void setLastTime(Timestamp lastTime) {
			this.lastTime = lastTime;
		}

		public String getLastIp() {
			return lastIp;
		}

		public void setLastIp(String lastIp) {
			this.lastIp = lastIp;
		}

		public Short getKeepDay() {
			return keepDay;
		}

		public void setKeepDay(Short keepDay) {
			this.keepDay = keepDay;
		}

		public Short getOnlineStatus() {
			return onlineStatus;
		}

		public void setOnlineStatus(Short onlineStatus) {
			this.onlineStatus = onlineStatus;
		}

		public Integer getArticleCount() {
			return articleCount;
		}

		public void setArticleCount(Integer articleCount) {
			this.articleCount = articleCount;
		}

		public Integer getArticleReplyCount() {
			return articleReplyCount;
		}

		public void setArticleReplyCount(Integer articleReplyCount) {
			this.articleReplyCount = articleReplyCount;
		}

		public Integer getTopicCount() {
			return topicCount;
		}

		public void setTopicCount(Integer topicCount) {
			this.topicCount = topicCount;
		}

		public Integer getTopicReplyCount() {
			return topicReplyCount;
		}

		public void setTopicReplyCount(Integer topicReplyCount) {
			this.topicReplyCount = topicReplyCount;
		}

		public Integer getImageCount() {
			return imageCount;
		}

		public void setImageCount(Integer imageCount) {
			this.imageCount = imageCount;
		}

		public Integer getImageReplyCount() {
			return imageReplyCount;
		}

		public void setImageReplyCount(Integer imageReplyCount) {
			this.imageReplyCount = imageReplyCount;
		}

		public Integer getGuestbookCount() {
			return guestbookCount;
		}

		public void setGuestbookCount(Integer guestbookCount) {
			this.guestbookCount = guestbookCount;
		}

		public Integer getTagCount() {
			return tagCount;
		}

		public void setTagCount(Integer tagCount) {
			this.tagCount = tagCount;
		}

		public Integer getPopedom() {
			return popedom;
		}

		public void setPopedom(Integer popedom) {
			this.popedom = popedom;
		}

		

}
