package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SysCollegeDao;
import com.cx.wxs.dto.SysCollegeDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SysCollege;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("SysCollegeDao")
public class SysCollegeDaoImpl extends BaseDaoImpl<SysCollege, Integer> implements SysCollegeDao{

    private BeanToDto<SysCollege, SysCollegeDto> beanToDto;

    /**
    * 通过id获取SysCollegeDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public SysCollegeDto getSysCollegeByID(SysCollegeDto sysCollegeDto){
        // TODO Auto-generated method stub
        if(sysCollegeDto!=null&&sysCollegeDto.getCollegeId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysCollege.class.getName()+"  a where a.collegeId=:id");
           params.put("id",sysCollegeDto.getCollegeId());
           List<SysCollege> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysCollege t1= list.get(0);
            SysCollegeDto    dto=new    SysCollegeDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SysCollegeDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<SysCollegeDto> getSysCollegeList(SysCollegeDto sysCollegeDto){
        return null;
    }

    /**
    * 添加一个新的SysCollege到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addSysCollege(SysCollegeDto sysCollegeDto){
         // TODO Auto-generated method stub
        if(sysCollegeDto!=null){
           SysCollege sysCollege= new SysCollege();
           sysCollege=beanToDto.D1ToT1(sysCollege, sysCollegeDto);
           return this.save(sysCollege);
        }
        return 0;
    }

    /**
    * 更新SysCollege
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateSysCollege(SysCollegeDto sysCollegeDto){
        // TODO Auto-generated method stub
        if(sysCollegeDto!=null&&sysCollegeDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sysCollegeDto.createSetPropertiesVal(sysCollegeDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SysCollege.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.collegeId=:uid");
           params.put("uid",sysCollegeDto.getCollegeId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SysCollege
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteSysCollege(SysCollegeDto sysCollegeDto){
         // TODO Auto-generated method stub
        if(sysCollegeDto!=null&&sysCollegeDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SysCollege.class.getName()+" a");
           stringBuffer.append(" where a.collegeId=:uid ");
           params.put("uid",sysCollegeDto.getCollegeId());
           SysCollege sysCollege= new SysCollege();
           BeanUtils.copyProperties(sysCollegeDto, sysCollege);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}