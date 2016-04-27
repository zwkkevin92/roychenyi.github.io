package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.MGuestbookDto;
import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class MReplyDto extends BeanBase{
    private Integer mreplyId;
    private MGuestbookDto MGuestbookDto;
    private UUserDto UUserDto;
    private String content;
    private Timestamp time;
    private Integer replyId;
    private Short clientType;
    private String clientIp;
    private String clientAgent;

    /** default constructor */
    public MReplyDto(){

    }

    /** full constructor */
    public MReplyDto(Integer mreplyId,MGuestbookDto MGuestbookDto,UUserDto UUserDto,String content,Timestamp time,Integer replyId,Short clientType,String clientIp,String clientAgent){super();
        this.mreplyId=mreplyId;
        this.MGuestbookDto=MGuestbookDto;
        this.UUserDto=UUserDto;
        this.content=content;
        this.time=time;
        this.replyId=replyId;
        this.clientType=clientType;
        this.clientIp=clientIp;
        this.clientAgent=clientAgent;
    }
    public Integer getMreplyId(){
        return mreplyId;
    }
    public void setMreplyId(Integer mreplyId){
        this.mreplyId=mreplyId;
    }

    public MGuestbookDto getMGuestbookDto(){
        return MGuestbookDto;
    }
    public void setMGuestbookDto(MGuestbookDto MGuestbookDto){
        this.MGuestbookDto=MGuestbookDto;
    }

    public UUserDto getUUserDto(){
        return UUserDto;
    }
    public void setUUserDto(UUserDto UUserDto){
        this.UUserDto=UUserDto;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content=content;
    }

    public Timestamp getTime(){
        return time;
    }
    public void setTime(Timestamp time){
        this.time=time;
    }

    public Integer getReplyId(){
        return replyId;
    }
    public void setReplyId(Integer replyId){
        this.replyId=replyId;
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