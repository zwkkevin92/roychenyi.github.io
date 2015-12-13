package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.IUpvoteDao;
import com.cx.wxs.dto.IUpvoteDto;
import com.cx.wxs.service.IUpvoteService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("IUpvoteService")
public class IUpvoteServiceImpl implements IUpvoteService {
    @Autowired
    private IUpvoteDao iUpvoteDao;

    public void setIUpvoteDao(IUpvoteDao iUpvoteDao){
        this.iUpvoteDao=iUpvoteDao;
    }

    /**
    * 通过用户id获取IUpvoteDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public IUpvoteDto getIUpvoteByID(IUpvoteDto iUpvoteDto){
        return iUpvoteDao.getIUpvoteByID(iUpvoteDto);
    }

    /**
    * 通过相关信息获取IUpvoteDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<IUpvoteDto> getIUpvoteList(IUpvoteDto iUpvoteDto){
        return iUpvoteDao.getIUpvoteList(iUpvoteDto);
    }

    /**
    * 添加一个新的IUpvote到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addIUpvote(IUpvoteDto iUpvoteDto){
        return iUpvoteDao.addIUpvote(iUpvoteDto);
    }

    /**
    * 更新IUpvote
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateIUpvote(IUpvoteDto iUpvoteDto){
        return iUpvoteDao.updateIUpvote(iUpvoteDto);
    }

    /**
    * 删除IUpvote
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteIUpvote(IUpvoteDto iUpvoteDto){
        return iUpvoteDao.deleteIUpvote(iUpvoteDto);
    }

}