package com.cx.wxs.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.cx.wxs.dao.UfriendDao;
import com.cx.wxs.dto.UfriendDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.UBook;
import com.cx.wxs.po.UFriend;
import com.cx.wxs.utils.StringUtils;
import com.cy.wxs.base.dao.BaseDaoImpl;

/**
 * @author 陈义
 * @date   2015-12-8 下午4:16:50
 */
public class UfriendDaoImpl extends BaseDaoImpl<UFriend,Integer> implements UfriendDao{

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendDao#getUfriendByID(com.cx.wxs.dto.UfriendDto)
	 */
	@Override
	public UfriendDto getUfriendByID(UfriendDto ufriendDto) {
		// TODO Auto-generated method stub
		if(ufriendDto!=null&&ufriendDto.getFriendId()!=null&&ufriendDto.getFriendId()>0){
			StringBuffer stringBuffer=new StringBuffer();
			stringBuffer.append("from "+UFriend.class.getName()+" a");
			stringBuffer.append(" where a.id=:id");
			Map<String,Object> params=new HashMap<String,Object>();
			params.put("id",ufriendDto.getId());
			List<UfriendDto> list=this.findDto(stringBuffer.toString(),params,UfriendDto.class);
			if(list!=null&&list.size()>0){
				return list.get(0);
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendDao#getUfriendList(com.cx.wxs.dto.UfriendDto)
	 */
	@Override
	public List<UfriendDto> getUfriendList(UfriendDto ufriendDto) {
		// TODO Auto-generated method stub
		if(ufriendDto!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+UFriend.class.getName()+" a ");
			stringBuffer.append(" where a.UFriendGroup.groupId =:groupId");
			params.put("groupId",ufriendDto.getUfriendGroupDto().getGroupId());

			List<UfriendDto> list=null;
			if(ufriendDto.getPage()!=null&&ufriendDto.getRows()!=null){
				list=this.findDto(stringBuffer.toString(),params,ufriendDto.getPage(),ufriendDto.getRows(),UfriendDto.class);
			}else{
				list=this.findDto(stringBuffer.toString(),params,UfriendDto.class);
			}
			return list;
		}
		return null;
	}
	
	public List<UfriendDto> getUfriendListByUserId(UfriendDto ufriendDto,List<Integer> userid){
		if(userid!=null&&userid.size()>0){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append(" from "+UFriend.class.getName()+" a ");
			stringBuffer.append(" where a.userId in (:userid) ");
			params.put("userid",userid);
			if(ufriendDto.getUfriendGroupDto().getGroupId()!=null){
				stringBuffer.append(" and a.UFriendGroup.groupId =:groupId");
				params.put("groupId",userid);
			}
			List<UfriendDto> list=null;
			if(ufriendDto.getPage()!=null&&ufriendDto.getRows()!=null){
				list=this.findDto(stringBuffer.toString(),params,ufriendDto.getPage(),ufriendDto.getRows(),UfriendDto.class);
				
			}else{
				list=this.findDto(stringBuffer.toString(),params,UfriendDto.class);
			}
			return list;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendDao#addUfriend(com.cx.wxs.dto.UfriendDto)
	 */
	@Override
	public Integer addUfriend(UfriendDto ufriendDto) {
		// TODO Auto-generated method stub
		if(ufriendDto!=null&&ufriendDto.getUserId()!=null&&ufriendDto.getFriendId()!=null&&ufriendDto.getUfriendGroupDto().getGroupId()!=null){
			UFriend ufriend=new UFriend();
			BeanUtils.copyProperties(ufriendDto, ufriend);
			return this.save(ufriend);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendDao#updateUfriend(com.cx.wxs.dto.UfriendDto)
	 */
	@Override
	public Integer updateUfriend(UfriendDto ufriendDto) {
		// TODO Auto-generated method stub
		if(ufriendDto!=null&ufriendDto.getUid()!=null){
		StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
		String[] fl = new String[]{"uid","page","rows"};//过滤掉的字段
		Map<String, Object> map = ufriendDto.createSetPropertiesVal(ufriendDto, "a", fl);
		Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);		
		stringBuffer.append(" form "+UFriend.class.getName()+" a ");
		stringBuffer.append(map.get(StringUtils.SET_HQL));
		stringBuffer.append(" where a.uid=:uid");
		params.put("uid",ufriendDto.getUid());
		return this.executeHql(stringBuffer.toString(),params);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendDao#deleteUfriend(com.cx.wxs.dto.UfriendDto)
	 */
	@Override
	public Integer deleteUfriend(UfriendDto ufriendDto) {
		// TODO Auto-generated method stub
		if(ufriendDto!=null&&ufriendDto.getUid()!=null){
			StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
			stringBuffer.append(" from "+UFriend.class.getName()+" a ");
			stringBuffer.append(" where a.id=:uid");
			Map<String,Object> params=new HashMap<String,Object>();
			params.put("uid",ufriendDto.getUid());
			return this.executeHql(stringBuffer.toString(),params);
		}
		return 0;
	}
	
	public Integer deleteUfriendByGroupID(UfriendDto ufriendDto){
		if(ufriendDto!=null&&ufriendDto.getUfriendGroupDto().getGroupId()!=null){
			StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
			stringBuffer.append(" from "+UFriend.class.getName()+" a ");
			stringBuffer.append(" where a.UFriendGroup.groupId=:groupId");
			Map<String,Object> params=new HashMap<String,Object>();
			params.put("groupId",ufriendDto.getUfriendGroupDto().getGroupId());
			return this.executeHql(stringBuffer.toString(),params);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendDao#getFriendCountByGroup(com.cx.wxs.dto.UfriendDto)
	 */
	@Override
	public Integer getFriendCountByGroup(UfriendDto ufriendDto) {
		// TODO Auto-generated method stub
		if(ufriendDto.getUfriendGroupDto().getGroupId()!=null&&ufriendDto.getUserId()!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append("select count(*) from "+UFriend.class.getName()+" a ");
			stringBuffer.append(" where a.userId=:userid and a.UFriendGroup.groupId =:groupid");
			params.put("userid",ufriendDto.getUserId());
			params.put("groupid",ufriendDto.getUfriendGroupDto().getGroupId());
			return this.count(stringBuffer.toString(), params);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.UfriendDao#getFriendCountByUser(com.cx.wxs.dto.UfriendDto)
	 */
	@Override
	public Integer getFriendCountByUser(UfriendDto ufriendDto) {
		// TODO Auto-generated method stub
		if(ufriendDto.getUserId()!=null){
			StringBuffer stringBuffer=new StringBuffer();
			Map<String,Object> params=new HashMap<String,Object>();
			stringBuffer.append("select count(*) from "+UFriend.class.getName()+" a ");
			stringBuffer.append(" where a.userId=:userid ");
			params.put("userid",ufriendDto.getUserId());
			return this.count(stringBuffer.toString(), params);
		}
		return 0;
	}

}
