package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.DAnnexDao;
import com.cx.wxs.dto.DAnnexDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.DAnnex;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("DAnnexDao")
public class DAnnexDaoImpl extends BaseDaoImpl<DAnnex, Integer> implements DAnnexDao{

    private BeanToDto<DAnnex, DAnnexDto> beanToDto;

    /**
    * 通过id获取DAnnexDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public DAnnexDto getDAnnexByID(DAnnexDto dAnnexDto){
        // TODO Auto-generated method stub
        if(dAnnexDto!=null&&dAnnexDto.getAnnexId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+DAnnex.class.getName()+"  a where a.annexId=:id");
           params.put("id",dAnnexDto.getAnnexId());
           List<DAnnex> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            DAnnex t1= list.get(0);
            DAnnexDto    dto=new    DAnnexDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取DAnnexDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<DAnnexDto> getDAnnexList(DAnnexDto dAnnexDto){
        return null;
    }

    /**
    * 添加一个新的DAnnex到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addDAnnex(DAnnexDto dAnnexDto){
         // TODO Auto-generated method stub
        if(dAnnexDto!=null){
           DAnnex dAnnex= new DAnnex();
           dAnnex=beanToDto.D1ToT1(dAnnex, dAnnexDto);
           return this.save(dAnnex);
        }
        return 0;
    }

    /**
    * 更新DAnnex
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateDAnnex(DAnnexDto dAnnexDto){
        // TODO Auto-generated method stub
        if(dAnnexDto!=null&&dAnnexDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = dAnnexDto.createSetPropertiesVal(dAnnexDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+DAnnex.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.annexId=:uid");
           params.put("uid",dAnnexDto.getAnnexId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除DAnnex
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteDAnnex(DAnnexDto dAnnexDto){
         // TODO Auto-generated method stub
        if(dAnnexDto!=null&&dAnnexDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+DAnnex.class.getName()+" a");
           stringBuffer.append(" where a.annexId=:uid ");
           params.put("uid",dAnnexDto.getAnnexId());
           DAnnex dAnnex= new DAnnex();
           BeanUtils.copyProperties(dAnnexDto, dAnnex);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}