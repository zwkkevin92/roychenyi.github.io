package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.MReplyDto;
import com.cx.wxs.po.MReply;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface MReplyDao extends IBaseDao<MReply,Integer>{
    /**
    * 通过id获取MReplyDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public MReplyDto getMReplyByID(MReplyDto mReplyDto);

    /**
    * 通过相关数据获取MReplyDtoList
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