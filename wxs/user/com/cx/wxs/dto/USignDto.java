package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class USignDto extends BeanBase{
    private Integer signId;
    private UUserDto UUserDto;
    private String content;
    private Timestamp createTime;
    private Short status;

    /** default constructor */
    public USignDto(){

    }

    /** full constructor */
    public USignDto(Integer signId,UUserDto UUserDto,String content,Timestamp createTime,Short status){super();
        this.signId=signId;
        this.UUserDto=UUserDto;
        this.content=content;
        this.createTime=createTime;
        this.status=status;
    }
    public Integer getSignId(){
        return signId;
    }
    public void setSignId(Integer signId){
        this.signId=signId;
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

    public Timestamp getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Timestamp createTime){
        this.createTime=createTime;
    }

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status=status;
    }


}