package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;

import com.cx.wxs.dto.UFriendGroupDto;
import com.cx.wxs.po.UUser;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class UFriendDto extends BeanBase{
    private Integer id;
    private UFriendGroupDto UFriendGroupDto;
    private UUserDto userDto;
    private UUserDto friendDto;
    private Integer friendType;
    private Integer friendRole;
    private Timestamp addTime;
    private Short status;

    /** default constructor */
    public UFriendDto(){

    }

    /** full constructor */
    public UFriendDto(Integer id,UFriendGroupDto UFriendGroupDto,UUserDto userDto,UUserDto friendDto,Integer friendType,Integer friendRole,Timestamp addTime,Short status){super();
        this.id=id;
        this.UFriendGroupDto=UFriendGroupDto;
        this.userDto=userDto;
        this.friendDto=friendDto;
        this.friendType=friendType;
        this.friendRole=friendRole;
        this.addTime=addTime;
        this.status=status;
    }
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }

    public UFriendGroupDto getUFriendGroupDto(){
        return UFriendGroupDto;
    }
    public void setUFriendGroupDto(UFriendGroupDto UFriendGroupDto){
        this.UFriendGroupDto=UFriendGroupDto;
    }

    

	public UUserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UUserDto userDto) {
		this.userDto = userDto;
	}

	public UUserDto getFriendDto() {
		return friendDto;
	}

	public void setFriendDto(UUserDto friendDto) {
		this.friendDto = friendDto;
	}

	public Integer getFriendType(){
        return friendType;
    }
    public void setFriendType(Integer friendType){
        this.friendType=friendType;
    }

    public Integer getFriendRole(){
        return friendRole;
    }
    public void setFriendRole(Integer friendRole){
        this.friendRole=friendRole;
    }

    public Timestamp getAddTime(){
        return addTime;
    }
    public void setAddTime(Timestamp addTime){
        this.addTime=addTime;
    }

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status=status;
    }


}