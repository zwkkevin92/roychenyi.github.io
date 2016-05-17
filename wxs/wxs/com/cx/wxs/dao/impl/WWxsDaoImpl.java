package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.WWxsDao;
import com.cx.wxs.dto.WWxsDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.WWxs;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("WWxsDao")
public class WWxsDaoImpl extends BaseDaoImpl<WWxs, Integer> implements WWxsDao {

	private BeanToDto<WWxs, WWxsDto> beanToDto = new BeanToDto<WWxs, WWxsDto>();

	public BeanToDto<WWxs, WWxsDto> getBeanToDto() {
		return beanToDto;
	}

	public void setBeanToDto(BeanToDto<WWxs, WWxsDto> beanToDto) {
		this.beanToDto = beanToDto;
	}

	/**
	 * 通过id获取WWxsDto
	 * 
	 * @author 陈义
	 * @date 2016-04-09 16:11:19
	 */
	@Override
	public WWxsDto getWWxsByID(WWxsDto wWxsDto) {
		// TODO Auto-generated method stub
		if (wWxsDto != null && wWxsDto.getWxsId() != null) {
			StringBuffer stringBuffer = new StringBuffer();
			Map<String, Object> params = new HashMap<String, Object>();
			stringBuffer.append("from  " + WWxs.class.getName()
					+ "  a where a.wxsId=:id");
			params.put("id", wWxsDto.getWxsId());
			List<WWxs> list = this.find(stringBuffer.toString(), params);
			if (list != null && list.size() > 0) {
				WWxs t1 = list.get(0);
				WWxsDto dto = new WWxsDto();
				dto = beanToDto.T1ToD1(t1, dto);
				return dto;
			}
		}
		return null;
	}

	@Override
	public WWxsDto getWWxsDto(WWxsDto wWxsDto) {
		// TODO Auto-generated method stub
		if (wWxsDto != null) {
			StringBuffer stringBuffer = new StringBuffer();
			Map<String, Object> params = new HashMap<String, Object>();
			stringBuffer.append("from  " + WWxs.class.getName()
					+ "  a where 1=1");
			if (wWxsDto.getName() != null) {
				stringBuffer.append(" and  a.name=:name ");
				params.put("name", wWxsDto.getName());
			}
			if (wWxsDto.getAccount() != null) {
				stringBuffer.append(" and  a.account=:account");
				params.put("account", wWxsDto.getAccount());
			}
			List<WWxs> list = this.find(stringBuffer.toString(), params);
			if (list != null && list.size() > 0) {
				WWxs t1 = list.get(0);
				WWxsDto dto = new WWxsDto();
				dto = beanToDto.T1ToD1(t1, dto);
				return dto;
			}
		}
		return null;
	}

	/**
	 * 通过相关数据获取WWxsDtoList
	 * 
	 * @author 陈义
	 * @date 2016-04-09 16:11:19
	 */
	@Override
	public List<WWxsDto> getWWxsList(WWxsDto wWxsDto) {
		if (wWxsDto != null) {
			StringBuffer sb = new StringBuffer(" from " + WWxs.class.getName() +" a where 1=1");
			Map<String, Object> params = new HashMap<String, Object>();
			if(wWxsDto.getName()!=null){
				sb.append(" and a.name like :name");
				params.put("name","%"+wWxsDto.getName()+"%");
			}
			if(wWxsDto.getSysSchoolDto()!=null){
				sb.append(" and a.sysSchool.schoolId=:schoolId");
				params.put("schoolId",wWxsDto.getSysSchoolDto().getSchoolId());
			}
			if(wWxsDto.getStatus()!=null){
				sb.append(" and status=:status");
				params.put("status",wWxsDto.getStatus());
			}else{
				sb.append(" and status=1 ");
			}
			if (StringUtils.isNotEmpty(wWxsDto.getOrder())
					&& StringUtils.isNotEmpty(wWxsDto.getSort())) {
				sb.append(" order by "+wWxsDto.getSort()+" "+wWxsDto.getOrder());
			}
			
			List<WWxs> list = new ArrayList<WWxs>();
			if(wWxsDto.getPage()!=null&&wWxsDto.getRows()!=null){
				list=this.find(sb.toString(), params,wWxsDto.getPage(),wWxsDto.getRows());
					
			}else{
				list=this.find(sb.toString(),params,1,10);
			}
			List<WWxsDto> result = new ArrayList<WWxsDto>();
			if(list!=null&&list.size()>0){
				WWxsDto dto = new WWxsDto();
				Integer count = (wWxsDto.getPage()-1)*wWxsDto.getRows();
				for(int i=0;i<list.size();i++){
					WWxs dao=list.get(i);
					dto = new WWxsDto();
					dto = beanToDto.T1ToD1(dao, dto);
					dto.setRow(count+i+1);
					dto.setPage(wWxsDto.getPage());
					result.add(dto);
				}
				return result;
			}
		}
		return null;
	}

	/**
	 * 添加一个新的WWxs到数据库
	 * 
	 * @author 陈义
	 * @date 2016-04-09 16:11:19
	 */
	@Override
	public Integer addWWxs(WWxsDto wWxsDto) {
		// TODO Auto-generated method stub
		if (wWxsDto != null) {
			WWxs wWxs = new WWxs();
			wWxs = beanToDto.D1ToT1(wWxs, wWxsDto);
			return this.save(wWxs);
		}
		return 0;
	}

	/**
	 * 更新WWxs
	 * 
	 * @author 陈义
	 * @date 2016-04-09 16:11:19
	 */
	@Override
	public Integer updateWWxs(WWxsDto wWxsDto) {
		// TODO Auto-generated method stub
		if (wWxsDto != null && wWxsDto.getWxsId() != null) {
			StringBuffer stringBuffer = new StringBuffer(
					DbType.UPDATE.toString());
			String[] fl = new String[] { "uid","wxsId" };// 过滤掉的字段
			Map<String, Object> map = wWxsDto.createSetPropertiesVal(wWxsDto,
					"a", fl);
			Map<String, Object> params = (Map<String, Object>) map
					.get(StringUtils.PARAMS);
			stringBuffer.append(" from " + WWxs.class.getName() + " a");
			stringBuffer.append(map.get(StringUtils.SET_HQL));
			stringBuffer.append(" where a.wxsId=:uid");
			params.put("uid", wWxsDto.getWxsId());
			return this.executeHql(stringBuffer.toString(), params);
		}
		return 0;
	}

	/**
	 * 删除WWxs
	 * 
	 * @author 陈义
	 * @date 2016-04-09 16:11:19
	 */
	@Override
	public Integer deleteWWxs(WWxsDto wWxsDto) {
		// TODO Auto-generated method stub
		if (wWxsDto != null && wWxsDto.getWxsId() != null) {
			StringBuffer stringBuffer = new StringBuffer(
					DbType.DELETE.toString());
			Map<String, Object> params = new HashMap<String, Object>();
			stringBuffer.append(" from " + WWxs.class.getName() + " a");
			stringBuffer.append(" where a.wxsId=:uid ");
			params.put("uid", wWxsDto.getWxsId());
			WWxs wWxs = new WWxs();
			BeanUtils.copyProperties(wWxsDto, wWxs);
			return this.executeHql(stringBuffer.toString(), params);
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cx.wxs.dao.WWxsDao#getWWDto(com.cx.wxs.dto.WWxsDto)
	 */
	@Override
	public WWxsDto getWWDto(WWxsDto wWxsDto) {
		// TODO Auto-generated method stub
		if (wWxsDto != null && wWxsDto.getName() != null) {
			StringBuffer stringBuffer = new StringBuffer();
			Map<String, Object> params = new HashMap<String, Object>();
			stringBuffer.append("from  " + WWxs.class.getName()
					+ "  a where a.name=:name");
			params.put("name", wWxsDto.getName());
			List<WWxs> list = this.find(stringBuffer.toString(), params);
			if (list != null && list.size() > 0) {
				WWxs t1 = list.get(0);
				WWxsDto dto = new WWxsDto();
				dto = beanToDto.T1ToD1(t1, dto);
				
				return dto;
			}
		}
		return null;
	}

	@Override
	public Integer getWWxsCount(WWxsDto wWxsDto) {
		if(wWxsDto!=null){
		StringBuffer sb=new StringBuffer(DbType.SELECT+" count(*) ");
		Map<String, Object> params = new HashMap<String, Object>();
		sb.append(" from "+WWxs.class.getName()+" a where 1=1");
		if(wWxsDto.getName()!=null){
			sb.append(" and a.name like :name");
			params.put("name","%"+wWxsDto.getName()+"%");
		}
		if(wWxsDto.getSysSchoolDto()!=null){
			sb.append(" and a.sysSchool.schoolId=:schoolId");
			params.put("schoolId",wWxsDto.getSysSchoolDto().getSchoolId());
		}
		if(wWxsDto.getStatus()!=null){
			sb.append(" and status=:status");
			params.put("status",wWxsDto.getStatus());
		}else{
			sb.append(" and status=1 ");
		}
		return this.count(sb.toString(), params);
		}else{
		return 0;
		}
	}

}