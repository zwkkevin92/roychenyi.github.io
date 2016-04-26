package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.BAccessDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface BAccessService {
    /**
    * 通过用户id获取BAccessDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public BAccessDto getBAccessByID(BAccessDto bAccessDto);

    /**
    * 通过相关信息获取BAccessDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<BAccessDto> getBAccessList(BAccessDto bAccessDto);

    /**
    * 添加一个新的BAccess到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addBAccess(BAccessDto bAccessDto);

    /**
    * 更新BAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateBAccess(BAccessDto bAccessDto);

    /**
    * 删除BAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteBAccess(BAccessDto bAccessDto);

}