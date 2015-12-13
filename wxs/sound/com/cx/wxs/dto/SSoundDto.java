package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.SBoxDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class SSoundDto extends BeanBase{
    private Integer soundId;
    private UUserDto UUserDto;
    private SBoxDto SBoxDto;
    private String title;
    private String content;
    private String url;
    private String fileName;
    private String filePath;
    private Timestamp time;
    private Short status;
    private Integer viewCount;
    private Integer downloadCount;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public SSoundDto(){

    }

    /** full constructor */
    public SSoundDto(Integer soundId,UUserDto UUserDto,SBoxDto SBoxDto,String title,String content,String url,String fileName,String filePath,Timestamp time,Short status,Integer viewCount,Integer downloadCount,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.soundId=soundId;
        this.UUserDto=UUserDto;
        this.SBoxDto=SBoxDto;
        this.title=title;
        this.content=content;
        this.url=url;
        this.fileName=fileName;
        this.filePath=filePath;
        this.time=time;
        this.status=status;
        this.viewCount=viewCount;
        this.downloadCount=downloadCount;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }
    public Integer getSoundId(){
        return soundId;
    }
    public void setSoundId(Integer soundId){
        this.soundId=soundId;
    }

    public UUserDto getUUserDto(){
        return UUserDto;
    }
    public void setUUserDto(UUserDto UUserDto){
        this.UUserDto=UUserDto;
    }

    public SBoxDto getSBoxDto(){
        return SBoxDto;
    }
    public void setSBoxDto(SBoxDto SBoxDto){
        this.SBoxDto=SBoxDto;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content=content;
    }

    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url=url;
    }

    public String getFileName(){
        return fileName;
    }
    public void setFileName(String fileName){
        this.fileName=fileName;
    }

    public String getFilePath(){
        return filePath;
    }
    public void setFilePath(String filePath){
        this.filePath=filePath;
    }

    public Timestamp getTime(){
        return time;
    }
    public void setTime(Timestamp time){
        this.time=time;
    }

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status=status;
    }

    public Integer getViewCount(){
        return viewCount;
    }
    public void setViewCount(Integer viewCount){
        this.viewCount=viewCount;
    }

    public Integer getDownloadCount(){
        return downloadCount;
    }
    public void setDownloadCount(Integer downloadCount){
        this.downloadCount=downloadCount;
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