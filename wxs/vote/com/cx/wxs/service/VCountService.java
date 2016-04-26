package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.VCountDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface VCountService {
    /**
    * 通过用户id获取VCountDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public VCountDto getVCountByID(VCountDto vCountDto);

    /**
    * 通过相关信息获取VCountDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<VCountDto> getVCountList(VCountDto vCountDto);

    /**
    * 添加一个新的VCount到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addVCount(VCountDto vCountDto);

    /**
    * 更新VCount
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateVCount(VCountDto vCountDto);

    /**
    * 删除VCount
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteVCount(VCountDto vCountDto);

}