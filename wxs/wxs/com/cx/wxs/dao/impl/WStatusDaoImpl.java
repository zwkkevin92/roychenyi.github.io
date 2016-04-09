package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.WStatusDao;
import com.cx.wxs.dto.WStatusDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.WStatus;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("WStatusDao")
public class WStatusDaoImpl extends BaseDaoImpl<WStatus, Integer> implements WStatusDao{

    private BeanToDto<WStatus, WStatusDto> beanToDto=new BeanToDto<WStatus, WStatusDto>();

    public BeanToDto<WStatus, WStatusDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<WStatus, WStatusDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取WStatusDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public WStatusDto getWStatusByID(WStatusDto wStatusDto){
        // TODO Auto-generated method stub
        if(wStatusDto!=null&&wStatusDto.getWstatusId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+WStatus.class.getName()+"  a where a.wstatusId=:id");
           params.put("id",wStatusDto.getWstatusId());
           List<WStatus> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            WStatus t1= list.get(0);
            WStatusDto    dto=new    WStatusDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取WStatusDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<WStatusDto> getWStatusList(WStatusDto wStatusDto){
        return null;
    }

    /**
    * 添加一个新的WStatus到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addWStatus(WStatusDto wStatusDto){
         // TODO Auto-generated method stub
        if(wStatusDto!=null){
           WStatus wStatus= new WStatus();
           wStatus=beanToDto.D1ToT1(wStatus, wStatusDto);
           return this.save(wStatus);
        }
        return 0;
    }

    /**
    * 更新WStatus
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateWStatus(WStatusDto wStatusDto){
        // TODO Auto-generated method stub
        if(wStatusDto!=null&&wStatusDto.getWstatusId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = wStatusDto.createSetPropertiesVal(wStatusDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+WStatus.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.wstatusId=:uid");
           params.put("uid",wStatusDto.getWstatusId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除WStatus
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteWStatus(WStatusDto wStatusDto){
         // TODO Auto-generated method stub
        if(wStatusDto!=null&&wStatusDto.getWstatusId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+WStatus.class.getName()+" a");
           stringBuffer.append(" where a.wstatusId=:uid ");
           params.put("uid",wStatusDto.getWstatusId());
           WStatus wStatus= new WStatus();
           BeanUtils.copyProperties(wStatusDto, wStatus);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}