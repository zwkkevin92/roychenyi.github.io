package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SysSchoolDao;
import com.cx.wxs.dto.SysSchoolDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SysSchool;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("SysSchoolDao")
public class SysSchoolDaoImpl extends BaseDaoImpl<SysSchool, Integer> implements SysSchoolDao{

    private BeanToDto<SysSchool, SysSchoolDto> beanToDto;

    /**
    * 通过id获取SysSchoolDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public SysSchoolDto getSysSchoolByID(SysSchoolDto sysSchoolDto){
        // TODO Auto-generated method stub
        if(sysSchoolDto!=null&&sysSchoolDto.getSchoolId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysSchool.class.getName()+"  a where a.schoolId=:id");
           params.put("id",sysSchoolDto.getSchoolId());
           List<SysSchool> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysSchool t1= list.get(0);
            SysSchoolDto    dto=new    SysSchoolDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SysSchoolDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<SysSchoolDto> getSysSchoolList(SysSchoolDto sysSchoolDto){
        return null;
    }

    /**
    * 添加一个新的SysSchool到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addSysSchool(SysSchoolDto sysSchoolDto){
         // TODO Auto-generated method stub
        if(sysSchoolDto!=null){
           SysSchool sysSchool= new SysSchool();
           sysSchool=beanToDto.D1ToT1(sysSchool, sysSchoolDto);
           return this.save(sysSchool);
        }
        return 0;
    }

    /**
    * 更新SysSchool
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateSysSchool(SysSchoolDto sysSchoolDto){
        // TODO Auto-generated method stub
        if(sysSchoolDto!=null&&sysSchoolDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sysSchoolDto.createSetPropertiesVal(sysSchoolDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SysSchool.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.schoolId=:uid");
           params.put("uid",sysSchoolDto.getSchoolId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SysSchool
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteSysSchool(SysSchoolDto sysSchoolDto){
         // TODO Auto-generated method stub
        if(sysSchoolDto!=null&&sysSchoolDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SysSchool.class.getName()+" a");
           stringBuffer.append(" where a.schoolId=:uid ");
           params.put("uid",sysSchoolDto.getSchoolId());
           SysSchool sysSchool= new SysSchool();
           BeanUtils.copyProperties(sysSchoolDto, sysSchool);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}