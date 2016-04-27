package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.WStatusDao;
import com.cx.wxs.dto.WStatusDto;
import com.cx.wxs.service.WStatusService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("WStatusService")
public class WStatusServiceImpl implements WStatusService {
    @Autowired
    private WStatusDao wStatusDao;

    public void setWStatusDao(WStatusDao wStatusDao){
        this.wStatusDao=wStatusDao;
    }

    /**
    * 通过用户id获取WStatusDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public WStatusDto getWStatusByID(WStatusDto wStatusDto){
        return wStatusDao.getWStatusByID(wStatusDto);
    }

    /**
    * 通过相关信息获取WStatusDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<WStatusDto> getWStatusList(WStatusDto wStatusDto){
        return wStatusDao.getWStatusList(wStatusDto);
    }

    /**
    * 添加一个新的WStatus到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addWStatus(WStatusDto wStatusDto){
        return wStatusDao.addWStatus(wStatusDto);
    }

    /**
    * 更新WStatus
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateWStatus(WStatusDto wStatusDto){
        return wStatusDao.updateWStatus(wStatusDto);
    }

    /**
    * 删除WStatus
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteWStatus(WStatusDto wStatusDto){
        return wStatusDao.deleteWStatus(wStatusDto);
    }

}