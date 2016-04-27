package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SysIllegalDto;
import com.cx.wxs.po.SysIllegal;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2016-03-24 21:47:22
 */
public interface SysIllegalDao extends IBaseDao<SysIllegal,Integer>{
    /**
    * 通过id获取SysIllegalDto
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    public SysIllegalDto getSysIllegalByID(SysIllegalDto sysIllegalDto);
    /***
     * 通过敏感词查询到敏感词信息
     * @param sysIllegalDto
     * @return
     * @author 陈义
     * @date   2016-3-25上午10:41:00
     */
    public SysIllegalDto getSysIllegal(SysIllegalDto sysIllegalDto);

    /**
    * 通过相关数据获取SysIllegalDtoList
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    public List<SysIllegalDto> getSysIllegalList(SysIllegalDto sysIllegalDto);

    /**
    * 添加一个新的SysIllegal到数据库
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    public Integer addSysIllegal(SysIllegalDto sysIllegalDto);

    /**
    * 更新SysIllegal
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    public Integer updateSysIllegal(SysIllegalDto sysIllegalDto);

    /**
    * 删除SysIllegal
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    public Integer deleteSysIllegal(SysIllegalDto sysIllegalDto);

}