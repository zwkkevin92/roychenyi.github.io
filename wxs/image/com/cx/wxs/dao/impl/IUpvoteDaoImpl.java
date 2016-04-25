package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.IUpvoteDao;
import com.cx.wxs.dto.IUpvoteDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.IUpvote;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("IUpvoteDao")
public class IUpvoteDaoImpl extends BaseDaoImpl<IUpvote, Integer> implements IUpvoteDao{

    private BeanToDto<IUpvote, IUpvoteDto> beanToDto=new BeanToDto<IUpvote, IUpvoteDto>();

    public BeanToDto<IUpvote, IUpvoteDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<IUpvote, IUpvoteDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取IUpvoteDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public IUpvoteDto getIUpvoteByID(IUpvoteDto iUpvoteDto){
        // TODO Auto-generated method stub
        if(iUpvoteDto!=null&&iUpvoteDto.getIupvoteId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+IUpvote.class.getName()+"  a where a.iupvoteId=:id");
           params.put("id",iUpvoteDto.getIupvoteId());
           List<IUpvote> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            IUpvote t1= list.get(0);
            IUpvoteDto    dto=new    IUpvoteDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取IUpvoteDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<IUpvoteDto> getIUpvoteList(IUpvoteDto iUpvoteDto){
        return null;
    }

    /**
    * 添加一个新的IUpvote到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addIUpvote(IUpvoteDto iUpvoteDto){
         // TODO Auto-generated method stub
        if(iUpvoteDto!=null){
           IUpvote iUpvote= new IUpvote();
           iUpvote=beanToDto.D1ToT1(iUpvote, iUpvoteDto);
           return this.save(iUpvote);
        }
        return 0;
    }

    /**
    * 更新IUpvote
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateIUpvote(IUpvoteDto iUpvoteDto){
        // TODO Auto-generated method stub
        if(iUpvoteDto!=null&&iUpvoteDto.getIupvoteId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = iUpvoteDto.createSetPropertiesVal(iUpvoteDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+IUpvote.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.iupvoteId=:uid");
           params.put("uid",iUpvoteDto.getIupvoteId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除IUpvote
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteIUpvote(IUpvoteDto iUpvoteDto){
         // TODO Auto-generated method stub
        if(iUpvoteDto!=null&&iUpvoteDto.getIupvoteId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+IUpvote.class.getName()+" a");
           stringBuffer.append(" where a.iupvoteId=:uid ");
           params.put("uid",iUpvoteDto.getIupvoteId());
           IUpvote iUpvote= new IUpvote();
           BeanUtils.copyProperties(iUpvoteDto, iUpvote);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}