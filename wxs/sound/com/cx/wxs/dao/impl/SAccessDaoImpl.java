package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SAccessDao;
import com.cx.wxs.dto.SAccessDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SAccess;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("SAccessDao")
public class SAccessDaoImpl extends BaseDaoImpl<SAccess, Integer> implements SAccessDao{

    private BeanToDto<SAccess, SAccessDto> beanToDto=new BeanToDto<SAccess, SAccessDto>();

    public BeanToDto<SAccess, SAccessDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<SAccess, SAccessDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取SAccessDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public SAccessDto getSAccessByID(SAccessDto sAccessDto){
        // TODO Auto-generated method stub
        if(sAccessDto!=null&&sAccessDto.getSaccessId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SAccess.class.getName()+"  a where a.saccessId=:id");
           params.put("id",sAccessDto.getSaccessId());
           List<SAccess> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SAccess t1= list.get(0);
            SAccessDto    dto=new    SAccessDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SAccessDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<SAccessDto> getSAccessList(SAccessDto sAccessDto){
        return null;
    }

    /**
    * 添加一个新的SAccess到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addSAccess(SAccessDto sAccessDto){
         // TODO Auto-generated method stub
        if(sAccessDto!=null){
           SAccess sAccess= new SAccess();
           sAccess=beanToDto.D1ToT1(sAccess, sAccessDto);
           return this.save(sAccess);
        }
        return 0;
    }

    /**
    * 更新SAccess
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateSAccess(SAccessDto sAccessDto){
        // TODO Auto-generated method stub
        if(sAccessDto!=null&&sAccessDto.getSaccessId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sAccessDto.createSetPropertiesVal(sAccessDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SAccess.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.saccessId=:uid");
           params.put("uid",sAccessDto.getSaccessId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SAccess
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteSAccess(SAccessDto sAccessDto){
         // TODO Auto-generated method stub
        if(sAccessDto!=null&&sAccessDto.getSaccessId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SAccess.class.getName()+" a");
           stringBuffer.append(" where a.saccessId=:uid ");
           params.put("uid",sAccessDto.getSaccessId());
           SAccess sAccess= new SAccess();
           BeanUtils.copyProperties(sAccessDto, sAccess);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}