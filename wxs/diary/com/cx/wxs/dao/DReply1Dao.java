package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.DReply1Dto;
import com.cx.wxs.po.DReply1;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface DReply1Dao extends IBaseDao<DReply1,Integer>{
    /**
    * 通过id获取DReply1Dto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public DReply1Dto getDReply1ByID(DReply1Dto dReply1Dto);

    /**
    * 通过相关数据获取DReply1DtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<DReply1Dto> getDReply1List(DReply1Dto dReply1Dto);

    /**
    * 添加一个新的DReply1到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addDReply1(DReply1Dto dReply1Dto);

    /**
    * 更新DReply1
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateDReply1(DReply1Dto dReply1Dto);

    /**
    * 删除DReply1
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteDReply1(DReply1Dto dReply1Dto);
    /**
     * 获取评论计数
     * @param dReply1Dto
     * @return
     * @author 陈义
     * @date   2016-5-4上午10:38:24
     */
    public Integer getDReply1Count(DReply1Dto dReply1Dto);

}