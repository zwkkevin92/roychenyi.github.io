package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.SysInvitationCodeDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface SysInvitationCodeService {
    /**
    * 通过用户id获取SysInvitationCodeDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysInvitationCodeDto getSysInvitationCodeByID(SysInvitationCodeDto sysInvitationCodeDto);

    /**
    * 通过相关信息获取SysInvitationCodeDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SysInvitationCodeDto> getSysInvitationCodeList(SysInvitationCodeDto sysInvitationCodeDto);

    /**
    * 添加一个新的SysInvitationCode到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSysInvitationCode(SysInvitationCodeDto sysInvitationCodeDto);

    /**
    * 更新SysInvitationCode
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSysInvitationCode(SysInvitationCodeDto sysInvitationCodeDto);

    /**
    * 删除SysInvitationCode
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSysInvitationCode(SysInvitationCodeDto sysInvitationCodeDto);

}