package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SUpvoteDao;
import com.cx.wxs.dto.SUpvoteDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SUpvote;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */
@Repository("SUpvoteDao")
public class SUpvoteDaoImpl extends BaseDaoImpl<SUpvote, Integer> implements SUpvoteDao{

    private BeanToDto<SUpvote, SUpvoteDto> beanToDto;

    /**
    * 通过id获取SUpvoteDto
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SUpvoteDto getSUpvoteByID(SUpvoteDto sUpvoteDto){
        // TODO Auto-generated method stub
        if(sUpvoteDto!=null&&sUpvoteDto.getSupvoteId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SUpvote.class.getName()+"  a where a.supvoteId=:id");
           params.put("id",sUpvoteDto.getSupvoteId());
           List<SUpvote> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SUpvote t1= list.get(0);
            SUpvoteDto    dto=new    SUpvoteDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SUpvoteDtoList
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SUpvoteDto> getSUpvoteList(SUpvoteDto sUpvoteDto){
        return null;
    }

    /**
    * 添加一个新的SUpvote到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSUpvote(SUpvoteDto sUpvoteDto){
         // TODO Auto-generated method stub
        if(sUpvoteDto!=null){
           SUpvote sUpvote= new SUpvote();
           sUpvote=beanToDto.D1ToT1(sUpvote, sUpvoteDto);
           return this.save(sUpvote);
        }
        return 0;
    }

    /**
    * 更新SUpvote
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSUpvote(SUpvoteDto sUpvoteDto){
        // TODO Auto-generated method stub
        if(sUpvoteDto!=null&&sUpvoteDto.getSupvoteId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sUpvoteDto.createSetPropertiesVal(sUpvoteDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SUpvote.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.supvoteId=:uid");
           params.put("uid",sUpvoteDto.getSupvoteId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SUpvote
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSUpvote(SUpvoteDto sUpvoteDto){
         // TODO Auto-generated method stub
        if(sUpvoteDto!=null&&sUpvoteDto.getSupvoteId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SUpvote.class.getName()+" a");
           stringBuffer.append(" where a.supvoteId=:uid ");
           params.put("uid",sUpvoteDto.getSupvoteId());
           SUpvote sUpvote= new SUpvote();
           BeanUtils.copyProperties(sUpvoteDto, sUpvote);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}