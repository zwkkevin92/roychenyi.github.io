package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.SysCollegeDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface SysCollegeService {
    /**
    * 通过用户id获取SysCollegeDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysCollegeDto getSysCollegeByID(SysCollegeDto sysCollegeDto);

    /**
    * 通过相关信息获取SysCollegeDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SysCollegeDto> getSysCollegeList(SysCollegeDto sysCollegeDto);

    /**
    * 添加一个新的SysCollege到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSysCollege(SysCollegeDto sysCollegeDto);

    /**
    * 更新SysCollege
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSysCollege(SysCollegeDto sysCollegeDto);

    /**
    * 删除SysCollege
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSysCollege(SysCollegeDto sysCollegeDto);

}