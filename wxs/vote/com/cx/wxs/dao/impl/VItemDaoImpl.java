package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.VItemDao;
import com.cx.wxs.dto.VItemDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.VItem;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("VItemDao")
public class VItemDaoImpl extends BaseDaoImpl<VItem, Integer> implements VItemDao{

    private BeanToDto<VItem, VItemDto> beanToDto=new BeanToDto<VItem, VItemDto>();

    public BeanToDto<VItem, VItemDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<VItem, VItemDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取VItemDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public VItemDto getVItemByID(VItemDto vItemDto){
        // TODO Auto-generated method stub
        if(vItemDto!=null&&vItemDto.getItemId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+VItem.class.getName()+"  a where a.itemId=:id");
           params.put("id",vItemDto.getItemId());
           List<VItem> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            VItem t1= list.get(0);
            VItemDto    dto=new    VItemDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取VItemDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<VItemDto> getVItemList(VItemDto vItemDto){
        return null;
    }

    /**
    * 添加一个新的VItem到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addVItem(VItemDto vItemDto){
         // TODO Auto-generated method stub
        if(vItemDto!=null){
           VItem vItem= new VItem();
           vItem=beanToDto.D1ToT1(vItem, vItemDto);
           return this.save(vItem);
        }
        return 0;
    }

    /**
    * 更新VItem
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateVItem(VItemDto vItemDto){
        // TODO Auto-generated method stub
        if(vItemDto!=null&&vItemDto.getItemId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = vItemDto.createSetPropertiesVal(vItemDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+VItem.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.itemId=:uid");
           params.put("uid",vItemDto.getItemId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除VItem
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteVItem(VItemDto vItemDto){
         // TODO Auto-generated method stub
        if(vItemDto!=null&&vItemDto.getItemId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+VItem.class.getName()+" a");
           stringBuffer.append(" where a.itemId=:uid ");
           params.put("uid",vItemDto.getItemId());
           VItem vItem= new VItem();
           BeanUtils.copyProperties(vItemDto, vItem);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}