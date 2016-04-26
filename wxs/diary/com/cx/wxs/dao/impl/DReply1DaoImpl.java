package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.DReply1Dao;
import com.cx.wxs.dto.DReply1Dto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.DReply1;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-26 21:51:42
 */
@Repository("DReply1Dao")
public class DReply1DaoImpl extends BaseDaoImpl<DReply1, Integer> implements DReply1Dao{

    private BeanToDto<DReply1, DReply1Dto> beanToDto=new BeanToDto<DReply1, DReply1Dto>();

    public BeanToDto<DReply1, DReply1Dto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<DReply1, DReply1Dto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取DReply1Dto
    * @author 陈义
    * @date 2016-04-26 21:51:43
    */
    @Override
    public DReply1Dto getDReply1ByID(DReply1Dto dReply1Dto){
        // TODO Auto-generated method stub
        if(dReply1Dto!=null&&dReply1Dto.getDreplyId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+DReply1.class.getName()+"  a where a.dreplyId=:id");
           params.put("id",dReply1Dto.getDreplyId());
           List<DReply1> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            DReply1 t1= list.get(0);
            DReply1Dto    dto=new    DReply1Dto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取DReply1DtoList
    * @author 陈义
    * @date 2016-04-26 21:51:43
    */
    @Override
    public List<DReply1Dto> getDReply1List(DReply1Dto dReply1Dto){
        return null;
    }

    /**
    * 添加一个新的DReply1到数据库
    * @author 陈义
    * @date 2016-04-26 21:51:43
    */
    @Override
    public Integer addDReply1(DReply1Dto dReply1Dto){
         // TODO Auto-generated method stub
        if(dReply1Dto!=null){
           DReply1 dReply1= new DReply1();
           dReply1=beanToDto.D1ToT1(dReply1, dReply1Dto);
           return this.save(dReply1);
        }
        return 0;
    }

    /**
    * 更新DReply1
    * @author 陈义
    * @date 2016-04-26 21:51:43
    */
    @Override
    public Integer updateDReply1(DReply1Dto dReply1Dto){
        // TODO Auto-generated method stub
        if(dReply1Dto!=null&&dReply1Dto.getDreplyId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = dReply1Dto.createSetPropertiesVal(dReply1Dto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" from "+DReply1.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.dreplyId=:uid");
           params.put("uid",dReply1Dto.getDreplyId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除DReply1
    * @author 陈义
    * @date 2016-04-26 21:51:43
    */
    @Override
    public Integer deleteDReply1(DReply1Dto dReply1Dto){
         // TODO Auto-generated method stub
        if(dReply1Dto!=null&&dReply1Dto.getDreplyId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append("  "+DReply1.class.getName()+" a");
           stringBuffer.append(" where a.dreplyId=:uid ");
           params.put("uid",dReply1Dto.getDreplyId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}