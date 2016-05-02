package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.po.DReply2;
/**
 * @author 陈义
 * @date 2015-12-09 22:36:38
 */
public class DReply1Dto extends BeanBase{
    private Integer dreplyId;
    private DDiaryDto DDiaryDto;
    private UUserDto UUserDto;
    private Short clientType;
    private Short ownerOnly;
    private Timestamp writeTime;
    private Short status;
    private List<DReply2Dto> DReply2Dtos = new ArrayList<DReply2Dto>(0);

    /** default constructor */
    public DReply1Dto(){

    }

    /** full constructor */
    public DReply1Dto(Integer dreplyId,DDiaryDto DDiaryDto,UUserDto UUserDto,Short clientType,Short ownerOnly,Timestamp writeTime,Short status){super();
        this.dreplyId=dreplyId;
        this.DDiaryDto=DDiaryDto;
        this.UUserDto=UUserDto;
        this.clientType=clientType;
        this.ownerOnly=ownerOnly;
        this.writeTime=writeTime;
        this.status=status;
    }
    
    
    /**
	 * @param dreplyId
	 * @param dDiaryDto
	 * @param uUserDto
	 * @param clientType
	 * @param ownerOnly
	 * @param writeTime
	 * @param status
	 * @param dReply2s
	 * @author 陈义
	 * @date   2016-4-27上午9:58:28
	 */
	public DReply1Dto(Integer dreplyId, com.cx.wxs.dto.DDiaryDto dDiaryDto,
			com.cx.wxs.dto.UUserDto uUserDto, Short clientType,
			Short ownerOnly, Timestamp writeTime, Short status,
			List<DReply2Dto> dReply2Dtos) {
		super();
		this.dreplyId = dreplyId;
		DDiaryDto = dDiaryDto;
		UUserDto = uUserDto;
		this.clientType = clientType;
		this.ownerOnly = ownerOnly;
		this.writeTime = writeTime;
		this.status = status;
		DReply2Dtos = dReply2Dtos;
	}

	public Integer getDreplyId(){
        return dreplyId;
    }
    public void setDreplyId(Integer dreplyId){
        this.dreplyId=dreplyId;
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

    public Short getClientType(){
        return clientType;
    }
    public void setClientType(Short clientType){
        this.clientType=clientType;
    }

    public Short getOwnerOnly(){
        return ownerOnly;
    }
    public void setOwnerOnly(Short ownerOnly){
        this.ownerOnly=ownerOnly;
    }

    public Timestamp getWriteTime(){
        return writeTime;
    }
    public void setWriteTime(Timestamp writeTime){
        this.writeTime=writeTime;
    }

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status=status;
    }

	/**
	 * @return the dReply2s
	 */
	public List<DReply2Dto> getDReply2Dtos() {
		return DReply2Dtos;
	}

	/**
	 * @param dReply2s the dReply2s to set
	 */
	public void setDReply2Dtos(List<DReply2Dto> dReply2Dtos) {
		DReply2Dtos = dReply2Dtos;
	}


}