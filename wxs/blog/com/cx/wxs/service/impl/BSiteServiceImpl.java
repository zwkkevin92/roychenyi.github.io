package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.BSiteDao;
import com.cx.wxs.dto.BSiteDto;
import com.cx.wxs.service.BSiteService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("BSiteService")
public class BSiteServiceImpl implements BSiteService {
    @Autowired
    private BSiteDao bSiteDao;

    public void setBSiteDao(BSiteDao bSiteDao){
        this.bSiteDao=bSiteDao;
    }

    /**
    * 通过用户id获取BSiteDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public BSiteDto getBSiteByID(BSiteDto bSiteDto){
        return bSiteDao.getBSiteByID(bSiteDto);
    }

    /**
    * 通过相关信息获取BSiteDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<BSiteDto> getBSiteList(BSiteDto bSiteDto){
        return bSiteDao.getBSiteList(bSiteDto);
    }

    /**
    * 添加一个新的BSite到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addBSite(BSiteDto bSiteDto){
        return bSiteDao.addBSite(bSiteDto);
    }

    /**
    * 更新BSite
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateBSite(BSiteDto bSiteDto){
        return bSiteDao.updateBSite(bSiteDto);
    }

    /**
    * 删除BSite
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteBSite(BSiteDto bSiteDto){
        return bSiteDao.deleteBSite(bSiteDto);
    }

}