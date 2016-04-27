package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SReply1Dao;
import com.cx.wxs.dto.SReply1Dto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SReply1;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("SReply1Dao")
public class SReply1DaoImpl extends BaseDaoImpl<SReply1, Integer> implements SReply1Dao{

    private BeanToDto<SReply1, SReply1Dto> beanToDto=new BeanToDto<SReply1, SReply1Dto>();

    public BeanToDto<SReply1, SReply1Dto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<SReply1, SReply1Dto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取SReply1Dto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public SReply1Dto getSReply1ByID(SReply1Dto sReply1Dto){
        // TODO Auto-generated method stub
        if(sReply1Dto!=null&&sReply1Dto.getSreplyId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SReply1.class.getName()+"  a where a.sreplyId=:id");
           params.put("id",sReply1Dto.getSreplyId());
           List<SReply1> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SReply1 t1= list.get(0);
            SReply1Dto    dto=new    SReply1Dto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SReply1DtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<SReply1Dto> getSReply1List(SReply1Dto sReply1Dto){
        return null;
    }

    /**
    * 添加一个新的SReply1到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addSReply1(SReply1Dto sReply1Dto){
         // TODO Auto-generated method stub
        if(sReply1Dto!=null){
           SReply1 sReply1= new SReply1();
           sReply1=beanToDto.D1ToT1(sReply1, sReply1Dto);
           return this.save(sReply1);
        }
        return 0;
    }

    /**
    * 更新SReply1
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateSReply1(SReply1Dto sReply1Dto){
        // TODO Auto-generated method stub
        if(sReply1Dto!=null&&sReply1Dto.getSreplyId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sReply1Dto.createSetPropertiesVal(sReply1Dto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SReply1.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.sreplyId=:uid");
           params.put("uid",sReply1Dto.getSreplyId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SReply1
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteSReply1(SReply1Dto sReply1Dto){
         // TODO Auto-generated method stub
        if(sReply1Dto!=null&&sReply1Dto.getSreplyId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SReply1.class.getName()+" a");
           stringBuffer.append(" where a.sreplyId=:uid ");
           params.put("uid",sReply1Dto.getSreplyId());
           SReply1 sReply1= new SReply1();
           BeanUtils.copyProperties(sReply1Dto, sReply1);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}