package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.VCountDao;
import com.cx.wxs.dto.VCountDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.VCount;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("VCountDao")
public class VCountDaoImpl extends BaseDaoImpl<VCount, Integer> implements VCountDao{

    private BeanToDto<VCount, VCountDto> beanToDto=new BeanToDto<VCount, VCountDto>();

    public BeanToDto<VCount, VCountDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<VCount, VCountDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取VCountDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public VCountDto getVCountByID(VCountDto vCountDto){
        // TODO Auto-generated method stub
        if(vCountDto!=null&&vCountDto.getVcountId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+VCount.class.getName()+"  a where a.vcountId=:id");
           params.put("id",vCountDto.getVcountId());
           List<VCount> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            VCount t1= list.get(0);
            VCountDto    dto=new    VCountDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取VCountDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<VCountDto> getVCountList(VCountDto vCountDto){
        return null;
    }

    /**
    * 添加一个新的VCount到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addVCount(VCountDto vCountDto){
         // TODO Auto-generated method stub
        if(vCountDto!=null){
           VCount vCount= new VCount();
           vCount=beanToDto.D1ToT1(vCount, vCountDto);
           return this.save(vCount);
        }
        return 0;
    }

    /**
    * 更新VCount
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateVCount(VCountDto vCountDto){
        // TODO Auto-generated method stub
        if(vCountDto!=null&&vCountDto.getVcountId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = vCountDto.createSetPropertiesVal(vCountDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+VCount.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.vcountId=:uid");
           params.put("uid",vCountDto.getVcountId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除VCount
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteVCount(VCountDto vCountDto){
         // TODO Auto-generated method stub
        if(vCountDto!=null&&vCountDto.getVcountId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+VCount.class.getName()+" a");
           stringBuffer.append(" where a.vcountId=:uid ");
           params.put("uid",vCountDto.getVcountId());
           VCount vCount= new VCount();
           BeanUtils.copyProperties(vCountDto, vCount);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}