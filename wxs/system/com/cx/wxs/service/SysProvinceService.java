package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.SysProvinceDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface SysProvinceService {
    /**
    * 通过用户id获取SysProvinceDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysProvinceDto getSysProvinceByID(SysProvinceDto sysProvinceDto);

    /**
    * 通过相关信息获取SysProvinceDtoList信息
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