package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.USignDto;

/**
 * @author 陈义
 * @date 2016-04-05 21:50:25
 */

public interface USignService {
    /**
    * 通过用户id获取USignDto信息
    * @author 陈义
    * @date 2016-04-05 21:50:25
    */
    
    public USignDto getUSignByID(USignDto uSignDto);

    /**
    * 通过相关信息获取USignDtoList信息
    * @author 陈义
    * @date 2016-04-05 21:50:25
    */
    
    public List<USignDto> getUSignList(USignDto uSignDto);

    /**
    * 添加一个新的USign到数据库
    * @author 陈义
    * @date 2016-04-05 21:50:25
    */
    
    public Integer addUSign(USignDto uSignDto);

    /**
    * 更新USign
    * @author 陈义
    * @date 2016-04-05 21:50:25
    */
    
    public Integer updateUSign(USignDto uSignDto);

    /**
    * 删除USign
    * @author 陈义
    * @date 2016-04-05 21:50:25
    */
    
    public Integer deleteUSign(USignDto uSignDto);
    /***
     * 设置用户的sign
     * @param uSignDto
     * @return
     * @author 陈义
     * @date   2016-4-5下午9:53:15
     */
    public Integer setUserSign(USignDto uSignDto);

}