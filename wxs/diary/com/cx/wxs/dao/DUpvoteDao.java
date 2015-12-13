package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.DUpvoteDto;
import com.cx.wxs.po.DUpvote;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface DUpvoteDao extends IBaseDao<DUpvote,Integer>{
    /**
    * 通过id获取DUpvoteDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public DUpvoteDto getDUpvoteByID(DUpvoteDto dUpvoteDto);

    /**
    * 通过相关数据获取DUpvoteDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<DUpvoteDto> getDUpvoteList(DUpvoteDto dUpvoteDto);

    /**
    * 添加一个新的DUpvote到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addDUpvote(DUpvoteDto dUpvoteDto);

    /**
    * 更新DUpvote
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateDUpvote(DUpvoteDto dUpvoteDto);

    /**
    * 删除DUpvote
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteDUpvote(DUpvoteDto dUpvoteDto);

}