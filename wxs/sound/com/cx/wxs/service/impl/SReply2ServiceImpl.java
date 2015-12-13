package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SReply2Dao;
import com.cx.wxs.dto.SReply2Dto;
import com.cx.wxs.service.SReply2Service;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("SReply2Service")
public class SReply2ServiceImpl implements SReply2Service {
    @Autowired
    private SReply2Dao sReply2Dao;

    public void setSReply2Dao(SReply2Dao sReply2Dao){
        this.sReply2Dao=sReply2Dao;
    }

    /**
    * 通过用户id获取SReply2Dto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public SReply2Dto getSReply2ByID(SReply2Dto sReply2Dto){
        return sReply2Dao.getSReply2ByID(sReply2Dto);
    }

    /**
    * 通过相关信息获取SReply2DtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<SReply2Dto> getSReply2List(SReply2Dto sReply2Dto){
        return sReply2Dao.getSReply2List(sReply2Dto);
    }

    /**
    * 添加一个新的SReply2到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addSReply2(SReply2Dto sReply2Dto){
        return sReply2Dao.addSReply2(sReply2Dto);
    }

    /**
    * 更新SReply2
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateSReply2(SReply2Dto sReply2Dto){
        return sReply2Dao.updateSReply2(sReply2Dto);
    }

    /**
    * 删除SReply2
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteSReply2(SReply2Dto sReply2Dto){
        return sReply2Dao.deleteSReply2(sReply2Dto);
    }

}