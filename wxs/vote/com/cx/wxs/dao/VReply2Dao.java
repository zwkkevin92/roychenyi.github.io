package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.VReply2Dto;
import com.cx.wxs.po.VReply2;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface VReply2Dao extends IBaseDao<VReply2,Integer>{
    /**
    * 通过id获取VReply2Dto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public VReply2Dto getVReply2ByID(VReply2Dto vReply2Dto);

    /**
    * 通过相关数据获取VReply2DtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<VReply2Dto> getVReply2List(VReply2Dto vReply2Dto);

    /**
    * 添加一个新的VReply2到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addVReply2(VReply2Dto vReply2Dto);

    /**
    * 更新VReply2
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateVReply2(VReply2Dto vReply2Dto);

    /**
    * 删除VReply2
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteVReply2(VReply2Dto vReply2Dto);

}