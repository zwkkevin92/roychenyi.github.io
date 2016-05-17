package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SysIllegalDao;
import com.cx.wxs.dto.SysIllegalDto;
import com.cx.wxs.service.SysIllegalService;

/**
 * @author 陈义
 * @date 2016-03-24 21:47:22
 */

@Service("SysIllegalService")
public class SysIllegalServiceImpl implements SysIllegalService {
    @Autowired
    private SysIllegalDao sysIllegalDao;

    public void setSysIllegalDao(SysIllegalDao sysIllegalDao){
        this.sysIllegalDao=sysIllegalDao;
    }

    /**
    * 通过用户id获取SysIllegalDto信息
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    @Override
    public SysIllegalDto getSysIllegalByID(SysIllegalDto sysIllegalDto){
        return sysIllegalDao.getSysIllegalByID(sysIllegalDto);
    }

    /**
    * 通过相关信息获取SysIllegalDtoList信息
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    @Override
    public List<SysIllegalDto> getSysIllegalList(SysIllegalDto sysIllegalDto){
        return sysIllegalDao.getSysIllegalList(sysIllegalDto);
    }

    /**
    * 添加一个新的SysIllegal到数据库
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    @Override
    public Integer addSysIllegal(SysIllegalDto sysIllegalDto){
    	
        return sysIllegalDao.addSysIllegal(sysIllegalDto);
    }

    /**
    * 更新SysIllegal
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    @Override
    public Integer updateSysIllegal(SysIllegalDto sysIllegalDto){
        return sysIllegalDao.updateSysIllegal(sysIllegalDto);
    }

    /**
    * 删除SysIllegal
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    @Override
    public Integer deleteSysIllegal(SysIllegalDto sysIllegalDto){
        return sysIllegalDao.deleteSysIllegal(sysIllegalDto);
    }

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.SysIllegalService#getSysIllegal(com.cx.wxs.dto.SysIllegalDto)
	 */
	@Override
	public SysIllegalDto getSysIllegal(SysIllegalDto sysIllegalDto) {
		// TODO Auto-generated method stub
		return sysIllegalDao.getSysIllegal(sysIllegalDto);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.SysIllegalService#IllegalCheck(java.lang.String)
	 */
	@Override
	public boolean IllegalCheck(String content) {
		// TODO Auto-generated method stub
		SysIllegalDto sysIllegalDto=new SysIllegalDto();
		sysIllegalDto.setNullify((short)0);
		List<SysIllegalDto> sysIllegalDtos=sysIllegalDao.getSysIllegalList(sysIllegalDto);
		for(SysIllegalDto sysIllegal :sysIllegalDtos){
			
			if(content.indexOf(sysIllegal.getWord())>=0){
				return false;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.SysIllegalService#IllegalReplace(java.lang.String)
	 */
	@Override
	public String IllegalReplace(String content) {
		// TODO Auto-generated method stub
		SysIllegalDto sysIllegalDto=new SysIllegalDto();
		sysIllegalDto.setNullify((short)0);
		List<SysIllegalDto> sysIllegalDtos=sysIllegalDao.getSysIllegalList(sysIllegalDto);
		for(SysIllegalDto sysIllegal : sysIllegalDtos){
			if(content.indexOf(sysIllegal.getWord())>=0){				
			content=content.replace(sysIllegal.getWord(), sysIllegal.getNewword());
				
			}
		}
		return content;
	}
	


}