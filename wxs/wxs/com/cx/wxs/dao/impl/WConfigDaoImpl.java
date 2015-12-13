package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.WConfigDao;
import com.cx.wxs.dto.WConfigDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.WConfig;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("WConfigDao")
public class WConfigDaoImpl extends BaseDaoImpl<WConfig, Integer> implements WConfigDao{

    private BeanToDto<WConfig, WConfigDto> beanToDto;

    /**
    * 通过id获取WConfigDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public WConfigDto getWConfigByID(WConfigDto wConfigDto){
        // TODO Auto-generated method stub
        if(wConfigDto!=null&&wConfigDto.getWconfigId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+WConfig.class.getName()+"  a where a.wconfigId=:id");
           params.put("id",wConfigDto.getWconfigId());
           List<WConfig> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            WConfig t1= list.get(0);
            WConfigDto    dto=new    WConfigDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取WConfigDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<WConfigDto> getWConfigList(WConfigDto wConfigDto){
        return null;
    }

    /**
    * 添加一个新的WConfig到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addWConfig(WConfigDto wConfigDto){
         // TODO Auto-generated method stub
        if(wConfigDto!=null){
           WConfig wConfig= new WConfig();
           wConfig=beanToDto.D1ToT1(wConfig, wConfigDto);
           return this.save(wConfig);
        }
        return 0;
    }

    /**
    * 更新WConfig
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateWConfig(WConfigDto wConfigDto){
        // TODO Auto-generated method stub
        if(wConfigDto!=null&&wConfigDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = wConfigDto.createSetPropertiesVal(wConfigDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+WConfig.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.wconfigId=:uid");
           params.put("uid",wConfigDto.getWconfigId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除WConfig
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteWConfig(WConfigDto wConfigDto){
         // TODO Auto-generated method stub
        if(wConfigDto!=null&&wConfigDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+WConfig.class.getName()+" a");
           stringBuffer.append(" where a.wconfigId=:uid ");
           params.put("uid",wConfigDto.getWconfigId());
           WConfig wConfig= new WConfig();
           BeanUtils.copyProperties(wConfigDto, wConfig);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}