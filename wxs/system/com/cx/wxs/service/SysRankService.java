package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.SysRankDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface SysRankService {
    /**
    * 通过用户id获取SysRankDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysRankDto getSysRankByID(SysRankDto sysRankDto);

    /**
    * 通过相关信息获取SysRankDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SysRankDto> getSysRankList(SysRankDto sysRankDto);

    /**
    * 添加一个新的SysRank到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSysRank(SysRankDto sysRankDto);

    /**
    * 更新SysRank
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSysRank(SysRankDto sysRankDto);

    /**
    * 删除SysRank
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSysRank(SysRankDto sysRankDto);

}