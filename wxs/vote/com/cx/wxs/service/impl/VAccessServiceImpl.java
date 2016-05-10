package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.VAccessDao;
import com.cx.wxs.dto.VAccessDto;
import com.cx.wxs.service.VAccessService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("VAccessService")
public class VAccessServiceImpl implements VAccessService {
    @Autowired
    private VAccessDao vAccessDao;

    public void setVAccessDao(VAccessDao vAccessDao){
        this.vAccessDao=vAccessDao;
    }

    /**
    * 通过用户id获取VAccessDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public VAccessDto getVAccessByID(VAccessDto vAccessDto){
        return vAccessDao.getVAccessByID(vAccessDto);
    }

    /**
    * 通过相关信息获取VAccessDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<VAccessDto> getVAccessList(VAccessDto vAccessDto){
        return vAccessDao.getVAccessList(vAccessDto);
    }

    /**
    * 添加一个新的VAccess到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addVAccess(VAccessDto vAccessDto){
        return vAccessDao.addVAccess(vAccessDto);
    }

    /**
    * 更新VAccess
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateVAccess(VAccessDto vAccessDto){
        return vAccessDao.updateVAccess(vAccessDto);
    }

    /**
    * 删除VAccess
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteVAccess(VAccessDto vAccessDto){
        return vAccessDao.deleteVAccess(vAccessDto);
    }

}