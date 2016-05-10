package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SysSchoolDto;
import com.cx.wxs.po.SysSchool;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SysSchoolDao extends IBaseDao<SysSchool,Integer>{
    /**
    * 通过id获取SysSchoolDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysSchoolDto getSysSchoolByID(SysSchoolDto sysSchoolDto);

    /**
    * 通过相关数据获取SysSchoolDtoList
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