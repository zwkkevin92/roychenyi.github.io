package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SReply1Dao;
import com.cx.wxs.dto.SReply1Dto;
import com.cx.wxs.service.SReply1Service;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("SReply1Service")
public class SReply1ServiceImpl implements SReply1Service {
    @Autowired
    private SReply1Dao sReply1Dao;

    public void setSReply1Dao(SReply1Dao sReply1Dao){
        this.sReply1Dao=sReply1Dao;
    }

    /**
    * 通过用户id获取SReply1Dto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SReply1Dto getSReply1ByID(SReply1Dto sReply1Dto){
        return sReply1Dao.getSReply1ByID(sReply1Dto);
    }

    /**
    * 通过相关信息获取SReply1DtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SReply1Dto> getSReply1List(SReply1Dto sReply1Dto){
        return sReply1Dao.getSReply1List(sReply1Dto);
    }

    /**
    * 添加一个新的SReply1到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSReply1(SReply1Dto sReply1Dto){
        return sReply1Dao.addSReply1(sReply1Dto);
    }

    /**
    * 更新SReply1
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSReply1(SReply1Dto sReply1Dto){
        return sReply1Dao.updateSReply1(sReply1Dto);
    }

    /**
    * 删除SReply1
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSReply1(SReply1Dto sReply1Dto){
        return sReply1Dao.deleteSReply1(sReply1Dto);
    }

}