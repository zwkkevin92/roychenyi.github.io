package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.MReplyDao;
import com.cx.wxs.dto.MReplyDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.MReply;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("MReplyDao")
public class MReplyDaoImpl extends BaseDaoImpl<MReply, Integer> implements MReplyDao{

    private BeanToDto<MReply, MReplyDto> beanToDto=new BeanToDto<MReply, MReplyDto>();

    public BeanToDto<MReply, MReplyDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<MReply, MReplyDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取MReplyDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public MReplyDto getMReplyByID(MReplyDto mReplyDto){
        // TODO Auto-generated method stub
        if(mReplyDto!=null&&mReplyDto.getMreplyId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+MReply.class.getName()+"  a where a.mreplyId=:id");
           params.put("id",mReplyDto.getMreplyId());
           List<MReply> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            MReply t1= list.get(0);
            MReplyDto    dto=new    MReplyDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取MReplyDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<MReplyDto> getMReplyList(MReplyDto mReplyDto){
        return null;
    }

    /**
    * 添加一个新的MReply到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addMReply(MReplyDto mReplyDto){
         // TODO Auto-generated method stub
        if(mReplyDto!=null){
           MReply mReply= new MReply();
           mReply=beanToDto.D1ToT1(mReply, mReplyDto);
           return this.save(mReply);
        }
        return 0;
    }

    /**
    * 更新MReply
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateMReply(MReplyDto mReplyDto){
        // TODO Auto-generated method stub
        if(mReplyDto!=null&&mReplyDto.getMreplyId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = mReplyDto.createSetPropertiesVal(mReplyDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+MReply.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.mreplyId=:uid");
           params.put("uid",mReplyDto.getMreplyId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除MReply
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteMReply(MReplyDto mReplyDto){
         // TODO Auto-generated method stub
        if(mReplyDto!=null&&mReplyDto.getMreplyId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+MReply.class.getName()+" a");
           stringBuffer.append(" where a.mreplyId=:uid ");
           params.put("uid",mReplyDto.getMreplyId());
           MReply mReply= new MReply();
           BeanUtils.copyProperties(mReplyDto, mReply);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}