package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.BSiteDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface BSiteService {
    /**
    * 通过用户id获取BSiteDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public BSiteDto getBSiteByID(BSiteDto bSiteDto);

    /**
    * 通过相关信息获取BSiteDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<BSiteDto> getBSiteList(BSiteDto bSiteDto);

    /**
    * 添加一个新的BSite到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addBSite(BSiteDto bSiteDto);

    /**
    * 更新BSite
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateBSite(BSiteDto bSiteDto);

    /**
    * 删除BSite
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteBSite(BSiteDto bSiteDto);

}