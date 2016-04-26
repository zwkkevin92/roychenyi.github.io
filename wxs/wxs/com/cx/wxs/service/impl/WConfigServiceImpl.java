package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.WConfigDao;
import com.cx.wxs.dto.WConfigDto;
import com.cx.wxs.service.WConfigService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("WConfigService")
public class WConfigServiceImpl implements WConfigService {
    @Autowired
    private WConfigDao wConfigDao;

    public void setWConfigDao(WConfigDao wConfigDao){
        this.wConfigDao=wConfigDao;
    }

    /**
    * 通过用户id获取WConfigDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public WConfigDto getWConfigByID(WConfigDto wConfigDto){
        return wConfigDao.getWConfigByID(wConfigDto);
    }

    /**
    * 通过相关信息获取WConfigDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<WConfigDto> getWConfigList(WConfigDto wConfigDto){
        return wConfigDao.getWConfigList(wConfigDto);
    }

    /**
    * 添加一个新的WConfig到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addWConfig(WConfigDto wConfigDto){
        return wConfigDao.addWConfig(wConfigDto);
    }

    /**
    * 更新WConfig
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateWConfig(WConfigDto wConfigDto){
        return wConfigDao.updateWConfig(wConfigDto);
    }

    /**
    * 删除WConfig
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteWConfig(WConfigDto wConfigDto){
        return wConfigDao.deleteWConfig(wConfigDto);
    }

}