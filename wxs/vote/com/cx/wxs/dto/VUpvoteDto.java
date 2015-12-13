package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.VVoteDto;
import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class VUpvoteDto extends BeanBase{
    private Integer vupvoteId;
    private VVoteDto VVoteDto;
    private UUserDto UUserDto;
    private Integer userId;
    private String clientAgent;
    private String clientIp;
    private Short clientType;
    private Timestamp time;
    private Short status;

    /** default constructor */
    public VUpvoteDto(){

    }

    /** full constructor */
    public VUpvoteDto(Integer vupvoteId,VVoteDto VVoteDto,UUserDto UUserDto,Integer userId,String clientAgent,String clientIp,Short clientType,Timestamp time,Short status){super();
        this.vupvoteId=vupvoteId;
        this.VVoteDto=VVoteDto;
        this.UUserDto=UUserDto;
        this.userId=userId;
        this.clientAgent=clientAgent;
        this.clientIp=clientIp;
        this.clientType=clientType;
        this.time=time;
        this.status=status;
    }
    public Integer getVupvoteId(){
        return vupvoteId;
    }
    public void setVupvoteId(Integer vupvoteId){
        this.vupvoteId=vupvoteId;
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

    public Integer getUserId(){
        return userId;
    }
    public void setUserId(Integer userId){
        this.userId=userId;
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