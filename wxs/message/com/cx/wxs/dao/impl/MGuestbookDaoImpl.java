package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.MGuestbookDao;
import com.cx.wxs.dto.MGuestbookDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.MGuestbook;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:03:39
 */
@Repository("MGuestbookDao")
public class MGuestbookDaoImpl extends BaseDaoImpl<MGuestbook, Integer> implements MGuestbookDao{

    private BeanToDto<MGuestbook, MGuestbookDto> beanToDto;

    /**
    * 通过id获取MGuestbookDto
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public MGuestbookDto getMGuestbookByID(MGuestbookDto mGuestbookDto){
        // TODO Auto-generated method stub
        if(mGuestbookDto!=null&&mGuestbookDto.getGuestbookId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+MGuestbook.class.getName()+"  a where a.guestbookId=:id");
           params.put("id",mGuestbookDto.getGuestbookId());
           List<MGuestbook> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            MGuestbook t1= list.get(0);
            MGuestbookDto    dto=new    MGuestbookDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取MGuestbookDtoList
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public List<MGuestbookDto> getMGuestbookList(MGuestbookDto mGuestbookDto){
        return null;
    }

    /**
    * 添加一个新的MGuestbook到数据库
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer addMGuestbook(MGuestbookDto mGuestbookDto){
         // TODO Auto-generated method stub
        if(mGuestbookDto!=null){
           MGuestbook mGuestbook= new MGuestbook();
           mGuestbook=beanToDto.D1ToT1(mGuestbook, mGuestbookDto);
           return this.save(mGuestbook);
        }
        return 0;
    }

    /**
    * 更新MGuestbook
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer updateMGuestbook(MGuestbookDto mGuestbookDto){
        // TODO Auto-generated method stub
        if(mGuestbookDto!=null&&mGuestbookDto.getUid()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = mGuestbookDto.createSetPropertiesVal(mGuestbookDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+MGuestbook.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.guestbookId=:uid");
           params.put("uid",mGuestbookDto.getGuestbookId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除MGuestbook
    * @author 陈义
    * @date 2015-12-13 19:03:39
    */
    @Override
    public Integer deleteMGuestbook(MGuestbookDto mGuestbookDto){
         // TODO Auto-generated method stub
        if(mGuestbookDto!=null&&mGuestbookDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+MGuestbook.class.getName()+" a");
           stringBuffer.append(" where a.guestbookId=:uid ");
           params.put("uid",mGuestbookDto.getGuestbookId());
           MGuestbook mGuestbook= new MGuestbook();
           BeanUtils.copyProperties(mGuestbookDto, mGuestbook);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}