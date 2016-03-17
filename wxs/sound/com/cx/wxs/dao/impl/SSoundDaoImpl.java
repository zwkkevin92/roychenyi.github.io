package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SSoundDao;
import com.cx.wxs.dto.SSoundDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SSound;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */
@Repository("SSoundDao")
public class SSoundDaoImpl extends BaseDaoImpl<SSound, Integer> implements SSoundDao{

    private BeanToDto<SSound, SSoundDto> beanToDto;

    /**
    * 通过id获取SSoundDto
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SSoundDto getSSoundByID(SSoundDto sSoundDto){
        // TODO Auto-generated method stub
        if(sSoundDto!=null&&sSoundDto.getSoundId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SSound.class.getName()+"  a where a.soundId=:id");
           params.put("id",sSoundDto.getSoundId());
           List<SSound> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SSound t1= list.get(0);
            SSoundDto    dto=new    SSoundDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SSoundDtoList
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SSoundDto> getSSoundList(SSoundDto sSoundDto){
        return null;
    }

    /**
    * 添加一个新的SSound到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSSound(SSoundDto sSoundDto){
         // TODO Auto-generated method stub
        if(sSoundDto!=null){
           SSound sSound= new SSound();
           sSound=beanToDto.D1ToT1(sSound, sSoundDto);
           return this.save(sSound);
        }
        return 0;
    }

    /**
    * 更新SSound
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSSound(SSoundDto sSoundDto){
        // TODO Auto-generated method stub
        if(sSoundDto!=null&&sSoundDto.getSoundId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sSoundDto.createSetPropertiesVal(sSoundDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SSound.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.soundId=:uid");
           params.put("uid",sSoundDto.getSoundId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SSound
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSSound(SSoundDto sSoundDto){
         // TODO Auto-generated method stub
        if(sSoundDto!=null&&sSoundDto.getSoundId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SSound.class.getName()+" a");
           stringBuffer.append(" where a.soundId=:uid ");
           params.put("uid",sSoundDto.getSoundId());
           SSound sSound= new SSound();
           BeanUtils.copyProperties(sSoundDto, sSound);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}