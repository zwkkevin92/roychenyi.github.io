package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class WAccessDto extends BeanBase{
    private Long waccessId;
    private UUserDto UUserDto;
    private String clientAgent;
    private String clientIp;
    private Short clientType;
    private Timestamp time;

    /** default constructor */
    public WAccessDto(){

    }

    /** full constructor */
    public WAccessDto(Long waccessId,UUserDto UUserDto,String clientAgent,String clientIp,Short clientType,Timestamp time){super();
        this.waccessId=waccessId;
        this.UUserDto=UUserDto;
        this.clientAgent=clientAgent;
        this.clientIp=clientIp;
        this.clientType=clientType;
        this.time=time;
    }
    public Long getWaccessId(){
        return waccessId;
    }
    public void setWaccessId(Long waccessId){
        this.waccessId=waccessId;
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