package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class DReply1Dto extends BeanBase{
    private Integer dreplyId;
    private DDiaryDto DDiaryDto;
    private UUserDto UUserDto;
    private Short clientType;
    private Short ownerOnly;
    private Timestamp writeTime;
    private Short status;

    /** default constructor */
    public DReply1Dto(){

    }

    /** full constructor */
    public DReply1Dto(Integer dreplyId,DDiaryDto DDiaryDto,UUserDto UUserDto,Short clientType,Short ownerOnly,Timestamp writeTime,Short status){super();
        this.dreplyId=dreplyId;
        this.DDiaryDto=DDiaryDto;
        this.UUserDto=UUserDto;
        this.clientType=clientType;
        this.ownerOnly=ownerOnly;
        this.writeTime=writeTime;
        this.status=status;
    }
    public Integer getDreplyId(){
        return dreplyId;
    }
    public void setDreplyId(Integer dreplyId){
        this.dreplyId=dreplyId;
    }

    public DDiaryDto getDDiaryDto(){
        return DDiaryDto;
    }
    public void setDDiaryDto(DDiaryDto DDiaryDto){
        this.DDiaryDto=DDiaryDto;
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