package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SBoxDao;
import com.cx.wxs.dto.SBoxDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SBox;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */
@Repository("SBoxDao")
public class SBoxDaoImpl extends BaseDaoImpl<SBox, Integer> implements SBoxDao{

    private BeanToDto<SBox, SBoxDto> beanToDto;

    /**
    * 通过id获取SBoxDto
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SBoxDto getSBoxByID(SBoxDto sBoxDto){
        // TODO Auto-generated method stub
        if(sBoxDto!=null&&sBoxDto.getBoxId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SBox.class.getName()+"  a where a.boxId=:id");
           params.put("id",sBoxDto.getBoxId());
           List<SBox> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SBox t1= list.get(0);
            SBoxDto    dto=new    SBoxDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SBoxDtoList
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SBoxDto> getSBoxList(SBoxDto sBoxDto){
        return null;
    }

    /**
    * 添加一个新的SBox到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSBox(SBoxDto sBoxDto){
         // TODO Auto-generated method stub
        if(sBoxDto!=null){
           SBox sBox= new SBox();
           sBox=beanToDto.D1ToT1(sBox, sBoxDto);
           return this.save(sBox);
        }
        return 0;
    }

    /**
    * 更新SBox
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSBox(SBoxDto sBoxDto){
        // TODO Auto-generated method stub
        if(sBoxDto!=null&&sBoxDto.getBoxId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sBoxDto.createSetPropertiesVal(sBoxDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SBox.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.boxId=:uid");
           params.put("uid",sBoxDto.getBoxId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SBox
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSBox(SBoxDto sBoxDto){
         // TODO Auto-generated method stub
        if(sBoxDto!=null&&sBoxDto.getBoxId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SBox.class.getName()+" a");
           stringBuffer.append(" where a.boxId=:uid ");
           params.put("uid",sBoxDto.getBoxId());
           SBox sBox= new SBox();
           BeanUtils.copyProperties(sBoxDto, sBox);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}