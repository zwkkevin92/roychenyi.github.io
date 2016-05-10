package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.SysSchoolDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface SysSchoolService {
    /**
    * 通过用户id获取SysSchoolDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysSchoolDto getSysSchoolByID(SysSchoolDto sysSchoolDto);

    /**
    * 通过相关信息获取SysSchoolDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SysSchoolDto> getSysSchoolList(SysSchoolDto sysSchoolDto);

    /**
    * 添加一个新的SysSchool到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSysSchool(SysSchoolDto sysSchoolDto);

    /**
    * 更新SysSchool
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSysSchool(SysSchoolDto sysSchoolDto);

    /**
    * 删除SysSchool
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSysSchool(SysSchoolDto sysSchoolDto);

}