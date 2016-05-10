package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.BStatusDto;
import com.cx.wxs.po.BStatus;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface BStatusDao extends IBaseDao<BStatus,Integer>{
    /**
    * 通过id获取BStatusDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public BStatusDto getBStatusByID(BStatusDto bStatusDto);

    /**
    * 通过相关数据获取BStatusDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<BStatusDto> getBStatusList(BStatusDto bStatusDto);

    /**
    * 添加一个新的BStatus到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addBStatus(BStatusDto bStatusDto);

    /**
    * 更新BStatus
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateBStatus(BStatusDto bStatusDto);

    /**
    * 删除BStatus
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteBStatus(BStatusDto bStatusDto);

}