package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.DFavoriteDto;
import com.cx.wxs.po.DFavorite;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2016-04-16 09:22:44
 */
public interface DFavoriteDao extends IBaseDao<DFavorite,Integer>{
    /**
    * 通过id获取DFavoriteDto
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    
    public DFavoriteDto getDFavoriteByID(DFavoriteDto dFavoriteDto);

    /**
    * 通过相关数据获取DFavoriteDtoList
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    
    public List<DFavoriteDto> getDFavoriteList(DFavoriteDto dFavoriteDto);

    /**
    * 添加一个新的DFavorite到数据库
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    
    public Integer addDFavorite(DFavoriteDto dFavoriteDto);

    /**
    * 更新DFavorite
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    
    public Integer updateDFavorite(DFavoriteDto dFavoriteDto);

    /**
    * 删除DFavorite
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    
    public Integer deleteDFavorite(DFavoriteDto dFavoriteDto);

}