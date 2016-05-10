package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.BStatusDao;
import com.cx.wxs.dto.BStatusDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.BStatus;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("BStatusDao")
public class BStatusDaoImpl extends BaseDaoImpl<BStatus, Integer> implements BStatusDao{

    private BeanToDto<BStatus, BStatusDto> beanToDto=new BeanToDto<BStatus, BStatusDto>();

    public BeanToDto<BStatus, BStatusDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<BStatus, BStatusDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取BStatusDto
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public BStatusDto getBStatusByID(BStatusDto bStatusDto){
        // TODO Auto-generated method stub
        if(bStatusDto!=null&&bStatusDto.getBstatusId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+BStatus.class.getName()+"  a where a.bstatusId=:id");
           params.put("id",bStatusDto.getBstatusId());
           List<BStatus> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            BStatus t1= list.get(0);
            BStatusDto    dto=new    BStatusDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取BStatusDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public List<BStatusDto> getBStatusList(BStatusDto bStatusDto){
        return null;
    }

    /**
    * 添加一个新的BStatus到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public Integer addBStatus(BStatusDto bStatusDto){
         // TODO Auto-generated method stub
        if(bStatusDto!=null){
           BStatus bStatus= new BStatus();
           bStatus=beanToDto.D1ToT1(bStatus, bStatusDto);
           return this.save(bStatus);
        }
        return 0;
    }

    /**
    * 更新BStatus
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public Integer updateBStatus(BStatusDto bStatusDto){
        // TODO Auto-generated method stub
        if(bStatusDto!=null&&bStatusDto.getBstatusId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = bStatusDto.createSetPropertiesVal(bStatusDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+BStatus.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.bstatusId=:uid");
           params.put("uid",bStatusDto.getBstatusId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除BStatus
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public Integer deleteBStatus(BStatusDto bStatusDto){
         // TODO Auto-generated method stub
        if(bStatusDto!=null&&bStatusDto.getBstatusId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+BStatus.class.getName()+" a");
           stringBuffer.append(" where a.bstatusId=:uid ");
           params.put("uid",bStatusDto.getBstatusId());
           BStatus bStatus= new BStatus();
           BeanUtils.copyProperties(bStatusDto, bStatus);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}