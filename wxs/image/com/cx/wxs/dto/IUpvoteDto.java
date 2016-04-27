package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.IImageDto;
import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class IUpvoteDto extends BeanBase{
    private Integer iupvoteId;
    private IImageDto IImageDto;
    private UUserDto UUserDto;
    private String clientAgent;
    private String clientIp;
    private Short clientType;
    private Timestamp time;
    private Short status;

    /** default constructor */
    public IUpvoteDto(){

    }

    /** full constructor */
    public IUpvoteDto(Integer iupvoteId,IImageDto IImageDto,UUserDto UUserDto,String clientAgent,String clientIp,Short clientType,Timestamp time,Short status){super();
        this.iupvoteId=iupvoteId;
        this.IImageDto=IImageDto;
        this.UUserDto=UUserDto;
        this.clientAgent=clientAgent;
        this.clientIp=clientIp;
        this.clientType=clientType;
        this.time=time;
        this.status=status;
    }
    public Integer getIupvoteId(){
        return iupvoteId;
    }
    public void setIupvoteId(Integer iupvoteId){
        this.iupvoteId=iupvoteId;
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