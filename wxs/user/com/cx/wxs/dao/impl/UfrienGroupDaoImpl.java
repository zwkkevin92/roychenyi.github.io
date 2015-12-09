package com.cx.wxs.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.cx.wxs.dao.UfriendGroupDao;
import com.cx.wxs.dto.UfriendGroupDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.UFriend;
import com.cx.wxs.po.UFriendGroup;
import com.cx.wxs.utils.StringUtils;
import com.cy.wxs.base.dao.BaseDaoImpl;

/**
 * @author 陈义
 * @date   2015-12-8 下午8:22:00
 */
public class UfrienGroupDaoImpl extends BaseDaoImpl<UFriendGroup, Integer> implements UfriendGroupDao{

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendGroupDao#getUfriendGroupByID(com.cx.wxs.dto.UfriendGroupDto)
	 */
	@Override
	public UfriendGroupDto getUfriendGroupByID(UfriendGroupDto ufriendGroupDto) {
		// TODO Auto-generated method stub
		if(ufriendGroupDto!=null&&ufriendGroupDto.getGroupId()!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+UFriendGroup.class.getName()+" a ");
			stringBuffer.append(" where a.groupId=:groupId");
			params.put("groupId",ufriendGroupDto.getGroupId());
			List<UfriendGroupDto> list=this.findDto(stringBuffer.toString(),params,UfriendGroupDto.class);
			if(list!=null&&list.size()>0){
				return list.get(0);
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendGroupDao#getUfriendGroupList(com.cx.wxs.dto.UfriendGroupDto)
	 */
	@Override
	public List<UfriendGroupDto> getUfriendGroupList(
			UfriendGroupDto ufriendGroupDto) {
		// TODO Auto-generated method stub
		if(ufriendGroupDto!=null&&ufriendGroupDto.getUUserDto().getUserId()!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+UFriendGroup.class.getName()+" a ");
			stringBuffer.append(" a.UUser.userId =:userid");
			params.put("userid",ufriendGroupDto.getUUserDto().getUserId());
			return this.findDto(stringBuffer.toString(),params,UfriendGroupDto.class);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendGroupDao#addUfriendGroup(com.cx.wxs.dto.UfriendGroupDto)
	 */
	@Override
	public Integer addUfriendGroup(UfriendGroupDto ufriendGroupDto) {
		// TODO Auto-generated method stub
		if(ufriendGroupDto!=null&&ufriendGroupDto.getUUserDto().getUserId()!=null&&StringUtils.isNotEmpty(ufriendGroupDto.getName())){
			UFriendGroup ufriendGroup=new UFriendGroup();
			BeanUtils.copyProperties(ufriendGroupDto,ufriendGroup);
			return this.save(ufriendGroup);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendGroupDao#updateUfriendGroup(com.cx.wxs.dto.UfriendGroupDto)
	 */
	@Override
	public Integer updateUfriendGroup(UfriendGroupDto ufriendGroupDto) {
		// TODO Auto-generated method stub
		if(ufriendGroupDto!=null&&ufriendGroupDto.getUid()!=null){
			StringBuffer stringBuffer=new StringBuffer(DbType.UPDATE.toString());
			String[] fl=new String[]{"uid"};
			Map<String,Object> map=ufriendGroupDto.createSetPropertiesVal(ufriendGroupDto, "a", fl);
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+UFriendGroup.class.getName()+" a ");
			stringBuffer.append(map.get(StringUtils.SET_HQL));
			stringBuffer.append(" where a.uid=:uid");
			params.put("uid",ufriendGroupDto.getUid());
			return this.executeHql(stringBuffer.toString(),params);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendGroupDao#deleteUfriendByGroup(com.cx.wxs.dto.UfriendGroupDto)
	 */
	public Integer deleteUfriendByGroup(UfriendGroupDto ufriendGroupDto) {
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
