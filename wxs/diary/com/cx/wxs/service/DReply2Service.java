package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.DReply2Dto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface DReply2Service {
    /**
    * 通过用户id获取DReply2Dto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public DReply2Dto getDReply2ByID(DReply2Dto dReply2Dto);

    /**
    * 通过相关信息获取DReply2DtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<DReply2Dto> getDReply2List(DReply2Dto dReply2Dto);

    /**
    * 添加一个新的DReply2到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addDReply2(DReply2Dto dReply2Dto);

    /**
    * 更新DReply2
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateDReply2(DReply2Dto dReply2Dto);

    /**
    * 删除DReply2
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteDReply2(DReply2Dto dReply2Dto);

}