package com.cx.wxs.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;


import com.cx.wxs.dao.UsignDao;
import com.cx.wxs.dto.UsignDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.USign;
import com.cx.wxs.utils.StringUtils;
import com.cy.wxs.base.dao.BaseDaoImpl;

/**
 * @author 陈义
 * @date   2015-12-8 下午9:54:04
 */
public class UsignDaoImpl extends BaseDaoImpl<USign, Integer> implements UsignDao{
	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UsignDao#getUsignByUserid(com.cx.wxs.dto.UsignDto)
	 */
	@Override
	public UsignDto getUsignByID(UsignDto usignDto) {
		// TODO Auto-generated method stub
		if(usignDto!=null&&usignDto.getSignId()!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+USign.class.getName()+" a ");
			stringBuffer.append(" where signId=:signid");
			params.put("signid",usignDto.getSignId());
			List<UsignDto> list=this.findDto(stringBuffer.toString(),params,UsignDto.class);
			if(list!=null&&list.size()>0){
				return list.get(0);
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UsignDao#getUsignByID(com.cx.wxs.dto.UsignDto)
	 */
	@Override
	public UsignDto getUsignByUserid(UsignDto usignDto) {
		// TODO Auto-generated method stub
		if(usignDto!=null&&usignDto.getSignId()!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+USign.class.getName()+" a ");
			stringBuffer.append(" where a.UUser.userId=:userid ");
			stringBuffer.append(" order by a.signId desc ");
			params.put("userid",usignDto.getUuserDto().getUserId());
			List<UsignDto> list=this.findDto(stringBuffer.toString(),params,UsignDto.class);
			if(list!=null&&list.size()>0){
				return list.get(0);
			}
		}
		return null;
	}
	

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UsignDao#getUsignList(com.cx.wxs.dto.UsignDto)
	 */
	@Override
	public List<UsignDto> getUsignList(UsignDto usignDto) {
		// TODO Auto-generated method stub'
		if(usignDto!=null&&usignDto.getUuserDto().getUserId()!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+USign.class.getName()+" a ");
			stringBuffer.append(" where a.UUser.userId=:userid ");
			params.put("userid",usignDto.getUuserDto().getUserId());
			List<UsignDto> list=null;
			if(usignDto.getPage()!=null&&usignDto.getRows()!=null){
				list=this.findDto(stringBuffer.toString(),params,usignDto.getPage(),usignDto.getRows(),UsignDto.class);
			}else{
				list=this.findDto(stringBuffer.toString(),params,UsignDto.class);
			}
			return list;
		}
		return null;
	}

	
	
	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UsignDao#addSign(com.cx.wxs.dto.UsignDto)
	 */
	@Override
	public Integer addSign(UsignDto usignDto) {
		// TODO Auto-generated method stub\
		if(usignDto!=null&&usignDto.getUuserDto().getUserId()!=null&&usignDto.getContent()!=null){
			USign usign=new USign();
			BeanUtils.copyProperties(usignDto, usign);
			return this.save(usign);
		}
		return 0;
	}

	
	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UsignDao#updateSign(com.cx.wxs.dto.UsignDto)
	 */
	@Override
	public Integer updateSign(UsignDto usignDto) {
		// TODO Auto-generated method stub
		if(usignDto!=null&&usignDto.getUid()!=null){
			StringBuffer stringBuffer=new StringBuffer(DbType.UPDATE.toString());
			String[] fl=new String[]{"uid"};
			Map<String,Object> map=usignDto.createSetPropertiesVal(usignDto, "a", fl);
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+USign.class.getName()+" a ");
			stringBuffer.append(map.get(StringUtils.SET_HQL));
			stringBuffer.append(" where a.uid=:uid ");
			params.put("uid",usignDto.getUid());
			return this.executeHql(stringBuffer.toString(),params);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UsignDao#deleteSign(com.cx.wxs.dto.UsignDto)
	 */
	@Override
	public Integer deleteSign(UsignDto usignDto) {
		// TODO Auto-generated method stub
		if(usignDto.getUid()!=null){
			StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+USign.class.getName()+" a ");
			stringBuffer.append(" where a.uid=:uid");
			params.put("uid",usignDto.getUid());
			return this.executeHql(stringBuffer.toString(), params);
		}
		return 0;
	}


}
