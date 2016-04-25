package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-10 11:22:39
 */
public class SysLoginRecordDto extends BeanBase{
    private Integer recordId;
    private UUserDto UUserDto;
    private Timestamp createTime;
    private String clientAgent;
    private String clientIp;
    private Short clientType;

    /** default constructor */
    public SysLoginRecordDto(){

    }

    /** full constructor */
    public SysLoginRecordDto(Integer recordId,UUserDto UUserDto,Timestamp createTime,String clientAgent,String clientIp,Short clientType){super();
        this.recordId=recordId;
        this.UUserDto=UUserDto;
        this.createTime=createTime;
        this.clientAgent=clientAgent;
        this.clientIp=clientIp;
        this.clientType=clientType;
    }

    public Integer getRecordId(){
        return recordId;
    }
    public void setRecordId(Integer recordId){
        this.recordId=recordId;
    }

    public UUserDto getUUserDto(){
        return UUserDto;
    }
    public void setUUserDto(UUserDto UUserDto){
        this.UUserDto=UUserDto;
    }

    public Timestamp getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Timestamp createTime){
        this.createTime=createTime;
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