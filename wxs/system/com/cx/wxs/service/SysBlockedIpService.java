package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.SysBlockedIpDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface SysBlockedIpService {
    /**
    * 通过用户id获取SysBlockedIpDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysBlockedIpDto getSysBlockedIpByID(SysBlockedIpDto sysBlockedIpDto);

    /**
    * 通过相关信息获取SysBlockedIpDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SysBlockedIpDto> getSysBlockedIpList(SysBlockedIpDto sysBlockedIpDto);

    /**
    * 添加一个新的SysBlockedIp到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSysBlockedIp(SysBlockedIpDto sysBlockedIpDto);

    /**
    * 更新SysBlockedIp
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSysBlockedIp(SysBlockedIpDto sysBlockedIpDto);

    /**
    * 删除SysBlockedIp
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSysBlockedIp(SysBlockedIpDto sysBlockedIpDto);

}