package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.WWxsDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class WBookDto extends BeanBase{
    private Integer wbookId;
    private WWxsDto WWxsDto;
    private String name;
    private String bookDateil;
    private String cover;
    private Timestamp createTime;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public WBookDto(){

    }

    /** full constructor */
    public WBookDto(Integer wbookId,WWxsDto WWxsDto,String name,String bookDateil,String cover,Timestamp createTime,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.wbookId=wbookId;
        this.WWxsDto=WWxsDto;
        this.name=name;
        this.bookDateil=bookDateil;
        this.cover=cover;
        this.createTime=createTime;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }
    public Integer getWbookId(){
        return wbookId;
    }
    public void setWbookId(Integer wbookId){
        this.wbookId=wbookId;
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

    public String getBookDateil(){
        return bookDateil;
    }
    public void setBookDateil(String bookDateil){
        this.bookDateil=bookDateil;
    }

    public String getCover(){
        return cover;
    }
    public void setCover(String cover){
        this.cover=cover;
    }

    public Timestamp getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Timestamp createTime){
        this.createTime=createTime;
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