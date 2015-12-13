package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.VUpvoteDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface VUpvoteService {
    /**
    * 通过用户id获取VUpvoteDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public VUpvoteDto getVUpvoteByID(VUpvoteDto vUpvoteDto);

    /**
    * 通过相关信息获取VUpvoteDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<VUpvoteDto> getVUpvoteList(VUpvoteDto vUpvoteDto);

    /**
    * 添加一个新的VUpvote到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addVUpvote(VUpvoteDto vUpvoteDto);

    /**
    * 更新VUpvote
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateVUpvote(VUpvoteDto vUpvoteDto);

    /**
    * 删除VUpvote
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteVUpvote(VUpvoteDto vUpvoteDto);

}