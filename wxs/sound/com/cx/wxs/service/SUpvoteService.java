package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.SUpvoteDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface SUpvoteService {
    /**
    * 通过用户id获取SUpvoteDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SUpvoteDto getSUpvoteByID(SUpvoteDto sUpvoteDto);

    /**
    * 通过相关信息获取SUpvoteDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SUpvoteDto> getSUpvoteList(SUpvoteDto sUpvoteDto);

    /**
    * 添加一个新的SUpvote到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSUpvote(SUpvoteDto sUpvoteDto);

    /**
    * 更新SUpvote
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSUpvote(SUpvoteDto sUpvoteDto);

    /**
    * 删除SUpvote
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSUpvote(SUpvoteDto sUpvoteDto);

}