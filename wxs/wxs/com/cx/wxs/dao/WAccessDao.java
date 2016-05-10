package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.WAccessDto;
import com.cx.wxs.po.WAccess;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface WAccessDao extends IBaseDao<WAccess,Integer>{
    /**
    * 通过id获取WAccessDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public WAccessDto getWAccessByID(WAccessDto wAccessDto);

    /**
    * 通过相关数据获取WAccessDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<WAccessDto> getWAccessList(WAccessDto wAccessDto);

    /**
    * 添加一个新的WAccess到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addWAccess(WAccessDto wAccessDto);

    /**
    * 更新WAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateWAccess(WAccessDto wAccessDto);

    /**
    * 删除WAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteWAccess(WAccessDto wAccessDto);

}