package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class SBoxDto extends BeanBase{
    private Integer boxId;
    private UUserDto UUserDto;
    private String name;
    private String description;
    private Timestamp createTime;
    private Integer soundCount;
    private Short sortOrder;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public SBoxDto(){

    }

    /** full constructor */
    public SBoxDto(Integer boxId,UUserDto UUserDto,String name,String description,Timestamp createTime,Integer soundCount,Short sortOrder,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.boxId=boxId;
        this.UUserDto=UUserDto;
        this.name=name;
        this.description=description;
        this.createTime=createTime;
        this.soundCount=soundCount;
        this.sortOrder=sortOrder;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }
    public Integer getBoxId(){
        return boxId;
    }
    public void setBoxId(Integer boxId){
        this.boxId=boxId;
    }

    public UUserDto getUUserDto(){
        return UUserDto;
    }
    public void setUUserDto(UUserDto UUserDto){
        this.UUserDto=UUserDto;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public Timestamp getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Timestamp createTime){
        this.createTime=createTime;
    }

    public Integer getSoundCount(){
        return soundCount;
    }
    public void setSoundCount(Integer soundCount){
        this.soundCount=soundCount;
    }

    public Short getSortOrder(){
        return sortOrder;
    }
    public void setSortOrder(Short sortOrder){
        this.sortOrder=sortOrder;
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