package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.BTagDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface BTagService {
    /**
    * 通过用户id获取BTagDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public BTagDto getBTagByID(BTagDto bTagDto);

    /**
    * 通过相关信息获取BTagDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<BTagDto> getBTagList(BTagDto bTagDto);

    /**
    * 添加一个新的BTag到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addBTag(BTagDto bTagDto);

    /**
    * 更新BTag
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateBTag(BTagDto bTagDto);

    /**
    * 删除BTag
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteBTag(BTagDto bTagDto);

}