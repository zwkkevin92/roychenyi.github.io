package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.WBookDao;
import com.cx.wxs.dto.WBookDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.WBook;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("WBookDao")
public class WBookDaoImpl extends BaseDaoImpl<WBook, Integer> implements WBookDao{

    private BeanToDto<WBook, WBookDto> beanToDto=new BeanToDto<WBook, WBookDto>();

    public BeanToDto<WBook, WBookDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<WBook, WBookDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取WBookDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public WBookDto getWBookByID(WBookDto wBookDto){
        // TODO Auto-generated method stub
        if(wBookDto!=null&&wBookDto.getWbookId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+WBook.class.getName()+"  a where a.wbookId=:id");
           params.put("id",wBookDto.getWbookId());
           List<WBook> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            WBook t1= list.get(0);
            WBookDto    dto=new    WBookDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取WBookDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<WBookDto> getWBookList(WBookDto wBookDto){
        return null;
    }

    /**
    * 添加一个新的WBook到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addWBook(WBookDto wBookDto){
         // TODO Auto-generated method stub
        if(wBookDto!=null){
           WBook wBook= new WBook();
           wBook=beanToDto.D1ToT1(wBook, wBookDto);
           return this.save(wBook);
        }
        return 0;
    }

    /**
    * 更新WBook
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateWBook(WBookDto wBookDto){
        // TODO Auto-generated method stub
        if(wBookDto!=null&&wBookDto.getWbookId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = wBookDto.createSetPropertiesVal(wBookDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+WBook.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.wbookId=:uid");
           params.put("uid",wBookDto.getWbookId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除WBook
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteWBook(WBookDto wBookDto){
         // TODO Auto-generated method stub
        if(wBookDto!=null&&wBookDto.getWbookId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+WBook.class.getName()+" a");
           stringBuffer.append(" where a.wbookId=:uid ");
           params.put("uid",wBookDto.getWbookId());
           WBook wBook= new WBook();
           BeanUtils.copyProperties(wBookDto, wBook);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}