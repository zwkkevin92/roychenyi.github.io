package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SysConfigDao;
import com.cx.wxs.dto.SysConfigDto;
import com.cx.wxs.service.SysConfigService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("SysConfigService")
public class SysConfigServiceImpl implements SysConfigService {
    @Autowired
    private SysConfigDao sysConfigDao;

    public void setSysConfigDao(SysConfigDao sysConfigDao){
        this.sysConfigDao=sysConfigDao;
    }

    /**
    * 通过用户id获取SysConfigDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SysConfigDto getSysConfigByID(SysConfigDto sysConfigDto){
        return sysConfigDao.getSysConfigByID(sysConfigDto);
    }

    /**
    * 通过相关信息获取SysConfigDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SysConfigDto> getSysConfigList(SysConfigDto sysConfigDto){
        return sysConfigDao.getSysConfigList(sysConfigDto);
    }

    /**
    * 添加一个新的SysConfig到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSysConfig(SysConfigDto sysConfigDto){
        return sysConfigDao.addSysConfig(sysConfigDto);
    }

    /**
    * 更新SysConfig
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSysConfig(SysConfigDto sysConfigDto){
        return sysConfigDao.updateSysConfig(sysConfigDto);
    }

    /**
    * 删除SysConfig
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSysConfig(SysConfigDto sysConfigDto){
        return sysConfigDao.deleteSysConfig(sysConfigDto);
    }

}