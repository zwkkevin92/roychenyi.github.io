package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.DAnnexDto;
import com.cx.wxs.po.DAnnex;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface DAnnexDao extends IBaseDao<DAnnex,Integer>{
    /**
    * 通过id获取DAnnexDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public DAnnexDto getDAnnexByID(DAnnexDto dAnnexDto);

    /**
    * 通过相关数据获取DAnnexDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<DAnnexDto> getDAnnexList(DAnnexDto dAnnexDto);

    /**
    * 添加一个新的DAnnex到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addDAnnex(DAnnexDto dAnnexDto);

    /**
    * 更新DAnnex
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateDAnnex(DAnnexDto dAnnexDto);

    /**
    * 删除DAnnex
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteDAnnex(DAnnexDto dAnnexDto);

}