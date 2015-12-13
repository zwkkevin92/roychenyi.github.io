package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.MMessageDao;
import com.cx.wxs.dto.MMessageDto;
import com.cx.wxs.service.MMessageService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("MMessageService")
public class MMessageServiceImpl implements MMessageService {
    @Autowired
    private MMessageDao mMessageDao;

    public void setMMessageDao(MMessageDao mMessageDao){
        this.mMessageDao=mMessageDao;
    }

    /**
    * 通过用户id获取MMessageDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public MMessageDto getMMessageByID(MMessageDto mMessageDto){
        return mMessageDao.getMMessageByID(mMessageDto);
    }

    /**
    * 通过相关信息获取MMessageDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<MMessageDto> getMMessageList(MMessageDto mMessageDto){
        return mMessageDao.getMMessageList(mMessageDto);
    }

    /**
    * 添加一个新的MMessage到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addMMessage(MMessageDto mMessageDto){
        return mMessageDao.addMMessage(mMessageDto);
    }

    /**
    * 更新MMessage
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateMMessage(MMessageDto mMessageDto){
        return mMessageDao.updateMMessage(mMessageDto);
    }

    /**
    * 删除MMessage
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteMMessage(MMessageDto mMessageDto){
        return mMessageDao.deleteMMessage(mMessageDto);
    }

}