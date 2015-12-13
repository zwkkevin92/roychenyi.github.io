package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.DReply1Dao;
import com.cx.wxs.dto.DReply1Dto;
import com.cx.wxs.service.DReply1Service;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("DReply1Service")
public class DReply1ServiceImpl implements DReply1Service {
    @Autowired
    private DReply1Dao dReply1Dao;

    public void setDReply1Dao(DReply1Dao dReply1Dao){
        this.dReply1Dao=dReply1Dao;
    }

    /**
    * 通过用户id获取DReply1Dto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public DReply1Dto getDReply1ByID(DReply1Dto dReply1Dto){
        return dReply1Dao.getDReply1ByID(dReply1Dto);
    }

    /**
    * 通过相关信息获取DReply1DtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<DReply1Dto> getDReply1List(DReply1Dto dReply1Dto){
        return dReply1Dao.getDReply1List(dReply1Dto);
    }

    /**
    * 添加一个新的DReply1到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addDReply1(DReply1Dto dReply1Dto){
        return dReply1Dao.addDReply1(dReply1Dto);
    }

    /**
    * 更新DReply1
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateDReply1(DReply1Dto dReply1Dto){
        return dReply1Dao.updateDReply1(dReply1Dto);
    }

    /**
    * 删除DReply1
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteDReply1(DReply1Dto dReply1Dto){
        return dReply1Dao.deleteDReply1(dReply1Dto);
    }

}