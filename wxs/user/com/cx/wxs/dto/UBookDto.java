package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class UBookDto extends BeanBase{
    private Integer ubookId;
    private UUserDto UUserDto;
    private String name;
    private String bookDetaik;
    private String cover;
    private Timestamp time;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public UBookDto(){

    }

    /** full constructor */
    public UBookDto(Integer ubookId,UUserDto UUserDto,String name,String bookDetaik,String cover,Timestamp time,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.ubookId=ubookId;
        this.UUserDto=UUserDto;
        this.name=name;
        this.bookDetaik=bookDetaik;
        this.cover=cover;
        this.time=time;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }
    public Integer getUbookId(){
        return ubookId;
    }
    public void setUbookId(Integer ubookId){
        this.ubookId=ubookId;
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

    public String getBookDetaik(){
        return bookDetaik;
    }
    public void setBookDetaik(String bookDetaik){
        this.bookDetaik=bookDetaik;
    }

    public String getCover(){
        return cover;
    }
    public void setCover(String cover){
        this.cover=cover;
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