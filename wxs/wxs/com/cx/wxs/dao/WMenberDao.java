package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.WMenberDto;
import com.cx.wxs.po.WMenber;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2016-05-16 10:33:22
 */
public interface WMenberDao extends IBaseDao<WMenber,Integer>{
    /**
    * 通过id获取WMenberDto
    * @author 陈义
    * @date 2016-05-16 10:33:22
    */
    
    public WMenberDto getWMenberByID(WMenberDto wMenberDto);

    /**
    * 通过相关数据获取WMenberDtoList
    * @author 陈义
    * @date 2016-05-16 10:33:22
    */
    
    public List<WMenberDto> getWMenberList(WMenberDto wMenberDto);

    /**
    * 添加一个新的WMenber到数据库
    * @author 陈义
    * @date 2016-05-16 10:33:22
    */
    
    public Integer addWMenber(WMenberDto wMenberDto);

    /**
    * 更新WMenber
    * @author 陈义
    * @date 2016-05-16 10:33:22
    */
    
    public Integer updateWMenber(WMenberDto wMenberDto);

    /**
    * 删除WMenber
    * @author 陈义
    * @date 2016-05-16 10:33:22
    */
    
    public Integer deleteWMenber(WMenberDto wMenberDto);

}