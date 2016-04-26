package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.SSoundDao;
import com.cx.wxs.dto.SSoundDto;
import com.cx.wxs.service.SSoundService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("SSoundService")
public class SSoundServiceImpl implements SSoundService {
    @Autowired
    private SSoundDao sSoundDao;

    public void setSSoundDao(SSoundDao sSoundDao){
        this.sSoundDao=sSoundDao;
    }

    /**
    * 通过用户id获取SSoundDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public SSoundDto getSSoundByID(SSoundDto sSoundDto){
        return sSoundDao.getSSoundByID(sSoundDto);
    }

    /**
    * 通过相关信息获取SSoundDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public List<SSoundDto> getSSoundList(SSoundDto sSoundDto){
        return sSoundDao.getSSoundList(sSoundDto);
    }

    /**
    * 添加一个新的SSound到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer addSSound(SSoundDto sSoundDto){
        return sSoundDao.addSSound(sSoundDto);
    }

    /**
    * 更新SSound
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer updateSSound(SSoundDto sSoundDto){
        return sSoundDao.updateSSound(sSoundDto);
    }

    /**
    * 删除SSound
    * @author 陈义
    * @date 2016-01-19 14:41:50
    */
    @Override
    public Integer deleteSSound(SSoundDto sSoundDto){
        return sSoundDao.deleteSSound(sSoundDto);
    }

}