package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SAccessDao;
import com.cx.wxs.dto.SAccessDto;
import com.cx.wxs.service.SAccessService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("SAccessService")
public class SAccessServiceImpl implements SAccessService {
    @Autowired
    private SAccessDao sAccessDao;

    public void setSAccessDao(SAccessDao sAccessDao){
        this.sAccessDao=sAccessDao;
    }

    /**
    * 通过用户id获取SAccessDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SAccessDto getSAccessByID(SAccessDto sAccessDto){
        return sAccessDao.getSAccessByID(sAccessDto);
    }

    /**
    * 通过相关信息获取SAccessDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SAccessDto> getSAccessList(SAccessDto sAccessDto){
        return sAccessDao.getSAccessList(sAccessDto);
    }

    /**
    * 添加一个新的SAccess到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSAccess(SAccessDto sAccessDto){
        return sAccessDao.addSAccess(sAccessDto);
    }

    /**
    * 更新SAccess
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSAccess(SAccessDto sAccessDto){
        return sAccessDao.updateSAccess(sAccessDto);
    }

    /**
    * 删除SAccess
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSAccess(SAccessDto sAccessDto){
        return sAccessDao.deleteSAccess(sAccessDto);
    }

}