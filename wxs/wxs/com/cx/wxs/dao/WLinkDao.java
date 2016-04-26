package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.WLinkDto;
import com.cx.wxs.po.WLink;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface WLinkDao extends IBaseDao<WLink,Integer>{
    /**
    * 通过id获取WLinkDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public WLinkDto getWLinkByID(WLinkDto wLinkDto);

    /**
    * 通过相关数据获取WLinkDtoList
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