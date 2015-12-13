package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.BTagDao;
import com.cx.wxs.dto.BTagDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.BTag;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("BTagDao")
public class BTagDaoImpl extends BaseDaoImpl<BTag, Integer> implements BTagDao{

    private BeanToDto<BTag, BTagDto> beanToDto;

    /**
    * 通过id获取BTagDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public BTagDto getBTagByID(BTagDto bTagDto){
        // TODO Auto-generated method stub
        if(bTagDto!=null&&bTagDto.getTagId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+BTag.class.getName()+"  a where a.tagId=:id");
           params.put("id",bTagDto.getTagId());
           List<BTag> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            BTag t1= list.get(0);
            BTagDto    dto=new    BTagDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取BTagDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<BTagDto> getBTagList(BTagDto bTagDto){
        return null;
    }

    /**
    * 添加一个新的BTag到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addBTag(BTagDto bTagDto){
         // TODO Auto-generated method stub
        if(bTagDto!=null){
           BTag bTag= new BTag();
           bTag=beanToDto.D1ToT1(bTag, bTagDto);
           return this.save(bTag);
        }
        return 0;
    }

    /**
    * 更新BTag
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateBTag(BTagDto bTagDto){
        // TODO Auto-generated method stub
        if(bTagDto!=null&&bTagDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = bTagDto.createSetPropertiesVal(bTagDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+BTag.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.tagId=:uid");
           params.put("uid",bTagDto.getTagId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除BTag
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteBTag(BTagDto bTagDto){
         // TODO Auto-generated method stub
        if(bTagDto!=null&&bTagDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+BTag.class.getName()+" a");
           stringBuffer.append(" where a.tagId=:uid ");
           params.put("uid",bTagDto.getTagId());
           BTag bTag= new BTag();
           BeanUtils.copyProperties(bTagDto, bTag);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}