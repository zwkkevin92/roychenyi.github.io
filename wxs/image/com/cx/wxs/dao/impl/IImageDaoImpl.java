package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.IImageDao;
import com.cx.wxs.dto.IImageDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.IImage;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("IImageDao")
public class IImageDaoImpl extends BaseDaoImpl<IImage, Integer> implements IImageDao{

    private BeanToDto<IImage, IImageDto> beanToDto;

    /**
    * 通过id获取IImageDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public IImageDto getIImageByID(IImageDto iImageDto){
        // TODO Auto-generated method stub
        if(iImageDto!=null&&iImageDto.getImageId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+IImage.class.getName()+"  a where a.imageId=:id");
           params.put("id",iImageDto.getImageId());
           List<IImage> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            IImage t1= list.get(0);
            IImageDto    dto=new    IImageDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取IImageDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<IImageDto> getIImageList(IImageDto iImageDto){
        return null;
    }

    /**
    * 添加一个新的IImage到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addIImage(IImageDto iImageDto){
         // TODO Auto-generated method stub
        if(iImageDto!=null){
           IImage iImage= new IImage();
           iImage=beanToDto.D1ToT1(iImage, iImageDto);
           return this.save(iImage);
        }
        return 0;
    }

    /**
    * 更新IImage
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateIImage(IImageDto iImageDto){
        // TODO Auto-generated method stub
        if(iImageDto!=null&&iImageDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = iImageDto.createSetPropertiesVal(iImageDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+IImage.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.imageId=:uid");
           params.put("uid",iImageDto.getImageId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除IImage
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteIImage(IImageDto iImageDto){
         // TODO Auto-generated method stub
        if(iImageDto!=null&&iImageDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+IImage.class.getName()+" a");
           stringBuffer.append(" where a.imageId=:uid ");
           params.put("uid",iImageDto.getImageId());
           IImage iImage= new IImage();
           BeanUtils.copyProperties(iImageDto, iImage);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}