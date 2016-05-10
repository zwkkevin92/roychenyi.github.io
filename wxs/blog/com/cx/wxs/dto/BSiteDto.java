package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.SysStyleDto;
import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class BSiteDto extends BeanBase{
    private Integer siteId;
    private SysStyleDto sysStyleDto;
    private UUserDto UUserDto;
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

    /** default constructor */
    public BSiteDto(){

    }

    /** full constructor */
    public BSiteDto(Integer siteId,SysStyleDto sysStyleDto,UUserDto UUserDto,String name,String title,String siteUrl,String siteDetail,String logo,Short flag,Timestamp createTime,Timestamp lastTime,Short mode,String accessCode,String indexName,String diaryName,String soundName,String imageName,String friendName,Integer siteType,Short status){super();
        this.siteId=siteId;
        this.sysStyleDto=sysStyleDto;
        this.UUserDto=UUserDto;
        this.name=name;
        this.title=title;
        this.siteUrl=siteUrl;
        this.siteDetail=siteDetail;
        this.logo=logo;
        this.flag=flag;
        this.createTime=createTime;
        this.lastTime=lastTime;
        this.mode=mode;
        this.accessCode=accessCode;
        this.indexName=indexName;
        this.diaryName=diaryName;
        this.soundName=soundName;
        this.imageName=imageName;
        this.friendName=friendName;
        this.siteType=siteType;
        this.status=status;
    }
    public Integer getSiteId(){
        return siteId;
    }
    public void setSiteId(Integer siteId){
        this.siteId=siteId;
    }

    public SysStyleDto getSysStyleDto(){
        return sysStyleDto;
    }
    public void setSysStyleDto(SysStyleDto sysStyleDto){
        this.sysStyleDto=sysStyleDto;
    }

    public UUserDto getUUserDto(){
        return UUserDto;
    }
    public void setUUserDto(UUserDto UUserDto){
        this.UUserDto=UUserDto;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getSiteUrl(){
        return siteUrl;
    }
    public void setSiteUrl(String siteUrl){
        this.siteUrl=siteUrl;
    }

    public String getSiteDetail(){
        return siteDetail;
    }
    public void setSiteDetail(String siteDetail){
        this.siteDetail=siteDetail;
    }

    public String getLogo(){
        return logo;
    }
    public void setLogo(String logo){
        this.logo=logo;
    }

    public Short getFlag(){
        return flag;
    }
    public void setFlag(Short flag){
        this.flag=flag;
    }

    public Timestamp getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Timestamp createTime){
        this.createTime=createTime;
    }

    public Timestamp getLastTime(){
        return lastTime;
    }
    public void setLastTime(Timestamp lastTime){
        this.lastTime=lastTime;
    }

    public Short getMode(){
        return mode;
    }
    public void setMode(Short mode){
        this.mode=mode;
    }

    public String getAccessCode(){
        return accessCode;
    }
    public void setAccessCode(String accessCode){
        this.accessCode=accessCode;
    }

    public String getIndexName(){
        return indexName;
    }
    public void setIndexName(String indexName){
        this.indexName=indexName;
    }

    public String getDiaryName(){
        return diaryName;
    }
    public void setDiaryName(String diaryName){
        this.diaryName=diaryName;
    }

    public String getSoundName(){
        return soundName;
    }
    public void setSoundName(String soundName){
        this.soundName=soundName;
    }

    public String getImageName(){
        return imageName;
    }
    public void setImageName(String imageName){
        this.imageName=imageName;
    }

    public String getFriendName(){
        return friendName;
    }
    public void setFriendName(String friendName){
        this.friendName=friendName;
    }

    public Integer getSiteType(){
        return siteType;
    }
    public void setSiteType(Integer siteType){
        this.siteType=siteType;
    }

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status=status;
    }


}