package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SysInvitationCodeDto;
import com.cx.wxs.po.SysInvitationCode;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SysInvitationCodeDao extends IBaseDao<SysInvitationCode,Integer>{
    /**
    * 通过id获取SysInvitationCodeDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysInvitationCodeDto getSysInvitationCodeByID(SysInvitationCodeDto sysInvitationCodeDto);

    /**
    * 通过相关数据获取SysInvitationCodeDtoList
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