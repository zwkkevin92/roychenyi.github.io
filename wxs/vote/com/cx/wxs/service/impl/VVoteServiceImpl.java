package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.VVoteDao;
import com.cx.wxs.dto.VVoteDto;
import com.cx.wxs.service.VVoteService;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */

@Service("VVoteService")
public class VVoteServiceImpl implements VVoteService {
    @Autowired
    private VVoteDao vVoteDao;

    public void setVVoteDao(VVoteDao vVoteDao){
        this.vVoteDao=vVoteDao;
    }

    /**
    * 通过用户id获取VVoteDto信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public VVoteDto getVVoteByID(VVoteDto vVoteDto){
        return vVoteDao.getVVoteByID(vVoteDto);
    }

    /**
    * 通过相关信息获取VVoteDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<VVoteDto> getVVoteList(VVoteDto vVoteDto){
        return vVoteDao.getVVoteList(vVoteDto);
    }

    /**
    * 添加一个新的VVote到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addVVote(VVoteDto vVoteDto){
        return vVoteDao.addVVote(vVoteDto);
    }

    /**
    * 更新VVote
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateVVote(VVoteDto vVoteDto){
        return vVoteDao.updateVVote(vVoteDto);
    }

    /**
    * 删除VVote
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteVVote(VVoteDto vVoteDto){
        return vVoteDao.deleteVVote(vVoteDto);
    }

}