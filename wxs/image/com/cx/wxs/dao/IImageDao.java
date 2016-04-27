package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.IImageDto;
import com.cx.wxs.po.IImage;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface IImageDao extends IBaseDao<IImage,Integer>{
    /**
    * 通过id获取IImageDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public IImageDto getIImageByID(IImageDto iImageDto);

    /**
    * 通过相关数据获取IImageDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<IImageDto> getIImageList(IImageDto iImageDto);

    /**
    * 添加一个新的IImage到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addIImage(IImageDto iImageDto);

    /**
    * 更新IImage
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateIImage(IImageDto iImageDto);

    /**
    * 删除IImage
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteIImage(IImageDto iImageDto);

}