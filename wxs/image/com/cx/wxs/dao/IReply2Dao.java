package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.IReply2Dto;
import com.cx.wxs.po.IReply2;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface IReply2Dao extends IBaseDao<IReply2,Integer>{
    /**
    * 通过id获取IReply2Dto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public IReply2Dto getIReply2ByID(IReply2Dto iReply2Dto);

    /**
    * 通过相关数据获取IReply2DtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<IReply2Dto> getIReply2List(IReply2Dto iReply2Dto);

    /**
    * 添加一个新的IReply2到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addIReply2(IReply2Dto iReply2Dto);

    /**
    * 更新IReply2
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateIReply2(IReply2Dto iReply2Dto);

    /**
    * 删除IReply2
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteIReply2(IReply2Dto iReply2Dto);

}