package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.WBookDto;
import com.cx.wxs.po.WBook;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface WBookDao extends IBaseDao<WBook,Integer>{
    /**
    * 通过id获取WBookDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public WBookDto getWBookByID(WBookDto wBookDto);

    /**
    * 通过相关数据获取WBookDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<WBookDto> getWBookList(WBookDto wBookDto);

    /**
    * 添加一个新的WBook到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addWBook(WBookDto wBookDto);

    /**
    * 更新WBook
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateWBook(WBookDto wBookDto);

    /**
    * 删除WBook
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteWBook(WBookDto wBookDto);

}