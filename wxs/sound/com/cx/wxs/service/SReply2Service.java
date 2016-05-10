package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.SReply2Dto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface SReply2Service {
    /**
    * 通过用户id获取SReply2Dto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SReply2Dto getSReply2ByID(SReply2Dto sReply2Dto);

    /**
    * 通过相关信息获取SReply2DtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SReply2Dto> getSReply2List(SReply2Dto sReply2Dto);

    /**
    * 添加一个新的SReply2到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSReply2(SReply2Dto sReply2Dto);

    /**
    * 更新SReply2
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSReply2(SReply2Dto sReply2Dto);

    /**
    * 删除SReply2
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSReply2(SReply2Dto sReply2Dto);

}