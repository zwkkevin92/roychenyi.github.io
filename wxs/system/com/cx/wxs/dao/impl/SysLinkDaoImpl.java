package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SysLinkDao;
import com.cx.wxs.dto.SysLinkDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SysLink;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("SysLinkDao")
public class SysLinkDaoImpl extends BaseDaoImpl<SysLink, Integer> implements SysLinkDao{

    private BeanToDto<SysLink, SysLinkDto> beanToDto;

    /**
    * 通过id获取SysLinkDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public SysLinkDto getSysLinkByID(SysLinkDto sysLinkDto){
        // TODO Auto-generated method stub
        if(sysLinkDto!=null&&sysLinkDto.getLinkId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysLink.class.getName()+"  a where a.linkId=:id");
           params.put("id",sysLinkDto.getLinkId());
           List<SysLink> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysLink t1= list.get(0);
            SysLinkDto    dto=new    SysLinkDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SysLinkDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<SysLinkDto> getSysLinkList(SysLinkDto sysLinkDto){
        return null;
    }

    /**
    * 添加一个新的SysLink到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addSysLink(SysLinkDto sysLinkDto){
         // TODO Auto-generated method stub
        if(sysLinkDto!=null){
           SysLink sysLink= new SysLink();
           sysLink=beanToDto.D1ToT1(sysLink, sysLinkDto);
           return this.save(sysLink);
        }
        return 0;
    }

    /**
    * 更新SysLink
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateSysLink(SysLinkDto sysLinkDto){
        // TODO Auto-generated method stub
        if(sysLinkDto!=null&&sysLinkDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sysLinkDto.createSetPropertiesVal(sysLinkDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SysLink.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.linkId=:uid");
           params.put("uid",sysLinkDto.getLinkId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SysLink
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteSysLink(SysLinkDto sysLinkDto){
         // TODO Auto-generated method stub
        if(sysLinkDto!=null&&sysLinkDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SysLink.class.getName()+" a");
           stringBuffer.append(" where a.linkId=:uid ");
           params.put("uid",sysLinkDto.getLinkId());
           SysLink sysLink= new SysLink();
           BeanUtils.copyProperties(sysLinkDto, sysLink);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}