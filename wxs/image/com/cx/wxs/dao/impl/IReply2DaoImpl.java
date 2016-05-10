package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.IReply2Dao;
import com.cx.wxs.dto.IReply2Dto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.IReply2;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("IReply2Dao")
public class IReply2DaoImpl extends BaseDaoImpl<IReply2, Integer> implements IReply2Dao{

    private BeanToDto<IReply2, IReply2Dto> beanToDto=new BeanToDto<IReply2, IReply2Dto>();

    public BeanToDto<IReply2, IReply2Dto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<IReply2, IReply2Dto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取IReply2Dto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public IReply2Dto getIReply2ByID(IReply2Dto iReply2Dto){
        // TODO Auto-generated method stub
        if(iReply2Dto!=null&&iReply2Dto.getIreply1Id()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+IReply2.class.getName()+"  a where a.ireply1Id=:id");
           params.put("id",iReply2Dto.getIreply1Id());
           List<IReply2> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            IReply2 t1= list.get(0);
            IReply2Dto    dto=new    IReply2Dto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取IReply2DtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<IReply2Dto> getIReply2List(IReply2Dto iReply2Dto){
        return null;
    }

    /**
    * 添加一个新的IReply2到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addIReply2(IReply2Dto iReply2Dto){
         // TODO Auto-generated method stub
        if(iReply2Dto!=null){
           IReply2 iReply2= new IReply2();
           iReply2=beanToDto.D1ToT1(iReply2, iReply2Dto);
           return this.save(iReply2);
        }
        return 0;
    }

    /**
    * 更新IReply2
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateIReply2(IReply2Dto iReply2Dto){
        // TODO Auto-generated method stub
        if(iReply2Dto!=null&&iReply2Dto.getIreply1Id()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = iReply2Dto.createSetPropertiesVal(iReply2Dto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+IReply2.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.ireply1Id=:uid");
           params.put("uid",iReply2Dto.getIreply1Id());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除IReply2
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteIReply2(IReply2Dto iReply2Dto){
         // TODO Auto-generated method stub
        if(iReply2Dto!=null&&iReply2Dto.getIreply1Id()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+IReply2.class.getName()+" a");
           stringBuffer.append(" where a.ireply1Id=:uid ");
           params.put("uid",iReply2Dto.getIreply1Id());
           IReply2 iReply2= new IReply2();
           BeanUtils.copyProperties(iReply2Dto, iReply2);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}