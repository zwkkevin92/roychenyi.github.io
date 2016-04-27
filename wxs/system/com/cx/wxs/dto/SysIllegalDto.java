package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

/**
 * @author 陈义
 * @date 2016-03-25 14:36:59
 */
public class SysIllegalDto extends BeanBase{
    private Integer illegalId;
    private String word;
    private String newword;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Short nullify;

    /** default constructor */
    public SysIllegalDto(){

    }

    /** full constructor */
    public SysIllegalDto(Integer illegalId,String word,String newword,Timestamp createTime,Timestamp updateTime,Short nullify){super();
        this.illegalId=illegalId;
        this.word=word;
        this.newword=newword;
        this.createTime=createTime;
        this.updateTime=updateTime;
        this.nullify=nullify;
    }

    public Integer getIllegalId(){
        return illegalId;
    }
    public void setIllegalId(Integer illegalId){
        this.illegalId=illegalId;
    }

    public String getWord(){
        return word;
    }
    public void setWord(String word){
        this.word=word;
    }

    public String getNewword(){
        return newword;
    }
    public void setNewword(String newword){
        this.newword=newword;
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

    public Short getNullify(){
        return nullify;
    }
    public void setNullify(Short nullify){
        this.nullify=nullify;
    }


}