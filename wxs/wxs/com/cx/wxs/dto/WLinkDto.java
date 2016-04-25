package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.WWxsDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class WLinkDto extends BeanBase{
    private Integer wlinkId;
    private WWxsDto WWxsDto;
    private String name;
    private String linkUrl;
    private String logo;
    private Integer linkType;
    private Timestamp createTime;
    private Short status;
    private Short sortOrder;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public WLinkDto(){

    }

    /** full constructor */
    public WLinkDto(Integer wlinkId,WWxsDto WWxsDto,String name,String linkUrl,String logo,Integer linkType,Timestamp createTime,Short status,Short sortOrder,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.wlinkId=wlinkId;
        this.WWxsDto=WWxsDto;
        this.name=name;
        this.linkUrl=linkUrl;
        this.logo=logo;
        this.linkType=linkType;
        this.createTime=createTime;
        this.status=status;
        this.sortOrder=sortOrder;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }
    public Integer getWlinkId(){
        return wlinkId;
    }
    public void setWlinkId(Integer wlinkId){
        this.wlinkId=wlinkId;
    }

    public WWxsDto getWWxsDto(){
        return WWxsDto;
    }
    public void setWWxsDto(WWxsDto WWxsDto){
        this.WWxsDto=WWxsDto;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getLinkUrl(){
        return linkUrl;
    }
    public void setLinkUrl(String linkUrl){
        this.linkUrl=linkUrl;
    }

    public String getLogo(){
        return logo;
    }
    public void setLogo(String logo){
        this.logo=logo;
    }

    public Integer getLinkType(){
        return linkType;
    }
    public void setLinkType(Integer linkType){
        this.linkType=linkType;
    }

    public Timestamp getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Timestamp createTime){
        this.createTime=createTime;
    }

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status=status;
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