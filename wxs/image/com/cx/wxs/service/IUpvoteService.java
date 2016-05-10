package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.IUpvoteDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface IUpvoteService {
    /**
    * 通过用户id获取IUpvoteDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public IUpvoteDto getIUpvoteByID(IUpvoteDto iUpvoteDto);

    /**
    * 通过相关信息获取IUpvoteDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<IUpvoteDto> getIUpvoteList(IUpvoteDto iUpvoteDto);

    /**
    * 添加一个新的IUpvote到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addIUpvote(IUpvoteDto iUpvoteDto);

    /**
    * 更新IUpvote
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateIUpvote(IUpvoteDto iUpvoteDto);

    /**
    * 删除IUpvote
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteIUpvote(IUpvoteDto iUpvoteDto);

}