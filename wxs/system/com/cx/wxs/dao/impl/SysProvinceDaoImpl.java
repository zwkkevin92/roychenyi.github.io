package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SysProvinceDao;
import com.cx.wxs.dto.SysProvinceDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SysProvince;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("SysProvinceDao")
public class SysProvinceDaoImpl extends BaseDaoImpl<SysProvince, Integer> implements SysProvinceDao{

    private BeanToDto<SysProvince, SysProvinceDto> beanToDto;

    /**
    * 通过id获取SysProvinceDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public SysProvinceDto getSysProvinceByID(SysProvinceDto sysProvinceDto){
        // TODO Auto-generated method stub
        if(sysProvinceDto!=null&&sysProvinceDto.getProvinceId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysProvince.class.getName()+"  a where a.provinceId=:id");
           params.put("id",sysProvinceDto.getProvinceId());
           List<SysProvince> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysProvince t1= list.get(0);
            SysProvinceDto    dto=new    SysProvinceDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SysProvinceDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<SysProvinceDto> getSysProvinceList(SysProvinceDto sysProvinceDto){
        return null;
    }

    /**
    * 添加一个新的SysProvince到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addSysProvince(SysProvinceDto sysProvinceDto){
         // TODO Auto-generated method stub
        if(sysProvinceDto!=null){
           SysProvince sysProvince= new SysProvince();
           sysProvince=beanToDto.D1ToT1(sysProvince, sysProvinceDto);
           return this.save(sysProvince);
        }
        return 0;
    }

    /**
    * 更新SysProvince
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateSysProvince(SysProvinceDto sysProvinceDto){
        // TODO Auto-generated method stub
        if(sysProvinceDto!=null&&sysProvinceDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sysProvinceDto.createSetPropertiesVal(sysProvinceDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SysProvince.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.provinceId=:uid");
           params.put("uid",sysProvinceDto.getProvinceId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SysProvince
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteSysProvince(SysProvinceDto sysProvinceDto){
         // TODO Auto-generated method stub
        if(sysProvinceDto!=null&&sysProvinceDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SysProvince.class.getName()+" a");
           stringBuffer.append(" where a.provinceId=:uid ");
           params.put("uid",sysProvinceDto.getProvinceId());
           SysProvince sysProvince= new SysProvince();
           BeanUtils.copyProperties(sysProvinceDto, sysProvince);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}