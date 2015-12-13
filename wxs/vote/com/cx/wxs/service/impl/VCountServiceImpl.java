package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.VCountDao;
import com.cx.wxs.dto.VCountDto;
import com.cx.wxs.service.VCountService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("VCountService")
public class VCountServiceImpl implements VCountService {
    @Autowired
    private VCountDao vCountDao;

    public void setVCountDao(VCountDao vCountDao){
        this.vCountDao=vCountDao;
    }

    /**
    * 通过用户id获取VCountDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public VCountDto getVCountByID(VCountDto vCountDto){
        return vCountDao.getVCountByID(vCountDto);
    }

    /**
    * 通过相关信息获取VCountDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<VCountDto> getVCountList(VCountDto vCountDto){
        return vCountDao.getVCountList(vCountDto);
    }

    /**
    * 添加一个新的VCount到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addVCount(VCountDto vCountDto){
        return vCountDao.addVCount(vCountDto);
    }

    /**
    * 更新VCount
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateVCount(VCountDto vCountDto){
        return vCountDao.updateVCount(vCountDto);
    }

    /**
    * 删除VCount
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteVCount(VCountDto vCountDto){
        return vCountDao.deleteVCount(vCountDto);
    }

}