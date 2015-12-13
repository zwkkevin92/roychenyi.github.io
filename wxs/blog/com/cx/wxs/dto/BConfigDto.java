package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.BSiteDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class BConfigDto extends BeanBase{
    private Integer bconfigId;
    private BSiteDto BSiteDto;
    private String configKey;
    private String value;
    private Timestamp createTime;
    private Timestamp lastTime;

    /** default constructor */
    public BConfigDto(){

    }

    /** full constructor */
    public BConfigDto(Integer bconfigId,BSiteDto BSiteDto,String configKey,String value,Timestamp createTime,Timestamp lastTime){super();
        this.bconfigId=bconfigId;
        this.BSiteDto=BSiteDto;
        this.configKey=configKey;
        this.value=value;
        this.createTime=createTime;
        this.lastTime=lastTime;
    }
    public Integer getBconfigId(){
        return bconfigId;
    }
    public void setBconfigId(Integer bconfigId){
        this.bconfigId=bconfigId;
    }

    public BSiteDto getBSiteDto(){
        return BSiteDto;
    }
    public void setBSiteDto(BSiteDto BSiteDto){
        this.BSiteDto=BSiteDto;
    }

    public String getConfigKey(){
        return configKey;
    }
    public void setConfigKey(String configKey){
        this.configKey=configKey;
    }

    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value=value;
    }

    public Timestamp getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Timestamp createTime){
        this.createTime=createTime;
    }

    public Timestamp getLastTime(){
        return lastTime;
    }
    public void setLastTime(Timestamp lastTime){
        this.lastTime=lastTime;
    }


}