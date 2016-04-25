package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

/**
 * @author 陈义
 * @date 2016-04-11 17:06:23
 */
public class SysTypeDto extends BeanBase{
    private Integer typeId;
    private String name;
    private String value;
    private Timestamp createTime;
    private Timestamp lastTime;
    private Integer parentId;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public SysTypeDto(){

    }

    /** full constructor */
    public SysTypeDto(Integer typeId,String name,String value,Timestamp createTime,Timestamp lastTime,Integer parentId,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.typeId=typeId;
        this.name=name;
        this.value=value;
        this.createTime=createTime;
        this.lastTime=lastTime;
        this.parentId=parentId;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }

    public Integer getTypeId(){
        return typeId;
    }
    public void setTypeId(Integer typeId){
        this.typeId=typeId;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
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

    public Integer getParentId(){
        return parentId;
    }
    public void setParentId(Integer parentId){
        this.parentId=parentId;
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