package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.SBoxDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface SBoxService {
    /**
    * 通过用户id获取SBoxDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SBoxDto getSBoxByID(SBoxDto sBoxDto);

    /**
    * 通过相关信息获取SBoxDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SBoxDto> getSBoxList(SBoxDto sBoxDto);

    /**
    * 添加一个新的SBox到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSBox(SBoxDto sBoxDto);

    /**
    * 更新SBox
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSBox(SBoxDto sBoxDto);

    /**
    * 删除SBox
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSBox(SBoxDto sBoxDto);

}