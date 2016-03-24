package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.BSiteDao;
import com.cx.wxs.dto.BSiteDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.BSite;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */
@Repository("BSiteDao")
public class BSiteDaoImpl extends BaseDaoImpl<BSite, Integer> implements BSiteDao{

    private BeanToDto<BSite, BSiteDto> beanToDto=new BeanToDto<BSite,BSiteDto>();

    /**
    * 通过id获取BSiteDto
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public BSiteDto getBSiteByID(BSiteDto bSiteDto){
        // TODO Auto-generated method stub
        if(bSiteDto!=null&&bSiteDto.getSiteId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+BSite.class.getName()+"  a where a.siteId=:id");
           params.put("id",bSiteDto.getSiteId());
           List<BSite> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            BSite t1= list.get(0);
            BSiteDto    dto=new    BSiteDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取BSiteDtoList
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<BSiteDto> getBSiteList(BSiteDto bSiteDto){
        return null;
    }

    /**
    * 添加一个新的BSite到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addBSite(BSiteDto bSiteDto){
         // TODO Auto-generated method stub
        if(bSiteDto!=null){
           BSite bSite= new BSite();
           bSite=beanToDto.D1ToT1(bSite, bSiteDto);
           return this.save(bSite);
        }
        return 0;
    }

    /**
    * 更新BSite
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateBSite(BSiteDto bSiteDto){
        // TODO Auto-generated method stub
        if(bSiteDto!=null&&bSiteDto.getSiteId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = bSiteDto.createSetPropertiesVal(bSiteDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+BSite.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.siteId=:uid");
           params.put("uid",bSiteDto.getSiteId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除BSite
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteBSite(BSiteDto bSiteDto){
         // TODO Auto-generated method stub
        if(bSiteDto!=null&&bSiteDto.getSiteId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+BSite.class.getName()+" a");
           stringBuffer.append(" where a.siteId=:uid ");
           params.put("uid",bSiteDto.getSiteId());
           BSite bSite= new BSite();
           BeanUtils.copyProperties(bSiteDto, bSite);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}