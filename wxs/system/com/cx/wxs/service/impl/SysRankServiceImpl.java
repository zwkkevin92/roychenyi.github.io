package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SysRankDao;
import com.cx.wxs.dto.SysRankDto;
import com.cx.wxs.service.SysRankService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("SysRankService")
public class SysRankServiceImpl implements SysRankService {
    @Autowired
    private SysRankDao sysRankDao;

    public void setSysRankDao(SysRankDao sysRankDao){
        this.sysRankDao=sysRankDao;
    }

    /**
    * 通过用户id获取SysRankDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SysRankDto getSysRankByID(SysRankDto sysRankDto){
        return sysRankDao.getSysRankByID(sysRankDto);
    }

    /**
    * 通过相关信息获取SysRankDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SysRankDto> getSysRankList(SysRankDto sysRankDto){
        return sysRankDao.getSysRankList(sysRankDto);
    }

    /**
    * 添加一个新的SysRank到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSysRank(SysRankDto sysRankDto){
        return sysRankDao.addSysRank(sysRankDto);
    }

    /**
    * 更新SysRank
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSysRank(SysRankDto sysRankDto){
        return sysRankDao.updateSysRank(sysRankDto);
    }

    /**
    * 删除SysRank
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSysRank(SysRankDto sysRankDto){
        return sysRankDao.deleteSysRank(sysRankDto);
    }

}