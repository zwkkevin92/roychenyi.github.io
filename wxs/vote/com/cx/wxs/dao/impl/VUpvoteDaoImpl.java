package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.VUpvoteDao;
import com.cx.wxs.dto.VUpvoteDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.VUpvote;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("VUpvoteDao")
public class VUpvoteDaoImpl extends BaseDaoImpl<VUpvote, Integer> implements VUpvoteDao{

    private BeanToDto<VUpvote, VUpvoteDto> beanToDto;

    /**
    * 通过id获取VUpvoteDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public VUpvoteDto getVUpvoteByID(VUpvoteDto vUpvoteDto){
        // TODO Auto-generated method stub
        if(vUpvoteDto!=null&&vUpvoteDto.getVupvoteId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+VUpvote.class.getName()+"  a where a.vupvoteId=:id");
           params.put("id",vUpvoteDto.getVupvoteId());
           List<VUpvote> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            VUpvote t1= list.get(0);
            VUpvoteDto    dto=new    VUpvoteDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取VUpvoteDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<VUpvoteDto> getVUpvoteList(VUpvoteDto vUpvoteDto){
        return null;
    }

    /**
    * 添加一个新的VUpvote到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addVUpvote(VUpvoteDto vUpvoteDto){
         // TODO Auto-generated method stub
        if(vUpvoteDto!=null){
           VUpvote vUpvote= new VUpvote();
           vUpvote=beanToDto.D1ToT1(vUpvote, vUpvoteDto);
           return this.save(vUpvote);
        }
        return 0;
    }

    /**
    * 更新VUpvote
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateVUpvote(VUpvoteDto vUpvoteDto){
        // TODO Auto-generated method stub
        if(vUpvoteDto!=null&&vUpvoteDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = vUpvoteDto.createSetPropertiesVal(vUpvoteDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+VUpvote.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.vupvoteId=:uid");
           params.put("uid",vUpvoteDto.getVupvoteId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除VUpvote
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteVUpvote(VUpvoteDto vUpvoteDto){
         // TODO Auto-generated method stub
        if(vUpvoteDto!=null&&vUpvoteDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+VUpvote.class.getName()+" a");
           stringBuffer.append(" where a.vupvoteId=:uid ");
           params.put("uid",vUpvoteDto.getVupvoteId());
           VUpvote vUpvote= new VUpvote();
           BeanUtils.copyProperties(vUpvoteDto, vUpvote);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}