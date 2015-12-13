package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SysRoleDao;
import com.cx.wxs.dto.SysRoleDto;
import com.cx.wxs.service.SysRoleService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("SysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;

    public void setSysRoleDao(SysRoleDao sysRoleDao){
        this.sysRoleDao=sysRoleDao;
    }

    /**
    * 通过用户id获取SysRoleDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public SysRoleDto getSysRoleByID(SysRoleDto sysRoleDto){
        return sysRoleDao.getSysRoleByID(sysRoleDto);
    }

    /**
    * 通过相关信息获取SysRoleDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<SysRoleDto> getSysRoleList(SysRoleDto sysRoleDto){
        return sysRoleDao.getSysRoleList(sysRoleDto);
    }

    /**
    * 添加一个新的SysRole到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addSysRole(SysRoleDto sysRoleDto){
        return sysRoleDao.addSysRole(sysRoleDto);
    }

    /**
    * 更新SysRole
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateSysRole(SysRoleDto sysRoleDto){
        return sysRoleDao.updateSysRole(sysRoleDto);
    }

    /**
    * 删除SysRole
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteSysRole(SysRoleDto sysRoleDto){
        return sysRoleDao.deleteSysRole(sysRoleDto);
    }

}