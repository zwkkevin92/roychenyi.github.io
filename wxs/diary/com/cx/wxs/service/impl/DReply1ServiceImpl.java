package com.cx.wxs.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.DReply1Dao;
import com.cx.wxs.dto.DReply1Dto;
import com.cx.wxs.service.DReply1Service;

/**
 * @author 陈义
 * @date 2016-01-19 14:41:49
 */

@Service("DReply1Service")
public class DReply1ServiceImpl implements DReply1Service {
    @Autowired
    private DReply1Dao dReply1Dao;

    public void setDReply1Dao(DReply1Dao dReply1Dao){
        this.dReply1Dao=dReply1Dao;
    }

    /**
    * 通过用户id获取DReply1Dto信息,一般是获取最新的评论
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public DReply1Dto getDReply1ByID(DReply1Dto dReply1Dto){
    	dReply1Dto=dReply1Dao.getDReply1ByID(dReply1Dto);
    	int row=dReply1Dao.getDReply1Count(dReply1Dto);
    	int pageCount=row/10+1;
    	dReply1Dto.setRow(row);
    	dReply1Dto.setRows(row);
    	dReply1Dto.setPage(pageCount);
    	dReply1Dto.setPageCount(pageCount);
        return dReply1Dto;
    }

    /**
    * 通过相关信息获取DReply1DtoList信息
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public List<DReply1Dto> getDReply1List(DReply1Dto dReply1Dto){
    	List<DReply1Dto> list=dReply1Dao.getDReply1List(dReply1Dto);
    	if(list!=null&&list.size()>0){
    		Integer count= dReply1Dao.getDReply1Count(dReply1Dto);
    		int pageCount=0;
    		if(dReply1Dto.getRows()==null){
    			pageCount=count/10;

    		}else{
    			pageCount=count/dReply1Dto.getRows();
    		}
			if(count%10>0){
				pageCount+=1;
			}
    		list.get(0).setRows(count);
    		list.get(0).setPageCount(pageCount);
    	}
        return list;
    }

    /**
    * 添加一个新的DReply1到数据库
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer addDReply1(DReply1Dto dReply1Dto){
        return dReply1Dao.addDReply1(dReply1Dto);
    }

    /**
    * 更新DReply1
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer updateDReply1(DReply1Dto dReply1Dto){
        return dReply1Dao.updateDReply1(dReply1Dto);
    }

    /**
    * 删除DReply1
    * @author 陈义
    * @date 2016-01-19 14:41:49
    */
    @Override
    public Integer deleteDReply1(DReply1Dto dReply1Dto){
        return dReply1Dao.deleteDReply1(dReply1Dto);
    }

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.DReply1Service#getDReply1Count(com.cx.wxs.dto.DReply1Dto)
	 */
	@Override
	public Integer getDReply1Count(DReply1Dto dReply1Dto) {
		// TODO Auto-generated method stub
		return dReply1Dao.getDReply1Count(dReply1Dto);
	}


    
    

}