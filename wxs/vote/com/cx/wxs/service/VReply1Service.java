package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.VReply1Dto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface VReply1Service {
    /**
    * 通过用户id获取VReply1Dto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public VReply1Dto getVReply1ByID(VReply1Dto vReply1Dto);

    /**
    * 通过相关信息获取VReply1DtoList信息
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