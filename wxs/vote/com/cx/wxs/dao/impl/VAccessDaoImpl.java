package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.VAccessDao;
import com.cx.wxs.dto.VAccessDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.VAccess;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("VAccessDao")
public class VAccessDaoImpl extends BaseDaoImpl<VAccess, Integer> implements VAccessDao{

    private BeanToDto<VAccess, VAccessDto> beanToDto;

    /**
    * 通过id获取VAccessDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public VAccessDto getVAccessByID(VAccessDto vAccessDto){
        // TODO Auto-generated method stub
        if(vAccessDto!=null&&vAccessDto.getVaccessId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+VAccess.class.getName()+"  a where a.vaccessId=:id");
           params.put("id",vAccessDto.getVaccessId());
           List<VAccess> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            VAccess t1= list.get(0);
            VAccessDto    dto=new    VAccessDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取VAccessDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<VAccessDto> getVAccessList(VAccessDto vAccessDto){
        return null;
    }

    /**
    * 添加一个新的VAccess到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addVAccess(VAccessDto vAccessDto){
         // TODO Auto-generated method stub
        if(vAccessDto!=null){
           VAccess vAccess= new VAccess();
           vAccess=beanToDto.D1ToT1(vAccess, vAccessDto);
           return this.save(vAccess);
        }
        return 0;
    }

    /**
    * 更新VAccess
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateVAccess(VAccessDto vAccessDto){
        // TODO Auto-generated method stub
        if(vAccessDto!=null&&vAccessDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = vAccessDto.createSetPropertiesVal(vAccessDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+VAccess.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.vaccessId=:uid");
           params.put("uid",vAccessDto.getVaccessId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除VAccess
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteVAccess(VAccessDto vAccessDto){
         // TODO Auto-generated method stub
        if(vAccessDto!=null&&vAccessDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+VAccess.class.getName()+" a");
           stringBuffer.append(" where a.vaccessId=:uid ");
           params.put("uid",vAccessDto.getVaccessId());
           VAccess vAccess= new VAccess();
           BeanUtils.copyProperties(vAccessDto, vAccess);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}