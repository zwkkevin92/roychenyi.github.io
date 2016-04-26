package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.IReply1Dao;
import com.cx.wxs.dto.IReply1Dto;
import com.cx.wxs.service.IReply1Service;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("IReply1Service")
public class IReply1ServiceImpl implements IReply1Service {
    @Autowired
    private IReply1Dao iReply1Dao;

    public void setIReply1Dao(IReply1Dao iReply1Dao){
        this.iReply1Dao=iReply1Dao;
    }

    /**
    * 通过用户id获取IReply1Dto信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public IReply1Dto getIReply1ByID(IReply1Dto iReply1Dto){
        return iReply1Dao.getIReply1ByID(iReply1Dto);
    }

    /**
    * 通过相关信息获取IReply1DtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<IReply1Dto> getIReply1List(IReply1Dto iReply1Dto){
        return iReply1Dao.getIReply1List(iReply1Dto);
    }

    /**
    * 添加一个新的IReply1到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addIReply1(IReply1Dto iReply1Dto){
        return iReply1Dao.addIReply1(iReply1Dto);
    }

    /**
    * 更新IReply1
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateIReply1(IReply1Dto iReply1Dto){
        return iReply1Dao.updateIReply1(iReply1Dto);
    }

    /**
    * 删除IReply1
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteIReply1(IReply1Dto iReply1Dto){
        return iReply1Dao.deleteIReply1(iReply1Dto);
    }

}