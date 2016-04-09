package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.DCatalogDto;
import com.cx.wxs.po.DCatalog;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface DCatalogDao extends IBaseDao<DCatalog,Integer>{
    /**
    * 通过id获取DCatalogDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public DCatalogDto getDCatalogByID(DCatalogDto dCatalogDto);

    /**
    * 通过相关数据获取DCatalogDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<DCatalogDto> getDCatalogList(DCatalogDto dCatalogDto);

    /**
    * 添加一个新的DCatalog到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addDCatalog(DCatalogDto dCatalogDto);

    /**
    * 更新DCatalog
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateDCatalog(DCatalogDto dCatalogDto);

    /**
    * 删除DCatalog
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteDCatalog(DCatalogDto dCatalogDto);
    /***
     * 获取catalog
     * @param dCatalogDto
     * @return
     * @author 陈义
     * @date   2016-4-9下午10:11:08
     */
    public DCatalogDto getDCatalog(DCatalogDto dCatalogDto);

}