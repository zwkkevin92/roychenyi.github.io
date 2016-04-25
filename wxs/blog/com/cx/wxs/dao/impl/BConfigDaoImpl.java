package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.BConfigDao;
import com.cx.wxs.dto.BConfigDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.BConfig;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("BConfigDao")
public class BConfigDaoImpl extends BaseDaoImpl<BConfig, Integer> implements BConfigDao{

    private BeanToDto<BConfig, BConfigDto> beanToDto=new BeanToDto<BConfig, BConfigDto>();

    public BeanToDto<BConfig, BConfigDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<BConfig, BConfigDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取BConfigDto
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public BConfigDto getBConfigByID(BConfigDto bConfigDto){
        // TODO Auto-generated method stub
        if(bConfigDto!=null&&bConfigDto.getBconfigId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+BConfig.class.getName()+"  a where a.bconfigId=:id");
           params.put("id",bConfigDto.getBconfigId());
           List<BConfig> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            BConfig t1= list.get(0);
            BConfigDto    dto=new    BConfigDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }
    
    /* (non-Javadoc)
	 * @see com.cx.wxs.dao.BConfigDao#getBConfig(com.cx.wxs.dto.BConfigDto)
	 */
	@Override
	public BConfigDto getBConfig(BConfigDto bConfigDto) {
		if(bConfigDto!=null){
	           StringBuffer stringBuffer=new StringBuffer();
	           Map<String,Object> params=new HashMap<String, Object>();
	           stringBuffer.append("from  "+BConfig.class.getName()+"  a where a.BSite.siteId=:siteId");
	           params.put("siteId",bConfigDto.getBSiteDto().getSiteId());
	           stringBuffer.append(" and a.configKey=:configKey");
	           params.put("configKey",bConfigDto.getConfigKey());	    
	           List<BConfig> list=this.find(stringBuffer.toString(), params);
	           if(list!=null&&list.size()>0){
	            BConfig t1= list.get(0);
	            BConfigDto    dto=new    BConfigDto();
	            dto=beanToDto.T1ToD1(t1,dto);
	            return dto;
	            }
	        }
	        return null;
	}

    /**
    * 通过相关数据获取BConfigDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public List<BConfigDto> getBConfigList(BConfigDto bConfigDto){
        return null;
    }

    /**
    * 添加一个新的BConfig到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public Integer addBConfig(BConfigDto bConfigDto){
         // TODO Auto-generated method stub
        if(bConfigDto!=null){
           BConfig bConfig= new BConfig();
           bConfig=beanToDto.D1ToT1(bConfig, bConfigDto);
           return this.save(bConfig);
        }
        return 0;
    }

    /**
    * 更新BConfig
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public Integer updateBConfig(BConfigDto bConfigDto){
        // TODO Auto-generated method stub
        if(bConfigDto!=null&&bConfigDto.getBconfigId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = bConfigDto.createSetPropertiesVal(bConfigDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append("  "+BConfig.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.bconfigId=:uid");
           params.put("uid",bConfigDto.getBconfigId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除BConfig
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public Integer deleteBConfig(BConfigDto bConfigDto){
         // TODO Auto-generated method stub
        if(bConfigDto!=null&&bConfigDto.getBconfigId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append("  "+BConfig.class.getName()+" a");
           stringBuffer.append(" where a.bconfigId=:uid ");
           params.put("uid",bConfigDto.getBconfigId());
           BConfig bConfig= new BConfig();
           BeanUtils.copyProperties(bConfigDto, bConfig);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

	

}