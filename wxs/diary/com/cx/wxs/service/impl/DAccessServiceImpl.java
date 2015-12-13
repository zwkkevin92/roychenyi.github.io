package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.DAccessDao;
import com.cx.wxs.dto.DAccessDto;
import com.cx.wxs.service.DAccessService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("DAccessService")
public class DAccessServiceImpl implements DAccessService {
    @Autowired
    private DAccessDao dAccessDao;

    public void setDAccessDao(DAccessDao dAccessDao){
        this.dAccessDao=dAccessDao;
    }

    /**
    * 通过用户id获取DAccessDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public DAccessDto getDAccessByID(DAccessDto dAccessDto){
        return dAccessDao.getDAccessByID(dAccessDto);
    }

    /**
    * 通过相关信息获取DAccessDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<DAccessDto> getDAccessList(DAccessDto dAccessDto){
        return dAccessDao.getDAccessList(dAccessDto);
    }

    /**
    * 添加一个新的DAccess到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addDAccess(DAccessDto dAccessDto){
        return dAccessDao.addDAccess(dAccessDto);
    }

    /**
    * 更新DAccess
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateDAccess(DAccessDto dAccessDto){
        return dAccessDao.updateDAccess(dAccessDto);
    }

    /**
    * 删除DAccess
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteDAccess(DAccessDto dAccessDto){
        return dAccessDao.deleteDAccess(dAccessDto);
    }

}