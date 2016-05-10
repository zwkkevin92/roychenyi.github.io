package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SysTopicDto;
import com.cx.wxs.po.SysTopic;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SysTopicDao extends IBaseDao<SysTopic,Integer>{
    /**
    * 通过id获取SysTopicDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SysTopicDto getSysTopicByID(SysTopicDto sysTopicDto);

    /**
    * 通过相关数据获取SysTopicDtoList
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