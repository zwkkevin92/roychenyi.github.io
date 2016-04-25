package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class VVoteDto extends BeanBase{
    private Integer voteId;
    private UUserDto UUserDto;
    private Integer vconfigId;
    private String content;
    private Timestamp createTime;
    private Timestamp updateTime;

    /** default constructor */
    public VVoteDto(){

    }

    /** full constructor */
    public VVoteDto(Integer voteId,UUserDto UUserDto,Integer vconfigId,String content,Timestamp createTime,Timestamp updateTime){super();
        this.voteId=voteId;
        this.UUserDto=UUserDto;
        this.vconfigId=vconfigId;
        this.content=content;
        this.createTime=createTime;
        this.updateTime=updateTime;
    }
    public Integer getVoteId(){
        return voteId;
    }
    public void setVoteId(Integer voteId){
        this.voteId=voteId;
    }

    public UUserDto getUUserDto(){
        return UUserDto;
    }
    public void setUUserDto(UUserDto UUserDto){
        this.UUserDto=UUserDto;
    }

    public Integer getVconfigId(){
        return vconfigId;
    }
    public void setVconfigId(Integer vconfigId){
        this.vconfigId=vconfigId;
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


}