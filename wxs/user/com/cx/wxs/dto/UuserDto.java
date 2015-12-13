package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.USignDto;
import com.cx.wxs.dto.BSiteDto;
import com.cx.wxs.dto.SysCollegeDto;
import com.cx.wxs.dto.SysInvitationCodeDto;
import com.cx.wxs.dto.SysProvinceDto;
import com.cx.wxs.dto.SysRankDto;
import com.cx.wxs.dto.SysCityDto;
import com.cx.wxs.dto.SysSchoolDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class UUserDto extends BeanBase{
    private Integer userId;
    private USignDto USignDto;
    private BSiteDto BSiteDto;
    private SysCollegeDto sysCollegeDto;
    private SysInvitationCodeDto sysInvitationCodeDto;
    private SysProvinceDto sysProvinceDto;
    private SysRankDto sysRankDto;
    private SysCityDto sysCityDto;
    private SysSchoolDto sysSchoolDto;
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

    /** default constructor */
    public UUserDto(){

    }

    /** full constructor */
    public UUserDto(Integer userId,USignDto USignDto,BSiteDto BSiteDto,SysCollegeDto sysCollegeDto,SysInvitationCodeDto sysInvitationCodeDto,SysProvinceDto sysProvinceDto,SysRankDto sysRankDto,SysCityDto sysCityDto,SysSchoolDto sysSchoolDto,Integer siteId,String username,String password,String nickname,Integer roleId,Short sex,Timestamp birth,String email,String homepage,String qq,String mobile,String class_,String portrait,Timestamp regtime,Timestamp lastTime,String lastIp,Short keepDay,Short onlineStatus,Integer articleCount,Integer articleReplyCount,Integer topicCount,Integer topicReplyCount,Integer imageCount,Integer imageReplyCount,Integer guestbookCount,Integer tagCount,Integer popedom){super();
        this.userId=userId;
        this.USignDto=USignDto;
        this.BSiteDto=BSiteDto;
        this.sysCollegeDto=sysCollegeDto;
        this.sysInvitationCodeDto=sysInvitationCodeDto;
        this.sysProvinceDto=sysProvinceDto;
        this.sysRankDto=sysRankDto;
        this.sysCityDto=sysCityDto;
        this.sysSchoolDto=sysSchoolDto;
        this.siteId=siteId;
        this.username=username;
        this.password=password;
        this.nickname=nickname;
        this.roleId=roleId;
        this.sex=sex;
        this.birth=birth;
        this.email=email;
        this.homepage=homepage;
        this.qq=qq;
        this.mobile=mobile;
        this.class_=class_;
        this.portrait=portrait;
        this.regtime=regtime;
        this.lastTime=lastTime;
        this.lastIp=lastIp;
        this.keepDay=keepDay;
        this.onlineStatus=onlineStatus;
        this.articleCount=articleCount;
        this.articleReplyCount=articleReplyCount;
        this.topicCount=topicCount;
        this.topicReplyCount=topicReplyCount;
        this.imageCount=imageCount;
        this.imageReplyCount=imageReplyCount;
        this.guestbookCount=guestbookCount;
        this.tagCount=tagCount;
        this.popedom=popedom;
    }
    public Integer getUserId(){
        return userId;
    }
    public void setUserId(Integer userId){
        this.userId=userId;
    }

    public USignDto getUSignDto(){
        return USignDto;
    }
    public void setUSignDto(USignDto USignDto){
        this.USignDto=USignDto;
    }

    public BSiteDto getBSiteDto(){
        return BSiteDto;
    }
    public void setBSiteDto(BSiteDto BSiteDto){
        this.BSiteDto=BSiteDto;
    }

    public SysCollegeDto getSysCollegeDto(){
        return sysCollegeDto;
    }
    public void setSysCollegeDto(SysCollegeDto sysCollegeDto){
        this.sysCollegeDto=sysCollegeDto;
    }

    public SysInvitationCodeDto getSysInvitationCodeDto(){
        return sysInvitationCodeDto;
    }
    public void setSysInvitationCodeDto(SysInvitationCodeDto sysInvitationCodeDto){
        this.sysInvitationCodeDto=sysInvitationCodeDto;
    }

    public SysProvinceDto getSysProvinceDto(){
        return sysProvinceDto;
    }
    public void setSysProvinceDto(SysProvinceDto sysProvinceDto){
        this.sysProvinceDto=sysProvinceDto;
    }

    public SysRankDto getSysRankDto(){
        return sysRankDto;
    }
    public void setSysRankDto(SysRankDto sysRankDto){
        this.sysRankDto=sysRankDto;
    }

    public SysCityDto getSysCityDto(){
        return sysCityDto;
    }
    public void setSysCityDto(SysCityDto sysCityDto){
        this.sysCityDto=sysCityDto;
    }

    public SysSchoolDto getSysSchoolDto(){
        return sysSchoolDto;
    }
    public void setSysSchoolDto(SysSchoolDto sysSchoolDto){
        this.sysSchoolDto=sysSchoolDto;
    }

    public Integer getSiteId(){
        return siteId;
    }
    public void setSiteId(Integer siteId){
        this.siteId=siteId;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname){
        this.nickname=nickname;
    }

    public Integer getRoleId(){
        return roleId;
    }
    public void setRoleId(Integer roleId){
        this.roleId=roleId;
    }

    public Short getSex(){
        return sex;
    }
    public void setSex(Short sex){
        this.sex=sex;
    }

    public Timestamp getBirth(){
        return birth;
    }
    public void setBirth(Timestamp birth){
        this.birth=birth;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public String getHomepage(){
        return homepage;
    }
    public void setHomepage(String homepage){
        this.homepage=homepage;
    }

    public String getQq(){
        return qq;
    }
    public void setQq(String qq){
        this.qq=qq;
    }

    public String getMobile(){
        return mobile;
    }
    public void setMobile(String mobile){
        this.mobile=mobile;
    }

    public String getClass_(){
        return class_;
    }
    public void setClass_(String class_){
        this.class_=class_;
    }

    public String getPortrait(){
        return portrait;
    }
    public void setPortrait(String portrait){
        this.portrait=portrait;
    }

    public Timestamp getRegtime(){
        return regtime;
    }
    public void setRegtime(Timestamp regtime){
        this.regtime=regtime;
    }

    public Timestamp getLastTime(){
        return lastTime;
    }
    public void setLastTime(Timestamp lastTime){
        this.lastTime=lastTime;
    }

    public String getLastIp(){
        return lastIp;
    }
    public void setLastIp(String lastIp){
        this.lastIp=lastIp;
    }

    public Short getKeepDay(){
        return keepDay;
    }
    public void setKeepDay(Short keepDay){
        this.keepDay=keepDay;
    }

    public Short getOnlineStatus(){
        return onlineStatus;
    }
    public void setOnlineStatus(Short onlineStatus){
        this.onlineStatus=onlineStatus;
    }

    public Integer getArticleCount(){
        return articleCount;
    }
    public void setArticleCount(Integer articleCount){
        this.articleCount=articleCount;
    }

    public Integer getArticleReplyCount(){
        return articleReplyCount;
    }
    public void setArticleReplyCount(Integer articleReplyCount){
        this.articleReplyCount=articleReplyCount;
    }

    public Integer getTopicCount(){
        return topicCount;
    }
    public void setTopicCount(Integer topicCount){
        this.topicCount=topicCount;
    }

    public Integer getTopicReplyCount(){
        return topicReplyCount;
    }
    public void setTopicReplyCount(Integer topicReplyCount){
        this.topicReplyCount=topicReplyCount;
    }

    public Integer getImageCount(){
        return imageCount;
    }
    public void setImageCount(Integer imageCount){
        this.imageCount=imageCount;
    }

    public Integer getImageReplyCount(){
        return imageReplyCount;
    }
    public void setImageReplyCount(Integer imageReplyCount){
        this.imageReplyCount=imageReplyCount;
    }

    public Integer getGuestbookCount(){
        return guestbookCount;
    }
    public void setGuestbookCount(Integer guestbookCount){
        this.guestbookCount=guestbookCount;
    }

    public Integer getTagCount(){
        return tagCount;
    }
    public void setTagCount(Integer tagCount){
        this.tagCount=tagCount;
    }

    public Integer getPopedom(){
        return popedom;
    }
    public void setPopedom(Integer popedom){
        this.popedom=popedom;
    }


}