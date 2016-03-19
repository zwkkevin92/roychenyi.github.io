package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SysStyleDao;
import com.cx.wxs.dto.SysStyleDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SysStyle;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */
@Repository("SysStyleDao")
public class SysStyleDaoImpl extends BaseDaoImpl<SysStyle, Integer> implements SysStyleDao{

    private BeanToDto<SysStyle, SysStyleDto> beanToDto;

    /**
    * 通过id获取SysStyleDto
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SysStyleDto getSysStyleByID(SysStyleDto sysStyleDto){
        // TODO Auto-generated method stub
        if(sysStyleDto!=null&&sysStyleDto.getStyleId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysStyle.class.getName()+"  a where a.styleId=:id");
           params.put("id",sysStyleDto.getStyleId());
           List<SysStyle> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysStyle t1= list.get(0);
            SysStyleDto    dto=new    SysStyleDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SysStyleDtoList
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SysStyleDto> getSysStyleList(SysStyleDto sysStyleDto){
        return null;
    }

    /**
    * 添加一个新的SysStyle到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSysStyle(SysStyleDto sysStyleDto){
         // TODO Auto-generated method stub
        if(sysStyleDto!=null){
           SysStyle sysStyle= new SysStyle();
           sysStyle=beanToDto.D1ToT1(sysStyle, sysStyleDto);
           return this.save(sysStyle);
        }
        return 0;
    }

    /**
    * 更新SysStyle
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSysStyle(SysStyleDto sysStyleDto){
        // TODO Auto-generated method stub
        if(sysStyleDto!=null&&sysStyleDto.getStyleId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sysStyleDto.createSetPropertiesVal(sysStyleDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SysStyle.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.styleId=:uid");
           params.put("uid",sysStyleDto.getStyleId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SysStyle
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSysStyle(SysStyleDto sysStyleDto){
         // TODO Auto-generated method stub
        if(sysStyleDto!=null&&sysStyleDto.getStyleId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SysStyle.class.getName()+" a");
           stringBuffer.append(" where a.styleId=:uid ");
           params.put("uid",sysStyleDto.getStyleId());
           SysStyle sysStyle= new SysStyle();
           BeanUtils.copyProperties(sysStyleDto, sysStyle);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}