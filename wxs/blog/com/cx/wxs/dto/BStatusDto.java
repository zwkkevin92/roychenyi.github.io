package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.BSiteDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class BStatusDto extends BeanBase{
    private Integer bstatusId;
    private BSiteDto BSiteDto;
    private Timestamp time;
    private Integer uvCount;
    private Integer pvCount;
    private Short type;
    private Timestamp updateTime;

    /** default constructor */
    public BStatusDto(){

    }

    /** full constructor */
    public BStatusDto(Integer bstatusId,BSiteDto BSiteDto,Timestamp time,Integer uvCount,Integer pvCount,Short type,Timestamp updateTime){super();
        this.bstatusId=bstatusId;
        this.BSiteDto=BSiteDto;
        this.time=time;
        this.uvCount=uvCount;
        this.pvCount=pvCount;
        this.type=type;
        this.updateTime=updateTime;
    }
    public Integer getBstatusId(){
        return bstatusId;
    }
    public void setBstatusId(Integer bstatusId){
        this.bstatusId=bstatusId;
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

    public Short getType(){
        return type;
    }
    public void setType(Short type){
        this.type=type;
    }

    public Timestamp getUpdateTime(){
        return updateTime;
    }
    public void setUpdateTime(Timestamp updateTime){
        this.updateTime=updateTime;
    }


}