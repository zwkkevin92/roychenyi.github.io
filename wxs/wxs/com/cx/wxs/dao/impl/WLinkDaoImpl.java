package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.WLinkDao;
import com.cx.wxs.dto.WLinkDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.WLink;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("WLinkDao")
public class WLinkDaoImpl extends BaseDaoImpl<WLink, Integer> implements WLinkDao{

    private BeanToDto<WLink, WLinkDto> beanToDto=new BeanToDto<WLink, WLinkDto>();

    public BeanToDto<WLink, WLinkDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<WLink, WLinkDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取WLinkDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public WLinkDto getWLinkByID(WLinkDto wLinkDto){
        // TODO Auto-generated method stub
        if(wLinkDto!=null&&wLinkDto.getWlinkId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+WLink.class.getName()+"  a where a.wlinkId=:id");
           params.put("id",wLinkDto.getWlinkId());
           List<WLink> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            WLink t1= list.get(0);
            WLinkDto    dto=new    WLinkDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取WLinkDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<WLinkDto> getWLinkList(WLinkDto wLinkDto){
        return null;
    }

    /**
    * 添加一个新的WLink到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addWLink(WLinkDto wLinkDto){
         // TODO Auto-generated method stub
        if(wLinkDto!=null){
           WLink wLink= new WLink();
           wLink=beanToDto.D1ToT1(wLink, wLinkDto);
           return this.save(wLink);
        }
        return 0;
    }

    /**
    * 更新WLink
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateWLink(WLinkDto wLinkDto){
        // TODO Auto-generated method stub
        if(wLinkDto!=null&&wLinkDto.getWlinkId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = wLinkDto.createSetPropertiesVal(wLinkDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+WLink.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.wlinkId=:uid");
           params.put("uid",wLinkDto.getWlinkId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除WLink
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteWLink(WLinkDto wLinkDto){
         // TODO Auto-generated method stub
        if(wLinkDto!=null&&wLinkDto.getWlinkId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+WLink.class.getName()+" a");
           stringBuffer.append(" where a.wlinkId=:uid ");
           params.put("uid",wLinkDto.getWlinkId());
           WLink wLink= new WLink();
           BeanUtils.copyProperties(wLinkDto, wLink);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}