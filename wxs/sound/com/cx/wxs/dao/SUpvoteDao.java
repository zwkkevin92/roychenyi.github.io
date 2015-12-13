package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SUpvoteDto;
import com.cx.wxs.po.SUpvote;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SUpvoteDao extends IBaseDao<SUpvote,Integer>{
    /**
    * 通过id获取SUpvoteDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SUpvoteDto getSUpvoteByID(SUpvoteDto sUpvoteDto);

    /**
    * 通过相关数据获取SUpvoteDtoList
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