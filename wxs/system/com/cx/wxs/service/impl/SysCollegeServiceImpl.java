package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SysCollegeDao;
import com.cx.wxs.dto.SysCollegeDto;
import com.cx.wxs.service.SysCollegeService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("SysCollegeService")
public class SysCollegeServiceImpl implements SysCollegeService {
    @Autowired
    private SysCollegeDao sysCollegeDao;

    public void setSysCollegeDao(SysCollegeDao sysCollegeDao){
        this.sysCollegeDao=sysCollegeDao;
    }

    /**
    * 通过用户id获取SysCollegeDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public SysCollegeDto getSysCollegeByID(SysCollegeDto sysCollegeDto){
        return sysCollegeDao.getSysCollegeByID(sysCollegeDto);
    }

    /**
    * 通过相关信息获取SysCollegeDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<SysCollegeDto> getSysCollegeList(SysCollegeDto sysCollegeDto){
        return sysCollegeDao.getSysCollegeList(sysCollegeDto);
    }

    /**
    * 添加一个新的SysCollege到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addSysCollege(SysCollegeDto sysCollegeDto){
        return sysCollegeDao.addSysCollege(sysCollegeDto);
    }

    /**
    * 更新SysCollege
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateSysCollege(SysCollegeDto sysCollegeDto){
        return sysCollegeDao.updateSysCollege(sysCollegeDto);
    }

    /**
    * 删除SysCollege
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteSysCollege(SysCollegeDto sysCollegeDto){
        return sysCollegeDao.deleteSysCollege(sysCollegeDto);
    }

}