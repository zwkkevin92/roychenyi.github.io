package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.MAfficheDto;
import com.cx.wxs.po.MAffiche;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface MAfficheDao extends IBaseDao<MAffiche,Integer>{
    /**
    * 通过id获取MAfficheDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public MAfficheDto getMAfficheByID(MAfficheDto mAfficheDto);

    /**
    * 通过相关数据获取MAfficheDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<MAfficheDto> getMAfficheList(MAfficheDto mAfficheDto);

    /**
    * 添加一个新的MAffiche到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addMAffiche(MAfficheDto mAfficheDto);

    /**
    * 更新MAffiche
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateMAffiche(MAfficheDto mAfficheDto);

    /**
    * 删除MAffiche
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteMAffiche(MAfficheDto mAfficheDto);

}