package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.BAccessDao;
import com.cx.wxs.dto.BAccessDto;
import com.cx.wxs.service.BAccessService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("BAccessService")
public class BAccessServiceImpl implements BAccessService {
    @Autowired
    private BAccessDao bAccessDao;

    public void setBAccessDao(BAccessDao bAccessDao){
        this.bAccessDao=bAccessDao;
    }

    /**
    * 通过用户id获取BAccessDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public BAccessDto getBAccessByID(BAccessDto bAccessDto){
        return bAccessDao.getBAccessByID(bAccessDto);
    }

    /**
    * 通过相关信息获取BAccessDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<BAccessDto> getBAccessList(BAccessDto bAccessDto){
        return bAccessDao.getBAccessList(bAccessDto);
    }

    /**
    * 添加一个新的BAccess到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addBAccess(BAccessDto bAccessDto){
        return bAccessDao.addBAccess(bAccessDto);
    }

    /**
    * 更新BAccess
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateBAccess(BAccessDto bAccessDto){
        return bAccessDao.updateBAccess(bAccessDto);
    }

    /**
    * 删除BAccess
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteBAccess(BAccessDto bAccessDto){
        return bAccessDao.deleteBAccess(bAccessDto);
    }

}