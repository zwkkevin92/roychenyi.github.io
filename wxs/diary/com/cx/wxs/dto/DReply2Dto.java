package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.DReply1Dto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class DReply2Dto extends BeanBase{
    private Integer dreply1Id;
    private UUserDto UUserByUserIdDto;
    private UUserDto UUserByCommentatorDto;
    private DReply1Dto DReply1Dto;
    private String content;
    private String clientAngent;
    private String clientIp;
    private Short clientType;
    private Timestamp replyTime;
    private Integer replyId;
    private Short sortOrder;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public DReply2Dto(){

    }

    /** full constructor */
    public DReply2Dto(Integer dreply1Id,UUserDto UUserByUserIdDto,UUserDto UUserByCommentatorDto,DReply1Dto DReply1Dto,String content,String clientAngent,String clientIp,Short clientType,Timestamp replyTime,Integer replyId,Short sortOrder,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.dreply1Id=dreply1Id;
        this.UUserByUserIdDto=UUserByUserIdDto;
        this.UUserByCommentatorDto=UUserByCommentatorDto;
        this.DReply1Dto=DReply1Dto;
        this.content=content;
        this.clientAngent=clientAngent;
        this.clientIp=clientIp;
        this.clientType=clientType;
        this.replyTime=replyTime;
        this.replyId=replyId;
        this.sortOrder=sortOrder;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }
    public Integer getDreply1Id(){
        return dreply1Id;
    }
    public void setDreply1Id(Integer dreply1Id){
        this.dreply1Id=dreply1Id;
    }

    public UUserDto getUUserByUserIdDto(){
        return UUserByUserIdDto;
    }
    public void setUUserByUserIdDto(UUserDto UUserByUserIdDto){
        this.UUserByUserIdDto=UUserByUserIdDto;
    }

    public UUserDto getUUserByCommentatorDto(){
        return UUserByCommentatorDto;
    }
    public void setUUserByCommentatorDto(UUserDto UUserByCommentatorDto){
        this.UUserByCommentatorDto=UUserByCommentatorDto;
    }

    public DReply1Dto getDReply1Dto(){
        return DReply1Dto;
    }
    public void setDReply1Dto(DReply1Dto DReply1Dto){
        this.DReply1Dto=DReply1Dto;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content=content;
    }

    public String getClientAngent(){
        return clientAngent;
    }
    public void setClientAngent(String clientAngent){
        this.clientAngent=clientAngent;
    }

    public String getClientIp(){
        return clientIp;
    }
    public void setClientIp(String clientIp){
        this.clientIp=clientIp;
    }

    public Short getClientType(){
        return clientType;
    }
    public void setClientType(Short clientType){
        this.clientType=clientType;
    }

    public Timestamp getReplyTime(){
        return replyTime;
    }
    public void setReplyTime(Timestamp replyTime){
        this.replyTime=replyTime;
    }

    public Integer getReplyId(){
        return replyId;
    }
    public void setReplyId(Integer replyId){
        this.replyId=replyId;
    }

    public Short getSortOrder(){
        return sortOrder;
    }
    public void setSortOrder(Short sortOrder){
        this.sortOrder=sortOrder;
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

    public String getExt3(){
        return ext3;
    }
    public void setExt3(String ext3){
        this.ext3=ext3;
    }

    public String getExt4(){
        return ext4;
    }
    public void setExt4(String ext4){
        this.ext4=ext4;
    }


}