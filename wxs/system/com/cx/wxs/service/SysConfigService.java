package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.SysConfigDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface SysConfigService {
    /**
    * 通过用户id获取SysConfigDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysConfigDto getSysConfigByID(SysConfigDto sysConfigDto);

    /**
    * 通过相关信息获取SysConfigDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SysConfigDto> getSysConfigList(SysConfigDto sysConfigDto);

    /**
    * 添加一个新的SysConfig到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSysConfig(SysConfigDto sysConfigDto);

    /**
    * 更新SysConfig
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSysConfig(SysConfigDto sysConfigDto);

    /**
    * 删除SysConfig
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSysConfig(SysConfigDto sysConfigDto);

}