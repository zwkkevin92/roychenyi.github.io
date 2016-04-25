package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.BSiteDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class MGuestbookDto extends BeanBase{
    private Integer guestbookId;
    private UUserDto UUserDto;
    private BSiteDto BSiteDto;
    private Integer visitorId;
    private String content;
    private Short clientType;
    private String clientIp;
    private String clientAgent;
    private Timestamp time;

    /** default constructor */
    public MGuestbookDto(){

    }

    /** full constructor */
    public MGuestbookDto(Integer guestbookId,UUserDto UUserDto,BSiteDto BSiteDto,Integer visitorId,String content,Short clientType,String clientIp,String clientAgent,Timestamp time){super();
        this.guestbookId=guestbookId;
        this.UUserDto=UUserDto;
        this.BSiteDto=BSiteDto;
        this.visitorId=visitorId;
        this.content=content;
        this.clientType=clientType;
        this.clientIp=clientIp;
        this.clientAgent=clientAgent;
        this.time=time;
    }
    public Integer getGuestbookId(){
        return guestbookId;
    }
    public void setGuestbookId(Integer guestbookId){
        this.guestbookId=guestbookId;
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

    public Integer getVisitorId(){
        return visitorId;
    }
    public void setVisitorId(Integer visitorId){
        this.visitorId=visitorId;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content=content;
    }

    public Short getClientType(){
        return clientType;
    }
    public void setClientType(Short clientType){
        this.clientType=clientType;
    }

    public String getClientIp(){
        return clientIp;
    }
    public void setClientIp(String clientIp){
        this.clientIp=clientIp;
    }

    public String getClientAgent(){
        return clientAgent;
    }
    public void setClientAgent(String clientAgent){
        this.clientAgent=clientAgent;
    }

    public Timestamp getTime(){
        return time;
    }
    public void setTime(Timestamp time){
        this.time=time;
    }


}