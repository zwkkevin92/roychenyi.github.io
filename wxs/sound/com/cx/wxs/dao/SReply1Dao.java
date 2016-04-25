package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SReply1Dto;
import com.cx.wxs.po.SReply1;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SReply1Dao extends IBaseDao<SReply1,Integer>{
    /**
    * 通过id获取SReply1Dto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SReply1Dto getSReply1ByID(SReply1Dto sReply1Dto);

    /**
    * 通过相关数据获取SReply1DtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SReply1Dto> getSReply1List(SReply1Dto sReply1Dto);

    /**
    * 添加一个新的SReply1到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSReply1(SReply1Dto sReply1Dto);

    /**
    * 更新SReply1
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSReply1(SReply1Dto sReply1Dto);

    /**
    * 删除SReply1
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSReply1(SReply1Dto sReply1Dto);

}