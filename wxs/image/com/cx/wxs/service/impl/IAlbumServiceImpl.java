package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.IAlbumDao;
import com.cx.wxs.dto.IAlbumDto;
import com.cx.wxs.service.IAlbumService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("IAlbumService")
public class IAlbumServiceImpl implements IAlbumService {
    @Autowired
    private IAlbumDao iAlbumDao;

    public void setIAlbumDao(IAlbumDao iAlbumDao){
        this.iAlbumDao=iAlbumDao;
    }

    /**
    * 通过用户id获取IAlbumDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public IAlbumDto getIAlbumByID(IAlbumDto iAlbumDto){
        return iAlbumDao.getIAlbumByID(iAlbumDto);
    }

    /**
    * 通过相关信息获取IAlbumDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<IAlbumDto> getIAlbumList(IAlbumDto iAlbumDto){
        return iAlbumDao.getIAlbumList(iAlbumDto);
    }

    /**
    * 添加一个新的IAlbum到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addIAlbum(IAlbumDto iAlbumDto){
        return iAlbumDao.addIAlbum(iAlbumDto);
    }

    /**
    * 更新IAlbum
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateIAlbum(IAlbumDto iAlbumDto){
        return iAlbumDao.updateIAlbum(iAlbumDto);
    }

    /**
    * 删除IAlbum
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteIAlbum(IAlbumDto iAlbumDto){
        return iAlbumDao.deleteIAlbum(iAlbumDto);
    }

}