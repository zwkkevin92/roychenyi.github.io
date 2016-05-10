package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.SSoundDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class SAccessDto extends BeanBase{
    private Long saccessId;
    private UUserDto UUserDto;
    private SSoundDto SSoundDto;
    private String clientAgent;
    private String clientIp;
    private Short clientType;
    private Timestamp time;

    /** default constructor */
    public SAccessDto(){

    }

    /** full constructor */
    public SAccessDto(Long saccessId,UUserDto UUserDto,SSoundDto SSoundDto,String clientAgent,String clientIp,Short clientType,Timestamp time){super();
        this.saccessId=saccessId;
        this.UUserDto=UUserDto;
        this.SSoundDto=SSoundDto;
        this.clientAgent=clientAgent;
        this.clientIp=clientIp;
        this.clientType=clientType;
        this.time=time;
    }
    public Long getSaccessId(){
        return saccessId;
    }
    public void setSaccessId(Long saccessId){
        this.saccessId=saccessId;
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