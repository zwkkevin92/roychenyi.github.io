package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.MMessageDto;
import com.cx.wxs.po.MMessage;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface MMessageDao extends IBaseDao<MMessage,Integer>{
    /**
    * 通过id获取MMessageDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public MMessageDto getMMessageByID(MMessageDto mMessageDto);

    /**
    * 通过相关数据获取MMessageDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<MMessageDto> getMMessageList(MMessageDto mMessageDto);

    /**
    * 添加一个新的MMessage到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addMMessage(MMessageDto mMessageDto);

    /**
    * 更新MMessage
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateMMessage(MMessageDto mMessageDto);

    /**
    * 删除MMessage
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteMMessage(MMessageDto mMessageDto);

}