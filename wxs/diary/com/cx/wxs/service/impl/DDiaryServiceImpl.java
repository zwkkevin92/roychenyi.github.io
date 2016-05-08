package com.cx.wxs.service.impl;

import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.DAccessDao;
import com.cx.wxs.dao.DDiaryDao;
import com.cx.wxs.dao.DFavoriteDao;
import com.cx.wxs.dao.DReply1Dao;
import com.cx.wxs.dao.DUpvoteDao;
import com.cx.wxs.dto.DAccessDto;
import com.cx.wxs.dto.DCatalogDto;
import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.dto.DFavoriteDto;
import com.cx.wxs.dto.DReply1Dto;
import com.cx.wxs.dto.DUpvoteDto;
import com.cx.wxs.service.DDiaryService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("DDiaryService")
public class DDiaryServiceImpl implements DDiaryService {
    @Autowired
    private DDiaryDao dDiaryDao;
    @Autowired
    private DFavoriteDao dFavoriteDao;
    @Autowired
    private DUpvoteDao dUpvoteDao;
    @Autowired
    private DReply1Dao dReply1Dao;
    @Autowired
    private DAccessDao dAccessDao;

    public void setDDiaryDao(DDiaryDao dDiaryDao){
        this.dDiaryDao=dDiaryDao;
    }

    /**
    * 通过用户id获取DDiaryDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public DDiaryDto getDDiaryByID(DDiaryDto dDiaryDto){
        return dDiaryDao.getDDiaryByID(dDiaryDto);
    }

    /**
    * 通过相关信息获取DDiaryDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<DDiaryDto> getDDiaryList(DDiaryDto dDiaryDto){
        return dDiaryDao.getDDiaryList(dDiaryDto);
    }

    /**
    * 添加一个新的DDiary到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addDDiary(DDiaryDto dDiaryDto){
        return dDiaryDao.addDDiary(dDiaryDto);
    }

    /**
    * 更新DDiary
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateDDiary(DDiaryDto dDiaryDto){
        return dDiaryDao.updateDDiary(dDiaryDto);
    }

    /**
    * 删除DDiary
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteDDiary(DDiaryDto dDiaryDto){
        return dDiaryDao.deleteDDiary(dDiaryDto);
    }

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.DDiaryService#diaryMove1(com.cx.wxs.dto.DCatalogDto)
	 */
	@Override
	public Integer diaryMove(DDiaryDto diaryDto,DCatalogDto catalogDto) {
		// TODO Auto-generated method stub
		return dDiaryDao.diaryMove(diaryDto,catalogDto);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.DDiaryService#getCurrentDiarys(com.cx.wxs.dto.DDiaryDto)
	 * 获取最近的文章依旧上下两篇文章，并且更新文章数据
	 */
	@Override
	public List<DDiaryDto> getCurrentDiarys(DDiaryDto diaryDto) {
		// TODO Auto-generated method stub
		//收藏数量
		DFavoriteDto dFavoriteDto=new DFavoriteDto();
		dFavoriteDto.setDDiaryDto(diaryDto);
		int favoriteCount =dFavoriteDao.getDFavoriteCount(dFavoriteDto);
		diaryDto.setFavoriteCount(favoriteCount);
		//点赞数量
		DUpvoteDto dUpvoteDto=new DUpvoteDto();
		dUpvoteDto.setDDiaryDto(diaryDto);
		int upvoteCount=dUpvoteDao.getDUpvoteCount(dUpvoteDto);
		diaryDto.setUpvoteCount(upvoteCount);
		/*//访问数量  不更新，这样会清楚游客访问数量
		DAccessDto dAccessDto=new DAccessDto();
		dAccessDto.setDDiaryDto(diaryDto);
		int accessCount =dAccessDao.getDAccessCount(dAccessDto);
		diaryDto.setViewCount(accessCount);*/
		//评论数量
		DReply1Dto dReply1Dto=new DReply1Dto();
		dReply1Dto.setDDiaryDto(diaryDto);
		int replyCount=dReply1Dao.getDReply1Count(dReply1Dto);
		diaryDto.setReplyCount(replyCount);
		//更新统计数据
		dDiaryDao.updateDDiary(diaryDto);
		return dDiaryDao.getCurrentDiarys(diaryDto);
	}
	@Override
	 public DDiaryDto getPageInfo(DDiaryDto diaryDto){
		int count=dDiaryDao.getDiaryCount(diaryDto);
		int pageCount=0;
		if(count%diaryDto.getRows()>0){
		pageCount=(count/diaryDto.getRows())+1;
		}else{
			pageCount=count/diaryDto.getRows();
		}
		diaryDto.setPageCont(pageCount);
		return diaryDto;
	}

}