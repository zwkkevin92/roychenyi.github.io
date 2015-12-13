package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SysTopicDao;
import com.cx.wxs.dto.SysTopicDto;
import com.cx.wxs.service.SysTopicService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("SysTopicService")
public class SysTopicServiceImpl implements SysTopicService {
    @Autowired
    private SysTopicDao sysTopicDao;

    public void setSysTopicDao(SysTopicDao sysTopicDao){
        this.sysTopicDao=sysTopicDao;
    }

    /**
    * 通过用户id获取SysTopicDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public SysTopicDto getSysTopicByID(SysTopicDto sysTopicDto){
        return sysTopicDao.getSysTopicByID(sysTopicDto);
    }

    /**
    * 通过相关信息获取SysTopicDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<SysTopicDto> getSysTopicList(SysTopicDto sysTopicDto){
        return sysTopicDao.getSysTopicList(sysTopicDto);
    }

    /**
    * 添加一个新的SysTopic到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addSysTopic(SysTopicDto sysTopicDto){
        return sysTopicDao.addSysTopic(sysTopicDto);
    }

    /**
    * 更新SysTopic
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateSysTopic(SysTopicDto sysTopicDto){
        return sysTopicDao.updateSysTopic(sysTopicDto);
    }

    /**
    * 删除SysTopic
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteSysTopic(SysTopicDto sysTopicDto){
        return sysTopicDao.deleteSysTopic(sysTopicDto);
    }

}