package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.SysIllegalDto;

/**
 * @author 陈义
 * @date 2016-03-24 21:47:22
 */

public interface SysIllegalService {
    /**
    * 通过用户id获取SysIllegalDto信息
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    public SysIllegalDto getSysIllegalByID(SysIllegalDto sysIllegalDto);
    /***
     * 通过关键字查询非法词信息
     * @param sysIllegalDto
     * @return
     * @author 陈义
     * @date   2016-3-25上午10:46:10
     */
    public SysIllegalDto getSysIllegal(SysIllegalDto sysIllegalDto);

    /**
    * 通过相关信息获取SysIllegalDtoList信息
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    public List<SysIllegalDto> getSysIllegalList(SysIllegalDto sysIllegalDto);

    /**
    * 添加一个新的SysIllegal到数据库
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    public Integer addSysIllegal(SysIllegalDto sysIllegalDto);

    /**
    * 更新SysIllegal
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    public Integer updateSysIllegal(SysIllegalDto sysIllegalDto);

    /**
    * 删除SysIllegal
    * @author 陈义
    * @date 2016-03-24 21:47:22
    */
    public Integer deleteSysIllegal(SysIllegalDto sysIllegalDto);
    
    /***
     * 验证内容中是否含有非法词
     * @param content 待验证的信息
     * @return 1 不非法    0 非法
     * @author 陈义
     * @date   2016-3-25上午10:52:23
     */
    public boolean IllegalCheck(String content);
    /***
     * 替换内容中的非法词
     * @param content  待验证替换的文本
     * @return
     * @author 陈义
     * @date   2016-3-25上午10:54:42
     */
    public String IllegalReplace(String content);

}