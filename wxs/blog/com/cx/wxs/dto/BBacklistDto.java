package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class BBacklistDto extends BeanBase{
    private Integer blacklistId;
    private UUserDto UUserByUserIdDto;
    private UUserDto UUserByBackIdDto;
    private Integer blType;
    private Timestamp addTime;

    /** default constructor */
    public BBacklistDto(){

    }

    /** full constructor */
    public BBacklistDto(Integer blacklistId,UUserDto UUserByUserIdDto,UUserDto UUserByBackIdDto,Integer blType,Timestamp addTime){super();
        this.blacklistId=blacklistId;
        this.UUserByUserIdDto=UUserByUserIdDto;
        this.UUserByBackIdDto=UUserByBackIdDto;
        this.blType=blType;
        this.addTime=addTime;
    }
    public Integer getBlacklistId(){
        return blacklistId;
    }
    public void setBlacklistId(Integer blacklistId){
        this.blacklistId=blacklistId;
    }

    public UUserDto getUUserByUserIdDto(){
        return UUserByUserIdDto;
    }
    public void setUUserByUserIdDto(UUserDto UUserByUserIdDto){
        this.UUserByUserIdDto=UUserByUserIdDto;
    }

    public UUserDto getUUserByBackIdDto(){
        return UUserByBackIdDto;
    }
    public void setUUserByBackIdDto(UUserDto UUserByBackIdDto){
        this.UUserByBackIdDto=UUserByBackIdDto;
    }

    public Integer getBlType(){
        return blType;
    }
    public void setBlType(Integer blType){
        this.blType=blType;
    }

    public Timestamp getAddTime(){
        return addTime;
    }
    public void setAddTime(Timestamp addTime){
        this.addTime=addTime;
    }


}