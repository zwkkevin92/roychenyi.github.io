package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.BConfigDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface BConfigService {
    /**
    * 通过用户id获取BConfigDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public BConfigDto getBConfigByID(BConfigDto bConfigDto);
    /**
     * 通过用户的configkey和siteId获取用户的信息
     * @param bConfigDto
     * @return
     * @author 陈义
     * @date   2016-4-9下午2:44:57
     */
    public BConfigDto getBConfig(BConfigDto bConfigDto);

    /**
    * 通过相关信息获取BConfigDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<BConfigDto> getBConfigList(BConfigDto bConfigDto);

    /**
    * 添加一个新的BConfig到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addBConfig(BConfigDto bConfigDto);

    /**
    * 更新BConfig
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateBConfig(BConfigDto bConfigDto);

    /**
    * 删除BConfig
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteBConfig(BConfigDto bConfigDto);

}