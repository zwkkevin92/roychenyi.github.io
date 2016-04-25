package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.dto.BSiteDto;
import com.cx.wxs.dto.IAlbumDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class IImageDto extends BeanBase{
    private Integer imageId;
    private UUserDto UUserDto;
    private BSiteDto BSiteDto;
    private IAlbumDto IAlbumDto;
    private String name;
    private String content;
    private String fileName;
    private String filePath;
    private String url;
    private String previewUrl;
    private String tag;
    private Timestamp time;
    private Short year;
    private Short mount;
    private Short day;
    private Short width;
    private Short height;
    private Integer imageType;
    private Short clientType;
    private String clientIp;
    private String clientAgent;
    private Short status;
    private Integer replyCount;
    private Integer viewCount;
    private Integer downloadCount;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public IImageDto(){

    }

    /** full constructor */
    public IImageDto(Integer imageId,UUserDto UUserDto,BSiteDto BSiteDto,IAlbumDto IAlbumDto,String name,String content,String fileName,String filePath,String url,String previewUrl,String tag,Timestamp time,Short year,Short mount,Short day,Short width,Short height,Integer imageType,Short clientType,String clientIp,String clientAgent,Short status,Integer replyCount,Integer viewCount,Integer downloadCount,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.imageId=imageId;
        this.UUserDto=UUserDto;
        this.BSiteDto=BSiteDto;
        this.IAlbumDto=IAlbumDto;
        this.name=name;
        this.content=content;
        this.fileName=fileName;
        this.filePath=filePath;
        this.url=url;
        this.previewUrl=previewUrl;
        this.tag=tag;
        this.time=time;
        this.year=year;
        this.mount=mount;
        this.day=day;
        this.width=width;
        this.height=height;
        this.imageType=imageType;
        this.clientType=clientType;
        this.clientIp=clientIp;
        this.clientAgent=clientAgent;
        this.status=status;
        this.replyCount=replyCount;
        this.viewCount=viewCount;
        this.downloadCount=downloadCount;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }
    public Integer getImageId(){
        return imageId;
    }
    public void setImageId(Integer imageId){
        this.imageId=imageId;
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

    public IAlbumDto getIAlbumDto(){
        return IAlbumDto;
    }
    public void setIAlbumDto(IAlbumDto IAlbumDto){
        this.IAlbumDto=IAlbumDto;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content=content;
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

    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url=url;
    }

    public String getPreviewUrl(){
        return previewUrl;
    }
    public void setPreviewUrl(String previewUrl){
        this.previewUrl=previewUrl;
    }

    public String getTag(){
        return tag;
    }
    public void setTag(String tag){
        this.tag=tag;
    }

    public Timestamp getTime(){
        return time;
    }
    public void setTime(Timestamp time){
        this.time=time;
    }

    public Short getYear(){
        return year;
    }
    public void setYear(Short year){
        this.year=year;
    }

    public Short getMount(){
        return mount;
    }
    public void setMount(Short mount){
        this.mount=mount;
    }

    public Short getDay(){
        return day;
    }
    public void setDay(Short day){
        this.day=day;
    }

    public Short getWidth(){
        return width;
    }
    public void setWidth(Short width){
        this.width=width;
    }

    public Short getHeight(){
        return height;
    }
    public void setHeight(Short height){
        this.height=height;
    }

    public Integer getImageType(){
        return imageType;
    }
    public void setImageType(Integer imageType){
        this.imageType=imageType;
    }

    public Short getClientType(){
        return clientType;
    }
    public void setClientType(Short clientType){
        this.clientType=clientType;
    }

    public String getClientIp(){
        return clientIp;
    }
    public void setClientIp(String clientIp){
        this.clientIp=clientIp;
    }

    public String getClientAgent(){
        return clientAgent;
    }
    public void setClientAgent(String clientAgent){
        this.clientAgent=clientAgent;
    }

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status=status;
    }

    public Integer getReplyCount(){
        return replyCount;
    }
    public void setReplyCount(Integer replyCount){
        this.replyCount=replyCount;
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