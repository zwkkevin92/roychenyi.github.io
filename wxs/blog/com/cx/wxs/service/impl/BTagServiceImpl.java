package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.BTagDao;
import com.cx.wxs.dto.BTagDto;
import com.cx.wxs.service.BTagService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("BTagService")
public class BTagServiceImpl implements BTagService {
    @Autowired
    private BTagDao bTagDao;

    public void setBTagDao(BTagDao bTagDao){
        this.bTagDao=bTagDao;
    }

    /**
    * 通过用户id获取BTagDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public BTagDto getBTagByID(BTagDto bTagDto){
        return bTagDao.getBTagByID(bTagDto);
    }

    /**
    * 通过相关信息获取BTagDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<BTagDto> getBTagList(BTagDto bTagDto){
        return bTagDao.getBTagList(bTagDto);
    }

    /**
    * 添加一个新的BTag到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addBTag(BTagDto bTagDto){
        return bTagDao.addBTag(bTagDto);
    }

    /**
    * 更新BTag
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateBTag(BTagDto bTagDto){
        return bTagDao.updateBTag(bTagDto);
    }

    /**
    * 删除BTag
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteBTag(BTagDto bTagDto){
        return bTagDao.deleteBTag(bTagDto);
    }

}