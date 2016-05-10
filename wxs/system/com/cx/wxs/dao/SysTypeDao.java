package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SysTypeDto;
import com.cx.wxs.po.SysType;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SysTypeDao extends IBaseDao<SysType,Integer>{
    /**
    * 通过id获取SysTypeDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysTypeDto getSysTypeByID(SysTypeDto sysTypeDto);

    /**
    * 通过相关数据获取SysTypeDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SysTypeDto> getSysTypeList(SysTypeDto sysTypeDto);

    /**
    * 添加一个新的SysType到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSysType(SysTypeDto sysTypeDto);

    /**
    * 更新SysType
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSysType(SysTypeDto sysTypeDto);

    /**
    * 删除SysType
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSysType(SysTypeDto sysTypeDto);

}