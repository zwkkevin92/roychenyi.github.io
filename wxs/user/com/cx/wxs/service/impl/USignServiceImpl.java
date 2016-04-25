package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.USignDao;
import com.cx.wxs.dto.USignDto;
import com.cx.wxs.service.USignService;

/**
 * @author 陈义
 * @date 2016-04-05 21:50:25
 */

@Service("USignService")
public class USignServiceImpl implements USignService {
   
	@Autowired
    private USignDao uSignDao;
        
	/**
	 * @param uSignDao the uSignDao to set
	 */
	public void setuSignDao(USignDao uSignDao) {
		this.uSignDao = uSignDao;
	}

	/**
    * 通过用户id获取USignDto信息
    * @author 陈义
    * @date 2016-04-05 21:50:25
    */
    @Override
    public USignDto getUSignByID(USignDto uSignDto){
        return uSignDao.getUsignByID(uSignDto);
    }

    /**
    * 通过相关信息获取USignDtoList信息
    * @author 陈义
    * @date 2016-04-05 21:50:25
    */
    @Override
    public List<USignDto> getUSignList(USignDto uSignDto){
        return uSignDao.getUsignList(uSignDto);
    }

    /**
    * 添加一个新的USign到数据库
    * @author 陈义
    * @date 2016-04-05 21:50:25
    */
    @Override
    public Integer addUSign(USignDto uSignDto){
        return uSignDao.addSign(uSignDto);
    }

    /**
    * 更新USign
    * @author 陈义
    * @date 2016-04-05 21:50:25
    */
    @Override
    public Integer updateUSign(USignDto uSignDto){
        return uSignDao.updateSign(uSignDto);
    }

    /**
    * 删除USign
    * @author 陈义
    * @date 2016-04-05 21:50:25
    */
    @Override
    public Integer deleteUSign(USignDto uSignDto){
        return uSignDao.deleteSign(uSignDto);
    }

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.USignService#setUserSing(com.cx.wxs.dto.USignDto)
	 */
	@Override
	public Integer setUserSign(USignDto uSignDto) {
		// TODO Auto-generated method stub
		//先把其他的签名档变成普通的
		List<USignDto> signList=uSignDao.getUsignList(uSignDto);
		for(USignDto signDto:signList){
			signDto.setStatus((short)0);			
			uSignDao.updateSign(signDto);
		}
		Integer usinId=uSignDao.addSign(uSignDto);
		return usinId;
	}

}