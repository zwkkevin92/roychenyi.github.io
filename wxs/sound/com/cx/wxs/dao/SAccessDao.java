package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SAccessDto;
import com.cx.wxs.po.SAccess;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SAccessDao extends IBaseDao<SAccess,Integer>{
    /**
    * 通过id获取SAccessDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SAccessDto getSAccessByID(SAccessDto sAccessDto);

    /**
    * 通过相关数据获取SAccessDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SAccessDto> getSAccessList(SAccessDto sAccessDto);

    /**
    * 添加一个新的SAccess到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSAccess(SAccessDto sAccessDto);

    /**
    * 更新SAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSAccess(SAccessDto sAccessDto);

    /**
    * 删除SAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSAccess(SAccessDto sAccessDto);

}