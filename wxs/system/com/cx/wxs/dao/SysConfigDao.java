package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SysConfigDto;
import com.cx.wxs.po.SysConfig;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SysConfigDao extends IBaseDao<SysConfig,Integer>{
    /**
    * 通过id获取SysConfigDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysConfigDto getSysConfigByID(SysConfigDto sysConfigDto);

    /**
    * 通过相关数据获取SysConfigDtoList
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