package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.WBookDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface WBookService {
    /**
    * 通过用户id获取WBookDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public WBookDto getWBookByID(WBookDto wBookDto);

    /**
    * 通过相关信息获取WBookDtoList信息
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