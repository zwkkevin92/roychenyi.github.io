package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SysSchoolDao;
import com.cx.wxs.dto.SysSchoolDto;
import com.cx.wxs.service.SysSchoolService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("SysSchoolService")
public class SysSchoolServiceImpl implements SysSchoolService {
    @Autowired
    private SysSchoolDao sysSchoolDao;

    public void setSysSchoolDao(SysSchoolDao sysSchoolDao){
        this.sysSchoolDao=sysSchoolDao;
    }

    /**
    * 通过用户id获取SysSchoolDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public SysSchoolDto getSysSchoolByID(SysSchoolDto sysSchoolDto){
        return sysSchoolDao.getSysSchoolByID(sysSchoolDto);
    }

    /**
    * 通过相关信息获取SysSchoolDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<SysSchoolDto> getSysSchoolList(SysSchoolDto sysSchoolDto){
        return sysSchoolDao.getSysSchoolList(sysSchoolDto);
    }

    /**
    * 添加一个新的SysSchool到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addSysSchool(SysSchoolDto sysSchoolDto){
        return sysSchoolDao.addSysSchool(sysSchoolDto);
    }

    /**
    * 更新SysSchool
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateSysSchool(SysSchoolDto sysSchoolDto){
        return sysSchoolDao.updateSysSchool(sysSchoolDto);
    }

    /**
    * 删除SysSchool
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteSysSchool(SysSchoolDto sysSchoolDto){
        return sysSchoolDao.deleteSysSchool(sysSchoolDto);
    }

}