package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SysInvitationCodeDao;
import com.cx.wxs.dto.SysInvitationCodeDto;
import com.cx.wxs.service.SysInvitationCodeService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("SysInvitationCodeService")
public class SysInvitationCodeServiceImpl implements SysInvitationCodeService {
    @Autowired
    private SysInvitationCodeDao sysInvitationCodeDao;

    public void setSysInvitationCodeDao(SysInvitationCodeDao sysInvitationCodeDao){
        this.sysInvitationCodeDao=sysInvitationCodeDao;
    }

    /**
    * 通过用户id获取SysInvitationCodeDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public SysInvitationCodeDto getSysInvitationCodeByID(SysInvitationCodeDto sysInvitationCodeDto){
        return sysInvitationCodeDao.getSysInvitationCodeByID(sysInvitationCodeDto);
    }

    /**
    * 通过相关信息获取SysInvitationCodeDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<SysInvitationCodeDto> getSysInvitationCodeList(SysInvitationCodeDto sysInvitationCodeDto){
        return sysInvitationCodeDao.getSysInvitationCodeList(sysInvitationCodeDto);
    }

    /**
    * 添加一个新的SysInvitationCode到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addSysInvitationCode(SysInvitationCodeDto sysInvitationCodeDto){
        return sysInvitationCodeDao.addSysInvitationCode(sysInvitationCodeDto);
    }

    /**
    * 更新SysInvitationCode
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateSysInvitationCode(SysInvitationCodeDto sysInvitationCodeDto){
        return sysInvitationCodeDao.updateSysInvitationCode(sysInvitationCodeDto);
    }

    /**
    * 删除SysInvitationCode
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteSysInvitationCode(SysInvitationCodeDto sysInvitationCodeDto){
        return sysInvitationCodeDao.deleteSysInvitationCode(sysInvitationCodeDto);
    }

}