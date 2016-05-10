package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.BSiteDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class BAccessDto extends BeanBase{
    private Long baccessId;
    private UUserDto UUserDto;
    private BSiteDto BSiteDto;
    private Timestamp time;
    private String clientAgent;
    private String clientIp;
    private Short clientType;

    /** default constructor */
    public BAccessDto(){

    }

    /** full constructor */
    public BAccessDto(Long baccessId,UUserDto UUserDto,BSiteDto BSiteDto,Timestamp time,String clientAgent,String clientIp,Short clientType){super();
        this.baccessId=baccessId;
        this.UUserDto=UUserDto;
        this.BSiteDto=BSiteDto;
        this.time=time;
        this.clientAgent=clientAgent;
        this.clientIp=clientIp;
        this.clientType=clientType;
    }
    public Long getBaccessId(){
        return baccessId;
    }
    public void setBaccessId(Long baccessId){
        this.baccessId=baccessId;
    }

    public UUserDto getUUserDto(){
        return UUserDto;
    }
    public void setUUserDto(UUserDto UUserDto){
        this.UUserDto=UUserDto;
    }

    public BSiteDto getBSiteDto(){
        return BSiteDto;
    }
    public void setBSiteDto(BSiteDto BSiteDto){
        this.BSiteDto=BSiteDto;
    }

    public Timestamp getTime(){
        return time;
    }
    public void setTime(Timestamp time){
        this.time=time;
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


}