package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.WWxsDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class WStatusDto extends BeanBase{
    private Integer wstatusId;
    private WWxsDto WWxsDto;
    private Timestamp time;
    private Integer uvCount;
    private Integer pvCount;
    private Integer type;
    private Timestamp updateTime;

    /** default constructor */
    public WStatusDto(){

    }

    /** full constructor */
    public WStatusDto(Integer wstatusId,WWxsDto WWxsDto,Timestamp time,Integer uvCount,Integer pvCount,Integer type,Timestamp updateTime){super();
        this.wstatusId=wstatusId;
        this.WWxsDto=WWxsDto;
        this.time=time;
        this.uvCount=uvCount;
        this.pvCount=pvCount;
        this.type=type;
        this.updateTime=updateTime;
    }
    public Integer getWstatusId(){
        return wstatusId;
    }
    public void setWstatusId(Integer wstatusId){
        this.wstatusId=wstatusId;
    }

    public WWxsDto getWWxsDto(){
        return WWxsDto;
    }
    public void setWWxsDto(WWxsDto WWxsDto){
        this.WWxsDto=WWxsDto;
    }

    public Timestamp getTime(){
        return time;
    }
    public void setTime(Timestamp time){
        this.time=time;
    }

    public Integer getUvCount(){
        return uvCount;
    }
    public void setUvCount(Integer uvCount){
        this.uvCount=uvCount;
    }

    public Integer getPvCount(){
        return pvCount;
    }
    public void setPvCount(Integer pvCount){
        this.pvCount=pvCount;
    }

    public Integer getType(){
        return type;
    }
    public void setType(Integer type){
        this.type=type;
    }

    public Timestamp getUpdateTime(){
        return updateTime;
    }
    public void setUpdateTime(Timestamp updateTime){
        this.updateTime=updateTime;
    }


}