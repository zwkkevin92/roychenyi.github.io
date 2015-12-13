package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.BConfigDao;
import com.cx.wxs.dto.BConfigDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.BConfig;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("BConfigDao")
public class BConfigDaoImpl extends BaseDaoImpl<BConfig, Integer> implements BConfigDao{

    private BeanToDto<BConfig, BConfigDto> beanToDto;

    /**
    * 通过id获取BConfigDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public BConfigDto getBConfigByID(BConfigDto bConfigDto){
        // TODO Auto-generated method stub
        if(bConfigDto!=null&&bConfigDto.getBconfigId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+BConfig.class.getName()+"  a where a.bconfigId=:id");
           params.put("id",bConfigDto.getBconfigId());
           List<BConfig> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            BConfig t1= list.get(0);
            BConfigDto    dto=new    BConfigDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取BConfigDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<BConfigDto> getBConfigList(BConfigDto bConfigDto){
        return null;
    }

    /**
    * 添加一个新的BConfig到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addBConfig(BConfigDto bConfigDto){
         // TODO Auto-generated method stub
        if(bConfigDto!=null){
           BConfig bConfig= new BConfig();
           bConfig=beanToDto.D1ToT1(bConfig, bConfigDto);
           return this.save(bConfig);
        }
        return 0;
    }

    /**
    * 更新BConfig
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateBConfig(BConfigDto bConfigDto){
        // TODO Auto-generated method stub
        if(bConfigDto!=null&&bConfigDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = bConfigDto.createSetPropertiesVal(bConfigDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+BConfig.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.bconfigId=:uid");
           params.put("uid",bConfigDto.getBconfigId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除BConfig
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteBConfig(BConfigDto bConfigDto){
         // TODO Auto-generated method stub
        if(bConfigDto!=null&&bConfigDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+BConfig.class.getName()+" a");
           stringBuffer.append(" where a.bconfigId=:uid ");
           params.put("uid",bConfigDto.getBconfigId());
           BConfig bConfig= new BConfig();
           BeanUtils.copyProperties(bConfigDto, bConfig);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}