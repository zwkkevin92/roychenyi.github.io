package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.DCatalogDao;
import com.cx.wxs.dao.DDiaryDao;
import com.cx.wxs.dto.DCatalogDto;
import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.service.DCatalogService;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("DCatalogService")
public class DCatalogServiceImpl implements DCatalogService {
    @Autowired
    private DCatalogDao dCatalogDao;
    @Autowired
    private DDiaryDao dDiaryDao;

    public void setDCatalogDao(DCatalogDao dCatalogDao){
        this.dCatalogDao=dCatalogDao;
    }

    /**
    * 通过用户id获取DCatalogDto信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public DCatalogDto getDCatalogByID(DCatalogDto dCatalogDto){
        return dCatalogDao.getDCatalogByID(dCatalogDto);
    }
    /**
     * 通过分类名字获取分类
     */
    @Override
    public DCatalogDto getDCatalog(DCatalogDto dCatalogDto){
    	return dCatalogDao.getDCatalog(dCatalogDto);
    }

    /**
    * 通过相关信息获取DCatalogDtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<DCatalogDto> getDCatalogList(DCatalogDto dCatalogDto){
    	List<DCatalogDto> list=dCatalogDao.getDCatalogList(dCatalogDto);
    	List<DCatalogDto> list1=new ArrayList<DCatalogDto>();
    	DCatalogDto catalogDto1=new DCatalogDto();
    	catalogDto1.setCatalogName("全部文章");
    	catalogDto1.setArticleCount(0);
    	//获取分类日志数
    	for(DCatalogDto catalogDto:list){
    //		DCatalogDto  dto1=dCatalogDao.getDCatalog(catalogDto);
    //		System.out.println(dto1.getUUserDto().getUserId());
    		DDiaryDto diaryDto=new DDiaryDto();
    		diaryDto.setDCatalogDto(catalogDto);
    		diaryDto.setUUserDto(dCatalogDto.getUUserDto());
    		int count=dDiaryDao.getDiaryCount(diaryDto);
    		catalogDto.setArticleCount(count);
    		dCatalogDao.updateDCatalog(catalogDto);
    		//获取全部日志的数量
    		catalogDto1.setArticleCount(catalogDto1.getArticleCount()+count);
    	}
    	list1.add(catalogDto1);
    	list=dCatalogDao.getDCatalogList(dCatalogDto);
    	list1.addAll(list);
    	return list1;
    }

    /**
    * 添加一个新的DCatalog到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addDCatalog(DCatalogDto dCatalogDto){
        return dCatalogDao.addDCatalog(dCatalogDto);
    }

    /**
    * 更新DCatalog
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateDCatalog(DCatalogDto dCatalogDto){
        return dCatalogDao.updateDCatalog(dCatalogDto);
    }

    /**
    * 删除DCatalog
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteDCatalog(DCatalogDto dCatalogDto){
        return dCatalogDao.deleteDCatalog(dCatalogDto);
    }

}