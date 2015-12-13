package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.IImageDto;
import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class IReply1Dto extends BeanBase{
    private Integer ireplyId;
    private IImageDto IImageDto;
    private UUserDto UUserDto;
    private Short clientType;
    private Short ownerOnly;
    private Timestamp writeTime;
    private Short status;

    /** default constructor */
    public IReply1Dto(){

    }

    /** full constructor */
    public IReply1Dto(Integer ireplyId,IImageDto IImageDto,UUserDto UUserDto,Short clientType,Short ownerOnly,Timestamp writeTime,Short status){super();
        this.ireplyId=ireplyId;
        this.IImageDto=IImageDto;
        this.UUserDto=UUserDto;
        this.clientType=clientType;
        this.ownerOnly=ownerOnly;
        this.writeTime=writeTime;
        this.status=status;
    }
    public Integer getIreplyId(){
        return ireplyId;
    }
    public void setIreplyId(Integer ireplyId){
        this.ireplyId=ireplyId;
    }

    public IImageDto getIImageDto(){
        return IImageDto;
    }
    public void setIImageDto(IImageDto IImageDto){
        this.IImageDto=IImageDto;
    }

    public UUserDto getUUserDto(){
        return UUserDto;
    }
    public void setUUserDto(UUserDto UUserDto){
        this.UUserDto=UUserDto;
    }

    public Short getClientType(){
        return clientType;
    }
    public void setClientType(Short clientType){
        this.clientType=clientType;
    }

    public Short getOwnerOnly(){
        return ownerOnly;
    }
    public void setOwnerOnly(Short ownerOnly){
        this.ownerOnly=ownerOnly;
    }

    public Timestamp getWriteTime(){
        return writeTime;
    }
    public void setWriteTime(Timestamp writeTime){
        this.writeTime=writeTime;
    }

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status=status;
    }


}