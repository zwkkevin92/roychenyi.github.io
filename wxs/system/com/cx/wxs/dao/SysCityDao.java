package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SysCityDto;
import com.cx.wxs.po.SysCity;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SysCityDao extends IBaseDao<SysCity,Integer>{
    /**
    * 通过id获取SysCityDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysCityDto getSysCityByID(SysCityDto sysCityDto);

    /**
    * 通过相关数据获取SysCityDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SysCityDto> getSysCityList(SysCityDto sysCityDto);

    /**
    * 添加一个新的SysCity到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSysCity(SysCityDto sysCityDto);

    /**
    * 更新SysCity
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSysCity(SysCityDto sysCityDto);

    /**
    * 删除SysCity
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSysCity(SysCityDto sysCityDto);

}