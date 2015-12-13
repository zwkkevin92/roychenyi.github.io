package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SysTopicDao;
import com.cx.wxs.dto.SysTopicDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SysTopic;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("SysTopicDao")
public class SysTopicDaoImpl extends BaseDaoImpl<SysTopic, Integer> implements SysTopicDao{

    private BeanToDto<SysTopic, SysTopicDto> beanToDto;

    /**
    * 通过id获取SysTopicDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public SysTopicDto getSysTopicByID(SysTopicDto sysTopicDto){
        // TODO Auto-generated method stub
        if(sysTopicDto!=null&&sysTopicDto.getTopicId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysTopic.class.getName()+"  a where a.topicId=:id");
           params.put("id",sysTopicDto.getTopicId());
           List<SysTopic> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysTopic t1= list.get(0);
            SysTopicDto    dto=new    SysTopicDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SysTopicDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<SysTopicDto> getSysTopicList(SysTopicDto sysTopicDto){
        return null;
    }

    /**
    * 添加一个新的SysTopic到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addSysTopic(SysTopicDto sysTopicDto){
         // TODO Auto-generated method stub
        if(sysTopicDto!=null){
           SysTopic sysTopic= new SysTopic();
           sysTopic=beanToDto.D1ToT1(sysTopic, sysTopicDto);
           return this.save(sysTopic);
        }
        return 0;
    }

    /**
    * 更新SysTopic
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateSysTopic(SysTopicDto sysTopicDto){
        // TODO Auto-generated method stub
        if(sysTopicDto!=null&&sysTopicDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sysTopicDto.createSetPropertiesVal(sysTopicDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SysTopic.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.topicId=:uid");
           params.put("uid",sysTopicDto.getTopicId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SysTopic
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteSysTopic(SysTopicDto sysTopicDto){
         // TODO Auto-generated method stub
        if(sysTopicDto!=null&&sysTopicDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SysTopic.class.getName()+" a");
           stringBuffer.append(" where a.topicId=:uid ");
           params.put("uid",sysTopicDto.getTopicId());
           SysTopic sysTopic= new SysTopic();
           BeanUtils.copyProperties(sysTopicDto, sysTopic);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}