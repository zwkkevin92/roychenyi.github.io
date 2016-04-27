package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.SSoundDto;
import com.cx.wxs.po.SSound;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface SSoundDao extends IBaseDao<SSound,Integer>{
    /**
    * 通过id获取SSoundDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public SSoundDto getSSoundByID(SSoundDto sSoundDto);

    /**
    * 通过相关数据获取SSoundDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<SSoundDto> getSSoundList(SSoundDto sSoundDto);

    /**
    * 添加一个新的SSound到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addSSound(SSoundDto sSoundDto);

    /**
    * 更新SSound
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateSSound(SSoundDto sSoundDto);

    /**
    * 删除SSound
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteSSound(SSoundDto sSoundDto);

}