package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.WWxsDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface WWxsService {
    /**
    * 通过用户id获取WWxsDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public WWxsDto getWWxsByID(WWxsDto wWxsDto);

    /***
     * 通过名字id等信息获取wxs信息
     * @param wWxsDto
     * @return
     * @author 陈义
     * @date   2016-3-24下午10:06:33
     */
    public WWxsDto getWwxs(WWxsDto wWxsDto);
    /**
    * 通过相关信息获取WWxsDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<WWxsDto> getWWxsList(WWxsDto wWxsDto);

    /**
    * 添加一个新的WWxs到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addWWxs(WWxsDto wWxsDto);

    /**
    * 更新WWxs
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateWWxs(WWxsDto wWxsDto);

    /**
    * 删除WWxs
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteWWxs(WWxsDto wWxsDto);

}