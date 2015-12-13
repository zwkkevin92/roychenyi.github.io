package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.IImageDao;
import com.cx.wxs.dto.IImageDto;
import com.cx.wxs.service.IImageService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("IImageService")
public class IImageServiceImpl implements IImageService {
    @Autowired
    private IImageDao iImageDao;

    public void setIImageDao(IImageDao iImageDao){
        this.iImageDao=iImageDao;
    }

    /**
    * 通过用户id获取IImageDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public IImageDto getIImageByID(IImageDto iImageDto){
        return iImageDao.getIImageByID(iImageDto);
    }

    /**
    * 通过相关信息获取IImageDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<IImageDto> getIImageList(IImageDto iImageDto){
        return iImageDao.getIImageList(iImageDto);
    }

    /**
    * 添加一个新的IImage到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addIImage(IImageDto iImageDto){
        return iImageDao.addIImage(iImageDto);
    }

    /**
    * 更新IImage
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateIImage(IImageDto iImageDto){
        return iImageDao.updateIImage(iImageDto);
    }

    /**
    * 删除IImage
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteIImage(IImageDto iImageDto){
        return iImageDao.deleteIImage(iImageDto);
    }

}