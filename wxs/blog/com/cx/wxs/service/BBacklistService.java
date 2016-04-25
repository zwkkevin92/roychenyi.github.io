package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.BBacklistDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface BBacklistService {
    /**
    * 通过用户id获取BBacklistDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public BBacklistDto getBBacklistByID(BBacklistDto bBacklistDto);

    /**
    * 通过相关信息获取BBacklistDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<BBacklistDto> getBBacklistList(BBacklistDto bBacklistDto);

    /**
    * 添加一个新的BBacklist到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addBBacklist(BBacklistDto bBacklistDto);

    /**
    * 更新BBacklist
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateBBacklist(BBacklistDto bBacklistDto);

    /**
    * 删除BBacklist
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteBBacklist(BBacklistDto bBacklistDto);

}