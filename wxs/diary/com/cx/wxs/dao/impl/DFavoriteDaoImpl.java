package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.DFavoriteDao;
import com.cx.wxs.dto.DFavoriteDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.DFavorite;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-16 09:22:44
 */
@Repository("DFavoriteDao")
public class DFavoriteDaoImpl extends BaseDaoImpl<DFavorite, Integer> implements DFavoriteDao{

    private BeanToDto<DFavorite, DFavoriteDto> beanToDto=new BeanToDto<DFavorite, DFavoriteDto>();

    public BeanToDto<DFavorite, DFavoriteDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<DFavorite, DFavoriteDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取DFavoriteDto
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public DFavoriteDto getDFavoriteByID(DFavoriteDto dFavoriteDto){
        // TODO Auto-generated method stub
        if(dFavoriteDto!=null&&dFavoriteDto.getDfavoriteId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+DFavorite.class.getName()+"  a where a.dfavoriteId=:id");
           params.put("id",dFavoriteDto.getDfavoriteId());
           List<DFavorite> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            DFavorite t1= list.get(0);
            DFavoriteDto    dto=new    DFavoriteDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取DFavoriteDtoList
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public List<DFavoriteDto> getDFavoriteList(DFavoriteDto dFavoriteDto){
        return null;
    }

    /**
    * 添加一个新的DFavorite到数据库
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public Integer addDFavorite(DFavoriteDto dFavoriteDto){
         // TODO Auto-generated method stub
        if(dFavoriteDto!=null){
           DFavorite dFavorite= new DFavorite();
           dFavorite=beanToDto.D1ToT1(dFavorite, dFavoriteDto);
           return this.save(dFavorite);
        }
        return 0;
    }

    /**
    * 更新DFavorite
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public Integer updateDFavorite(DFavoriteDto dFavoriteDto){
        // TODO Auto-generated method stub
        if(dFavoriteDto!=null&&dFavoriteDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = dFavoriteDto.createSetPropertiesVal(dFavoriteDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" from "+DFavorite.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.dfavoriteId=:uid");
           params.put("uid",dFavoriteDto.getDfavoriteId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除DFavorite
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public Integer deleteDFavorite(DFavoriteDto dFavoriteDto){
         // TODO Auto-generated method stub
        if(dFavoriteDto!=null&&dFavoriteDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+DFavorite.class.getName()+" a");
           stringBuffer.append(" where a.dfavoriteId=:uid ");
           params.put("uid",dFavoriteDto.getDfavoriteId());
           DFavorite dFavorite= new DFavorite();
           BeanUtils.copyProperties(dFavoriteDto, dFavorite);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}