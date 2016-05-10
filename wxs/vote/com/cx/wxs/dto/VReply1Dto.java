package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.VVoteDto;
import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class VReply1Dto extends BeanBase{
    private Integer vreplyId;
    private VVoteDto VVoteDto;
    private UUserDto UUserDto;
    private Short clientType;
    private Short ownerOnly;
    private Timestamp writeTime;
    private Short status;

    /** default constructor */
    public VReply1Dto(){

    }

    /** full constructor */
    public VReply1Dto(Integer vreplyId,VVoteDto VVoteDto,UUserDto UUserDto,Short clientType,Short ownerOnly,Timestamp writeTime,Short status){super();
        this.vreplyId=vreplyId;
        this.VVoteDto=VVoteDto;
        this.UUserDto=UUserDto;
        this.clientType=clientType;
        this.ownerOnly=ownerOnly;
        this.writeTime=writeTime;
        this.status=status;
    }
    public Integer getVreplyId(){
        return vreplyId;
    }
    public void setVreplyId(Integer vreplyId){
        this.vreplyId=vreplyId;
    }

    public VVoteDto getVVoteDto(){
        return VVoteDto;
    }
    public void setVVoteDto(VVoteDto VVoteDto){
        this.VVoteDto=VVoteDto;
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