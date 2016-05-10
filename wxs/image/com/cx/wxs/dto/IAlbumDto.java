package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.BSiteDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class IAlbumDto extends BeanBase{
    private Integer albumId;
    private UUserDto UUserDto;
    private BSiteDto BSiteDto;
    private String name;
    private String description;
    private Integer ablumType;
    private Integer ablumCount;
    private String accessQuestion;
    private String verifycode;
    private Timestamp createTime;
    private Short sortOrder;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public IAlbumDto(){

    }

    /** full constructor */
    public IAlbumDto(Integer albumId,UUserDto UUserDto,BSiteDto BSiteDto,String name,String description,Integer ablumType,Integer ablumCount,String accessQuestion,String verifycode,Timestamp createTime,Short sortOrder,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.albumId=albumId;
        this.UUserDto=UUserDto;
        this.BSiteDto=BSiteDto;
        this.name=name;
        this.description=description;
        this.ablumType=ablumType;
        this.ablumCount=ablumCount;
        this.accessQuestion=accessQuestion;
        this.verifycode=verifycode;
        this.createTime=createTime;
        this.sortOrder=sortOrder;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }
    public Integer getAlbumId(){
        return albumId;
    }
    public void setAlbumId(Integer albumId){
        this.albumId=albumId;
    }

    public UUserDto getUUserDto(){
        return UUserDto;
    }
    public void setUUserDto(UUserDto UUserDto){
        this.UUserDto=UUserDto;
    }

    public BSiteDto getBSiteDto(){
        return BSiteDto;
    }
    public void setBSiteDto(BSiteDto BSiteDto){
        this.BSiteDto=BSiteDto;
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

    public Integer getAblumType(){
        return ablumType;
    }
    public void setAblumType(Integer ablumType){
        this.ablumType=ablumType;
    }

    public Integer getAblumCount(){
        return ablumCount;
    }
    public void setAblumCount(Integer ablumCount){
        this.ablumCount=ablumCount;
    }

    public String getAccessQuestion(){
        return accessQuestion;
    }
    public void setAccessQuestion(String accessQuestion){
        this.accessQuestion=accessQuestion;
    }

    public String getVerifycode(){
        return verifycode;
    }
    public void setVerifycode(String verifycode){
        this.verifycode=verifycode;
    }

    public Timestamp getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Timestamp createTime){
        this.createTime=createTime;
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