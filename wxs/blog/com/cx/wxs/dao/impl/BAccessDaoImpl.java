package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.BAccessDao;
import com.cx.wxs.dto.BAccessDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.BAccess;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */
@Repository("BAccessDao")
public class BAccessDaoImpl extends BaseDaoImpl<BAccess, Integer> implements BAccessDao{

    private BeanToDto<BAccess, BAccessDto> beanToDto;

    /**
    * 通过id获取BAccessDto
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public BAccessDto getBAccessByID(BAccessDto bAccessDto){
        // TODO Auto-generated method stub
        if(bAccessDto!=null&&bAccessDto.getBaccessId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+BAccess.class.getName()+"  a where a.baccessId=:id");
           params.put("id",bAccessDto.getBaccessId());
           List<BAccess> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            BAccess t1= list.get(0);
            BAccessDto    dto=new    BAccessDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取BAccessDtoList
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<BAccessDto> getBAccessList(BAccessDto bAccessDto){
        return null;
    }

    /**
    * 添加一个新的BAccess到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addBAccess(BAccessDto bAccessDto){
         // TODO Auto-generated method stub
        if(bAccessDto!=null){
           BAccess bAccess= new BAccess();
           bAccess=beanToDto.D1ToT1(bAccess, bAccessDto);
           return this.save(bAccess);
        }
        return 0;
    }

    /**
    * 更新BAccess
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateBAccess(BAccessDto bAccessDto){
        // TODO Auto-generated method stub
        if(bAccessDto!=null&&bAccessDto.getBaccessId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = bAccessDto.createSetPropertiesVal(bAccessDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+BAccess.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.baccessId=:uid");
           params.put("uid",bAccessDto.getBaccessId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除BAccess
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteBAccess(BAccessDto bAccessDto){
         // TODO Auto-generated method stub
        if(bAccessDto!=null&&bAccessDto.getBaccessId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+BAccess.class.getName()+" a");
           stringBuffer.append(" where a.baccessId=:uid ");
           params.put("uid",bAccessDto.getBaccessId());
           BAccess bAccess= new BAccess();
           BeanUtils.copyProperties(bAccessDto, bAccess);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}