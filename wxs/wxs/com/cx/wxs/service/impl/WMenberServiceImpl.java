package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.WMenberDao;
import com.cx.wxs.dto.WMenberDto;
import com.cx.wxs.service.WMenberService;

/**
 * @author 陈义
 * @date 2016-05-16 10:33:22
 */

@Service("WMenberService")
public class WMenberServiceImpl implements WMenberService {
    @Autowired
    private WMenberDao wMenberDao;

    public void setWMenberDao(WMenberDao wMenberDao){
        this.wMenberDao=wMenberDao;
    }

    /**
    * 通过用户id获取WMenberDto信息
    * @author 陈义
    * @date 2016-05-16 10:33:22
    */
    @Override
    public WMenberDto getWMenberByID(WMenberDto wMenberDto){
        return wMenberDao.getWMenberByID(wMenberDto);
    }

    /**
    * 通过相关信息获取WMenberDtoList信息
    * @author 陈义
    * @date 2016-05-16 10:33:22
    */
    @Override
    public List<WMenberDto> getWMenberList(WMenberDto wMenberDto){
        return wMenberDao.getWMenberList(wMenberDto);
    }

    /**
    * 添加一个新的WMenber到数据库
    * @author 陈义
    * @date 2016-05-16 10:33:22
    */
    @Override
    public Integer addWMenber(WMenberDto wMenberDto){
        return wMenberDao.addWMenber(wMenberDto);
    }

    /**
    * 更新WMenber
    * @author 陈义
    * @date 2016-05-16 10:33:22
    */
    @Override
    public Integer updateWMenber(WMenberDto wMenberDto){
        return wMenberDao.updateWMenber(wMenberDto);
    }

    /**
    * 删除WMenber
    * @author 陈义
    * @date 2016-05-16 10:33:22
    */
    @Override
    public Integer deleteWMenber(WMenberDto wMenberDto){
        return wMenberDao.deleteWMenber(wMenberDto);
    }

}