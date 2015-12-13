package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.WAccessDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface WAccessService {
    /**
    * 通过用户id获取WAccessDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public WAccessDto getWAccessByID(WAccessDto wAccessDto);

    /**
    * 通过相关信息获取WAccessDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<WAccessDto> getWAccessList(WAccessDto wAccessDto);

    /**
    * 添加一个新的WAccess到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addWAccess(WAccessDto wAccessDto);

    /**
    * 更新WAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateWAccess(WAccessDto wAccessDto);

    /**
    * 删除WAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteWAccess(WAccessDto wAccessDto);

}