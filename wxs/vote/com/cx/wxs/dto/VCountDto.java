package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.VVoteDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.VItemDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class VCountDto extends BeanBase{
    private Integer vcountId;
    private VVoteDto VVoteDto;
    private UUserDto UUserDto;
    private VItemDto VItemDto;
    private String clientAgent;
    private String clientIp;
    private Short clientType;
    private Timestamp time;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public VCountDto(){

    }

    /** full constructor */
    public VCountDto(Integer vcountId,VVoteDto VVoteDto,UUserDto UUserDto,VItemDto VItemDto,String clientAgent,String clientIp,Short clientType,Timestamp time,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.vcountId=vcountId;
        this.VVoteDto=VVoteDto;
        this.UUserDto=UUserDto;
        this.VItemDto=VItemDto;
        this.clientAgent=clientAgent;
        this.clientIp=clientIp;
        this.clientType=clientType;
        this.time=time;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }
    public Integer getVcountId(){
        return vcountId;
    }
    public void setVcountId(Integer vcountId){
        this.vcountId=vcountId;
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

    public VItemDto getVItemDto(){
        return VItemDto;
    }
    public void setVItemDto(VItemDto VItemDto){
        this.VItemDto=VItemDto;
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