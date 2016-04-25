package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.IAlbumDto;
import com.cx.wxs.po.IAlbum;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface IAlbumDao extends IBaseDao<IAlbum,Integer>{
    /**
    * 通过id获取IAlbumDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public IAlbumDto getIAlbumByID(IAlbumDto iAlbumDto);

    /**
    * 通过相关数据获取IAlbumDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<IAlbumDto> getIAlbumList(IAlbumDto iAlbumDto);

    /**
    * 添加一个新的IAlbum到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addIAlbum(IAlbumDto iAlbumDto);

    /**
    * 更新IAlbum
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateIAlbum(IAlbumDto iAlbumDto);

    /**
    * 删除IAlbum
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteIAlbum(IAlbumDto iAlbumDto);

}