package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SysBlockedIpDao;
import com.cx.wxs.dto.SysBlockedIpDto;
import com.cx.wxs.service.SysBlockedIpService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("SysBlockedIpService")
public class SysBlockedIpServiceImpl implements SysBlockedIpService {
    @Autowired
    private SysBlockedIpDao sysBlockedIpDao;

    public void setSysBlockedIpDao(SysBlockedIpDao sysBlockedIpDao){
        this.sysBlockedIpDao=sysBlockedIpDao;
    }

    /**
    * 通过用户id获取SysBlockedIpDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public SysBlockedIpDto getSysBlockedIpByID(SysBlockedIpDto sysBlockedIpDto){
        return sysBlockedIpDao.getSysBlockedIpByID(sysBlockedIpDto);
    }

    /**
    * 通过相关信息获取SysBlockedIpDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<SysBlockedIpDto> getSysBlockedIpList(SysBlockedIpDto sysBlockedIpDto){
        return sysBlockedIpDao.getSysBlockedIpList(sysBlockedIpDto);
    }

    /**
    * 添加一个新的SysBlockedIp到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addSysBlockedIp(SysBlockedIpDto sysBlockedIpDto){
        return sysBlockedIpDao.addSysBlockedIp(sysBlockedIpDto);
    }

    /**
    * 更新SysBlockedIp
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateSysBlockedIp(SysBlockedIpDto sysBlockedIpDto){
        return sysBlockedIpDao.updateSysBlockedIp(sysBlockedIpDto);
    }

    /**
    * 删除SysBlockedIp
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteSysBlockedIp(SysBlockedIpDto sysBlockedIpDto){
        return sysBlockedIpDao.deleteSysBlockedIp(sysBlockedIpDto);
    }

}