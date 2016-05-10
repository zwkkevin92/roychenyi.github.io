package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SReply2Dao;
import com.cx.wxs.dto.SReply2Dto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SReply2;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("SReply2Dao")
public class SReply2DaoImpl extends BaseDaoImpl<SReply2, Integer> implements SReply2Dao{

    private BeanToDto<SReply2, SReply2Dto> beanToDto=new BeanToDto<SReply2, SReply2Dto>();

    public BeanToDto<SReply2, SReply2Dto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<SReply2, SReply2Dto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取SReply2Dto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public SReply2Dto getSReply2ByID(SReply2Dto sReply2Dto){
        // TODO Auto-generated method stub
        if(sReply2Dto!=null&&sReply2Dto.getSreply1Id()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SReply2.class.getName()+"  a where a.sreply1Id=:id");
           params.put("id",sReply2Dto.getSreply1Id());
           List<SReply2> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SReply2 t1= list.get(0);
            SReply2Dto    dto=new    SReply2Dto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SReply2DtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<SReply2Dto> getSReply2List(SReply2Dto sReply2Dto){
        return null;
    }

    /**
    * 添加一个新的SReply2到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addSReply2(SReply2Dto sReply2Dto){
         // TODO Auto-generated method stub
        if(sReply2Dto!=null){
           SReply2 sReply2= new SReply2();
           sReply2=beanToDto.D1ToT1(sReply2, sReply2Dto);
           return this.save(sReply2);
        }
        return 0;
    }

    /**
    * 更新SReply2
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateSReply2(SReply2Dto sReply2Dto){
        // TODO Auto-generated method stub
        if(sReply2Dto!=null&&sReply2Dto.getSreply1Id()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sReply2Dto.createSetPropertiesVal(sReply2Dto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SReply2.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.sreply1Id=:uid");
           params.put("uid",sReply2Dto.getSreply1Id());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SReply2
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteSReply2(SReply2Dto sReply2Dto){
         // TODO Auto-generated method stub
        if(sReply2Dto!=null&&sReply2Dto.getSreply1Id()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SReply2.class.getName()+" a");
           stringBuffer.append(" where a.sreply1Id=:uid ");
           params.put("uid",sReply2Dto.getSreply1Id());
           SReply2 sReply2= new SReply2();
           BeanUtils.copyProperties(sReply2Dto, sReply2);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}