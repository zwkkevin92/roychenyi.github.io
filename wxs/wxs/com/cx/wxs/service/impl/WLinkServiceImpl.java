package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.WLinkDao;
import com.cx.wxs.dto.WLinkDto;
import com.cx.wxs.service.WLinkService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("WLinkService")
public class WLinkServiceImpl implements WLinkService {
    @Autowired
    private WLinkDao wLinkDao;

    public void setWLinkDao(WLinkDao wLinkDao){
        this.wLinkDao=wLinkDao;
    }

    /**
    * 通过用户id获取WLinkDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public WLinkDto getWLinkByID(WLinkDto wLinkDto){
        return wLinkDao.getWLinkByID(wLinkDto);
    }

    /**
    * 通过相关信息获取WLinkDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<WLinkDto> getWLinkList(WLinkDto wLinkDto){
        return wLinkDao.getWLinkList(wLinkDto);
    }

    /**
    * 添加一个新的WLink到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addWLink(WLinkDto wLinkDto){
        return wLinkDao.addWLink(wLinkDto);
    }

    /**
    * 更新WLink
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateWLink(WLinkDto wLinkDto){
        return wLinkDao.updateWLink(wLinkDto);
    }

    /**
    * 删除WLink
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteWLink(WLinkDto wLinkDto){
        return wLinkDao.deleteWLink(wLinkDto);
    }

}