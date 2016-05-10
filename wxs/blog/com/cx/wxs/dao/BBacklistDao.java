package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.BBacklistDto;
import com.cx.wxs.po.BBacklist;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface BBacklistDao extends IBaseDao<BBacklist,Integer>{
    /**
    * 通过id获取BBacklistDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public BBacklistDto getBBacklistByID(BBacklistDto bBacklistDto);

    /**
    * 通过相关数据获取BBacklistDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<BBacklistDto> getBBacklistList(BBacklistDto bBacklistDto);

    /**
    * 添加一个新的BBacklist到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addBBacklist(BBacklistDto bBacklistDto);

    /**
    * 更新BBacklist
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateBBacklist(BBacklistDto bBacklistDto);

    /**
    * 删除BBacklist
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteBBacklist(BBacklistDto bBacklistDto);

}