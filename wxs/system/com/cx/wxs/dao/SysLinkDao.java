package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SysLinkDto;
import com.cx.wxs.po.SysLink;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SysLinkDao extends IBaseDao<SysLink,Integer>{
    /**
    * 通过id获取SysLinkDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysLinkDto getSysLinkByID(SysLinkDto sysLinkDto);

    /**
    * 通过相关数据获取SysLinkDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SysLinkDto> getSysLinkList(SysLinkDto sysLinkDto);

    /**
    * 添加一个新的SysLink到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSysLink(SysLinkDto sysLinkDto);

    /**
    * 更新SysLink
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSysLink(SysLinkDto sysLinkDto);

    /**
    * 删除SysLink
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSysLink(SysLinkDto sysLinkDto);

}