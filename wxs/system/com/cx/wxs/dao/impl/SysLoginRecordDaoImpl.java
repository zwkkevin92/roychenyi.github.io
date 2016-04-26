package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SysLoginRecordDao;
import com.cx.wxs.dto.SysLoginRecordDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SysLoginRecord;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("SysLoginRecordDao")
public class SysLoginRecordDaoImpl extends BaseDaoImpl<SysLoginRecord, Integer> implements SysLoginRecordDao{

    private BeanToDto<SysLoginRecord, SysLoginRecordDto> beanToDto=new BeanToDto<SysLoginRecord, SysLoginRecordDto>();

    public BeanToDto<SysLoginRecord, SysLoginRecordDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<SysLoginRecord, SysLoginRecordDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取SysLoginRecordDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public SysLoginRecordDto getSysLoginRecordByID(SysLoginRecordDto sysLoginRecordDto){
        // TODO Auto-generated method stub
        if(sysLoginRecordDto!=null&&sysLoginRecordDto.getRecordId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysLoginRecord.class.getName()+"  a where a.recordId=:id");
           params.put("id",sysLoginRecordDto.getRecordId());
           List<SysLoginRecord> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysLoginRecord t1= list.get(0);
            SysLoginRecordDto    dto=new    SysLoginRecordDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SysLoginRecordDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<SysLoginRecordDto> getSysLoginRecordList(SysLoginRecordDto sysLoginRecordDto){
        return null;
    }

    /**
    * 添加一个新的SysLoginRecord到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addSysLoginRecord(SysLoginRecordDto sysLoginRecordDto){
         // TODO Auto-generated method stub
        if(sysLoginRecordDto!=null){
           SysLoginRecord sysLoginRecord= new SysLoginRecord();
           sysLoginRecord=beanToDto.D1ToT1(sysLoginRecord, sysLoginRecordDto);
           return this.save(sysLoginRecord);
        }
        return 0;
    }

    /**
    * 更新SysLoginRecord
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateSysLoginRecord(SysLoginRecordDto sysLoginRecordDto){
        // TODO Auto-generated method stub
        if(sysLoginRecordDto!=null&&sysLoginRecordDto.getRecordId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sysLoginRecordDto.createSetPropertiesVal(sysLoginRecordDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SysLoginRecord.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.recordId=:uid");
           params.put("uid",sysLoginRecordDto.getRecordId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SysLoginRecord
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteSysLoginRecord(SysLoginRecordDto sysLoginRecordDto){
         // TODO Auto-generated method stub
        if(sysLoginRecordDto!=null&&sysLoginRecordDto.getRecordId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SysLoginRecord.class.getName()+" a");
           stringBuffer.append(" where a.recordId=:uid ");
           params.put("uid",sysLoginRecordDto.getRecordId());
           SysLoginRecord sysLoginRecord= new SysLoginRecord();
           BeanUtils.copyProperties(sysLoginRecordDto, sysLoginRecord);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}