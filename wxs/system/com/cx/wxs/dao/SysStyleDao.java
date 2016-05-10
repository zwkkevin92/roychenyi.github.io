package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SysStyleDto;
import com.cx.wxs.po.SysStyle;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SysStyleDao extends IBaseDao<SysStyle,Integer>{
    /**
    * 通过id获取SysStyleDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysStyleDto getSysStyleByID(SysStyleDto sysStyleDto);

    /**
    * 通过相关数据获取SysStyleDtoList
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