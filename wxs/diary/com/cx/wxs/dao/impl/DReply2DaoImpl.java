package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.DReply2Dao;
import com.cx.wxs.dto.DReply1Dto;
import com.cx.wxs.dto.DReply2Dto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.DReply1;
import com.cx.wxs.po.DReply2;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-26 21:51:42
 */
@Repository("DReply2Dao")
public class DReply2DaoImpl extends BaseDaoImpl<DReply2, Integer> implements DReply2Dao{

    private BeanToDto<DReply2, DReply2Dto> beanToDto=new BeanToDto<DReply2, DReply2Dto>();

    public BeanToDto<DReply2, DReply2Dto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<DReply2, DReply2Dto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取DReply2Dto
    * @author 陈义
    * @date 2016-04-26 21:51:43
    */
    @Override
    public DReply2Dto getDReply2ByID(DReply2Dto dReply2Dto){
        // TODO Auto-generated method stub
        if(dReply2Dto!=null&&dReply2Dto.getDreply1Id()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+DReply2.class.getName()+"  a where a.dreply1Id=:id");
           params.put("id",dReply2Dto.getDreply1Id());
           List<DReply2> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            DReply2 t1= list.get(0);
            DReply2Dto    dto=new    DReply2Dto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取DReply2DtoList
    * @author 陈义
    * @date 2016-04-26 21:51:43
    */
    @Override
    public List<DReply2Dto> getDReply2List(DReply2Dto dReply2Dto){
        return null;
    }

    /**
    * 添加一个新的DReply2到数据库
    * @author 陈义
    * @date 2016-04-26 21:51:43
    */
    @Override
    public Integer addDReply2(DReply2Dto dReply2Dto){
         // TODO Auto-generated method stub
        if(dReply2Dto!=null){
           DReply1 dReply1=new DReply1();
           BeanToDto<DReply1, DReply1Dto> beanToDto1=new BeanToDto<DReply1, DReply1Dto>();
           dReply1=beanToDto1.D1ToT1(dReply1, dReply2Dto.getDReply1Dto());
           DReply2 dReply2= new DReply2(); 
           dReply2=beanToDto.D1ToT1(dReply2, dReply2Dto);
           dReply2.setDReply1(dReply1);
           return this.save(dReply2);
        }
        return 0;
    }

    /**
    * 更新DReply2
    * @author 陈义
    * @date 2016-04-26 21:51:43
    */
    @Override
    public Integer updateDReply2(DReply2Dto dReply2Dto){
        // TODO Auto-generated method stub
        if(dReply2Dto!=null&&dReply2Dto.getDreply1Id()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = dReply2Dto.createSetPropertiesVal(dReply2Dto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" from "+DReply2.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.dreply1Id=:uid");
           params.put("uid",dReply2Dto.getDreply1Id());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除DReply2
    * @author 陈义
    * @date 2016-04-26 21:51:43
    */
    @Override
    public Integer deleteDReply2(DReply2Dto dReply2Dto){
         // TODO Auto-generated method stub
        if(dReply2Dto!=null&&dReply2Dto.getDreply1Id()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append("  "+DReply2.class.getName()+" a");
           stringBuffer.append(" where a.dreply1Id=:uid ");
           params.put("uid",dReply2Dto.getDreply1Id());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}