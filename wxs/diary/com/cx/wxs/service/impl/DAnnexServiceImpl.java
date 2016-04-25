package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.DAnnexDao;
import com.cx.wxs.dto.DAnnexDto;
import com.cx.wxs.service.DAnnexService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("DAnnexService")
public class DAnnexServiceImpl implements DAnnexService {
    @Autowired
    private DAnnexDao dAnnexDao;

    public void setDAnnexDao(DAnnexDao dAnnexDao){
        this.dAnnexDao=dAnnexDao;
    }

    /**
    * 通过用户id获取DAnnexDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public DAnnexDto getDAnnexByID(DAnnexDto dAnnexDto){
        return dAnnexDao.getDAnnexByID(dAnnexDto);
    }

    /**
    * 通过相关信息获取DAnnexDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<DAnnexDto> getDAnnexList(DAnnexDto dAnnexDto){
        return dAnnexDao.getDAnnexList(dAnnexDto);
    }

    /**
    * 添加一个新的DAnnex到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addDAnnex(DAnnexDto dAnnexDto){
        return dAnnexDao.addDAnnex(dAnnexDto);
    }

    /**
    * 更新DAnnex
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateDAnnex(DAnnexDto dAnnexDto){
        return dAnnexDao.updateDAnnex(dAnnexDto);
    }

    /**
    * 删除DAnnex
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteDAnnex(DAnnexDto dAnnexDto){
        return dAnnexDao.deleteDAnnex(dAnnexDto);
    }

}