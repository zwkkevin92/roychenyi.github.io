package com.cx.wxs.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.UFriendGroupDao;
import com.cx.wxs.dto.UFriendGroupDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.UFriend;
import com.cx.wxs.po.UFriendGroup;
import com.cx.wxs.utils.BeanToDto;
import com.cx.wxs.utils.StringUtils;

/**
 * @author 陈义
 * @date   2015-12-8 下午8:22:00
 */
@Repository("UFrienGroupDao") 
public class UFrienGroupDaoImpl extends BaseDaoImpl<UFriendGroup, Integer> implements UFriendGroupDao{

	private BeanToDto<UFriendGroup,UFriendGroupDto> beanToDto=new BeanToDto<UFriendGroup,UFriendGroupDto>();
	
	
	/**
	 * @return the beanToDto
	 */
	public BeanToDto<UFriendGroup, UFriendGroupDto> getBeanToDto() {
		return beanToDto;
	}

	/**
	 * @param beanToDto the beanToDto to set
	 */
	public void setBeanToDto(BeanToDto<UFriendGroup, UFriendGroupDto> beanToDto) {
		this.beanToDto = beanToDto;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendGroupDao#getUfriendGroupByID(com.cx.wxs.dto.UFriendGroupDto)
	 */
	@Override
	public UFriendGroupDto getUfriendGroupByID(UFriendGroupDto ufriendGroupDto) {
		// TODO Auto-generated method stub
		if(ufriendGroupDto!=null&&ufriendGroupDto.getGroupId()!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+UFriendGroup.class.getName()+" a ");
			stringBuffer.append(" where a.groupId=:groupId");
			params.put("groupId",ufriendGroupDto.getGroupId());
			List<UFriendGroup> list=this.find(stringBuffer.toString(),params);
			if(list!=null&&list.size()>0){
				UFriendGroup  ufriFriendGroup=list.get(0);
				UFriendGroupDto uFriendGroupDto2=beanToDto.T1ToD1(new UFriendGroup(), new UFriendGroupDto());
				return uFriendGroupDto2;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendGroupDao#getUfriendGroupList(com.cx.wxs.dto.UFriendGroupDto)
	 */
	@Override
	public List<UFriendGroupDto> getUfriendGroupList(
			UFriendGroupDto ufriendGroupDto) {
		// TODO Auto-generated method stub
		if(ufriendGroupDto!=null&&ufriendGroupDto.getUUserDto().getUserId()!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+UFriendGroup.class.getName()+" a ");
			stringBuffer.append(" a.UUser.userId =:userid");
			params.put("userid",ufriendGroupDto.getUUserDto().getUserId());
			List<UFriendGroup> list=this.find(stringBuffer.toString(),params);
			List<UFriendGroupDto> list1= new ArrayList<UFriendGroupDto>();
			for(UFriendGroup ufriendgroup:list){
				UFriendGroupDto dto=new UFriendGroupDto();
			    dto=beanToDto.T1ToD1(ufriendgroup,dto);
			    list1.add(dto);
			}
			return list1;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendGroupDao#addUfriendGroup(com.cx.wxs.dto.UFriendGroupDto)
	 */
	@Override
	public Integer addUfriendGroup(UFriendGroupDto ufriendGroupDto) {
		// TODO Auto-generated method stub
		if(ufriendGroupDto!=null&&ufriendGroupDto.getUUserDto().getUserId()!=null&&StringUtils.isNotEmpty(ufriendGroupDto.getName())){
			UFriendGroup ufriendGroup=new UFriendGroup();
		//	BeanUtils.copyProperties(ufriendGroupDto,ufriendGroup);
			ufriendGroup=beanToDto.D1ToT1(ufriendGroup,ufriendGroupDto);
			return this.save(ufriendGroup);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendGroupDao#updateUfriendGroup(com.cx.wxs.dto.UFriendGroupDto)
	 */
	@Override
	public Integer updateUfriendGroup(UFriendGroupDto ufriendGroupDto) {
		// TODO Auto-generated method stub
		if(ufriendGroupDto!=null&&ufriendGroupDto.getUid()!=null){
			StringBuffer stringBuffer=new StringBuffer(DbType.UPDATE.toString());
			String[] fl=new String[]{"uid"};
			Map<String,Object> map=ufriendGroupDto.createSetPropertiesVal(ufriendGroupDto, "a", fl);
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+UFriendGroup.class.getName()+" a ");
			stringBuffer.append(map.get(StringUtils.SET_HQL));
			stringBuffer.append(" where a.groupId=:uid");
			params.put("uid",ufriendGroupDto.getUid());
			return this.executeHql(stringBuffer.toString(),params);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendGroupDao#deleteUfriendByGroup(com.cx.wxs.dto.UFriendGroupDto)
	 */
	public Integer deleteUfriendByGroup(UFriendGroupDto ufriendGroupDto) {
		// TODO Auto-generated method stub
		if(ufriendGroupDto.getGroupId()!=null&&ufriendGroupDto.getUUserDto().getUserId()!=null){
			StringBuffer stringBuffer1=new StringBuffer(DbType.DELETE.toString());
			StringBuffer stringBuffer2=new StringBuffer(DbType.DELETE.toString());
			Map<String,Object> params1=new HashMap<String,Object>();
			Map<String,Object> params2=new HashMap<String,Object>();
		    stringBuffer1.append(" from "+UFriend.class.getName()+" a ");
		    stringBuffer1.append(" where a.UFriendGroup.groupId=:groupId");
		    params1.put("groupId",ufriendGroupDto.getGroupId());
		    this.executeHql(stringBuffer1.toString(), params1);
		    stringBuffer2.append(" from "+UFriendGroup.class.getName()+" a ");
		    stringBuffer2.append(" where a.groupId=:groupId");
		    params2.put("groupId",ufriendGroupDto.getGroupId());
		    return this.executeHql(stringBuffer2.toString(), params2);
		}
		return 0;
	}

}
