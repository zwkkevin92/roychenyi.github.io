package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.VAccessDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface VAccessService {
    /**
    * 通过用户id获取VAccessDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public VAccessDto getVAccessByID(VAccessDto vAccessDto);

    /**
    * 通过相关信息获取VAccessDtoList信息
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