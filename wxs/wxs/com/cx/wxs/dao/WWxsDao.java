package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.WWxsDto;
import com.cx.wxs.po.WWxs;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface WWxsDao extends IBaseDao<WWxs,Integer>{
    /**
    * 通过id获取WWxsDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public WWxsDto getWWxsByID(WWxsDto wWxsDto);
    /**
     * 通过相关信息获取wxsDto
     * @param wWxsDto
     * @return
     * @author 陈义
     * @date   2016-5-16下午11:41:36
     */
    public WWxsDto getWWxsDto(WWxsDto wWxsDto);
    /***
     * 通过名字之类的获取文学社信息
     * @param wWxsDto
     * @return
     * @author 陈义
     * @date   2016-3-24下午10:12:24
     */
    public WWxsDto getWWDto(WWxsDto wWxsDto);

    /**
    * 通过相关数据获取WWxsDtoList
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
    /**
     * 获取文学社数量
     * @param wWxsDto
     * @return
     */
    public Integer getWWxsCount(WWxsDto wWxsDto);

}