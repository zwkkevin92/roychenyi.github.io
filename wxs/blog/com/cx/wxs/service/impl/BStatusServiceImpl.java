package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.BStatusDao;
import com.cx.wxs.dto.BStatusDto;
import com.cx.wxs.service.BStatusService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("BStatusService")
public class BStatusServiceImpl implements BStatusService {
    @Autowired
    private BStatusDao bStatusDao;

    public void setBStatusDao(BStatusDao bStatusDao){
        this.bStatusDao=bStatusDao;
    }

    /**
    * 通过用户id获取BStatusDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public BStatusDto getBStatusByID(BStatusDto bStatusDto){
        return bStatusDao.getBStatusByID(bStatusDto);
    }

    /**
    * 通过相关信息获取BStatusDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<BStatusDto> getBStatusList(BStatusDto bStatusDto){
        return bStatusDao.getBStatusList(bStatusDto);
    }

    /**
    * 添加一个新的BStatus到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addBStatus(BStatusDto bStatusDto){
        return bStatusDao.addBStatus(bStatusDto);
    }

    /**
    * 更新BStatus
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateBStatus(BStatusDto bStatusDto){
        return bStatusDao.updateBStatus(bStatusDto);
    }

    /**
    * 删除BStatus
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteBStatus(BStatusDto bStatusDto){
        return bStatusDao.deleteBStatus(bStatusDto);
    }

}