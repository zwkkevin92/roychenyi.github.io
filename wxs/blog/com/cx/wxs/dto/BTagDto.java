package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.BSiteDto;
import com.cx.wxs.dto.DDiaryDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class BTagDto extends BeanBase{
    private Integer tagId;
    private BSiteDto BSiteDto;
    private DDiaryDto DDiaryDto;
    private Short refType;
    private Timestamp time;
    private String tagName;

    /** default constructor */
    public BTagDto(){

    }

    /** full constructor */
    public BTagDto(Integer tagId,BSiteDto BSiteDto,DDiaryDto DDiaryDto,Short refType,Timestamp time,String tagName){super();
        this.tagId=tagId;
        this.BSiteDto=BSiteDto;
        this.DDiaryDto=DDiaryDto;
        this.refType=refType;
        this.time=time;
        this.tagName=tagName;
    }
    public Integer getTagId(){
        return tagId;
    }
    public void setTagId(Integer tagId){
        this.tagId=tagId;
    }

    public BSiteDto getBSiteDto(){
        return BSiteDto;
    }
    public void setBSiteDto(BSiteDto BSiteDto){
        this.BSiteDto=BSiteDto;
    }

    public DDiaryDto getDDiaryDto(){
        return DDiaryDto;
    }
    public void setDDiaryDto(DDiaryDto DDiaryDto){
        this.DDiaryDto=DDiaryDto;
    }

    public Short getRefType(){
        return refType;
    }
    public void setRefType(Short refType){
        this.refType=refType;
    }

    public Timestamp getTime(){
        return time;
    }
    public void setTime(Timestamp time){
        this.time=time;
    }

    public String getTagName(){
        return tagName;
    }
    public void setTagName(String tagName){
        this.tagName=tagName;
    }


}