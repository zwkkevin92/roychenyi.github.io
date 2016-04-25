package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.VReply1Dao;
import com.cx.wxs.dto.VReply1Dto;
import com.cx.wxs.service.VReply1Service;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("VReply1Service")
public class VReply1ServiceImpl implements VReply1Service {
    @Autowired
    private VReply1Dao vReply1Dao;

    public void setVReply1Dao(VReply1Dao vReply1Dao){
        this.vReply1Dao=vReply1Dao;
    }

    /**
    * 通过用户id获取VReply1Dto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public VReply1Dto getVReply1ByID(VReply1Dto vReply1Dto){
        return vReply1Dao.getVReply1ByID(vReply1Dto);
    }

    /**
    * 通过相关信息获取VReply1DtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<VReply1Dto> getVReply1List(VReply1Dto vReply1Dto){
        return vReply1Dao.getVReply1List(vReply1Dto);
    }

    /**
    * 添加一个新的VReply1到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addVReply1(VReply1Dto vReply1Dto){
        return vReply1Dao.addVReply1(vReply1Dto);
    }

    /**
    * 更新VReply1
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateVReply1(VReply1Dto vReply1Dto){
        return vReply1Dao.updateVReply1(vReply1Dto);
    }

    /**
    * 删除VReply1
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteVReply1(VReply1Dto vReply1Dto){
        return vReply1Dao.deleteVReply1(vReply1Dto);
    }

}