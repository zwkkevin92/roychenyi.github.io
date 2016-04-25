package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.IReply2Dto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface IReply2Service {
    /**
    * 通过用户id获取IReply2Dto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public IReply2Dto getIReply2ByID(IReply2Dto iReply2Dto);

    /**
    * 通过相关信息获取IReply2DtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<IReply2Dto> getIReply2List(IReply2Dto iReply2Dto);

    /**
    * 添加一个新的IReply2到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addIReply2(IReply2Dto iReply2Dto);

    /**
    * 更新IReply2
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateIReply2(IReply2Dto iReply2Dto);

    /**
    * 删除IReply2
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteIReply2(IReply2Dto iReply2Dto);

}