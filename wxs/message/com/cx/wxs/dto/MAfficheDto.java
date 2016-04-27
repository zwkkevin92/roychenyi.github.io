package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class MAfficheDto extends BeanBase{
    private Integer afficheId;
    private UUserDto UUserDto;
    private String title;
    private String content;
    private Timestamp sendTime;
    private Timestamp expireTime;
    private Short status;

    /** default constructor */
    public MAfficheDto(){

    }

    /** full constructor */
    public MAfficheDto(Integer afficheId,UUserDto UUserDto,String title,String content,Timestamp sendTime,Timestamp expireTime,Short status){super();
        this.afficheId=afficheId;
        this.UUserDto=UUserDto;
        this.title=title;
        this.content=content;
        this.sendTime=sendTime;
        this.expireTime=expireTime;
        this.status=status;
    }
    public Integer getAfficheId(){
        return afficheId;
    }
    public void setAfficheId(Integer afficheId){
        this.afficheId=afficheId;
    }

    public UUserDto getUUserDto(){
        return UUserDto;
    }
    public void setUUserDto(UUserDto UUserDto){
        this.UUserDto=UUserDto;
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

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status=status;
    }


}