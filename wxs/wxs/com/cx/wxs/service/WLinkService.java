package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.WLinkDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface WLinkService {
    /**
    * 通过用户id获取WLinkDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public WLinkDto getWLinkByID(WLinkDto wLinkDto);

    /**
    * 通过相关信息获取WLinkDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<WLinkDto> getWLinkList(WLinkDto wLinkDto);

    /**
    * 添加一个新的WLink到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addWLink(WLinkDto wLinkDto);

    /**
    * 更新WLink
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateWLink(WLinkDto wLinkDto);

    /**
    * 删除WLink
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteWLink(WLinkDto wLinkDto);

}