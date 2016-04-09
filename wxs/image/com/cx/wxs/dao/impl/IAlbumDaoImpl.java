package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.IAlbumDao;
import com.cx.wxs.dto.IAlbumDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.IAlbum;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("IAlbumDao")
public class IAlbumDaoImpl extends BaseDaoImpl<IAlbum, Integer> implements IAlbumDao{

    private BeanToDto<IAlbum, IAlbumDto> beanToDto=new BeanToDto<IAlbum, IAlbumDto>();

    public BeanToDto<IAlbum, IAlbumDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<IAlbum, IAlbumDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取IAlbumDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public IAlbumDto getIAlbumByID(IAlbumDto iAlbumDto){
        // TODO Auto-generated method stub
        if(iAlbumDto!=null&&iAlbumDto.getAlbumId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+IAlbum.class.getName()+"  a where a.albumId=:id");
           params.put("id",iAlbumDto.getAlbumId());
           List<IAlbum> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            IAlbum t1= list.get(0);
            IAlbumDto    dto=new    IAlbumDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取IAlbumDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<IAlbumDto> getIAlbumList(IAlbumDto iAlbumDto){
        return null;
    }

    /**
    * 添加一个新的IAlbum到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addIAlbum(IAlbumDto iAlbumDto){
         // TODO Auto-generated method stub
        if(iAlbumDto!=null){
           IAlbum iAlbum= new IAlbum();
           iAlbum=beanToDto.D1ToT1(iAlbum, iAlbumDto);
           return this.save(iAlbum);
        }
        return 0;
    }

    /**
    * 更新IAlbum
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateIAlbum(IAlbumDto iAlbumDto){
        // TODO Auto-generated method stub
        if(iAlbumDto!=null&&iAlbumDto.getAlbumId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = iAlbumDto.createSetPropertiesVal(iAlbumDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+IAlbum.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.albumId=:uid");
           params.put("uid",iAlbumDto.getAlbumId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除IAlbum
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteIAlbum(IAlbumDto iAlbumDto){
         // TODO Auto-generated method stub
        if(iAlbumDto!=null&&iAlbumDto.getAlbumId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+IAlbum.class.getName()+" a");
           stringBuffer.append(" where a.albumId=:uid ");
           params.put("uid",iAlbumDto.getAlbumId());
           IAlbum iAlbum= new IAlbum();
           BeanUtils.copyProperties(iAlbumDto, iAlbum);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}