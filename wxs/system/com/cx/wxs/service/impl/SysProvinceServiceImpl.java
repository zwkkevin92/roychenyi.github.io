package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SysProvinceDao;
import com.cx.wxs.dto.SysProvinceDto;
import com.cx.wxs.service.SysProvinceService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("SysProvinceService")
public class SysProvinceServiceImpl implements SysProvinceService {
    @Autowired
    private SysProvinceDao sysProvinceDao;

    public void setSysProvinceDao(SysProvinceDao sysProvinceDao){
        this.sysProvinceDao=sysProvinceDao;
    }

    /**
    * 通过用户id获取SysProvinceDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SysProvinceDto getSysProvinceByID(SysProvinceDto sysProvinceDto){
        return sysProvinceDao.getSysProvinceByID(sysProvinceDto);
    }

    /**
    * 通过相关信息获取SysProvinceDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SysProvinceDto> getSysProvinceList(SysProvinceDto sysProvinceDto){
        return sysProvinceDao.getSysProvinceList(sysProvinceDto);
    }

    /**
    * 添加一个新的SysProvince到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSysProvince(SysProvinceDto sysProvinceDto){
        return sysProvinceDao.addSysProvince(sysProvinceDto);
    }

    /**
    * 更新SysProvince
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSysProvince(SysProvinceDto sysProvinceDto){
        return sysProvinceDao.updateSysProvince(sysProvinceDto);
    }

    /**
    * 删除SysProvince
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSysProvince(SysProvinceDto sysProvinceDto){
        return sysProvinceDao.deleteSysProvince(sysProvinceDto);
    }

}