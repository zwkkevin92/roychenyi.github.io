package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.VItemDao;
import com.cx.wxs.dto.VItemDto;
import com.cx.wxs.service.VItemService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("VItemService")
public class VItemServiceImpl implements VItemService {
    @Autowired
    private VItemDao vItemDao;

    public void setVItemDao(VItemDao vItemDao){
        this.vItemDao=vItemDao;
    }

    /**
    * 通过用户id获取VItemDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public VItemDto getVItemByID(VItemDto vItemDto){
        return vItemDao.getVItemByID(vItemDto);
    }

    /**
    * 通过相关信息获取VItemDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<VItemDto> getVItemList(VItemDto vItemDto){
        return vItemDao.getVItemList(vItemDto);
    }

    /**
    * 添加一个新的VItem到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addVItem(VItemDto vItemDto){
        return vItemDao.addVItem(vItemDto);
    }

    /**
    * 更新VItem
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateVItem(VItemDto vItemDto){
        return vItemDao.updateVItem(vItemDto);
    }

    /**
    * 删除VItem
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteVItem(VItemDto vItemDto){
        return vItemDao.deleteVItem(vItemDto);
    }

}