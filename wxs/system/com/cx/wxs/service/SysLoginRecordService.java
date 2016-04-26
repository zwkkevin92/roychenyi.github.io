package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.SysLoginRecordDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface SysLoginRecordService {
    /**
    * 通过用户id获取SysLoginRecordDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysLoginRecordDto getSysLoginRecordByID(SysLoginRecordDto sysLoginRecordDto);

    /**
    * 通过相关信息获取SysLoginRecordDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SysLoginRecordDto> getSysLoginRecordList(SysLoginRecordDto sysLoginRecordDto);

    /**
    * 添加一个新的SysLoginRecord到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSysLoginRecord(SysLoginRecordDto sysLoginRecordDto);

    /**
    * 更新SysLoginRecord
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSysLoginRecord(SysLoginRecordDto sysLoginRecordDto);

    /**
    * 删除SysLoginRecord
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSysLoginRecord(SysLoginRecordDto sysLoginRecordDto);

}