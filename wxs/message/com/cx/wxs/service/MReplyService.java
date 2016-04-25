package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.MReplyDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface MReplyService {
    /**
    * 通过用户id获取MReplyDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public MReplyDto getMReplyByID(MReplyDto mReplyDto);

    /**
    * 通过相关信息获取MReplyDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<MReplyDto> getMReplyList(MReplyDto mReplyDto);

    /**
    * 添加一个新的MReply到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addMReply(MReplyDto mReplyDto);

    /**
    * 更新MReply
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateMReply(MReplyDto mReplyDto);

    /**
    * 删除MReply
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteMReply(MReplyDto mReplyDto);

}