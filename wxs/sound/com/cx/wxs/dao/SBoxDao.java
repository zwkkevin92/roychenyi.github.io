package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SBoxDto;
import com.cx.wxs.po.SBox;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SBoxDao extends IBaseDao<SBox,Integer>{
    /**
    * 通过id获取SBoxDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SBoxDto getSBoxByID(SBoxDto sBoxDto);

    /**
    * 通过相关数据获取SBoxDtoList
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