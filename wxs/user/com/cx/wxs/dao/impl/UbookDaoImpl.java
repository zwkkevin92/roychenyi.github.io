package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;



import com.cx.wxs.dao.UbookDao;
import com.cx.wxs.dto.UbookDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.UBook;
import com.cx.wxs.utils.StringUtils;
import com.cy.wxs.base.dao.BaseDaoImpl;

/**
 * @author 陈义
 * @date   2015-12-3 下午5:29:08
 */
@Repository("UbookDao")
public class UbookDaoImpl extends BaseDaoImpl<UBook, Integer> implements UbookDao{

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UbookDao#getUBook(com.cx.wxs.dto.UbookDto)
	 * 通过UBook 的id获取图书信息
	 * @author 陈义
	 * @date  2015-12-4
	 */
	@Override
	public UbookDto getUBookByID(UbookDto ubookDto) {
		// TODO Auto-generated method stub
		if(ubookDto!=null&&ubookDto.getUbookId()!=null){
			StringBuffer stringBuffer=new StringBuffer();
			stringBuffer.append("from "+UBook.class.getName()+" a");
			stringBuffer.append(" where a.ubookId=:id");
			Map<String,Object> params=new HashMap<String, Object>();
			params.put("id",ubookDto.getUbookId());
			List<UbookDto> list=this.findDto(stringBuffer.toString(), params, UbookDto.class);
			if(list!=null&&list.size()>0){
			return	list.get(0);
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UbookDao#getUBookList(com.cx.wxs.dto.UbookDto)
	 * 通过ubookDto的用户id，或者是用户名或者是书名，
	 * @auther 陈义
	 * @date  2015-12-4
	 */
	@Override
	public List<UbookDto> getUBookList(UbookDto ubookDto) {
		// TODO Auto-generated method stub
		if(ubookDto!=null){
			StringBuffer stringBuffer= new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append("from "+UBook.class.getName()+" a ");
			stringBuffer.append(" where 1=1 ");
			if(ubookDto.getUuserDto().getUserId()!=null){
				stringBuffer.append(" and a.UUser.UserId=:id ");
				params.put("id",ubookDto.getUuserDto().getUserId());
			}
			if(ubookDto.getUuserDto().getNickname()!=null){
				stringBuffer.append(" and a.UUser.Nickname like :nickname");
				params.put("nickname","%"+ubookDto.getUuserDto().getNickname()+"%");
			}
			if(ubookDto.getName()!=null){
				stringBuffer.append(" and a.name like :name");
				params.put("name","%"+ubookDto.getName()+"%");
			}
			List<UbookDto> list=this.findDto(stringBuffer.toString(), params, UbookDto.class);
			return list;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UbookDao#addUBook(com.cx.wxs.dto.UbookDto)
	 * 添加新的book信息
	 * @auther 陈义
	 * @date  2015-12-4
	 */
	@Override
	public Integer addUBook(UbookDto ubookDto) {
		// TODO Auto-generated method stub
	if(ubookDto!=null&&StringUtils.isNotEmpty(ubookDto.getName())&&ubookDto.getUuserDto().getUserId()>0){
				Date time=new Date();
				ubookDto.setTime((Timestamp)time);
				UBook ubook= new UBook();
				BeanUtils.copyProperties(ubookDto, ubook);
				return this.save(ubook);
			}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UbookDao#updateUBook(com.cx.wxs.dto.UbookDto)
	 */
	@Override
	public Integer updateUBook(UbookDto ubookDto) {
		// TODO Auto-generated method stub
		if(ubookDto!=null&&ubookDto.getUbookId()!=null&&ubookDto.getUbookId()>0){
			StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
			String[] fl = new String[]{"uid"};//过滤掉的字段
			Map<String, Object> map = ubookDto.createSetPropertiesVal(ubookDto, "a", fl);
			Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);		
			stringBuffer.append(" form "+UBook.class.getName()+" a");
			stringBuffer.append(map.get(StringUtils.SET_HQL));
			stringBuffer.append(" where u.uid=:uid");
			params.put("uid",ubookDto.getUid());
			return this.executeHql(stringBuffer.toString(),params);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UbookDao#deleteUBook(com.cx.wxs.dto.UbookDto)
	 * @auther 陈义
	 * @date   2015-12-7
	 */
	@Override
	public Integer deleteUBook(UbookDto ubookDto) {
		// TODO Auto-generated method stub
		if(ubookDto!=null&&ubookDto.getUbookId()!=null&&ubookDto.getUbookId()>0){
			StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
		    Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+UBook.class.getName()+" a ");
			stringBuffer.append(" where 1=1 ");
			if(ubookDto.getUbookId()!=null&&ubookDto.getUbookId()>0){
				stringBuffer.append(" and ubookId=:ubookid ");
				params.put("ubookid",ubookDto.getUbookId());
			}
			return this.executeHql(stringBuffer.toString(), params);
		}
		return 0;
	} 

}
