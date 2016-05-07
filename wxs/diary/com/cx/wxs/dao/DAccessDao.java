package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.DAccessDto;
import com.cx.wxs.po.DAccess;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface DAccessDao extends IBaseDao<DAccess,Integer>{
    /**
    * 通过id获取DAccessDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public DAccessDto getDAccessByID(DAccessDto dAccessDto);

    /**
    * 通过相关数据获取DAccessDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<DAccessDto> getDAccessList(DAccessDto dAccessDto);

    /**
    * 添加一个新的DAccess到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addDAccess(DAccessDto dAccessDto);

    /**
    * 更新DAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateDAccess(DAccessDto dAccessDto);

    /**
    * 删除DAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteDAccess(DAccessDto dAccessDto);
    /**
     * 获取评论计数
     * @param dAccessDto
     * @return
     * @author 陈义
     * @date   2016-5-6上午9:02:21
     */
    public Integer getDAccessCount(DAccessDto dAccessDto);


}