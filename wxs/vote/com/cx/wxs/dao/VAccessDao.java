package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.VAccessDto;
import com.cx.wxs.po.VAccess;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface VAccessDao extends IBaseDao<VAccess,Integer>{
    /**
    * 通过id获取VAccessDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public VAccessDto getVAccessByID(VAccessDto vAccessDto);

    /**
    * 通过相关数据获取VAccessDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<VAccessDto> getVAccessList(VAccessDto vAccessDto);

    /**
    * 添加一个新的VAccess到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addVAccess(VAccessDto vAccessDto);

    /**
    * 更新VAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateVAccess(VAccessDto vAccessDto);

    /**
    * 删除VAccess
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteVAccess(VAccessDto vAccessDto);

}