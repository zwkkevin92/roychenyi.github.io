package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.DFavoriteDao;
import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.dto.DFavoriteDto;
import com.cx.wxs.service.DFavoriteService;

/**
 * @author 陈义
 * @date 2016-04-16 09:22:44
 */

@Service("DFavoriteService")
public class DFavoriteServiceImpl implements DFavoriteService {
    @Autowired
    private DFavoriteDao dFavoriteDao;

    public void setDFavoriteDao(DFavoriteDao dFavoriteDao){
        this.dFavoriteDao=dFavoriteDao;
    }

    /**
    * 通过用户id获取DFavoriteDto信息
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public DFavoriteDto getDFavoriteByID(DFavoriteDto dFavoriteDto){
        return dFavoriteDao.getDFavoriteByID(dFavoriteDto);
    }
    
    @Override
    public DFavoriteDto getDFavorite(DFavoriteDto dFavoriteDto){
    	return dFavoriteDao.getDFavorite(dFavoriteDto);
    }

    /**
    * 通过相关信息获取DFavoriteDtoList信息
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public List<DFavoriteDto> getDFavoriteList(DFavoriteDto dFavoriteDto){
        List<DFavoriteDto> list=dFavoriteDao.getDFavoriteList(dFavoriteDto);
        if(list!=null&&list.size()>0){
        	Integer count=dFavoriteDao.getDFavoriteCount(dFavoriteDto);
        	int pageCount=0;
        	if(dFavoriteDto.getRows()!=null){
        		pageCount=count/dFavoriteDto.getRows();
        	}else{
        		pageCount=count/10;
        	}
        	list.get(0).setRows(count);
        	list.get(0).setPageCount(count%10>0?pageCount+1:pageCount);
        }
    	return list;
    }

    /**
    * 添加一个新的DFavorite到数据库
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public Integer addDFavorite(DFavoriteDto dFavoriteDto){
        return dFavoriteDao.addDFavorite(dFavoriteDto);
    }

    /**
    * 更新DFavorite
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public Integer updateDFavorite(DFavoriteDto dFavoriteDto){
        return dFavoriteDao.updateDFavorite(dFavoriteDto);
    }

    /**
    * 删除DFavorite
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public Integer deleteDFavorite(DFavoriteDto dFavoriteDto){
        return dFavoriteDao.deleteDFavorite(dFavoriteDto);
    }

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.DFavoriteService#getDFavoriteCount(com.cx.wxs.dto.DFavoriteDto)
	 */
	@Override
	public Integer getDFavoriteCount(DFavoriteDto dFavoriteDto) {
		// TODO Auto-generated method stub
		return dFavoriteDao.getDFavoriteCount(dFavoriteDto);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.DFavoriteService#getDiarysByFavorite(com.cx.wxs.dto.DFavoriteDto)
	 */
	@Override
	public List<DDiaryDto> getDiarysByFavorite(DFavoriteDto dFavoriteDto) {
		// TODO Auto-generated method stub
		List<DFavoriteDto> list=dFavoriteDao.getDFavoriteList(dFavoriteDto);
        List<DDiaryDto> list1=new ArrayList<DDiaryDto>();
		if(list!=null&&list.size()>0){
			for(DFavoriteDto favoriteDto:list){
				DDiaryDto diaryDto=favoriteDto.getDDiaryDto();
				diaryDto.setWriteTime(favoriteDto.getTime());
				diaryDto.setPage(favoriteDto.getPage());
				diaryDto.setRow(favoriteDto.getRow());
				list1.add(diaryDto);				
			}
			//收藏的总行数
        	Integer count=dFavoriteDao.getDFavoriteCount(dFavoriteDto);
        	int pageCount=0;
        	if(dFavoriteDto.getRows()!=null){
        		pageCount=count/dFavoriteDto.getRows();
        	}else{
        		pageCount=count/10;
        	}
        	list1.get(0).setRows(count);
        	list1.get(0).setPageCount(count%10>0?pageCount+1:pageCount);
        }
    	return list1;
	}

}