package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.BBacklistDao;
import com.cx.wxs.dto.BBacklistDto;
import com.cx.wxs.service.BBacklistService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("BBacklistService")
public class BBacklistServiceImpl implements BBacklistService {
    @Autowired
    private BBacklistDao bBacklistDao;

    public void setBBacklistDao(BBacklistDao bBacklistDao){
        this.bBacklistDao=bBacklistDao;
    }

    /**
    * 通过用户id获取BBacklistDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public BBacklistDto getBBacklistByID(BBacklistDto bBacklistDto){
        return bBacklistDao.getBBacklistByID(bBacklistDto);
    }

    /**
    * 通过相关信息获取BBacklistDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<BBacklistDto> getBBacklistList(BBacklistDto bBacklistDto){
        return bBacklistDao.getBBacklistList(bBacklistDto);
    }

    /**
    * 添加一个新的BBacklist到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addBBacklist(BBacklistDto bBacklistDto){
        return bBacklistDao.addBBacklist(bBacklistDto);
    }

    /**
    * 更新BBacklist
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateBBacklist(BBacklistDto bBacklistDto){
        return bBacklistDao.updateBBacklist(bBacklistDto);
    }

    /**
    * 删除BBacklist
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteBBacklist(BBacklistDto bBacklistDto){
        return bBacklistDao.deleteBBacklist(bBacklistDto);
    }

}