package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.WAccessDao;
import com.cx.wxs.dto.WAccessDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.WAccess;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("WAccessDao")
public class WAccessDaoImpl extends BaseDaoImpl<WAccess, Integer> implements WAccessDao{

    private BeanToDto<WAccess, WAccessDto> beanToDto;

    /**
    * 通过id获取WAccessDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public WAccessDto getWAccessByID(WAccessDto wAccessDto){
        // TODO Auto-generated method stub
        if(wAccessDto!=null&&wAccessDto.getWaccessId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+WAccess.class.getName()+"  a where a.waccessId=:id");
           params.put("id",wAccessDto.getWaccessId());
           List<WAccess> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            WAccess t1= list.get(0);
            WAccessDto    dto=new    WAccessDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取WAccessDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<WAccessDto> getWAccessList(WAccessDto wAccessDto){
        return null;
    }

    /**
    * 添加一个新的WAccess到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addWAccess(WAccessDto wAccessDto){
         // TODO Auto-generated method stub
        if(wAccessDto!=null){
           WAccess wAccess= new WAccess();
           wAccess=beanToDto.D1ToT1(wAccess, wAccessDto);
           return this.save(wAccess);
        }
        return 0;
    }

    /**
    * 更新WAccess
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateWAccess(WAccessDto wAccessDto){
        // TODO Auto-generated method stub
        if(wAccessDto!=null&&wAccessDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = wAccessDto.createSetPropertiesVal(wAccessDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+WAccess.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.waccessId=:uid");
           params.put("uid",wAccessDto.getWaccessId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除WAccess
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteWAccess(WAccessDto wAccessDto){
         // TODO Auto-generated method stub
        if(wAccessDto!=null&&wAccessDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+WAccess.class.getName()+" a");
           stringBuffer.append(" where a.waccessId=:uid ");
           params.put("uid",wAccessDto.getWaccessId());
           WAccess wAccess= new WAccess();
           BeanUtils.copyProperties(wAccessDto, wAccess);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}