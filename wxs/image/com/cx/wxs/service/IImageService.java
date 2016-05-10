package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.IImageDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface IImageService {
    /**
    * 通过用户id获取IImageDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public IImageDto getIImageByID(IImageDto iImageDto);

    /**
    * 通过相关信息获取IImageDtoList信息
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