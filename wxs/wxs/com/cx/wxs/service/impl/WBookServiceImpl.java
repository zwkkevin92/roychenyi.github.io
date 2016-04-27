package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.WBookDao;
import com.cx.wxs.dto.WBookDto;
import com.cx.wxs.service.WBookService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("WBookService")
public class WBookServiceImpl implements WBookService {
    @Autowired
    private WBookDao wBookDao;

    public void setWBookDao(WBookDao wBookDao){
        this.wBookDao=wBookDao;
    }

    /**
    * 通过用户id获取WBookDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public WBookDto getWBookByID(WBookDto wBookDto){
        return wBookDao.getWBookByID(wBookDto);
    }

    /**
    * 通过相关信息获取WBookDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<WBookDto> getWBookList(WBookDto wBookDto){
        return wBookDao.getWBookList(wBookDto);
    }

    /**
    * 添加一个新的WBook到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addWBook(WBookDto wBookDto){
        return wBookDao.addWBook(wBookDto);
    }

    /**
    * 更新WBook
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateWBook(WBookDto wBookDto){
        return wBookDao.updateWBook(wBookDto);
    }

    /**
    * 删除WBook
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteWBook(WBookDto wBookDto){
        return wBookDao.deleteWBook(wBookDto);
    }

}