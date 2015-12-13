package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.IAccessDao;
import com.cx.wxs.dto.IAccessDto;
import com.cx.wxs.service.IAccessService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("IAccessService")
public class IAccessServiceImpl implements IAccessService {
    @Autowired
    private IAccessDao iAccessDao;

    public void setIAccessDao(IAccessDao iAccessDao){
        this.iAccessDao=iAccessDao;
    }

    /**
    * 通过用户id获取IAccessDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public IAccessDto getIAccessByID(IAccessDto iAccessDto){
        return iAccessDao.getIAccessByID(iAccessDto);
    }

    /**
    * 通过相关信息获取IAccessDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<IAccessDto> getIAccessList(IAccessDto iAccessDto){
        return iAccessDao.getIAccessList(iAccessDto);
    }

    /**
    * 添加一个新的IAccess到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addIAccess(IAccessDto iAccessDto){
        return iAccessDao.addIAccess(iAccessDto);
    }

    /**
    * 更新IAccess
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateIAccess(IAccessDto iAccessDto){
        return iAccessDao.updateIAccess(iAccessDto);
    }

    /**
    * 删除IAccess
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteIAccess(IAccessDto iAccessDto){
        return iAccessDao.deleteIAccess(iAccessDto);
    }

}