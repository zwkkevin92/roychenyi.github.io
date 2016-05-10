package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.MGuestbookDto;
import com.cx.wxs.po.MGuestbook;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface MGuestbookDao extends IBaseDao<MGuestbook,Integer>{
    /**
    * 通过id获取MGuestbookDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public MGuestbookDto getMGuestbookByID(MGuestbookDto mGuestbookDto);

    /**
    * 通过相关数据获取MGuestbookDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<MGuestbookDto> getMGuestbookList(MGuestbookDto mGuestbookDto);

    /**
    * 添加一个新的MGuestbook到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addMGuestbook(MGuestbookDto mGuestbookDto);

    /**
    * 更新MGuestbook
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateMGuestbook(MGuestbookDto mGuestbookDto);

    /**
    * 删除MGuestbook
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteMGuestbook(MGuestbookDto mGuestbookDto);

}