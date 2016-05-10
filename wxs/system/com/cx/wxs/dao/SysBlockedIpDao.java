package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SysBlockedIpDto;
import com.cx.wxs.po.SysBlockedIp;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SysBlockedIpDao extends IBaseDao<SysBlockedIp,Integer>{
    /**
    * 通过id获取SysBlockedIpDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysBlockedIpDto getSysBlockedIpByID(SysBlockedIpDto sysBlockedIpDto);

    /**
    * 通过相关数据获取SysBlockedIpDtoList
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