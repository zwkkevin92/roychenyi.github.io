package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SysConfigDao;
import com.cx.wxs.dto.SysConfigDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SysConfig;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("SysConfigDao")
public class SysConfigDaoImpl extends BaseDaoImpl<SysConfig, Integer> implements SysConfigDao{

    private BeanToDto<SysConfig, SysConfigDto> beanToDto=new BeanToDto<SysConfig, SysConfigDto>();

    public BeanToDto<SysConfig, SysConfigDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<SysConfig, SysConfigDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取SysConfigDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public SysConfigDto getSysConfigByID(SysConfigDto sysConfigDto){
        // TODO Auto-generated method stub
        if(sysConfigDto!=null&&sysConfigDto.getConfigId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysConfig.class.getName()+"  a where a.configId=:id");
           params.put("id",sysConfigDto.getConfigId());
           List<SysConfig> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysConfig t1= list.get(0);
            SysConfigDto    dto=new    SysConfigDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SysConfigDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<SysConfigDto> getSysConfigList(SysConfigDto sysConfigDto){
        return null;
    }

    /**
    * 添加一个新的SysConfig到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addSysConfig(SysConfigDto sysConfigDto){
         // TODO Auto-generated method stub
        if(sysConfigDto!=null){
           SysConfig sysConfig= new SysConfig();
           sysConfig=beanToDto.D1ToT1(sysConfig, sysConfigDto);
           return this.save(sysConfig);
        }
        return 0;
    }

    /**
    * 更新SysConfig
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateSysConfig(SysConfigDto sysConfigDto){
        // TODO Auto-generated method stub
        if(sysConfigDto!=null&&sysConfigDto.getConfigId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sysConfigDto.createSetPropertiesVal(sysConfigDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SysConfig.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.configId=:uid");
           params.put("uid",sysConfigDto.getConfigId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SysConfig
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteSysConfig(SysConfigDto sysConfigDto){
         // TODO Auto-generated method stub
        if(sysConfigDto!=null&&sysConfigDto.getConfigId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SysConfig.class.getName()+" a");
           stringBuffer.append(" where a.configId=:uid ");
           params.put("uid",sysConfigDto.getConfigId());
           SysConfig sysConfig= new SysConfig();
           BeanUtils.copyProperties(sysConfigDto, sysConfig);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}