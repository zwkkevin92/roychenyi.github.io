package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.IReply2Dao;
import com.cx.wxs.dto.IReply2Dto;
import com.cx.wxs.service.IReply2Service;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("IReply2Service")
public class IReply2ServiceImpl implements IReply2Service {
    @Autowired
    private IReply2Dao iReply2Dao;

    public void setIReply2Dao(IReply2Dao iReply2Dao){
        this.iReply2Dao=iReply2Dao;
    }

    /**
    * 通过用户id获取IReply2Dto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public IReply2Dto getIReply2ByID(IReply2Dto iReply2Dto){
        return iReply2Dao.getIReply2ByID(iReply2Dto);
    }

    /**
    * 通过相关信息获取IReply2DtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<IReply2Dto> getIReply2List(IReply2Dto iReply2Dto){
        return iReply2Dao.getIReply2List(iReply2Dto);
    }

    /**
    * 添加一个新的IReply2到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addIReply2(IReply2Dto iReply2Dto){
        return iReply2Dao.addIReply2(iReply2Dto);
    }

    /**
    * 更新IReply2
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateIReply2(IReply2Dto iReply2Dto){
        return iReply2Dao.updateIReply2(iReply2Dto);
    }

    /**
    * 删除IReply2
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteIReply2(IReply2Dto iReply2Dto){
        return iReply2Dao.deleteIReply2(iReply2Dto);
    }

}