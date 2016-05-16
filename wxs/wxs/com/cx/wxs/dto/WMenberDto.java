package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.WWxsDto;
/**
 * @author 陈义
 * @date 2016-05-16 10:33:22
 */
public class WMenberDto extends BeanBase{
    private Integer menberId;
    private UUserDto UUserDto;
    private WWxsDto WWxsDto;
    private Timestamp createTime;
    private Timestamp lastTime;
    private Short clientType;
    private String clientIp;
    private String clientAgent;
    private Short status;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public WMenberDto(){

    }

    /** full constructor */
    public WMenberDto(Integer menberId,UUserDto UUserDto,WWxsDto WWxsDto,Timestamp createTime,Timestamp lastTime,Short clientType,String clientIp,String clientAgent,Short status,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.menberId=menberId;
        this.UUserDto=UUserDto;
        this.WWxsDto=WWxsDto;
        this.createTime=createTime;
        this.lastTime=lastTime;
        this.clientType=clientType;
        this.clientIp=clientIp;
        this.clientAgent=clientAgent;
        this.status=status;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }

    public Integer getMenberId(){
        return menberId;
    }
    public void setMenberId(Integer menberId){
        this.menberId=menberId;
    }

    public UUserDto getUUserDto(){
        return UUserDto;
    }
    public void setUUserDto(UUserDto UUserDto){
        this.UUserDto=UUserDto;
    }

    public WWxsDto getWWxsDto(){
        return WWxsDto;
    }
    public void setWWxsDto(WWxsDto WWxsDto){
        this.WWxsDto=WWxsDto;
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

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status=status;
    }

    public Integer getExt1(){
        return ext1;
    }
    public void setExt1(Integer ext1){
        this.ext1=ext1;
    }

    public Integer getExt2(){
        return ext2;
    }
    public void setExt2(Integer ext2){
        this.ext2=ext2;
    }

    public String getExt3(){
        return ext3;
    }
    public void setExt3(String ext3){
        this.ext3=ext3;
    }

    public String getExt4(){
        return ext4;
    }
    public void setExt4(String ext4){
        this.ext4=ext4;
    }


}