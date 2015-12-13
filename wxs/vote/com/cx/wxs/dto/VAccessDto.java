package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.VVoteDto;
import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class VAccessDto extends BeanBase{
    private Long vaccessId;
    private VVoteDto VVoteDto;
    private UUserDto UUserDto;
    private String clientAgent;
    private String clientIp;
    private Short clientType;
    private Timestamp time;

    /** default constructor */
    public VAccessDto(){

    }

    /** full constructor */
    public VAccessDto(Long vaccessId,VVoteDto VVoteDto,UUserDto UUserDto,String clientAgent,String clientIp,Short clientType,Timestamp time){super();
        this.vaccessId=vaccessId;
        this.VVoteDto=VVoteDto;
        this.UUserDto=UUserDto;
        this.clientAgent=clientAgent;
        this.clientIp=clientIp;
        this.clientType=clientType;
        this.time=time;
    }
    public Long getVaccessId(){
        return vaccessId;
    }
    public void setVaccessId(Long vaccessId){
        this.vaccessId=vaccessId;
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

    public String getClientAgent(){
        return clientAgent;
    }
    public void setClientAgent(String clientAgent){
        this.clientAgent=clientAgent;
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

    public Timestamp getTime(){
        return time;
    }
    public void setTime(Timestamp time){
        this.time=time;
    }


}