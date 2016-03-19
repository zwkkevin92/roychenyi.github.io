package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.DCatalogDao;
import com.cx.wxs.dto.DCatalogDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.DCatalog;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */
@Repository("DCatalogDao")
public class DCatalogDaoImpl extends BaseDaoImpl<DCatalog, Integer> implements DCatalogDao{

    private BeanToDto<DCatalog, DCatalogDto> beanToDto;

    /**
    * 通过id获取DCatalogDto
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public DCatalogDto getDCatalogByID(DCatalogDto dCatalogDto){
        // TODO Auto-generated method stub
        if(dCatalogDto!=null&&dCatalogDto.getCatalogId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+DCatalog.class.getName()+"  a where a.catalogId=:id");
           params.put("id",dCatalogDto.getCatalogId());
           List<DCatalog> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            DCatalog t1= list.get(0);
            DCatalogDto    dto=new    DCatalogDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取DCatalogDtoList
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<DCatalogDto> getDCatalogList(DCatalogDto dCatalogDto){
        return null;
    }

    /**
    * 添加一个新的DCatalog到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addDCatalog(DCatalogDto dCatalogDto){
         // TODO Auto-generated method stub
        if(dCatalogDto!=null){
           DCatalog dCatalog= new DCatalog();
           dCatalog=beanToDto.D1ToT1(dCatalog, dCatalogDto);
           return this.save(dCatalog);
        }
        return 0;
    }

    /**
    * 更新DCatalog
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateDCatalog(DCatalogDto dCatalogDto){
        // TODO Auto-generated method stub
        if(dCatalogDto!=null&&dCatalogDto.getCatalogId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = dCatalogDto.createSetPropertiesVal(dCatalogDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+DCatalog.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.catalogId=:uid");
           params.put("uid",dCatalogDto.getCatalogId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除DCatalog
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteDCatalog(DCatalogDto dCatalogDto){
         // TODO Auto-generated method stub
        if(dCatalogDto!=null&&dCatalogDto.getCatalogId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+DCatalog.class.getName()+" a");
           stringBuffer.append(" where a.catalogId=:uid ");
           params.put("uid",dCatalogDto.getCatalogId());
           DCatalog dCatalog= new DCatalog();
           BeanUtils.copyProperties(dCatalogDto, dCatalog);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}