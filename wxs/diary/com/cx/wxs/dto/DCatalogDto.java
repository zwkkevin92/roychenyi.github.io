package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.BSiteDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class DCatalogDto extends BeanBase{
    private Integer catalogId;
    private UUserDto UUserDto;
    private BSiteDto BSiteDto;
    private String catalogName;
    private String description;
    private Timestamp createTime;
    private Integer articleCount;
    private Integer catalogType;
    private String verifyCode;
    private Short sortOrder;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public DCatalogDto(){

    }
    
    public DCatalogDto(Integer catalogId){
    	this.catalogId=catalogId;
    }

    /** full constructor */
    public DCatalogDto(Integer catalogId,UUserDto UUserDto,BSiteDto BSiteDto,String catalogName,String description,Timestamp createTime,Integer articleCount,Integer catalogType,String verifyCode,Short sortOrder,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.catalogId=catalogId;
        this.UUserDto=UUserDto;
        this.BSiteDto=BSiteDto;
        this.catalogName=catalogName;
        this.description=description;
        this.createTime=createTime;
        this.articleCount=articleCount;
        this.catalogType=catalogType;
        this.verifyCode=verifyCode;
        this.sortOrder=sortOrder;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }
    public Integer getCatalogId(){
        return catalogId;
    }
    public void setCatalogId(Integer catalogId){
        this.catalogId=catalogId;
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

    public String getCatalogName(){
        return catalogName;
    }
    public void setCatalogName(String catalogName){
        this.catalogName=catalogName;
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

    public Integer getArticleCount(){
        return articleCount;
    }
    public void setArticleCount(Integer articleCount){
        this.articleCount=articleCount;
    }

    public Integer getCatalogType(){
        return catalogType;
    }
    public void setCatalogType(Integer catalogType){
        this.catalogType=catalogType;
    }

    public String getVerifyCode(){
        return verifyCode;
    }
    public void setVerifyCode(String verifyCode){
        this.verifyCode=verifyCode;
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