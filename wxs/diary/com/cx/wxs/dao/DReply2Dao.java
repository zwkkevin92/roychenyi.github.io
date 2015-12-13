package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.DReply2Dto;
import com.cx.wxs.po.DReply2;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface DReply2Dao extends IBaseDao<DReply2,Integer>{
    /**
    * 通过id获取DReply2Dto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public DReply2Dto getDReply2ByID(DReply2Dto dReply2Dto);

    /**
    * 通过相关数据获取DReply2DtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<DReply2Dto> getDReply2List(DReply2Dto dReply2Dto);

    /**
    * 添加一个新的DReply2到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addDReply2(DReply2Dto dReply2Dto);

    /**
    * 更新DReply2
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateDReply2(DReply2Dto dReply2Dto);

    /**
    * 删除DReply2
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteDReply2(DReply2Dto dReply2Dto);

}