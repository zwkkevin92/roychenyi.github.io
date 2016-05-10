package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SysStyleDao;
import com.cx.wxs.dto.SysStyleDto;
import com.cx.wxs.service.SysStyleService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("SysStyleService")
public class SysStyleServiceImpl implements SysStyleService {
    @Autowired
    private SysStyleDao sysStyleDao;

    public void setSysStyleDao(SysStyleDao sysStyleDao){
        this.sysStyleDao=sysStyleDao;
    }

    /**
    * 通过用户id获取SysStyleDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SysStyleDto getSysStyleByID(SysStyleDto sysStyleDto){
        return sysStyleDao.getSysStyleByID(sysStyleDto);
    }

    /**
    * 通过相关信息获取SysStyleDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SysStyleDto> getSysStyleList(SysStyleDto sysStyleDto){
        return sysStyleDao.getSysStyleList(sysStyleDto);
    }

    /**
    * 添加一个新的SysStyle到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSysStyle(SysStyleDto sysStyleDto){
        return sysStyleDao.addSysStyle(sysStyleDto);
    }

    /**
    * 更新SysStyle
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSysStyle(SysStyleDto sysStyleDto){
        return sysStyleDao.updateSysStyle(sysStyleDto);
    }

    /**
    * 删除SysStyle
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSysStyle(SysStyleDto sysStyleDto){
        return sysStyleDao.deleteSysStyle(sysStyleDto);
    }

}