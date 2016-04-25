package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import com.cx.wxs.dto.UUserDto;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class UFriendGroupDto extends BeanBase{
    private Integer groupId;
    private UUserDto UUserDto;
    private String name;
    private Integer groupType;
    private Integer groupCount;

    /** default constructor */
    public UFriendGroupDto(){

    }

    /** full constructor */
    public UFriendGroupDto(Integer groupId,UUserDto UUserDto,String name,Integer groupType,Integer groupCount){super();
        this.groupId=groupId;
        this.UUserDto=UUserDto;
        this.name=name;
        this.groupType=groupType;
        this.groupCount=groupCount;
    }
    public Integer getGroupId(){
        return groupId;
    }
    public void setGroupId(Integer groupId){
        this.groupId=groupId;
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

    public Integer getGroupType(){
        return groupType;
    }
    public void setGroupType(Integer groupType){
        this.groupType=groupType;
    }

    public Integer getGroupCount(){
        return groupCount;
    }
    public void setGroupCount(Integer groupCount){
        this.groupCount=groupCount;
    }


}