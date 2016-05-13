package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.dto.DFavoriteDto;

/**
 * @author 陈义
 * @date 2016-04-16 09:22:44
 */

public interface DFavoriteService {
    /**
    * 通过用户id获取DFavoriteDto信息
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    
    public DFavoriteDto getDFavoriteByID(DFavoriteDto dFavoriteDto);
    
    public DFavoriteDto getDFavorite(DFavoriteDto dFavoriteDto);

    /**
    * 通过相关信息获取DFavoriteDtoList信息
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
    /***
     * 获取文章收藏数量
     * @param dFavoriteDto
     * @return
     * @author 陈义
     * @date   2016-5-11下午7:45:37
     */
    public Integer getDFavoriteCount(DFavoriteDto dFavoriteDto);
    /***
     * 通过收藏获取文章列表
     * @param dFavoriteDto
     * @return
     * @author 陈义
     * @date   2016-5-13下午2:47:45
     */
    public List<DDiaryDto> getDiarysByFavorite(DFavoriteDto dFavoriteDto);

}