package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SysRankDao;
import com.cx.wxs.dto.SysRankDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SysRank;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("SysRankDao")
public class SysRankDaoImpl extends BaseDaoImpl<SysRank, Integer> implements SysRankDao{

    private BeanToDto<SysRank, SysRankDto> beanToDto=new BeanToDto<SysRank, SysRankDto>();

    public BeanToDto<SysRank, SysRankDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<SysRank, SysRankDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取SysRankDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public SysRankDto getSysRankByID(SysRankDto sysRankDto){
        // TODO Auto-generated method stub
        if(sysRankDto!=null&&sysRankDto.getRankId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysRank.class.getName()+"  a where a.rankId=:id");
           params.put("id",sysRankDto.getRankId());
           List<SysRank> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysRank t1= list.get(0);
            SysRankDto    dto=new    SysRankDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SysRankDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<SysRankDto> getSysRankList(SysRankDto sysRankDto){
        return null;
    }

    /**
    * 添加一个新的SysRank到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addSysRank(SysRankDto sysRankDto){
         // TODO Auto-generated method stub
        if(sysRankDto!=null){
           SysRank sysRank= new SysRank();
           sysRank=beanToDto.D1ToT1(sysRank, sysRankDto);
           return this.save(sysRank);
        }
        return 0;
    }

    /**
    * 更新SysRank
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateSysRank(SysRankDto sysRankDto){
        // TODO Auto-generated method stub
        if(sysRankDto!=null&&sysRankDto.getRankId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sysRankDto.createSetPropertiesVal(sysRankDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SysRank.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.rankId=:uid");
           params.put("uid",sysRankDto.getRankId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SysRank
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteSysRank(SysRankDto sysRankDto){
         // TODO Auto-generated method stub
        if(sysRankDto!=null&&sysRankDto.getRankId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SysRank.class.getName()+" a");
           stringBuffer.append(" where a.rankId=:uid ");
           params.put("uid",sysRankDto.getRankId());
           SysRank sysRank= new SysRank();
           BeanUtils.copyProperties(sysRankDto, sysRank);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}