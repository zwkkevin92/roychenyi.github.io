package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.IReply1Dao;
import com.cx.wxs.dto.IReply1Dto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.IReply1;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */
@Repository("IReply1Dao")
public class IReply1DaoImpl extends BaseDaoImpl<IReply1, Integer> implements IReply1Dao{

    private BeanToDto<IReply1, IReply1Dto> beanToDto;

    /**
    * 通过id获取IReply1Dto
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public IReply1Dto getIReply1ByID(IReply1Dto iReply1Dto){
        // TODO Auto-generated method stub
        if(iReply1Dto!=null&&iReply1Dto.getIreplyId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+IReply1.class.getName()+"  a where a.ireplyId=:id");
           params.put("id",iReply1Dto.getIreplyId());
           List<IReply1> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            IReply1 t1= list.get(0);
            IReply1Dto    dto=new    IReply1Dto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取IReply1DtoList
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<IReply1Dto> getIReply1List(IReply1Dto iReply1Dto){
        return null;
    }

    /**
    * 添加一个新的IReply1到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addIReply1(IReply1Dto iReply1Dto){
         // TODO Auto-generated method stub
        if(iReply1Dto!=null){
           IReply1 iReply1= new IReply1();
           iReply1=beanToDto.D1ToT1(iReply1, iReply1Dto);
           return this.save(iReply1);
        }
        return 0;
    }

    /**
    * 更新IReply1
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateIReply1(IReply1Dto iReply1Dto){
        // TODO Auto-generated method stub
        if(iReply1Dto!=null&&iReply1Dto.getIreplyId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = iReply1Dto.createSetPropertiesVal(iReply1Dto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+IReply1.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.ireplyId=:uid");
           params.put("uid",iReply1Dto.getIreplyId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除IReply1
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteIReply1(IReply1Dto iReply1Dto){
         // TODO Auto-generated method stub
        if(iReply1Dto!=null&&iReply1Dto.getIreplyId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+IReply1.class.getName()+" a");
           stringBuffer.append(" where a.ireplyId=:uid ");
           params.put("uid",iReply1Dto.getIreplyId());
           IReply1 iReply1= new IReply1();
           BeanUtils.copyProperties(iReply1Dto, iReply1);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}