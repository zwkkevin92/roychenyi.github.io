package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.DUpvoteDao;
import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.dto.DUpvoteDto;
import com.cx.wxs.service.DUpvoteService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("DUpvoteService")
public class DUpvoteServiceImpl implements DUpvoteService {
    @Autowired
    private DUpvoteDao dUpvoteDao;

    public void setDUpvoteDao(DUpvoteDao dUpvoteDao){
        this.dUpvoteDao=dUpvoteDao;
    }

    /**
    * 通过用户id获取DUpvoteDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public DUpvoteDto getDUpvoteByID(DUpvoteDto dUpvoteDto){
        return dUpvoteDao.getDUpvoteByID(dUpvoteDto);
    }
    @Override
    public DUpvoteDto getDUpvote(DUpvoteDto dUpvoteDto){
    	return dUpvoteDao.getDUpvote(dUpvoteDto);
    }

    /**
    * 通过相关信息获取DUpvoteDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<DUpvoteDto> getDUpvoteList(DUpvoteDto dUpvoteDto){
        return dUpvoteDao.getDUpvoteList(dUpvoteDto);
    }

    /**
    * 添加一个新的DUpvote到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addDUpvote(DUpvoteDto dUpvoteDto){
        return dUpvoteDao.addDUpvote(dUpvoteDto);
    }

    /**
    * 更新DUpvote
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateDUpvote(DUpvoteDto dUpvoteDto){
        return dUpvoteDao.updateDUpvote(dUpvoteDto);
    }

    /**
    * 删除DUpvote
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteDUpvote(DUpvoteDto dUpvoteDto){
        return dUpvoteDao.deleteDUpvote(dUpvoteDto);
    }

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.DUpvoteService#getDUpvoteCount(com.cx.wxs.dto.DUpvoteDto)
	 */
	@Override
	public Integer getDUpvoteCount(DUpvoteDto dUpvoteDto) {
		// TODO Auto-generated method stub
		return dUpvoteDao.getDUpvoteCount(dUpvoteDto);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.DUpvoteService#getdDiarysByUpvote(com.cx.wxs.dto.DUpvoteDto)
	 */
	@Override
	public List<DDiaryDto> getdDiarysByUpvote(DUpvoteDto dUpvoteDto) {
		// TODO Auto-generated method stub
		return null;
	}

}