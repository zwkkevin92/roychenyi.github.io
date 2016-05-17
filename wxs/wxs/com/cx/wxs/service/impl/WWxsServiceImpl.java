package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.PagerUtils;
import com.cx.wxs.dao.WWxsDao;
import com.cx.wxs.dto.WWxsDto;
import com.cx.wxs.service.WWxsService;
import com.cx.wxs.utils.PageUtils;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("WWxsService")
public class WWxsServiceImpl implements WWxsService {
    @Autowired
    private WWxsDao wWxsDao;

    public void setWWxsDao(WWxsDao wWxsDao){
        this.wWxsDao=wWxsDao;
    }

    /**
    * 通过用户id获取WWxsDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public WWxsDto getWWxsByID(WWxsDto wWxsDto){
        return wWxsDao.getWWxsByID(wWxsDto);
    }

    /**
    * 通过相关信息获取WWxsDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<WWxsDto> getWWxsList(WWxsDto wWxsDto){
    	Integer count = wWxsDao.getWWxsCount(wWxsDto);
    	Integer totalPage = PageUtils.getTotalPage(count,wWxsDto.getRows()); 
        List<WWxsDto> list = wWxsDao.getWWxsList(wWxsDto);
        if(list!=null&&list.size()>0){
       // 	list.get(0).setPage(wWxsDto.getPage());
        	list.get(0).setPageCount(totalPage);
        	list.get(0).setRows(count);
        }
        return list;
    }

    /**
    * 添加一个新的WWxs到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addWWxs(WWxsDto wWxsDto){
        return wWxsDao.addWWxs(wWxsDto);
    }

    /**
    * 更新WWxs
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateWWxs(WWxsDto wWxsDto){
        return wWxsDao.updateWWxs(wWxsDto);
    }

    /**
    * 删除WWxs
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteWWxs(WWxsDto wWxsDto){
        return wWxsDao.deleteWWxs(wWxsDto);
    }

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.WWxsService#getWwxs(com.cx.wxs.dto.WWxsDto)
	 */
	@Override
	public WWxsDto getWwxs(WWxsDto wWxsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WWxsDto getWWxsDto(WWxsDto wWxsDto) {
		return wWxsDao.getWWxsDto(wWxsDto);
		
	}

}