package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2016-04-16 09:22:44
 */
public class DFavoriteDto extends BeanBase{
    private Integer dfavoriteId;
    private DDiaryDto DDiaryDto;
    private UUserDto UUserDto;
    private String clientAgent;
    private String clientIp;
    private Short clientType;
    private Timestamp time;
    private Timestamp updateTime;
    private Short status;

    /** default constructor */
    public DFavoriteDto(){

    }

    /** full constructor */
    public DFavoriteDto(Integer dfavoriteId,DDiaryDto DDiaryDto,UUserDto UUserDto,String clientAgent,String clientIp,Short clientType,Timestamp time,Timestamp updateTime,Short status){super();
        this.dfavoriteId=dfavoriteId;
        this.DDiaryDto=DDiaryDto;
        this.UUserDto=UUserDto;
        this.clientAgent=clientAgent;
        this.clientIp=clientIp;
        this.clientType=clientType;
        this.time=time;
        this.updateTime=updateTime;
        this.status=status;
    }

    public Integer getDfavoriteId(){
        return dfavoriteId;
    }
    public void setDfavoriteId(Integer dfavoriteId){
        this.dfavoriteId=dfavoriteId;
    }

    public DDiaryDto getDDiaryDto(){
        return DDiaryDto;
    }
    public void setDDiaryDto(DDiaryDto DDiaryDto){
        this.DDiaryDto=DDiaryDto;
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

    public Timestamp getUpdateTime(){
        return updateTime;
    }
    public void setUpdateTime(Timestamp updateTime){
        this.updateTime=updateTime;
    }

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status=status;
    }


}