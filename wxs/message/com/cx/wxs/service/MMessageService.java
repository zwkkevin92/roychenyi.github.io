package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.MMessageDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface MMessageService {
    /**
    * 通过用户id获取MMessageDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public MMessageDto getMMessageByID(MMessageDto mMessageDto);

    /**
    * 通过相关信息获取MMessageDtoList信息
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