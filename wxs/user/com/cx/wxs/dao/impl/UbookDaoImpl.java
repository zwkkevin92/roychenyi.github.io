package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;



import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.UBookDao;
import com.cx.wxs.dto.UBookDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.UBook;
import com.cx.wxs.po.UUser;
import com.cx.wxs.utils.BeanToDto;
import com.cx.wxs.utils.StringUtils;

/**
 * @author 陈义
 * @date   2015-12-3 下午5:29:08
 */
@Repository("UbookDao")
public class UBookDaoImpl extends BaseDaoImpl<UBook, Integer> implements UBookDao{

	private BeanToDto<UBook, UBookDto> beanToDto=new BeanToDto<UBook,UBookDto>();
	
	
	/**
	 * @return the beanToDto
	 */
	public BeanToDto<UBook, UBookDto> getBeanToDto() {
		return beanToDto;
	}

	/**
	 * @param beanToDto the beanToDto to set
	 */
	public void setBeanToDto(BeanToDto<UBook, UBookDto> beanToDto) {
		this.beanToDto = beanToDto;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UbookDao#getUBook(com.cx.wxs.dto.UBookDto)
	 * 通过UBook 的id获取图书信息
	 * @author 陈义
	 * @date  2015-12-4
	 */
	@Override
	public UBookDto getUBookByID(UBookDto ubookDto) {
		// TODO Auto-generated method stub
		if(ubookDto!=null&&ubookDto.getUbookId()!=null){
			StringBuffer stringBuffer=new StringBuffer();
			stringBuffer.append("from "+UBook.class.getName()+" a");
			stringBuffer.append(" where a.ubookId=:id");
			Map<String,Object> params=new HashMap<String, Object>();
			params.put("id",ubookDto.getUbookId());
			List<UBook> list=this.find(stringBuffer.toString(), params);
			UBookDto uBookDto=new UBookDto();
			if(list!=null&&list.size()>0){
				UBook ubook= list.get(0);
				BeanUtils.copyProperties(ubook, uBookDto);
				UUser user=ubook.getUUser();
				if(user!=null){
					UUserDto userDto=new UUserDto();
					BeanUtils.copyProperties(user, userDto);
					uBookDto.setUUserDto(userDto);
				}
			return	uBookDto;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UbookDao#getUBookList(com.cx.wxs.dto.UBookDto)
	 * 通过ubookDto的用户id，或者是用户名或者是书名，
	 * @auther 陈义
	 * @date  2015-12-4
	 */
	@Override
	public List<UBookDto> getUBookList(UBookDto ubookDto) {
		// TODO Auto-generated method stub
		if(ubookDto!=null){
			StringBuffer stringBuffer= new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append("from "+UBook.class.getName()+" a ");
			stringBuffer.append(" where 1=1 ");
			if(ubookDto.getUUserDto().getUserId()!=null){
				stringBuffer.append(" and a.UUser.UserId=:id ");
				params.put("id",ubookDto.getUUserDto().getUserId());
			}
			if(ubookDto.getUUserDto().getNickname()!=null){
				stringBuffer.append(" and a.UUser.Nickname like :nickname");
				params.put("nickname","%"+ubookDto.getUUserDto().getNickname()+"%");
			}
			if(ubookDto.getName()!=null){
				stringBuffer.append(" and a.name like :name");
				params.put("name","%"+ubookDto.getName()+"%");
			}
			List<UBook> list=new ArrayList<UBook>();
			if(ubookDto.getPage()!=null&&ubookDto.getRows()!=null){
			    list=this.find(stringBuffer.toString(),params,ubookDto.getPage(),ubookDto.getRows());
			}else{
				list=this.find(stringBuffer.toString(),params);
			}
			List<UBookDto> list1=new ArrayList<UBookDto>();
			if(list.size()>0){
				for(UBook book:list){
					UBookDto uBookDto=new UBookDto();
					BeanUtils.copyProperties(book, uBookDto);
					UUser user=book.getUUser();
					if(user!=null){
						UUserDto userDto=new UUserDto();
						BeanUtils.copyProperties(user, userDto);
						uBookDto.setUUserDto(userDto);
					}
					list1.add(uBookDto);
				}
			}		
			return list1;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UbookDao#addUBook(com.cx.wxs.dto.UBookDto)
	 * 添加新的book信息
	 * @auther 陈义
	 * @date  2015-12-4
	 */
	@Override
	public Integer addUBook(UBookDto ubookDto) {
		// TODO Auto-generated method stub
	if(ubookDto!=null&&StringUtils.isNotEmpty(ubookDto.getName())&&ubookDto.getUUserDto().getUserId()>0&&ubookDto.getUUserDto()!=null){
		if(ubookDto.getTime()!=null){	
		        Date time=new Date();
				ubookDto.setTime((Timestamp)time);
		}
				UBook ubook= new UBook();
				BeanUtils.copyProperties(ubookDto, ubook);
				UUser user=new UUser();
				BeanUtils.copyProperties(ubookDto.getUUserDto(), user);
				ubook.setUUser(user);
				return this.save(ubook);
			}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UbookDao#updateUBook(com.cx.wxs.dto.UBookDto)
	 */
	@Override
	public Integer updateUBook(UBookDto ubookDto) {
		// TODO Auto-generated method stub
		if(ubookDto!=null&&ubookDto.getUbookId()!=null&&ubookDto.getUbookId()>0){
			StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
			String[] fl = new String[]{"uid"};//过滤掉的字段
			Map<String, Object> map = ubookDto.createSetPropertiesVal(ubookDto, "a", fl);
			Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);		
			stringBuffer.append(" form "+UBook.class.getName()+" a");
			stringBuffer.append(map.get(StringUtils.SET_HQL));
			stringBuffer.append(" where a.ubookId=:uid");
			params.put("uid",ubookDto.getUid());
			return this.executeHql(stringBuffer.toString(),params);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UbookDao#deleteUBook(com.cx.wxs.dto.UBookDto)
	 * @auther 陈义
	 * @date   2015-12-7
	 */
	@Override
	public Integer deleteUBook(UBookDto ubookDto) {
		// TODO Auto-generated method stub
		if(ubookDto!=null&&ubookDto.getUbookId()!=null&&ubookDto.getUbookId()>0){
			StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
		    Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+UBook.class.getName()+" a ");
			stringBuffer.append(" where 1=1 ");
			if(ubookDto.getUbookId()!=null&&ubookDto.getUbookId()>0){
				stringBuffer.append(" and a.ubookId=:ubookid ");
				params.put("ubookid",ubookDto.getUbookId());
			}
			return this.executeHql(stringBuffer.toString(), params);
		}
		return 0;
	} 

}
