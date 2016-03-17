package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SysCityDao;
import com.cx.wxs.dto.SysCityDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SysCity;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */
@Repository("SysCityDao")
public class SysCityDaoImpl extends BaseDaoImpl<SysCity, Integer> implements SysCityDao{

    private BeanToDto<SysCity, SysCityDto> beanToDto;

    /**
    * 通过id获取SysCityDto
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SysCityDto getSysCityByID(SysCityDto sysCityDto){
        // TODO Auto-generated method stub
        if(sysCityDto!=null&&sysCityDto.getCityId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysCity.class.getName()+"  a where a.cityId=:id");
           params.put("id",sysCityDto.getCityId());
           List<SysCity> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysCity t1= list.get(0);
            SysCityDto    dto=new    SysCityDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SysCityDtoList
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SysCityDto> getSysCityList(SysCityDto sysCityDto){
        return null;
    }

    /**
    * 添加一个新的SysCity到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSysCity(SysCityDto sysCityDto){
         // TODO Auto-generated method stub
        if(sysCityDto!=null){
           SysCity sysCity= new SysCity();
           sysCity=beanToDto.D1ToT1(sysCity, sysCityDto);
           return this.save(sysCity);
        }
        return 0;
    }

    /**
    * 更新SysCity
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSysCity(SysCityDto sysCityDto){
        // TODO Auto-generated method stub
        if(sysCityDto!=null&&sysCityDto.getCityId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sysCityDto.createSetPropertiesVal(sysCityDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SysCity.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.cityId=:uid");
           params.put("uid",sysCityDto.getCityId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SysCity
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSysCity(SysCityDto sysCityDto){
         // TODO Auto-generated method stub
        if(sysCityDto!=null&&sysCityDto.getCityId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SysCity.class.getName()+" a");
           stringBuffer.append(" where a.cityId=:uid ");
           params.put("uid",sysCityDto.getCityId());
           SysCity sysCity= new SysCity();
           BeanUtils.copyProperties(sysCityDto, sysCity);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}