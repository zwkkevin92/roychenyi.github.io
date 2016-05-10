package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.SSoundDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class SUpvoteDto extends BeanBase{
    private Integer supvoteId;
    private UUserDto UUserDto;
    private SSoundDto SSoundDto;
    private String clientAgent;
    private String clientIp;
    private Short clientType;
    private Timestamp time;
    private Short status;

    /** default constructor */
    public SUpvoteDto(){

    }

    /** full constructor */
    public SUpvoteDto(Integer supvoteId,UUserDto UUserDto,SSoundDto SSoundDto,String clientAgent,String clientIp,Short clientType,Timestamp time,Short status){super();
        this.supvoteId=supvoteId;
        this.UUserDto=UUserDto;
        this.SSoundDto=SSoundDto;
        this.clientAgent=clientAgent;
        this.clientIp=clientIp;
        this.clientType=clientType;
        this.time=time;
        this.status=status;
    }
    public Integer getSupvoteId(){
        return supvoteId;
    }
    public void setSupvoteId(Integer supvoteId){
        this.supvoteId=supvoteId;
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

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status=status;
    }


}