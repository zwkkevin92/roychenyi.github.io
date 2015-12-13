package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.WAccessDao;
import com.cx.wxs.dto.WAccessDto;
import com.cx.wxs.service.WAccessService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("WAccessService")
public class WAccessServiceImpl implements WAccessService {
    @Autowired
    private WAccessDao wAccessDao;

    public void setWAccessDao(WAccessDao wAccessDao){
        this.wAccessDao=wAccessDao;
    }

    /**
    * 通过用户id获取WAccessDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public WAccessDto getWAccessByID(WAccessDto wAccessDto){
        return wAccessDao.getWAccessByID(wAccessDto);
    }

    /**
    * 通过相关信息获取WAccessDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<WAccessDto> getWAccessList(WAccessDto wAccessDto){
        return wAccessDao.getWAccessList(wAccessDto);
    }

    /**
    * 添加一个新的WAccess到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addWAccess(WAccessDto wAccessDto){
        return wAccessDao.addWAccess(wAccessDto);
    }

    /**
    * 更新WAccess
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateWAccess(WAccessDto wAccessDto){
        return wAccessDao.updateWAccess(wAccessDto);
    }

    /**
    * 删除WAccess
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteWAccess(WAccessDto wAccessDto){
        return wAccessDao.deleteWAccess(wAccessDto);
    }

}