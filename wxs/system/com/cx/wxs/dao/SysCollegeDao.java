package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SysCollegeDto;
import com.cx.wxs.po.SysCollege;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SysCollegeDao extends IBaseDao<SysCollege,Integer>{
    /**
    * 通过id获取SysCollegeDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysCollegeDto getSysCollegeByID(SysCollegeDto sysCollegeDto);

    /**
    * 通过相关数据获取SysCollegeDtoList
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