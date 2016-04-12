package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.DDiaryDao;
import com.cx.wxs.dto.DCatalogDto;
import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.service.DDiaryService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("DDiaryService")
public class DDiaryServiceImpl implements DDiaryService {
    @Autowired
    private DDiaryDao dDiaryDao;

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
	 */
	@Override
	public List<DDiaryDto> getCurrentDiarys(DDiaryDto diaryDto) {
		// TODO Auto-generated method stub
		return dDiaryDao.getCurrentDiarys(diaryDto);
	}

}