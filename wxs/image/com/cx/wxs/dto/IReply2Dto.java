package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.IReply1Dto;
import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class IReply2Dto extends BeanBase{
    private Integer ireply1Id;
    private UUserDto UUserByUserIdDto;
    private IReply1Dto IReply1Dto;
    private UUserDto UUserByCommentatorDto;
    private String content;
    private String clientAngent;
    private String clientIp;
    private Short clientType;
    private Timestamp replyTime;
    private Timestamp replyId;
    private Short sortOrder;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public IReply2Dto(){

    }

    /** full constructor */
    public IReply2Dto(Integer ireply1Id,UUserDto UUserByUserIdDto,IReply1Dto IReply1Dto,UUserDto UUserByCommentatorDto,String content,String clientAngent,String clientIp,Short clientType,Timestamp replyTime,Timestamp replyId,Short sortOrder,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.ireply1Id=ireply1Id;
        this.UUserByUserIdDto=UUserByUserIdDto;
        this.IReply1Dto=IReply1Dto;
        this.UUserByCommentatorDto=UUserByCommentatorDto;
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
    public Integer getIreply1Id(){
        return ireply1Id;
    }
    public void setIreply1Id(Integer ireply1Id){
        this.ireply1Id=ireply1Id;
    }

    public UUserDto getUUserByUserIdDto(){
        return UUserByUserIdDto;
    }
    public void setUUserByUserIdDto(UUserDto UUserByUserIdDto){
        this.UUserByUserIdDto=UUserByUserIdDto;
    }

    public IReply1Dto getIReply1Dto(){
        return IReply1Dto;
    }
    public void setIReply1Dto(IReply1Dto IReply1Dto){
        this.IReply1Dto=IReply1Dto;
    }

    public UUserDto getUUserByCommentatorDto(){
        return UUserByCommentatorDto;
    }
    public void setUUserByCommentatorDto(UUserDto UUserByCommentatorDto){
        this.UUserByCommentatorDto=UUserByCommentatorDto;
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

    public Timestamp getReplyId(){
        return replyId;
    }
    public void setReplyId(Timestamp replyId){
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