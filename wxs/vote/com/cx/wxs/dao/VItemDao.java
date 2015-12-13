package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.VItemDto;
import com.cx.wxs.po.VItem;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface VItemDao extends IBaseDao<VItem,Integer>{
    /**
    * 通过id获取VItemDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public VItemDto getVItemByID(VItemDto vItemDto);

    /**
    * 通过相关数据获取VItemDtoList
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