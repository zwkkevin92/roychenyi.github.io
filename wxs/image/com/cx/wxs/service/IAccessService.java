package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.IAccessDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface IAccessService {
    /**
    * 通过用户id获取IAccessDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public IAccessDto getIAccessByID(IAccessDto iAccessDto);

    /**
    * 通过相关信息获取IAccessDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<IAccessDto> getIAccessList(IAccessDto iAccessDto);

    /**
    * 添加一个新的IAccess到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addIAccess(IAccessDto iAccessDto);

    /**
    * 更新IAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateIAccess(IAccessDto iAccessDto);

    /**
    * 删除IAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteIAccess(IAccessDto iAccessDto);

}