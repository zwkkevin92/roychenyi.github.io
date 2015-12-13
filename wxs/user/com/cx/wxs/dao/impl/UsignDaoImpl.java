package com.cx.wxs.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;


import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.USignDao;
import com.cx.wxs.dto.USignDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.USign;
import com.cx.wxs.utils.BeanToDto;
import com.cx.wxs.utils.StringUtils;

/**
 * @author 陈义
 * @date   2015-12-8 下午9:54:04
 */
public class USignDaoImpl extends BaseDaoImpl<USign, Integer> implements USignDao{
	
	private BeanToDto<USign,USignDto> beanToDto=new BeanToDto<USign,USignDto>();
	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UsignDao#getUsignByUserid(com.cx.wxs.dto.USignDto)
	 */
	@Override
	public USignDto getUsignByID(USignDto usignDto) {
		// TODO Auto-generated method stub
		if(usignDto!=null&&usignDto.getSignId()!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+USign.class.getName()+" a ");
			stringBuffer.append(" where signId=:signid");
			params.put("signid",usignDto.getSignId());
			List<USign> list=this.find(stringBuffer.toString(),params);
			if(list!=null&&list.size()>0){
				USign usign=  list.get(0);
				USignDto dto=beanToDto.T1ToD1(usign,new USignDto());
				return dto;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UsignDao#getUsignByID(com.cx.wxs.dto.USignDto)
	 */
	@Override
	public USignDto getUsignByUserid(USignDto usignDto) {
		// TODO Auto-generated method stub
		if(usignDto!=null&&usignDto.getSignId()!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+USign.class.getName()+" a ");
			stringBuffer.append(" where a.UUser.userId=:userid ");
			stringBuffer.append(" order by a.signId desc ");
			params.put("userid",usignDto.getUUserDto().getUserId());
			List<USign> list=this.find(stringBuffer.toString(),params);
			if(list!=null&&list.size()>0){
				USign usign=  list.get(0);
				USignDto dto=beanToDto.T1ToD1(usign,new USignDto());
				return dto;
			}
		}
		return null;
	}
	

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UsignDao#getUsignList(com.cx.wxs.dto.USignDto)
	 */
	@Override
	public List<USignDto> getUsignList(USignDto usignDto) {
		// TODO Auto-generated method stub'
		if(usignDto!=null&&usignDto.getUUserDto().getUserId()!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+USign.class.getName()+" a ");
			stringBuffer.append(" where a.UUser.userId=:userid ");
			params.put("userid",usignDto.getUUserDto().getUserId());
			List<USignDto> list=new ArrayList<USignDto>();
			List<USign> list1=new ArrayList<USign>();
			if(usignDto.getPage()!=null&&usignDto.getRows()!=null){
				list1=this.find(stringBuffer.toString(),params,usignDto.getPage(),usignDto.getRows());
			}else{
				list1=this.find(stringBuffer.toString(),params);
			}
			for(USign usign:list1){
				USignDto dto=beanToDto.T1ToD1(usign,new USignDto());
				list.add(dto);
			}
			return list;
		}
		return null;
	}

	
	
	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UsignDao#addSign(com.cx.wxs.dto.USignDto)
	 */
	@Override
	public Integer addSign(USignDto usignDto) {
		// TODO Auto-generated method stub\
		if(usignDto!=null&&usignDto.getUUserDto().getUserId()!=null&&usignDto.getContent()!=null){
			USign usign=new USign();
			usign=beanToDto.D1ToT1(usign,usignDto);
		//	BeanUtils.copyProperties(usignDto, usign);
			return this.save(usign);
		}
		return 0;
	}

	
	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UsignDao#updateSign(com.cx.wxs.dto.USignDto)
	 */
	@Override
	public Integer updateSign(USignDto usignDto) {
		// TODO Auto-generated method stub
		if(usignDto!=null&&usignDto.getUid()!=null){
			StringBuffer stringBuffer=new StringBuffer(DbType.UPDATE.toString());
			String[] fl=new String[]{"uid"};
			Map<String,Object> map=usignDto.createSetPropertiesVal(usignDto, "a", fl);
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+USign.class.getName()+" a ");
			stringBuffer.append(map.get(StringUtils.SET_HQL));
			stringBuffer.append(" where a.signId=:uid ");
			params.put("uid",usignDto.getUid());
			return this.executeHql(stringBuffer.toString(),params);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UsignDao#deleteSign(com.cx.wxs.dto.USignDto)
	 */
	@Override
	public Integer deleteSign(USignDto usignDto) {
		// TODO Auto-generated method stub
		if(usignDto.getUid()!=null){
			StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+USign.class.getName()+" a ");
			stringBuffer.append(" where a.signId=:uid");
			params.put("uid",usignDto.getUid());
			return this.executeHql(stringBuffer.toString(), params);
		}
		return 0;
	}


}
