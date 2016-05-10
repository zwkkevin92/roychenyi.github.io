package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.SysStyleDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface SysStyleService {
    /**
    * 通过用户id获取SysStyleDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysStyleDto getSysStyleByID(SysStyleDto sysStyleDto);

    /**
    * 通过相关信息获取SysStyleDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SysStyleDto> getSysStyleList(SysStyleDto sysStyleDto);

    /**
    * 添加一个新的SysStyle到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSysStyle(SysStyleDto sysStyleDto);

    /**
    * 更新SysStyle
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSysStyle(SysStyleDto sysStyleDto);

    /**
    * 删除SysStyle
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSysStyle(SysStyleDto sysStyleDto);

}