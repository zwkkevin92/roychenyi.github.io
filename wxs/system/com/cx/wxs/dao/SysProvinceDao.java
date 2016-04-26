package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SysProvinceDto;
import com.cx.wxs.po.SysProvince;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SysProvinceDao extends IBaseDao<SysProvince,Integer>{
    /**
    * 通过id获取SysProvinceDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysProvinceDto getSysProvinceByID(SysProvinceDto sysProvinceDto);

    /**
    * 通过相关数据获取SysProvinceDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SysProvinceDto> getSysProvinceList(SysProvinceDto sysProvinceDto);

    /**
    * 添加一个新的SysProvince到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSysProvince(SysProvinceDto sysProvinceDto);

    /**
    * 更新SysProvince
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSysProvince(SysProvinceDto sysProvinceDto);

    /**
    * 删除SysProvince
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSysProvince(SysProvinceDto sysProvinceDto);

}