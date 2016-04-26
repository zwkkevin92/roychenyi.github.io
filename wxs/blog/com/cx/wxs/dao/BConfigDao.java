package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.BConfigDto;
import com.cx.wxs.po.BConfig;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface BConfigDao extends IBaseDao<BConfig,Integer>{
    /**
    * 通过id获取BConfigDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public BConfigDto getBConfigByID(BConfigDto bConfigDto);
    /**
     * 获取BconfigDto
     * @param bConfigDto
     * @return
     * @author 陈义
     * @date   2016-4-9下午2:35:37
     */
    public BConfigDto getBConfig(BConfigDto bConfigDto);

    /**
    * 通过相关数据获取BConfigDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<BConfigDto> getBConfigList(BConfigDto bConfigDto);

    /**
    * 添加一个新的BConfig到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addBConfig(BConfigDto bConfigDto);

    /**
    * 更新BConfig
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateBConfig(BConfigDto bConfigDto);

    /**
    * 删除BConfig
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteBConfig(BConfigDto bConfigDto);

}