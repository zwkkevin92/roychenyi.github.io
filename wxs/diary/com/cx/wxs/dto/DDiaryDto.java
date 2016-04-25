package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.SysTypeDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.BSiteDto;
import com.cx.wxs.dto.DCatalogDto;
/**
 * @author 陈义
 * @date 2016-04-16 09:17:32
 */
public class DDiaryDto extends BeanBase{
    private Integer diaryId;
    private SysTypeDto sysTypeDto;
    private UUserDto UUserDto;
    private BSiteDto BSiteDto;
    private DCatalogDto DCatalogDto;
    private String title;
    private String content;
    private String txt;
    private Integer diarySize;
    private Integer replyCount;
    private Integer viewCount;
    private Integer upvoteCount;
    private Integer favoriteCount;
    private Short clientType;
    private String clientIp;
    private String clientAgent;
    private Timestamp writeTime;
    private Timestamp lastReadTime;
    private Timestamp lastReplyTime;
    private Timestamp modifyTime;
    private Short replyNotify;
    private Short moodLevel;
    private Short locked;
    private Short contribute;
    private Short role;
    private String tag;
    private Integer annexId;
    private Integer ext1;
    private Integer ext2;
    private Integer ext3;
    private Integer ext4;

    /** default constructor */
    public DDiaryDto(){

    }

    /** full constructor */
    public DDiaryDto(Integer diaryId,SysTypeDto sysTypeDto,UUserDto UUserDto,BSiteDto BSiteDto,DCatalogDto DCatalogDto,String title,String content,String txt,Integer diarySize,Integer replyCount,Integer viewCount,Integer upvoteCount,Integer favoriteCount,Short clientType,String clientIp,String clientAgent,Timestamp writeTime,Timestamp lastReadTime,Timestamp lastReplyTime,Timestamp modifyTime,Short replyNotify,Short moodLevel,Short locked,Short contribute,Short role,String tag,Integer annexId,Integer ext1,Integer ext2,Integer ext3,Integer ext4){super();
        this.diaryId=diaryId;
        this.sysTypeDto=sysTypeDto;
        this.UUserDto=UUserDto;
        this.BSiteDto=BSiteDto;
        this.DCatalogDto=DCatalogDto;
        this.title=title;
        this.content=content;
        this.txt=txt;
        this.diarySize=diarySize;
        this.replyCount=replyCount;
        this.viewCount=viewCount;
        this.upvoteCount=upvoteCount;
        this.favoriteCount=favoriteCount;
        this.clientType=clientType;
        this.clientIp=clientIp;
        this.clientAgent=clientAgent;
        this.writeTime=writeTime;
        this.lastReadTime=lastReadTime;
        this.lastReplyTime=lastReplyTime;
        this.modifyTime=modifyTime;
        this.replyNotify=replyNotify;
        this.moodLevel=moodLevel;
        this.locked=locked;
        this.contribute=contribute;
        this.role=role;
        this.tag=tag;
        this.annexId=annexId;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }

    public Integer getDiaryId(){
        return diaryId;
    }
    public void setDiaryId(Integer diaryId){
        this.diaryId=diaryId;
    }

    public SysTypeDto getSysTypeDto(){
        return sysTypeDto;
    }
    public void setSysTypeDto(SysTypeDto sysTypeDto){
        this.sysTypeDto=sysTypeDto;
    }

    public UUserDto getUUserDto(){
        return UUserDto;
    }
    public void setUUserDto(UUserDto UUserDto){
        this.UUserDto=UUserDto;
    }

    public BSiteDto getBSiteDto(){
        return BSiteDto;
    }
    public void setBSiteDto(BSiteDto BSiteDto){
        this.BSiteDto=BSiteDto;
    }

    public DCatalogDto getDCatalogDto(){
        return DCatalogDto;
    }
    public void setDCatalogDto(DCatalogDto DCatalogDto){
        this.DCatalogDto=DCatalogDto;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content=content;
    }

    public String getTxt(){
        return txt;
    }
    public void setTxt(String txt){
        this.txt=txt;
    }

    public Integer getDiarySize(){
        return diarySize;
    }
    public void setDiarySize(Integer diarySize){
        this.diarySize=diarySize;
    }

    public Integer getReplyCount(){
        return replyCount;
    }
    public void setReplyCount(Integer replyCount){
        this.replyCount=replyCount;
    }

    public Integer getViewCount(){
        return viewCount;
    }
    public void setViewCount(Integer viewCount){
        this.viewCount=viewCount;
    }

    public Integer getUpvoteCount(){
        return upvoteCount;
    }
    public void setUpvoteCount(Integer upvoteCount){
        this.upvoteCount=upvoteCount;
    }

    public Integer getFavoriteCount(){
        return favoriteCount;
    }
    public void setFavoriteCount(Integer favoriteCount){
        this.favoriteCount=favoriteCount;
    }

    public Short getClientType(){
        return clientType;
    }
    public void setClientType(Short clientType){
        this.clientType=clientType;
    }

    public String getClientIp(){
        return clientIp;
    }
    public void setClientIp(String clientIp){
        this.clientIp=clientIp;
    }

    public String getClientAgent(){
        return clientAgent;
    }
    public void setClientAgent(String clientAgent){
        this.clientAgent=clientAgent;
    }

    public Timestamp getWriteTime(){
        return writeTime;
    }
    public void setWriteTime(Timestamp writeTime){
        this.writeTime=writeTime;
    }

    public Timestamp getLastReadTime(){
        return lastReadTime;
    }
    public void setLastReadTime(Timestamp lastReadTime){
        this.lastReadTime=lastReadTime;
    }

    public Timestamp getLastReplyTime(){
        return lastReplyTime;
    }
    public void setLastReplyTime(Timestamp lastReplyTime){
        this.lastReplyTime=lastReplyTime;
    }

    public Timestamp getModifyTime(){
        return modifyTime;
    }
    public void setModifyTime(Timestamp modifyTime){
        this.modifyTime=modifyTime;
    }

    public Short getReplyNotify(){
        return replyNotify;
    }
    public void setReplyNotify(Short replyNotify){
        this.replyNotify=replyNotify;
    }

    public Short getMoodLevel(){
        return moodLevel;
    }
    public void setMoodLevel(Short moodLevel){
        this.moodLevel=moodLevel;
    }

    public Short getLocked(){
        return locked;
    }
    public void setLocked(Short locked){
        this.locked=locked;
    }

    public Short getContribute(){
        return contribute;
    }
    public void setContribute(Short contribute){
        this.contribute=contribute;
    }

    public Short getRole(){
        return role;
    }
    public void setRole(Short role){
        this.role=role;
    }

    public String getTag(){
        return tag;
    }
    public void setTag(String tag){
        this.tag=tag;
    }

    public Integer getAnnexId(){
        return annexId;
    }
    public void setAnnexId(Integer annexId){
        this.annexId=annexId;
    }

    public Integer getExt1(){
        return ext1;
    }
    public void setExt1(Integer ext1){
        this.ext1=ext1;
    }

    public Integer getExt2(){
        return ext2;
    }
    public void setExt2(Integer ext2){
        this.ext2=ext2;
    }

    public Integer getExt3(){
        return ext3;
    }
    public void setExt3(Integer ext3){
        this.ext3=ext3;
    }

    public Integer getExt4(){
        return ext4;
    }
    public void setExt4(Integer ext4){
        this.ext4=ext4;
    }


}