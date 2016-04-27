package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.DFavoriteDao;
import com.cx.wxs.dto.DFavoriteDto;
import com.cx.wxs.service.DFavoriteService;

/**
 * @author 陈义
 * @date 2016-04-16 09:22:44
 */

@Service("DFavoriteService")
public class DFavoriteServiceImpl implements DFavoriteService {
    @Autowired
    private DFavoriteDao dFavoriteDao;

    public void setDFavoriteDao(DFavoriteDao dFavoriteDao){
        this.dFavoriteDao=dFavoriteDao;
    }

    /**
    * 通过用户id获取DFavoriteDto信息
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public DFavoriteDto getDFavoriteByID(DFavoriteDto dFavoriteDto){
        return dFavoriteDao.getDFavoriteByID(dFavoriteDto);
    }
    
    @Override
    public DFavoriteDto getDFavorite(DFavoriteDto dFavoriteDto){
    	return dFavoriteDao.getDFavorite(dFavoriteDto);
    }

    /**
    * 通过相关信息获取DFavoriteDtoList信息
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public List<DFavoriteDto> getDFavoriteList(DFavoriteDto dFavoriteDto){
        return dFavoriteDao.getDFavoriteList(dFavoriteDto);
    }

    /**
    * 添加一个新的DFavorite到数据库
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public Integer addDFavorite(DFavoriteDto dFavoriteDto){
        return dFavoriteDao.addDFavorite(dFavoriteDto);
    }

    /**
    * 更新DFavorite
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public Integer updateDFavorite(DFavoriteDto dFavoriteDto){
        return dFavoriteDao.updateDFavorite(dFavoriteDto);
    }

    /**
    * 删除DFavorite
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public Integer deleteDFavorite(DFavoriteDto dFavoriteDto){
        return dFavoriteDao.deleteDFavorite(dFavoriteDto);
    }

}