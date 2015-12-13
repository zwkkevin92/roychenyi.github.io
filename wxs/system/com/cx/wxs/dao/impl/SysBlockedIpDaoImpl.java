package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SysBlockedIpDao;
import com.cx.wxs.dto.SysBlockedIpDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SysBlockedIp;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("SysBlockedIpDao")
public class SysBlockedIpDaoImpl extends BaseDaoImpl<SysBlockedIp, Integer> implements SysBlockedIpDao{

    private BeanToDto<SysBlockedIp, SysBlockedIpDto> beanToDto;

    /**
    * 通过id获取SysBlockedIpDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public SysBlockedIpDto getSysBlockedIpByID(SysBlockedIpDto sysBlockedIpDto){
        // TODO Auto-generated method stub
        if(sysBlockedIpDto!=null&&sysBlockedIpDto.getBlockedipId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysBlockedIp.class.getName()+"  a where a.blockedipId=:id");
           params.put("id",sysBlockedIpDto.getBlockedipId());
           List<SysBlockedIp> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysBlockedIp t1= list.get(0);
            SysBlockedIpDto    dto=new    SysBlockedIpDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SysBlockedIpDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<SysBlockedIpDto> getSysBlockedIpList(SysBlockedIpDto sysBlockedIpDto){
        return null;
    }

    /**
    * 添加一个新的SysBlockedIp到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addSysBlockedIp(SysBlockedIpDto sysBlockedIpDto){
         // TODO Auto-generated method stub
        if(sysBlockedIpDto!=null){
           SysBlockedIp sysBlockedIp= new SysBlockedIp();
           sysBlockedIp=beanToDto.D1ToT1(sysBlockedIp, sysBlockedIpDto);
           return this.save(sysBlockedIp);
        }
        return 0;
    }

    /**
    * 更新SysBlockedIp
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateSysBlockedIp(SysBlockedIpDto sysBlockedIpDto){
        // TODO Auto-generated method stub
        if(sysBlockedIpDto!=null&&sysBlockedIpDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sysBlockedIpDto.createSetPropertiesVal(sysBlockedIpDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SysBlockedIp.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.blockedipId=:uid");
           params.put("uid",sysBlockedIpDto.getBlockedipId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SysBlockedIp
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteSysBlockedIp(SysBlockedIpDto sysBlockedIpDto){
         // TODO Auto-generated method stub
        if(sysBlockedIpDto!=null&&sysBlockedIpDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SysBlockedIp.class.getName()+" a");
           stringBuffer.append(" where a.blockedipId=:uid ");
           params.put("uid",sysBlockedIpDto.getBlockedipId());
           SysBlockedIp sysBlockedIp= new SysBlockedIp();
           BeanUtils.copyProperties(sysBlockedIpDto, sysBlockedIp);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}