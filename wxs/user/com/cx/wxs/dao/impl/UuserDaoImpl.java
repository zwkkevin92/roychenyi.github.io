package com.cx.wxs.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.dao.UuserDao;
import com.cx.wxs.dto.UuserDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.UBook;
import com.cx.wxs.po.UUser;
import com.cx.wxs.utils.StringUtils;
import com.cy.wxs.base.dao.BaseDaoImpl;

/**
 * @author 陈义
 * @date   2015-12-3 上午11:34:21
 */
@Repository("UuserDao")
public class UuserDaoImpl extends BaseDaoImpl<UUser, Integer> implements UuserDao{

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UuserDao#getUuser(com.cx.wxs.dto.UuserDto)
	 */
	@Override
	public UuserDto getUuser(UuserDto uuserDto) {
		// TODO Auto-generated method stub
		if(uuserDto!=null){
		    StringBuffer stringBuffer=new StringBuffer();
		    Map<String ,Object> params=new HashMap<String,Object>();
		    stringBuffer.append(" from "+UUser.class.getName()+" a ");
		    stringBuffer.append(" where 1=1 ");
			if(uuserDto.getUserId()!=null&&uuserDto.getUserId()>0){
				stringBuffer.append(" a.userId=:userId ");
				params.put("userId",uuserDto.getUserId());
			}
			if(uuserDto.getUsername()!=null){
				stringBuffer.append(" a.username=:username");
				params.put("username",uuserDto.getUsername());
			}
			List<UuserDto> list=this.findDto(stringBuffer.toString(), params, UuserDto.class);
			if(list!=null&&list.size()>0){
				return list.get(0);
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UuserDao#getUuserList(com.cx.wxs.dto.UuserDto)
	 */
	@Override
	public List<UuserDto> getUuserList(UuserDto uuserDto) {
		// TODO Auto-generated method stub
		if(uuserDto!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append("from "+UUser.class.getName()+" u");
			stringBuffer.append(" where 1=1 ");
			if(uuserDto.getSysRank().getRankId()!=null&&uuserDto.getSysRank().getRankId()>0){
				stringBuffer.append(" and u.sysRank.rankId=:rankId");
				params.put("rankId",uuserDto.getSysRank().getRankId());
			}
			if(uuserDto.getNickname()!=null){
				stringBuffer.append(" and u.nickname like :nickname");
				params.put("nickname","%"+uuserDto.getNickname()+"%");
			}
			
			List<UuserDto> list=null; 
			if(uuserDto.getPage()!=null&&uuserDto.getRows()!=null){
				list=this.findDto(stringBuffer.toString(),params,uuserDto.getPage(),uuserDto.getRows(),UuserDto.class);
			}else{
				list=this.findDto(stringBuffer.toString(),params,UuserDto.class);
			}
			return list;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UuserDao#addUuser(com.cx.wxs.dto.UuserDto)
	 */
	@Override
	public Integer addUuser(UuserDto uuserDto) {
		// TODO Auto-generated method stub
		if(uuserDto!=null&&uuserDto.getNickname()!=null&&uuserDto.getUsername()!=null&&uuserDto.getPassword()!=null){
			UUser uuser=new UUser();
			BeanUtils.copyProperties(uuserDto, uuser);
			return this.save(uuser);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UuserDao#updateUuser(com.cx.wxs.dto.UuserDto)
	 */
	@Override
	public Integer updateUuser(UuserDto uuserDto) {
		// TODO Auto-generated method stub
		if(uuserDto!=null&&uuserDto.getUserId()!=null&&uuserDto.getUserId()>0){
			StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
			String[] fl = new String[]{"uid"};//过滤掉的字段
			Map<String, Object> map = uuserDto.createSetPropertiesVal(uuserDto, "a", fl);
			Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);		
			stringBuffer.append(" form "+UBook.class.getName()+" a");
			stringBuffer.append(map.get(StringUtils.SET_HQL));
			stringBuffer.append(" where u.uid=:uid");
			params.put("uid",uuserDto.getUid());
			return this.executeHql(stringBuffer.toString(),params);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UuserDao#deleteUuser(com.cx.wxs.dto.UuserDto)
	 */
	@Override
	public Integer deleteUuser(UuserDto uuserDto) {
		// TODO Auto-generated method stub
		if(uuserDto!=null&&uuserDto.getUserId()!=null&&uuserDto.getUserId()>0){
			StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
		    Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+UBook.class.getName()+" a ");
			stringBuffer.append(" where 1=1 ");
				stringBuffer.append(" and userId=:userid ");
				params.put("userid",uuserDto.getUserId());
			return this.executeHql(stringBuffer.toString(), params);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UuserDao#getCountByRank(java.lang.Integer)
	 */
	public Integer getCountByRank(Integer rankID) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("select count(*) from "+UUser.class.getName()+" u ");
		stringBuffer.append(" where u.sysRank.rankId=:rankID");
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("rankID",rankID);
		return this.count(stringBuffer.toString(), params);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UuserDao#getUuserListByInvitationCode(com.cx.wxs.dto.UuserDto, java.util.List)
	 */
	@Override
	public List<UuserDto> getUuserListByInvitationCode(UuserDto userDto,
			List<Integer> codeIdList) {
		// TODO Auto-generated method stub
		if(userDto!=null&&codeIdList!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append("from "+UUser.class.getName()+" a ");
			stringBuffer.append(" where a.sysInvitationCode in (:codeIdList)");
			params.put("codeIdList",codeIdList);
			List<UuserDto> list=null;
			if(userDto.getPage()!=null&&userDto.getRows()!=null){
			list=this.findDto(stringBuffer.toString(),params,userDto.getPage(),userDto.getRows(),UuserDto.class);
			}else{
				list=this.findDto(stringBuffer.toString(),params,UuserDto.class);
			}
			return list;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UuserDao#login(com.cx.wxs.dto.UuserDto)
	 */
	@Override
	public UuserDto login(UuserDto uuserDto) {
		// TODO Auto-generated method stub
		if(uuserDto!=null&&StringUtils.isNotEmpty(uuserDto.getUsername())&&StringUtils.isNotEmpty(uuserDto.getPassword())){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+UUser.class.getName()+" a ");
			stringBuffer.append(" where a.username=:username and a.password=:password");
			params.put("username",uuserDto.getUsername());
			params.put("password",uuserDto.getPassword());
			List<UuserDto> list=this.findDto(stringBuffer.toString(),params,UuserDto.class);
			if(list!=null&&list.size()>0){
				return list.get(0);
			}
		}
		return null;
	}

}
