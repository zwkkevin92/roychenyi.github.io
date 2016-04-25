package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.IAccessDao;
import com.cx.wxs.dto.IAccessDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.IAccess;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("IAccessDao")
public class IAccessDaoImpl extends BaseDaoImpl<IAccess, Integer> implements IAccessDao{

    private BeanToDto<IAccess, IAccessDto> beanToDto=new BeanToDto<IAccess, IAccessDto>();

    public BeanToDto<IAccess, IAccessDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<IAccess, IAccessDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取IAccessDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public IAccessDto getIAccessByID(IAccessDto iAccessDto){
        // TODO Auto-generated method stub
        if(iAccessDto!=null&&iAccessDto.getIaccessId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+IAccess.class.getName()+"  a where a.iaccessId=:id");
           params.put("id",iAccessDto.getIaccessId());
           List<IAccess> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            IAccess t1= list.get(0);
            IAccessDto    dto=new    IAccessDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取IAccessDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<IAccessDto> getIAccessList(IAccessDto iAccessDto){
        return null;
    }

    /**
    * 添加一个新的IAccess到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addIAccess(IAccessDto iAccessDto){
         // TODO Auto-generated method stub
        if(iAccessDto!=null){
           IAccess iAccess= new IAccess();
           iAccess=beanToDto.D1ToT1(iAccess, iAccessDto);
           return this.save(iAccess);
        }
        return 0;
    }

    /**
    * 更新IAccess
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateIAccess(IAccessDto iAccessDto){
        // TODO Auto-generated method stub
        if(iAccessDto!=null&&iAccessDto.getIaccessId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = iAccessDto.createSetPropertiesVal(iAccessDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+IAccess.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.iaccessId=:uid");
           params.put("uid",iAccessDto.getIaccessId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除IAccess
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteIAccess(IAccessDto iAccessDto){
         // TODO Auto-generated method stub
        if(iAccessDto!=null&&iAccessDto.getIaccessId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+IAccess.class.getName()+" a");
           stringBuffer.append(" where a.iaccessId=:uid ");
           params.put("uid",iAccessDto.getIaccessId());
           IAccess iAccess= new IAccess();
           BeanUtils.copyProperties(iAccessDto, iAccess);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}