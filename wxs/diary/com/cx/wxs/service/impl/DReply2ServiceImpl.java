package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.DReply2Dao;
import com.cx.wxs.dto.DReply2Dto;
import com.cx.wxs.service.DReply2Service;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("DReply2Service")
public class DReply2ServiceImpl implements DReply2Service {
    @Autowired
    private DReply2Dao dReply2Dao;

    public void setDReply2Dao(DReply2Dao dReply2Dao){
        this.dReply2Dao=dReply2Dao;
    }

    /**
    * 通过用户id获取DReply2Dto信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public DReply2Dto getDReply2ByID(DReply2Dto dReply2Dto){
        return dReply2Dao.getDReply2ByID(dReply2Dto);
    }

    /**
    * 通过相关信息获取DReply2DtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<DReply2Dto> getDReply2List(DReply2Dto dReply2Dto){
        return dReply2Dao.getDReply2List(dReply2Dto);
    }

    /**
    * 添加一个新的DReply2到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addDReply2(DReply2Dto dReply2Dto){
        return dReply2Dao.addDReply2(dReply2Dto);
    }

    /**
    * 更新DReply2
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateDReply2(DReply2Dto dReply2Dto){
        return dReply2Dao.updateDReply2(dReply2Dto);
    }

    /**
    * 删除DReply2
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteDReply2(DReply2Dto dReply2Dto){
        return dReply2Dao.deleteDReply2(dReply2Dto);
    }

}