package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SBoxDao;
import com.cx.wxs.dto.SBoxDto;
import com.cx.wxs.service.SBoxService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("SBoxService")
public class SBoxServiceImpl implements SBoxService {
    @Autowired
    private SBoxDao sBoxDao;

    public void setSBoxDao(SBoxDao sBoxDao){
        this.sBoxDao=sBoxDao;
    }

    /**
    * 通过用户id获取SBoxDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public SBoxDto getSBoxByID(SBoxDto sBoxDto){
        return sBoxDao.getSBoxByID(sBoxDto);
    }

    /**
    * 通过相关信息获取SBoxDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<SBoxDto> getSBoxList(SBoxDto sBoxDto){
        return sBoxDao.getSBoxList(sBoxDto);
    }

    /**
    * 添加一个新的SBox到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addSBox(SBoxDto sBoxDto){
        return sBoxDao.addSBox(sBoxDto);
    }

    /**
    * 更新SBox
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateSBox(SBoxDto sBoxDto){
        return sBoxDao.updateSBox(sBoxDto);
    }

    /**
    * 删除SBox
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteSBox(SBoxDto sBoxDto){
        return sBoxDao.deleteSBox(sBoxDto);
    }

}