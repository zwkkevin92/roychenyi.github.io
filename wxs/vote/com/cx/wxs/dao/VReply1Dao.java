package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.VReply1Dto;
import com.cx.wxs.po.VReply1;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface VReply1Dao extends IBaseDao<VReply1,Integer>{
    /**
    * 通过id获取VReply1Dto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public VReply1Dto getVReply1ByID(VReply1Dto vReply1Dto);

    /**
    * 通过相关数据获取VReply1DtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<VReply1Dto> getVReply1List(VReply1Dto vReply1Dto);

    /**
    * 添加一个新的VReply1到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addVReply1(VReply1Dto vReply1Dto);

    /**
    * 更新VReply1
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateVReply1(VReply1Dto vReply1Dto);

    /**
    * 删除VReply1
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteVReply1(VReply1Dto vReply1Dto);

}