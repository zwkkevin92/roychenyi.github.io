package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.VReply2Dao;
import com.cx.wxs.dto.VReply2Dto;
import com.cx.wxs.service.VReply2Service;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("VReply2Service")
public class VReply2ServiceImpl implements VReply2Service {
    @Autowired
    private VReply2Dao vReply2Dao;

    public void setVReply2Dao(VReply2Dao vReply2Dao){
        this.vReply2Dao=vReply2Dao;
    }

    /**
    * 通过用户id获取VReply2Dto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public VReply2Dto getVReply2ByID(VReply2Dto vReply2Dto){
        return vReply2Dao.getVReply2ByID(vReply2Dto);
    }

    /**
    * 通过相关信息获取VReply2DtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<VReply2Dto> getVReply2List(VReply2Dto vReply2Dto){
        return vReply2Dao.getVReply2List(vReply2Dto);
    }

    /**
    * 添加一个新的VReply2到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addVReply2(VReply2Dto vReply2Dto){
        return vReply2Dao.addVReply2(vReply2Dto);
    }

    /**
    * 更新VReply2
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateVReply2(VReply2Dto vReply2Dto){
        return vReply2Dao.updateVReply2(vReply2Dto);
    }

    /**
    * 删除VReply2
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteVReply2(VReply2Dto vReply2Dto){
        return vReply2Dao.deleteVReply2(vReply2Dto);
    }

}