package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.VVoteDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class VItemDto extends BeanBase{
    private Integer itemId;
    private VVoteDto VVoteDto;
    private String content;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer count;
    private Short sortOrder;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public VItemDto(){

    }

    /** full constructor */
    public VItemDto(Integer itemId,VVoteDto VVoteDto,String content,Timestamp createTime,Timestamp updateTime,Integer count,Short sortOrder,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.itemId=itemId;
        this.VVoteDto=VVoteDto;
        this.content=content;
        this.createTime=createTime;
        this.updateTime=updateTime;
        this.count=count;
        this.sortOrder=sortOrder;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }
    public Integer getItemId(){
        return itemId;
    }
    public void setItemId(Integer itemId){
        this.itemId=itemId;
    }

    public VVoteDto getVVoteDto(){
        return VVoteDto;
    }
    public void setVVoteDto(VVoteDto VVoteDto){
        this.VVoteDto=VVoteDto;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content=content;
    }

    public Timestamp getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Timestamp createTime){
        this.createTime=createTime;
    }

    public Timestamp getUpdateTime(){
        return updateTime;
    }
    public void setUpdateTime(Timestamp updateTime){
        this.updateTime=updateTime;
    }

    public Integer getCount(){
        return count;
    }
    public void setCount(Integer count){
        this.count=count;
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