package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.VReply1Dao;
import com.cx.wxs.dto.VReply1Dto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.VReply1;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("VReply1Dao")
public class VReply1DaoImpl extends BaseDaoImpl<VReply1, Integer> implements VReply1Dao{

    private BeanToDto<VReply1, VReply1Dto> beanToDto;

    /**
    * 通过id获取VReply1Dto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public VReply1Dto getVReply1ByID(VReply1Dto vReply1Dto){
        // TODO Auto-generated method stub
        if(vReply1Dto!=null&&vReply1Dto.getVreplyId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+VReply1.class.getName()+"  a where a.vreplyId=:id");
           params.put("id",vReply1Dto.getVreplyId());
           List<VReply1> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            VReply1 t1= list.get(0);
            VReply1Dto    dto=new    VReply1Dto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取VReply1DtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<VReply1Dto> getVReply1List(VReply1Dto vReply1Dto){
        return null;
    }

    /**
    * 添加一个新的VReply1到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addVReply1(VReply1Dto vReply1Dto){
         // TODO Auto-generated method stub
        if(vReply1Dto!=null){
           VReply1 vReply1= new VReply1();
           vReply1=beanToDto.D1ToT1(vReply1, vReply1Dto);
           return this.save(vReply1);
        }
        return 0;
    }

    /**
    * 更新VReply1
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateVReply1(VReply1Dto vReply1Dto){
        // TODO Auto-generated method stub
        if(vReply1Dto!=null&&vReply1Dto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = vReply1Dto.createSetPropertiesVal(vReply1Dto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+VReply1.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.vreplyId=:uid");
           params.put("uid",vReply1Dto.getVreplyId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除VReply1
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteVReply1(VReply1Dto vReply1Dto){
         // TODO Auto-generated method stub
        if(vReply1Dto!=null&&vReply1Dto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+VReply1.class.getName()+" a");
           stringBuffer.append(" where a.vreplyId=:uid ");
           params.put("uid",vReply1Dto.getVreplyId());
           VReply1 vReply1= new VReply1();
           BeanUtils.copyProperties(vReply1Dto, vReply1);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}