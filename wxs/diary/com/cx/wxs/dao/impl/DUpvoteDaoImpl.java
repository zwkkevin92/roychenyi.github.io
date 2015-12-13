package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.DUpvoteDao;
import com.cx.wxs.dto.DUpvoteDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.DUpvote;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("DUpvoteDao")
public class DUpvoteDaoImpl extends BaseDaoImpl<DUpvote, Integer> implements DUpvoteDao{

    private BeanToDto<DUpvote, DUpvoteDto> beanToDto;

    /**
    * 通过id获取DUpvoteDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public DUpvoteDto getDUpvoteByID(DUpvoteDto dUpvoteDto){
        // TODO Auto-generated method stub
        if(dUpvoteDto!=null&&dUpvoteDto.getDupvoteId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+DUpvote.class.getName()+"  a where a.dupvoteId=:id");
           params.put("id",dUpvoteDto.getDupvoteId());
           List<DUpvote> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            DUpvote t1= list.get(0);
            DUpvoteDto    dto=new    DUpvoteDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取DUpvoteDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<DUpvoteDto> getDUpvoteList(DUpvoteDto dUpvoteDto){
        return null;
    }

    /**
    * 添加一个新的DUpvote到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addDUpvote(DUpvoteDto dUpvoteDto){
         // TODO Auto-generated method stub
        if(dUpvoteDto!=null){
           DUpvote dUpvote= new DUpvote();
           dUpvote=beanToDto.D1ToT1(dUpvote, dUpvoteDto);
           return this.save(dUpvote);
        }
        return 0;
    }

    /**
    * 更新DUpvote
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateDUpvote(DUpvoteDto dUpvoteDto){
        // TODO Auto-generated method stub
        if(dUpvoteDto!=null&&dUpvoteDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = dUpvoteDto.createSetPropertiesVal(dUpvoteDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+DUpvote.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.dupvoteId=:uid");
           params.put("uid",dUpvoteDto.getDupvoteId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除DUpvote
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteDUpvote(DUpvoteDto dUpvoteDto){
         // TODO Auto-generated method stub
        if(dUpvoteDto!=null&&dUpvoteDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+DUpvote.class.getName()+" a");
           stringBuffer.append(" where a.dupvoteId=:uid ");
           params.put("uid",dUpvoteDto.getDupvoteId());
           DUpvote dUpvote= new DUpvote();
           BeanUtils.copyProperties(dUpvoteDto, dUpvote);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}