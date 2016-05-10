package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.BConfigDao;
import com.cx.wxs.dto.BConfigDto;
import com.cx.wxs.service.BConfigService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("BConfigService")
public class BConfigServiceImpl implements BConfigService {
    @Autowired
    private BConfigDao bConfigDao;

    public void setBConfigDao(BConfigDao bConfigDao){
        this.bConfigDao=bConfigDao;
    }

    /**
    * 通过用户id获取BConfigDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public BConfigDto getBConfigByID(BConfigDto bConfigDto){
        return bConfigDao.getBConfigByID(bConfigDto);
    }

    /**
     * 通过configKey 和siteId或许configDto信息
     */
    @Override
    public BConfigDto getBConfig(BConfigDto bConfigDto){
    	return bConfigDao.getBConfig(bConfigDto);
    }
    /**
    * 通过相关信息获取BConfigDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<BConfigDto> getBConfigList(BConfigDto bConfigDto){
        return bConfigDao.getBConfigList(bConfigDto);
    }

    /**
    * 添加一个新的BConfig到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addBConfig(BConfigDto bConfigDto){
        return bConfigDao.addBConfig(bConfigDto);
    }

    /**
    * 更新BConfig
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateBConfig(BConfigDto bConfigDto){
        return bConfigDao.updateBConfig(bConfigDto);
    }

    /**
    * 删除BConfig
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteBConfig(BConfigDto bConfigDto){
        return bConfigDao.deleteBConfig(bConfigDto);
    }

}