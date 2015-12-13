package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.BSiteDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class DAnnexDto extends BeanBase{
    private Integer annexId;
    private DDiaryDto DDiaryDto;
    private UUserDto UUserDto;
    private BSiteDto BSiteDto;
    private Timestamp uploadTime;
    private Integer downloadCount;
    private Short status;
    private Short validate;
    private String url;
    private String path;
    private String fileName;
    private String fileDescription;
    private Integer size;
    private Timestamp lastTime;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public DAnnexDto(){

    }

    /** full constructor */
    public DAnnexDto(Integer annexId,DDiaryDto DDiaryDto,UUserDto UUserDto,BSiteDto BSiteDto,Timestamp uploadTime,Integer downloadCount,Short status,Short validate,String url,String path,String fileName,String fileDescription,Integer size,Timestamp lastTime,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.annexId=annexId;
        this.DDiaryDto=DDiaryDto;
        this.UUserDto=UUserDto;
        this.BSiteDto=BSiteDto;
        this.uploadTime=uploadTime;
        this.downloadCount=downloadCount;
        this.status=status;
        this.validate=validate;
        this.url=url;
        this.path=path;
        this.fileName=fileName;
        this.fileDescription=fileDescription;
        this.size=size;
        this.lastTime=lastTime;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }
    public Integer getAnnexId(){
        return annexId;
    }
    public void setAnnexId(Integer annexId){
        this.annexId=annexId;
    }

    public DDiaryDto getDDiaryDto(){
        return DDiaryDto;
    }
    public void setDDiaryDto(DDiaryDto DDiaryDto){
        this.DDiaryDto=DDiaryDto;
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

    public Timestamp getUploadTime(){
        return uploadTime;
    }
    public void setUploadTime(Timestamp uploadTime){
        this.uploadTime=uploadTime;
    }

    public Integer getDownloadCount(){
        return downloadCount;
    }
    public void setDownloadCount(Integer downloadCount){
        this.downloadCount=downloadCount;
    }

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status=status;
    }

    public Short getValidate(){
        return validate;
    }
    public void setValidate(Short validate){
        this.validate=validate;
    }

    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url=url;
    }

    public String getPath(){
        return path;
    }
    public void setPath(String path){
        this.path=path;
    }

    public String getFileName(){
        return fileName;
    }
    public void setFileName(String fileName){
        this.fileName=fileName;
    }

    public String getFileDescription(){
        return fileDescription;
    }
    public void setFileDescription(String fileDescription){
        this.fileDescription=fileDescription;
    }

    public Integer getSize(){
        return size;
    }
    public void setSize(Integer size){
        this.size=size;
    }

    public Timestamp getLastTime(){
        return lastTime;
    }
    public void setLastTime(Timestamp lastTime){
        this.lastTime=lastTime;
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