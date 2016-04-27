package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.VReply2Dao;
import com.cx.wxs.dto.VReply2Dto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.VReply2;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("VReply2Dao")
public class VReply2DaoImpl extends BaseDaoImpl<VReply2, Integer> implements VReply2Dao{

    private BeanToDto<VReply2, VReply2Dto> beanToDto=new BeanToDto<VReply2, VReply2Dto>();

    public BeanToDto<VReply2, VReply2Dto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<VReply2, VReply2Dto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取VReply2Dto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public VReply2Dto getVReply2ByID(VReply2Dto vReply2Dto){
        // TODO Auto-generated method stub
        if(vReply2Dto!=null&&vReply2Dto.getVreply1Id()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+VReply2.class.getName()+"  a where a.vreply1Id=:id");
           params.put("id",vReply2Dto.getVreply1Id());
           List<VReply2> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            VReply2 t1= list.get(0);
            VReply2Dto    dto=new    VReply2Dto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取VReply2DtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<VReply2Dto> getVReply2List(VReply2Dto vReply2Dto){
        return null;
    }

    /**
    * 添加一个新的VReply2到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addVReply2(VReply2Dto vReply2Dto){
         // TODO Auto-generated method stub
        if(vReply2Dto!=null){
           VReply2 vReply2= new VReply2();
           vReply2=beanToDto.D1ToT1(vReply2, vReply2Dto);
           return this.save(vReply2);
        }
        return 0;
    }

    /**
    * 更新VReply2
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateVReply2(VReply2Dto vReply2Dto){
        // TODO Auto-generated method stub
        if(vReply2Dto!=null&&vReply2Dto.getVreply1Id()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = vReply2Dto.createSetPropertiesVal(vReply2Dto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+VReply2.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.vreply1Id=:uid");
           params.put("uid",vReply2Dto.getVreply1Id());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除VReply2
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteVReply2(VReply2Dto vReply2Dto){
         // TODO Auto-generated method stub
        if(vReply2Dto!=null&&vReply2Dto.getVreply1Id()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+VReply2.class.getName()+" a");
           stringBuffer.append(" where a.vreply1Id=:uid ");
           params.put("uid",vReply2Dto.getVreply1Id());
           VReply2 vReply2= new VReply2();
           BeanUtils.copyProperties(vReply2Dto, vReply2);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}