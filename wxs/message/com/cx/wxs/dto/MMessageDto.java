package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class MMessageDto extends BeanBase{
    private Integer messageId;
    private UUserDto UUserByUserIdDto;
    private UUserDto UUserByReceiveIdDto;
    private String content;
    private Timestamp sendTime;
    private Timestamp expireTime;
    private Timestamp readTime;
    private Short status;
    private Short clientType;
    private String clientIp;
    private String clientAgent;

    /** default constructor */
    public MMessageDto(){

    }

    /** full constructor */
    public MMessageDto(Integer messageId,UUserDto UUserByUserIdDto,UUserDto UUserByReceiveIdDto,String content,Timestamp sendTime,Timestamp expireTime,Timestamp readTime,Short status,Short clientType,String clientIp,String clientAgent){super();
        this.messageId=messageId;
        this.UUserByUserIdDto=UUserByUserIdDto;
        this.UUserByReceiveIdDto=UUserByReceiveIdDto;
        this.content=content;
        this.sendTime=sendTime;
        this.expireTime=expireTime;
        this.readTime=readTime;
        this.status=status;
        this.clientType=clientType;
        this.clientIp=clientIp;
        this.clientAgent=clientAgent;
    }
    public Integer getMessageId(){
        return messageId;
    }
    public void setMessageId(Integer messageId){
        this.messageId=messageId;
    }

    public UUserDto getUUserByUserIdDto(){
        return UUserByUserIdDto;
    }
    public void setUUserByUserIdDto(UUserDto UUserByUserIdDto){
        this.UUserByUserIdDto=UUserByUserIdDto;
    }

    public UUserDto getUUserByReceiveIdDto(){
        return UUserByReceiveIdDto;
    }
    public void setUUserByReceiveIdDto(UUserDto UUserByReceiveIdDto){
        this.UUserByReceiveIdDto=UUserByReceiveIdDto;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content=content;
    }

    public Timestamp getSendTime(){
        return sendTime;
    }
    public void setSendTime(Timestamp sendTime){
        this.sendTime=sendTime;
    }

    public Timestamp getExpireTime(){
        return expireTime;
    }
    public void setExpireTime(Timestamp expireTime){
        this.expireTime=expireTime;
    }

    public Timestamp getReadTime(){
        return readTime;
    }
    public void setReadTime(Timestamp readTime){
        this.readTime=readTime;
    }

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status=status;
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


}