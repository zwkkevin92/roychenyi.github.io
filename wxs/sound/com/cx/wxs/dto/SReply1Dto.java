package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.SSoundDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class SReply1Dto extends BeanBase{
    private Integer sreplyId;
    private UUserDto UUserDto;
    private SSoundDto SSoundDto;
    private Short clientType;
    private Short ownerOnly;
    private Timestamp writeTime;
    private Short status;

    /** default constructor */
    public SReply1Dto(){

    }

    /** full constructor */
    public SReply1Dto(Integer sreplyId,UUserDto UUserDto,SSoundDto SSoundDto,Short clientType,Short ownerOnly,Timestamp writeTime,Short status){super();
        this.sreplyId=sreplyId;
        this.UUserDto=UUserDto;
        this.SSoundDto=SSoundDto;
        this.clientType=clientType;
        this.ownerOnly=ownerOnly;
        this.writeTime=writeTime;
        this.status=status;
    }
    public Integer getSreplyId(){
        return sreplyId;
    }
    public void setSreplyId(Integer sreplyId){
        this.sreplyId=sreplyId;
    }

    public UUserDto getUUserDto(){
        return UUserDto;
    }
    public void setUUserDto(UUserDto UUserDto){
        this.UUserDto=UUserDto;
    }

    public SSoundDto getSSoundDto(){
        return SSoundDto;
    }
    public void setSSoundDto(SSoundDto SSoundDto){
        this.SSoundDto=SSoundDto;
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