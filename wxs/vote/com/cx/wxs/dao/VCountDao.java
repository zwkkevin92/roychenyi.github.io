package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.VCountDto;
import com.cx.wxs.po.VCount;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface VCountDao extends IBaseDao<VCount,Integer>{
    /**
    * 通过id获取VCountDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public VCountDto getVCountByID(VCountDto vCountDto);

    /**
    * 通过相关数据获取VCountDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<VCountDto> getVCountList(VCountDto vCountDto);

    /**
    * 添加一个新的VCount到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addVCount(VCountDto vCountDto);

    /**
    * 更新VCount
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateVCount(VCountDto vCountDto);

    /**
    * 删除VCount
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteVCount(VCountDto vCountDto);

}