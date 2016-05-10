package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.SysTopicDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface SysTopicService {
    /**
    * 通过用户id获取SysTopicDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysTopicDto getSysTopicByID(SysTopicDto sysTopicDto);

    /**
    * 通过相关信息获取SysTopicDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SysTopicDto> getSysTopicList(SysTopicDto sysTopicDto);

    /**
    * 添加一个新的SysTopic到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSysTopic(SysTopicDto sysTopicDto);

    /**
    * 更新SysTopic
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSysTopic(SysTopicDto sysTopicDto);

    /**
    * 删除SysTopic
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSysTopic(SysTopicDto sysTopicDto);

}