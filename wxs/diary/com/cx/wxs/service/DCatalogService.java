package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.DCatalogDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface DCatalogService {
    /**
    * 通过用户id获取DCatalogDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public DCatalogDto getDCatalogByID(DCatalogDto dCatalogDto);

    /**
    * 通过相关信息获取DCatalogDtoList信息
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

}