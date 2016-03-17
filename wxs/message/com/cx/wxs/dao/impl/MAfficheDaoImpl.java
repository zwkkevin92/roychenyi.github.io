package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.MAfficheDao;
import com.cx.wxs.dto.MAfficheDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.MAffiche;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */
@Repository("MAfficheDao")
public class MAfficheDaoImpl extends BaseDaoImpl<MAffiche, Integer> implements MAfficheDao{

    private BeanToDto<MAffiche, MAfficheDto> beanToDto;

    /**
    * 通过id获取MAfficheDto
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public MAfficheDto getMAfficheByID(MAfficheDto mAfficheDto){
        // TODO Auto-generated method stub
        if(mAfficheDto!=null&&mAfficheDto.getAfficheId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+MAffiche.class.getName()+"  a where a.afficheId=:id");
           params.put("id",mAfficheDto.getAfficheId());
           List<MAffiche> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            MAffiche t1= list.get(0);
            MAfficheDto    dto=new    MAfficheDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取MAfficheDtoList
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<MAfficheDto> getMAfficheList(MAfficheDto mAfficheDto){
        return null;
    }

    /**
    * 添加一个新的MAffiche到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addMAffiche(MAfficheDto mAfficheDto){
         // TODO Auto-generated method stub
        if(mAfficheDto!=null){
           MAffiche mAffiche= new MAffiche();
           mAffiche=beanToDto.D1ToT1(mAffiche, mAfficheDto);
           return this.save(mAffiche);
        }
        return 0;
    }

    /**
    * 更新MAffiche
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateMAffiche(MAfficheDto mAfficheDto){
        // TODO Auto-generated method stub
        if(mAfficheDto!=null&&mAfficheDto.getAfficheId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = mAfficheDto.createSetPropertiesVal(mAfficheDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+MAffiche.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.afficheId=:uid");
           params.put("uid",mAfficheDto.getAfficheId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除MAffiche
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteMAffiche(MAfficheDto mAfficheDto){
         // TODO Auto-generated method stub
        if(mAfficheDto!=null&&mAfficheDto.getAfficheId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+MAffiche.class.getName()+" a");
           stringBuffer.append(" where a.afficheId=:uid ");
           params.put("uid",mAfficheDto.getAfficheId());
           MAffiche mAffiche= new MAffiche();
           BeanUtils.copyProperties(mAfficheDto, mAffiche);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}