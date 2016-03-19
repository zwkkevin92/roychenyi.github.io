package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.MMessageDao;
import com.cx.wxs.dto.MMessageDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.MMessage;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */
@Repository("MMessageDao")
public class MMessageDaoImpl extends BaseDaoImpl<MMessage, Integer> implements MMessageDao{

    private BeanToDto<MMessage, MMessageDto> beanToDto;

    /**
    * 通过id获取MMessageDto
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public MMessageDto getMMessageByID(MMessageDto mMessageDto){
        // TODO Auto-generated method stub
        if(mMessageDto!=null&&mMessageDto.getMessageId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+MMessage.class.getName()+"  a where a.messageId=:id");
           params.put("id",mMessageDto.getMessageId());
           List<MMessage> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            MMessage t1= list.get(0);
            MMessageDto    dto=new    MMessageDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取MMessageDtoList
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<MMessageDto> getMMessageList(MMessageDto mMessageDto){
        return null;
    }

    /**
    * 添加一个新的MMessage到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addMMessage(MMessageDto mMessageDto){
         // TODO Auto-generated method stub
        if(mMessageDto!=null){
           MMessage mMessage= new MMessage();
           mMessage=beanToDto.D1ToT1(mMessage, mMessageDto);
           return this.save(mMessage);
        }
        return 0;
    }

    /**
    * 更新MMessage
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateMMessage(MMessageDto mMessageDto){
        // TODO Auto-generated method stub
        if(mMessageDto!=null&&mMessageDto.getMessageId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = mMessageDto.createSetPropertiesVal(mMessageDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+MMessage.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.messageId=:uid");
           params.put("uid",mMessageDto.getMessageId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除MMessage
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteMMessage(MMessageDto mMessageDto){
         // TODO Auto-generated method stub
        if(mMessageDto!=null&&mMessageDto.getMessageId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+MMessage.class.getName()+" a");
           stringBuffer.append(" where a.messageId=:uid ");
           params.put("uid",mMessageDto.getMessageId());
           MMessage mMessage= new MMessage();
           BeanUtils.copyProperties(mMessageDto, mMessage);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}