package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.IReply1Dto;
import com.cx.wxs.po.IReply1;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface IReply1Dao extends IBaseDao<IReply1,Integer>{
    /**
    * 通过id获取IReply1Dto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public IReply1Dto getIReply1ByID(IReply1Dto iReply1Dto);

    /**
    * 通过相关数据获取IReply1DtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<IReply1Dto> getIReply1List(IReply1Dto iReply1Dto);

    /**
    * 添加一个新的IReply1到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addIReply1(IReply1Dto iReply1Dto);

    /**
    * 更新IReply1
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateIReply1(IReply1Dto iReply1Dto);

    /**
    * 删除IReply1
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteIReply1(IReply1Dto iReply1Dto);

}