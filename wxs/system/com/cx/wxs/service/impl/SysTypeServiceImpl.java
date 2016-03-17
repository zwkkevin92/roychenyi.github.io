package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SysTypeDao;
import com.cx.wxs.dto.SysTypeDto;
import com.cx.wxs.service.SysTypeService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("SysTypeService")
public class SysTypeServiceImpl implements SysTypeService {
    @Autowired
    private SysTypeDao sysTypeDao;

    public void setSysTypeDao(SysTypeDao sysTypeDao){
        this.sysTypeDao=sysTypeDao;
    }

    /**
    * 通过用户id获取SysTypeDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SysTypeDto getSysTypeByID(SysTypeDto sysTypeDto){
        return sysTypeDao.getSysTypeByID(sysTypeDto);
    }

    /**
    * 通过相关信息获取SysTypeDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SysTypeDto> getSysTypeList(SysTypeDto sysTypeDto){
        return sysTypeDao.getSysTypeList(sysTypeDto);
    }

    /**
    * 添加一个新的SysType到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSysType(SysTypeDto sysTypeDto){
        return sysTypeDao.addSysType(sysTypeDto);
    }

    /**
    * 更新SysType
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSysType(SysTypeDto sysTypeDto){
        return sysTypeDao.updateSysType(sysTypeDto);
    }

    /**
    * 删除SysType
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSysType(SysTypeDto sysTypeDto){
        return sysTypeDao.deleteSysType(sysTypeDto);
    }

}