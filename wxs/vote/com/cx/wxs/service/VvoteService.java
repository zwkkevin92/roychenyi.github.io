package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.VVoteDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface VVoteService {
    /**
    * 通过用户id获取VVoteDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public VVoteDto getVVoteByID(VVoteDto vVoteDto);

    /**
    * 通过相关信息获取VVoteDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<VVoteDto> getVVoteList(VVoteDto vVoteDto);

    /**
    * 添加一个新的VVote到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addVVote(VVoteDto vVoteDto);

    /**
    * 更新VVote
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateVVote(VVoteDto vVoteDto);

    /**
    * 删除VVote
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteVVote(VVoteDto vVoteDto);

}