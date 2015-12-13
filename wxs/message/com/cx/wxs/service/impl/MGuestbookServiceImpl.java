package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.MGuestbookDao;
import com.cx.wxs.dto.MGuestbookDto;
import com.cx.wxs.service.MGuestbookService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("MGuestbookService")
public class MGuestbookServiceImpl implements MGuestbookService {
    @Autowired
    private MGuestbookDao mGuestbookDao;

    public void setMGuestbookDao(MGuestbookDao mGuestbookDao){
        this.mGuestbookDao=mGuestbookDao;
    }

    /**
    * 通过用户id获取MGuestbookDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public MGuestbookDto getMGuestbookByID(MGuestbookDto mGuestbookDto){
        return mGuestbookDao.getMGuestbookByID(mGuestbookDto);
    }

    /**
    * 通过相关信息获取MGuestbookDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<MGuestbookDto> getMGuestbookList(MGuestbookDto mGuestbookDto){
        return mGuestbookDao.getMGuestbookList(mGuestbookDto);
    }

    /**
    * 添加一个新的MGuestbook到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addMGuestbook(MGuestbookDto mGuestbookDto){
        return mGuestbookDao.addMGuestbook(mGuestbookDto);
    }

    /**
    * 更新MGuestbook
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateMGuestbook(MGuestbookDto mGuestbookDto){
        return mGuestbookDao.updateMGuestbook(mGuestbookDto);
    }

    /**
    * 删除MGuestbook
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteMGuestbook(MGuestbookDto mGuestbookDto){
        return mGuestbookDao.deleteMGuestbook(mGuestbookDto);
    }

}