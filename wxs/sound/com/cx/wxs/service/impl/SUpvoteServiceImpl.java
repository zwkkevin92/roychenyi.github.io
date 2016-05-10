package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SUpvoteDao;
import com.cx.wxs.dto.SUpvoteDto;
import com.cx.wxs.service.SUpvoteService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("SUpvoteService")
public class SUpvoteServiceImpl implements SUpvoteService {
    @Autowired
    private SUpvoteDao sUpvoteDao;

    public void setSUpvoteDao(SUpvoteDao sUpvoteDao){
        this.sUpvoteDao=sUpvoteDao;
    }

    /**
    * 通过用户id获取SUpvoteDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SUpvoteDto getSUpvoteByID(SUpvoteDto sUpvoteDto){
        return sUpvoteDao.getSUpvoteByID(sUpvoteDto);
    }

    /**
    * 通过相关信息获取SUpvoteDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SUpvoteDto> getSUpvoteList(SUpvoteDto sUpvoteDto){
        return sUpvoteDao.getSUpvoteList(sUpvoteDto);
    }

    /**
    * 添加一个新的SUpvote到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSUpvote(SUpvoteDto sUpvoteDto){
        return sUpvoteDao.addSUpvote(sUpvoteDto);
    }

    /**
    * 更新SUpvote
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSUpvote(SUpvoteDto sUpvoteDto){
        return sUpvoteDao.updateSUpvote(sUpvoteDto);
    }

    /**
    * 删除SUpvote
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSUpvote(SUpvoteDto sUpvoteDto){
        return sUpvoteDao.deleteSUpvote(sUpvoteDto);
    }

}