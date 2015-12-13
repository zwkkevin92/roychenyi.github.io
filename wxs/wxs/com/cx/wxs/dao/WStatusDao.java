package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.WStatusDto;
import com.cx.wxs.po.WStatus;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface WStatusDao extends IBaseDao<WStatus,Integer>{
    /**
    * 通过id获取WStatusDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public WStatusDto getWStatusByID(WStatusDto wStatusDto);

    /**
    * 通过相关数据获取WStatusDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<WStatusDto> getWStatusList(WStatusDto wStatusDto);

    /**
    * 添加一个新的WStatus到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addWStatus(WStatusDto wStatusDto);

    /**
    * 更新WStatus
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateWStatus(WStatusDto wStatusDto);

    /**
    * 删除WStatus
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteWStatus(WStatusDto wStatusDto);

}