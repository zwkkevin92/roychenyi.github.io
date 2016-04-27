package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.VUpvoteDao;
import com.cx.wxs.dto.VUpvoteDto;
import com.cx.wxs.service.VUpvoteService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("VUpvoteService")
public class VUpvoteServiceImpl implements VUpvoteService {
    @Autowired
    private VUpvoteDao vUpvoteDao;

    public void setVUpvoteDao(VUpvoteDao vUpvoteDao){
        this.vUpvoteDao=vUpvoteDao;
    }

    /**
    * 通过用户id获取VUpvoteDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public VUpvoteDto getVUpvoteByID(VUpvoteDto vUpvoteDto){
        return vUpvoteDao.getVUpvoteByID(vUpvoteDto);
    }

    /**
    * 通过相关信息获取VUpvoteDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<VUpvoteDto> getVUpvoteList(VUpvoteDto vUpvoteDto){
        return vUpvoteDao.getVUpvoteList(vUpvoteDto);
    }

    /**
    * 添加一个新的VUpvote到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addVUpvote(VUpvoteDto vUpvoteDto){
        return vUpvoteDao.addVUpvote(vUpvoteDto);
    }

    /**
    * 更新VUpvote
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateVUpvote(VUpvoteDto vUpvoteDto){
        return vUpvoteDao.updateVUpvote(vUpvoteDto);
    }

    /**
    * 删除VUpvote
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteVUpvote(VUpvoteDto vUpvoteDto){
        return vUpvoteDao.deleteVUpvote(vUpvoteDto);
    }

}