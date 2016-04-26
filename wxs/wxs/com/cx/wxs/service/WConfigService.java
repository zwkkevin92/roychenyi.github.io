package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.WConfigDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface WConfigService {
    /**
    * 通过用户id获取WConfigDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public WConfigDto getWConfigByID(WConfigDto wConfigDto);

    /**
    * 通过相关信息获取WConfigDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<WConfigDto> getWConfigList(WConfigDto wConfigDto);

    /**
    * 添加一个新的WConfig到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addWConfig(WConfigDto wConfigDto);

    /**
    * 更新WConfig
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateWConfig(WConfigDto wConfigDto);

    /**
    * 删除WConfig
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteWConfig(WConfigDto wConfigDto);

}