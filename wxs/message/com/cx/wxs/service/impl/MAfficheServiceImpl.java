package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.MAfficheDao;
import com.cx.wxs.dto.MAfficheDto;
import com.cx.wxs.service.MAfficheService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("MAfficheService")
public class MAfficheServiceImpl implements MAfficheService {
    @Autowired
    private MAfficheDao mAfficheDao;

    public void setMAfficheDao(MAfficheDao mAfficheDao){
        this.mAfficheDao=mAfficheDao;
    }

    /**
    * 通过用户id获取MAfficheDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public MAfficheDto getMAfficheByID(MAfficheDto mAfficheDto){
        return mAfficheDao.getMAfficheByID(mAfficheDto);
    }

    /**
    * 通过相关信息获取MAfficheDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<MAfficheDto> getMAfficheList(MAfficheDto mAfficheDto){
        return mAfficheDao.getMAfficheList(mAfficheDto);
    }

    /**
    * 添加一个新的MAffiche到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addMAffiche(MAfficheDto mAfficheDto){
        return mAfficheDao.addMAffiche(mAfficheDto);
    }

    /**
    * 更新MAffiche
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateMAffiche(MAfficheDto mAfficheDto){
        return mAfficheDao.updateMAffiche(mAfficheDto);
    }

    /**
    * 删除MAffiche
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteMAffiche(MAfficheDto mAfficheDto){
        return mAfficheDao.deleteMAffiche(mAfficheDto);
    }

}