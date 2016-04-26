package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.WStatusDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface WStatusService {
    /**
    * 通过用户id获取WStatusDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public WStatusDto getWStatusByID(WStatusDto wStatusDto);

    /**
    * 通过相关信息获取WStatusDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<WStatusDto> getWStatusList(WStatusDto wStatusDto);

    /**
    * 添加一个新的WStatus到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addWStatus(WStatusDto wStatusDto);

    /**
    * 更新WStatus
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateWStatus(WStatusDto wStatusDto);

    /**
    * 删除WStatus
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteWStatus(WStatusDto wStatusDto);

}