package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.WWxsDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class WConfigDto extends BeanBase{
    private Integer wconfigId;
    private WWxsDto WWxsDto;
    private String configKey;
    private String value;
    private Timestamp createTime;
    private Timestamp lastTime;

    /** default constructor */
    public WConfigDto(){

    }

    /** full constructor */
    public WConfigDto(Integer wconfigId,WWxsDto WWxsDto,String configKey,String value,Timestamp createTime,Timestamp lastTime){super();
        this.wconfigId=wconfigId;
        this.WWxsDto=WWxsDto;
        this.configKey=configKey;
        this.value=value;
        this.createTime=createTime;
        this.lastTime=lastTime;
    }
    public Integer getWconfigId(){
        return wconfigId;
    }
    public void setWconfigId(Integer wconfigId){
        this.wconfigId=wconfigId;
    }

    public WWxsDto getWWxsDto(){
        return WWxsDto;
    }
    public void setWWxsDto(WWxsDto WWxsDto){
        this.WWxsDto=WWxsDto;
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