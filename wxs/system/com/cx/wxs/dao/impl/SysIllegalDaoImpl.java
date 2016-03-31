package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SysIllegalDao;
import com.cx.wxs.dto.SysIllegalDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SysIllegal;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-03-24 21:47:22
 */
@Repository("SysIllegalDao")
public class SysIllegalDaoImpl extends BaseDaoImpl<SysIllegal, Integer> implements SysIllegalDao{

    private BeanToDto<SysIllegal, SysIllegalDto> beanToDto =new  BeanToDto<SysIllegal,SysIllegalDto>();

    /**
    * 通过id获取SysIllegalDto
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    @Override
    public SysIllegalDto getSysIllegalByID(SysIllegalDto sysIllegalDto){
        // TODO Auto-generated method stub
        if(sysIllegalDto!=null&&sysIllegalDto.getIllegalId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysIllegal.class.getName()+"  a where a.illegalId=:id");
           params.put("id",sysIllegalDto.getIllegalId());
           List<SysIllegal> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysIllegal t1= list.get(0);
            SysIllegalDto    dto=new    SysIllegalDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SysIllegalDtoList
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    @Override
    public List<SysIllegalDto> getSysIllegalList(SysIllegalDto sysIllegalDto){

    	StringBuffer stringBuffer=new StringBuffer();
		Map<String,Object> params=new HashMap<String,Object>();
		stringBuffer.append("from "+SysIllegal.class.getName()+" a");
		stringBuffer.append(" where 1=1 ");
		if(sysIllegalDto!=null&&sysIllegalDto.getWord()!=null){
			stringBuffer.append(" and (a.word =:word or a.word like :word1)");
			params.put("word", sysIllegalDto.getWord());
			params.put("word1","%"+sysIllegalDto.getWord()+"%");
		}
		if(sysIllegalDto!=null&&sysIllegalDto.getNullify()!=null){
			stringBuffer.append(" and a.nullify =:nullify");
			params.put("nullify",sysIllegalDto.getNullify());
		}
		List<SysIllegalDto> list=new ArrayList<SysIllegalDto>(); 
		List<SysIllegal> list1=new ArrayList<SysIllegal>();
		if(sysIllegalDto.getPage()!=null&&sysIllegalDto.getRows()!=null){
			list1=this.find(stringBuffer.toString(),params,sysIllegalDto.getPage(),sysIllegalDto.getRows());
		}else{
			list1=this.find(stringBuffer.toString(),params);
		}
		for(SysIllegal sysIllegal:list1){
			SysIllegalDto dto=beanToDto.T1ToD1(sysIllegal, new SysIllegalDto());
			list.add(dto);
		}
		return list;

    }

    /**
    * 添加一个新的SysIllegal到数据库
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    @Override
    public Integer addSysIllegal(SysIllegalDto sysIllegalDto){
         // TODO Auto-generated method stub
        if(sysIllegalDto!=null){
           SysIllegal sysIllegal= new SysIllegal();
           sysIllegal=beanToDto.D1ToT1(sysIllegal, sysIllegalDto);
           return this.save(sysIllegal);
        }
        return 0;
    }

    /**
    * 更新SysIllegal
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    @Override
    public Integer updateSysIllegal(SysIllegalDto sysIllegalDto){
        // TODO Auto-generated method stub
        if(sysIllegalDto!=null&&sysIllegalDto.getIllegalId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sysIllegalDto.createSetPropertiesVal(sysIllegalDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append("  "+SysIllegal.class.getName()+" a ");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.illegalId=:uid");
           params.put("uid",sysIllegalDto.getIllegalId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SysIllegal
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    @Override
    public Integer deleteSysIllegal(SysIllegalDto sysIllegalDto){
         // TODO Auto-generated method stub
        if(sysIllegalDto!=null&&sysIllegalDto.getIllegalId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SysIllegal.class.getName()+" a");
           stringBuffer.append(" where a.illegalId=:uid ");
           params.put("uid",sysIllegalDto.getIllegalId());
           SysIllegal sysIllegal= new SysIllegal();
           BeanUtils.copyProperties(sysIllegalDto, sysIllegal);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.SysIllegalDao#getSysIllegal(com.cx.wxs.dto.SysIllegalDto)
	 */
	@Override
	public SysIllegalDto getSysIllegal(SysIllegalDto sysIllegalDto) {
        // TODO Auto-generated method stub
        if(sysIllegalDto!=null&&sysIllegalDto.getWord()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysIllegal.class.getName()+"  a where a.word=:word or a.word like :word1");
           params.put("word",sysIllegalDto.getWord());
           params.put("word1","%"+sysIllegalDto.getWord()+"%");
           List<SysIllegal> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysIllegal t1= list.get(0);
            SysIllegalDto    dto=new    SysIllegalDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
	}

}