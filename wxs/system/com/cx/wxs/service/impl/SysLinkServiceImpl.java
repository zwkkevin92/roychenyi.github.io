package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SysLinkDao;
import com.cx.wxs.dto.SysLinkDto;
import com.cx.wxs.service.SysLinkService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("SysLinkService")
public class SysLinkServiceImpl implements SysLinkService {
    @Autowired
    private SysLinkDao sysLinkDao;

    public void setSysLinkDao(SysLinkDao sysLinkDao){
        this.sysLinkDao=sysLinkDao;
    }

    /**
    * 通过用户id获取SysLinkDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public SysLinkDto getSysLinkByID(SysLinkDto sysLinkDto){
        return sysLinkDao.getSysLinkByID(sysLinkDto);
    }

    /**
    * 通过相关信息获取SysLinkDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<SysLinkDto> getSysLinkList(SysLinkDto sysLinkDto){
        return sysLinkDao.getSysLinkList(sysLinkDto);
    }

    /**
    * 添加一个新的SysLink到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addSysLink(SysLinkDto sysLinkDto){
        return sysLinkDao.addSysLink(sysLinkDto);
    }

    /**
    * 更新SysLink
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateSysLink(SysLinkDto sysLinkDto){
        return sysLinkDao.updateSysLink(sysLinkDto);
    }

    /**
    * 删除SysLink
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteSysLink(SysLinkDto sysLinkDto){
        return sysLinkDao.deleteSysLink(sysLinkDto);
    }

}