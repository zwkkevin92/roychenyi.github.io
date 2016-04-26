package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.VItemDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface VItemService {
    /**
    * 通过用户id获取VItemDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public VItemDto getVItemByID(VItemDto vItemDto);

    /**
    * 通过相关信息获取VItemDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<VItemDto> getVItemList(VItemDto vItemDto);

    /**
    * 添加一个新的VItem到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addVItem(VItemDto vItemDto);

    /**
    * 更新VItem
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateVItem(VItemDto vItemDto);

    /**
    * 删除VItem
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteVItem(VItemDto vItemDto);

}