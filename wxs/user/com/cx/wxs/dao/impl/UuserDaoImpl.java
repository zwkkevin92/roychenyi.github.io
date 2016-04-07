package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.UUserDao;
import com.cx.wxs.dto.SysRankDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.UBook;
import com.cx.wxs.po.UUser;
import com.cx.wxs.utils.BeanToDto;
import com.cx.wxs.utils.StringUtils;

/**
 * @author 陈义
 * @date   2015-12-3 上午11:34:21
 */
@Repository("UuserDao") 
public class UUserDaoImpl extends BaseDaoImpl<UUser, Integer> implements UUserDao{

	
	private BeanToDto<UUser,UUserDto> beanToDto=new BeanToDto<UUser,UUserDto>();
	
	/**
	 * @return the beanToDto
	 */
	public BeanToDto<UUser, UUserDto> getBeanToDto() {
		return beanToDto;
	}

	/**
	 * @param beanToDto the beanToDto to set
	 */
	public void setBeanToDto(BeanToDto<UUser, UUserDto> beanToDto) {
		this.beanToDto = beanToDto;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UuserDao#getUuser(com.cx.wxs.dto.UUserDto)
	 */
	@Override
	public UUserDto getUuser(UUserDto uuserDto) {
		// TODO Auto-generated method stub
		if(uuserDto!=null){
		    StringBuffer stringBuffer=new StringBuffer();
		    Map<String ,Object> params=new HashMap<String,Object>();
		    stringBuffer.append(" from "+UUser.class.getName()+" a ");
		    stringBuffer.append(" where 1=1 ");
			if(uuserDto.getUserId()!=null&&uuserDto.getUserId()>0){
				stringBuffer.append(" and  a.userId=:userId ");
				params.put("userId",uuserDto.getUserId());
			}
			if(uuserDto.getUsername()!=null){
				stringBuffer.append(" and a.username=:username");
				params.put("username",uuserDto.getUsername());
			}
			if(uuserDto.getNickname()!=null){
				stringBuffer.append(" and a.nickname=:nickname");
				params.put("nickname",uuserDto.getNickname());
			}
			List<UUser> list=this.find(stringBuffer.toString(), params);
			if(list!=null&&list.size()>0){
				UUser uuser= list.get(0);
				UUserDto dto=new UUserDto(); 
				dto=beanToDto.T1ToD1(uuser, dto);
				return dto;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UuserDao#getUuserList(com.cx.wxs.dto.UUserDto)
	 */
	@Override
	public List<UUserDto> getUuserList(UUserDto uuserDto) {
		// TODO Auto-generated method stub
		if(uuserDto!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append("from "+UUser.class.getName()+" u");
			stringBuffer.append(" where 1=1 ");
			if(uuserDto.getSysRankDto().getRankId()!=null&&uuserDto.getSysRankDto().getRankId()>0){
				stringBuffer.append(" and u.sysRank.rankId=:rankId");
				params.put("rankId",uuserDto.getSysRankDto().getRankId());
			}
			if(uuserDto.getNickname()!=null){
				stringBuffer.append(" and u.nickname like :nickname");
				params.put("nickname","%"+uuserDto.getNickname()+"%");
			}
			
			List<UUserDto> list=new ArrayList<UUserDto>(); 
			List<UUser> list1=new ArrayList<UUser>();
			if(uuserDto.getPage()!=null&&uuserDto.getRows()!=null){
				list1=this.find(stringBuffer.toString(),params,uuserDto.getPage(),uuserDto.getRows());
			}else{
				list1=this.find(stringBuffer.toString(),params);
			}
			for(UUser user:list1){
				UUserDto dto=beanToDto.T1ToD1(user, new UUserDto());
				list.add(dto);
			}
			return list;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UuserDao#addUuser(com.cx.wxs.dto.UUserDto)
	 */
	@Override
	public Integer addUuser(UUserDto uuserDto) {
		// TODO Auto-generated method stub
		if(uuserDto!=null&&uuserDto.getNickname()!=null&&uuserDto.getUsername()!=null&&uuserDto.getPassword()!=null){
			UUser uuser=new UUser();
			setDefault(uuserDto);
		//	BeanUtils.copyProperties(uuserDto, uuser);
			uuser=beanToDto.D1ToT1(uuser, uuserDto);
			return this.save(uuser);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UuserDao#updateUuser(com.cx.wxs.dto.UUserDto)
	 */
	@Override
	public Integer updateUuser(UUserDto uuserDto) {
		// TODO Auto-generated method stub
		if(uuserDto!=null&&uuserDto.getUserId()!=null&&uuserDto.getUserId()>0){
			StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
			String[] fl = new String[]{"uid","userId","username"};//过滤掉的字段
			Map<String, Object> map = uuserDto.createSetPropertiesVal(uuserDto, "a", fl);
			Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);		
			stringBuffer.append(" "+UUser.class.getName()+" a");
			stringBuffer.append(map.get(StringUtils.SET_HQL));
			stringBuffer.append(" where a.userId=:uid");
			if(uuserDto.getUserId()==null){
				params.put("uid",uuserDto.getUid());
			}else{
				params.put("uid",uuserDto.getUserId());			
			}
			return this.executeHql(stringBuffer.toString(),params);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UuserDao#deleteUuser(com.cx.wxs.dto.UUserDto)
	 */
	@Override
	public Integer deleteUuser(UUserDto uuserDto) {
		// TODO Auto-generated method stub
		if(uuserDto!=null&&uuserDto.getUserId()!=null&&uuserDto.getUserId()>0){
			StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
		    Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+UUser.class.getName()+" a ");
			stringBuffer.append(" where 1=1 ");
				stringBuffer.append(" and userId=:userid ");
				params.put("userid",uuserDto.getUserId());
			return this.executeHql(stringBuffer.toString(), params);
		}
		return 0;
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
	 * @see com.cx.wxs.dao.UuserDao#getUuserListByInvitationCode(com.cx.wxs.dto.UUserDto, java.util.List)
	 */
	@Override
	public List<UUserDto> getUuserListByInvitationCode(UUserDto userDto,
			List<Integer> codeIdList) {
		// TODO Auto-generated method stub
		if(userDto!=null&&codeIdList!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append("from "+UUser.class.getName()+" a ");
			stringBuffer.append(" where a.sysInvitationCode in (:codeIdList)");
			params.put("codeIdList",codeIdList);
			List<UUserDto> list=new ArrayList<UUserDto>(); 
			List<UUser> list1=new ArrayList<UUser>();
			if(userDto.getPage()!=null&&userDto.getRows()!=null){
				list1=this.find(stringBuffer.toString(),params,userDto.getPage(),userDto.getRows());
			}else{
				list1=this.find(stringBuffer.toString(),params);
			}
			for(UUser user:list1){
				UUserDto dto=beanToDto.T1ToD1(user, new UUserDto());
				list.add(dto);
			}
			return list;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UuserDao#login(com.cx.wxs.dto.UUserDto)
	 */
	@Override
	public UUserDto login(UUserDto uuserDto) {
		// TODO Auto-generated method stub
		if(uuserDto!=null&&StringUtils.isNotEmpty(uuserDto.getUsername())&&StringUtils.isNotEmpty(uuserDto.getPassword())){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+UUser.class.getName()+" a ");
			stringBuffer.append(" where a.username=:username ");
			params.put("username",uuserDto.getUsername());
		//	params.put("password",uuserDto.getPassword());
			List<UUser> list=this.find(stringBuffer.toString(), params);
			UUserDto dto=new UUserDto(); 
			if(list!=null&&list.size()>0){
				UUser uuser= list.get(0);
				if(uuser.getPassword().equals(uuserDto.getPassword())||uuser.getPassword()==uuserDto.getPassword()){
					dto=beanToDto.T1ToD1(uuser, dto);
					dto.setLoginFlag("1");
					Date date=new Date();
					uuser.setLastTime(new Timestamp(date.getTime()));
					uuser.setLastIp(uuserDto.getIp());
					this.update(uuser);
				}else{
					dto.setLoginFlag("-1");
				}
		//		BeanToDto<UUser,UUserDto> beanToDto=new BeanToDto<UUser,UUserDto>();
				
			}else{
				dto.setLoginFlag("-2");
			}
			return dto;
		}
		return null;
	}
	/***
	 * 设置默认属性
	 * @param userDto
	 * @author 陈义
	 * @date   2016-3-18下午4:33:46
	 */
	private void setDefault(UUserDto userDto) {
		//一以下给定默认值，一般与数据库设置的默认值一致
		Date date=new Date();
		userDto.setRoleId(1);
		userDto.setArticleCount(0);
		userDto.setArticleReplyCount(0);
		userDto.setTagCount(0);
		userDto.setTopicCount(0);
		userDto.setTopicReplyCount(0);
		userDto.setImageCount(0);
		userDto.setImageReplyCount(0);
		userDto.setGuestbookCount(0);
		userDto.setFans(0);
		userDto.setFollows(0);
		SysRankDto sysRankDto=new SysRankDto();
		sysRankDto.setRankId(1);
		userDto.setRank(0);
		userDto.setRegtime(new Timestamp(date.getTime()));
	}
	

	

}
