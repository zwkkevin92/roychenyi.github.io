package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.DCatalogDao;
import com.cx.wxs.dto.DCatalogDto;
import com.cx.wxs.service.DCatalogService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("DCatalogService")
public class DCatalogServiceImpl implements DCatalogService {
    @Autowired
    private DCatalogDao dCatalogDao;

    public void setDCatalogDao(DCatalogDao dCatalogDao){
        this.dCatalogDao=dCatalogDao;
    }

    /**
    * 通过用户id获取DCatalogDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public DCatalogDto getDCatalogByID(DCatalogDto dCatalogDto){
        return dCatalogDao.getDCatalogByID(dCatalogDto);
    }

    /**
    * 通过相关信息获取DCatalogDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<DCatalogDto> getDCatalogList(DCatalogDto dCatalogDto){
        return dCatalogDao.getDCatalogList(dCatalogDto);
    }

    /**
    * 添加一个新的DCatalog到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addDCatalog(DCatalogDto dCatalogDto){
        return dCatalogDao.addDCatalog(dCatalogDto);
    }

    /**
    * 更新DCatalog
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateDCatalog(DCatalogDto dCatalogDto){
        return dCatalogDao.updateDCatalog(dCatalogDto);
    }

    /**
    * 删除DCatalog
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteDCatalog(DCatalogDto dCatalogDto){
        return dCatalogDao.deleteDCatalog(dCatalogDto);
    }

}