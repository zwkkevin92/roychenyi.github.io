package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SysCityDao;
import com.cx.wxs.dto.SysCityDto;
import com.cx.wxs.service.SysCityService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("SysCityService")
public class SysCityServiceImpl implements SysCityService {
    @Autowired
    private SysCityDao sysCityDao;

    public void setSysCityDao(SysCityDao sysCityDao){
        this.sysCityDao=sysCityDao;
    }

    /**
    * 通过用户id获取SysCityDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SysCityDto getSysCityByID(SysCityDto sysCityDto){
        return sysCityDao.getSysCityByID(sysCityDto);
    }

    /**
    * 通过相关信息获取SysCityDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SysCityDto> getSysCityList(SysCityDto sysCityDto){
        return sysCityDao.getSysCityList(sysCityDto);
    }

    /**
    * 添加一个新的SysCity到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSysCity(SysCityDto sysCityDto){
        return sysCityDao.addSysCity(sysCityDto);
    }

    /**
    * 更新SysCity
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSysCity(SysCityDto sysCityDto){
        return sysCityDao.updateSysCity(sysCityDto);
    }

    /**
    * 删除SysCity
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSysCity(SysCityDto sysCityDto){
        return sysCityDao.deleteSysCity(sysCityDto);
    }

}