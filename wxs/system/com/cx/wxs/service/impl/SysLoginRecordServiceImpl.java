package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SysLoginRecordDao;
import com.cx.wxs.dto.SysLoginRecordDto;
import com.cx.wxs.service.SysLoginRecordService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("SysLoginRecordService")
public class SysLoginRecordServiceImpl implements SysLoginRecordService {
    @Autowired
    private SysLoginRecordDao sysLoginRecordDao;

    public void setSysLoginRecordDao(SysLoginRecordDao sysLoginRecordDao){
        this.sysLoginRecordDao=sysLoginRecordDao;
    }

    /**
    * 通过用户id获取SysLoginRecordDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SysLoginRecordDto getSysLoginRecordByID(SysLoginRecordDto sysLoginRecordDto){
        return sysLoginRecordDao.getSysLoginRecordByID(sysLoginRecordDto);
    }

    /**
    * 通过相关信息获取SysLoginRecordDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SysLoginRecordDto> getSysLoginRecordList(SysLoginRecordDto sysLoginRecordDto){
        return sysLoginRecordDao.getSysLoginRecordList(sysLoginRecordDto);
    }

    /**
    * 添加一个新的SysLoginRecord到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSysLoginRecord(SysLoginRecordDto sysLoginRecordDto){
        return sysLoginRecordDao.addSysLoginRecord(sysLoginRecordDto);
    }

    /**
    * 更新SysLoginRecord
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSysLoginRecord(SysLoginRecordDto sysLoginRecordDto){
        return sysLoginRecordDao.updateSysLoginRecord(sysLoginRecordDto);
    }

    /**
    * 删除SysLoginRecord
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSysLoginRecord(SysLoginRecordDto sysLoginRecordDto){
        return sysLoginRecordDao.deleteSysLoginRecord(sysLoginRecordDto);
    }

}