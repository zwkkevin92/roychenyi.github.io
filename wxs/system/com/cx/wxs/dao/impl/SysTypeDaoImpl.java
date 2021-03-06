package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SysTypeDao;
import com.cx.wxs.dto.SysTypeDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SysType;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("SysTypeDao")
public class SysTypeDaoImpl extends BaseDaoImpl<SysType, Integer> implements SysTypeDao{

    private BeanToDto<SysType, SysTypeDto> beanToDto=new BeanToDto<SysType, SysTypeDto>();

    public BeanToDto<SysType, SysTypeDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<SysType, SysTypeDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取SysTypeDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public SysTypeDto getSysTypeByID(SysTypeDto sysTypeDto){
        // TODO Auto-generated method stub
        if(sysTypeDto!=null&&sysTypeDto.getTypeId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysType.class.getName()+"  a where a.typeId=:id");
           params.put("id",sysTypeDto.getTypeId());
           List<SysType> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysType t1= list.get(0);
            SysTypeDto    dto=new    SysTypeDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SysTypeDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<SysTypeDto> getSysTypeList(SysTypeDto sysTypeDto){
    	if(sysTypeDto!=null){
    		StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+SysType.class.getName()+" a ");
			stringBuffer.append(" where 1=1 ");
			if(sysTypeDto.getParentId()!=null){
			stringBuffer.append(" and a.parentId=:parentId");
			params.put("parentId", sysTypeDto.getParentId());
			}
			List<SysTypeDto> list=new ArrayList<SysTypeDto>();
			List<SysType> list1=new ArrayList<SysType>();
			list1=this.find(stringBuffer.toString(),params);
			for(SysType sysType:list1){
				SysTypeDto sysTypeDto2=beanToDto.T1ToD1(sysType, new SysTypeDto());
				list.add(sysTypeDto2);
			}
			return list;
			
    	}
        return null;
    }

    /**
    * 添加一个新的SysType到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addSysType(SysTypeDto sysTypeDto){
         // TODO Auto-generated method stub
        if(sysTypeDto!=null){
           SysType sysType= new SysType();
           sysType=beanToDto.D1ToT1(sysType, sysTypeDto);
           return this.save(sysType);
        }
        return 0;
    }

    /**
    * 更新SysType
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateSysType(SysTypeDto sysTypeDto){
        // TODO Auto-generated method stub
        if(sysTypeDto!=null&&sysTypeDto.getTypeId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sysTypeDto.createSetPropertiesVal(sysTypeDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" from "+SysType.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.typeId=:uid");
           params.put("uid",sysTypeDto.getTypeId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SysType
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteSysType(SysTypeDto sysTypeDto){
         // TODO Auto-generated method stub
        if(sysTypeDto!=null&&sysTypeDto.getTypeId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SysType.class.getName()+" a");
           stringBuffer.append(" where a.typeId=:uid ");
           params.put("uid",sysTypeDto.getTypeId());
           SysType sysType= new SysType();
           BeanUtils.copyProperties(sysTypeDto, sysType);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}