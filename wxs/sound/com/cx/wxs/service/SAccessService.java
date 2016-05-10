package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.SAccessDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface SAccessService {
    /**
    * 通过用户id获取SAccessDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SAccessDto getSAccessByID(SAccessDto sAccessDto);

    /**
    * 通过相关信息获取SAccessDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SAccessDto> getSAccessList(SAccessDto sAccessDto);

    /**
    * 添加一个新的SAccess到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSAccess(SAccessDto sAccessDto);

    /**
    * 更新SAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSAccess(SAccessDto sAccessDto);

    /**
    * 删除SAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSAccess(SAccessDto sAccessDto);

}