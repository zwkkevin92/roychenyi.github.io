package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.BBacklistDao;
import com.cx.wxs.dto.BBacklistDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.BBacklist;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("BBacklistDao")
public class BBacklistDaoImpl extends BaseDaoImpl<BBacklist, Integer> implements BBacklistDao{

    private BeanToDto<BBacklist, BBacklistDto> beanToDto=new BeanToDto<BBacklist, BBacklistDto>();

    public BeanToDto<BBacklist, BBacklistDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<BBacklist, BBacklistDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取BBacklistDto
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public BBacklistDto getBBacklistByID(BBacklistDto bBacklistDto){
        // TODO Auto-generated method stub
        if(bBacklistDto!=null&&bBacklistDto.getBlacklistId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+BBacklist.class.getName()+"  a where a.blacklistId=:id");
           params.put("id",bBacklistDto.getBlacklistId());
           List<BBacklist> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            BBacklist t1= list.get(0);
            BBacklistDto    dto=new    BBacklistDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取BBacklistDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public List<BBacklistDto> getBBacklistList(BBacklistDto bBacklistDto){
        return null;
    }

    /**
    * 添加一个新的BBacklist到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public Integer addBBacklist(BBacklistDto bBacklistDto){
         // TODO Auto-generated method stub
        if(bBacklistDto!=null){
           BBacklist bBacklist= new BBacklist();
           bBacklist=beanToDto.D1ToT1(bBacklist, bBacklistDto);
           return this.save(bBacklist);
        }
        return 0;
    }

    /**
    * 更新BBacklist
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public Integer updateBBacklist(BBacklistDto bBacklistDto){
        // TODO Auto-generated method stub
        if(bBacklistDto!=null&&bBacklistDto.getBlacklistId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = bBacklistDto.createSetPropertiesVal(bBacklistDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+BBacklist.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.blacklistId=:uid");
           params.put("uid",bBacklistDto.getBlacklistId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除BBacklist
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public Integer deleteBBacklist(BBacklistDto bBacklistDto){
         // TODO Auto-generated method stub
        if(bBacklistDto!=null&&bBacklistDto.getBlacklistId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+BBacklist.class.getName()+" a");
           stringBuffer.append(" where a.blacklistId=:uid ");
           params.put("uid",bBacklistDto.getBlacklistId());
           BBacklist bBacklist= new BBacklist();
           BeanUtils.copyProperties(bBacklistDto, bBacklist);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}