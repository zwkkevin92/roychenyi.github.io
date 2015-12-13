package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.MReplyDao;
import com.cx.wxs.dto.MReplyDto;
import com.cx.wxs.service.MReplyService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("MReplyService")
public class MReplyServiceImpl implements MReplyService {
    @Autowired
    private MReplyDao mReplyDao;

    public void setMReplyDao(MReplyDao mReplyDao){
        this.mReplyDao=mReplyDao;
    }

    /**
    * 通过用户id获取MReplyDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public MReplyDto getMReplyByID(MReplyDto mReplyDto){
        return mReplyDao.getMReplyByID(mReplyDto);
    }

    /**
    * 通过相关信息获取MReplyDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<MReplyDto> getMReplyList(MReplyDto mReplyDto){
        return mReplyDao.getMReplyList(mReplyDto);
    }

    /**
    * 添加一个新的MReply到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addMReply(MReplyDto mReplyDto){
        return mReplyDao.addMReply(mReplyDto);
    }

    /**
    * 更新MReply
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateMReply(MReplyDto mReplyDto){
        return mReplyDao.updateMReply(mReplyDto);
    }

    /**
    * 删除MReply
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteMReply(MReplyDto mReplyDto){
        return mReplyDao.deleteMReply(mReplyDto);
    }

}