package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.WMenberDao;
import com.cx.wxs.dto.WMenberDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.WMenber;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-05-16 10:33:22
 */
@Repository("WMenberDao")
public class WMenberDaoImpl extends BaseDaoImpl<WMenber, Integer> implements WMenberDao{

    private BeanToDto<WMenber, WMenberDto> beanToDto=new BeanToDto<WMenber, WMenberDto>();

    public BeanToDto<WMenber, WMenberDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<WMenber, WMenberDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取WMenberDto
    * @author 陈义
    * @date 2016-05-16 10:33:22
    */
    @Override
    public WMenberDto getWMenberByID(WMenberDto wMenberDto){
        // TODO Auto-generated method stub
        if(wMenberDto!=null&&wMenberDto.getMenberId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+WMenber.class.getName()+"  a where a.menberId=:id");
           params.put("id",wMenberDto.getMenberId());
           List<WMenber> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            WMenber t1= list.get(0);
            WMenberDto    dto=new    WMenberDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取WMenberDtoList
    * @author 陈义
    * @date 2016-05-16 10:33:22
    */
    @Override
    public List<WMenberDto> getWMenberList(WMenberDto wMenberDto){
        return null;
    }

    /**
    * 添加一个新的WMenber到数据库
    * @author 陈义
    * @date 2016-05-16 10:33:22
    */
    @Override
    public Integer addWMenber(WMenberDto wMenberDto){
         // TODO Auto-generated method stub
        if(wMenberDto!=null){
           WMenber wMenber= new WMenber();
           wMenber=beanToDto.D1ToT1(wMenber, wMenberDto);
           return this.save(wMenber);
        }
        return 0;
    }

    /**
    * 更新WMenber
    * @author 陈义
    * @date 2016-05-16 10:33:22
    */
    @Override
    public Integer updateWMenber(WMenberDto wMenberDto){
        // TODO Auto-generated method stub
        if(wMenberDto!=null&&wMenberDto.getMenberId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = wMenberDto.createSetPropertiesVal(wMenberDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" from "+WMenber.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.menberId=:uid");
           params.put("uid",wMenberDto.getMenberId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除WMenber
    * @author 陈义
    * @date 2016-05-16 10:33:22
    */
    @Override
    public Integer deleteWMenber(WMenberDto wMenberDto){
         // TODO Auto-generated method stub
        if(wMenberDto!=null&&wMenberDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+WMenber.class.getName()+" a");
           stringBuffer.append(" where a.menberId=:uid ");
           params.put("uid",wMenberDto.getMenberId());
           WMenber wMenber= new WMenber();
           BeanUtils.copyProperties(wMenberDto, wMenber);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}