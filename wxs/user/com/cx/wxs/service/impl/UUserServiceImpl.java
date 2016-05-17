package com.cx.wxs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.UUserDao;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.service.UUserService;

/**
 * @author 陈义
 * @date   2015-12-3 上午11:36:34
 */
@Service("UuserService")
public class UUserServiceImpl implements UUserService{

	@Autowired
	private UUserDao uuserDao;
	
	/* (non-Javadoc)
	 * @see com.cx.wxs.service.UUserService#getUuser(com.cx.wxs.dto.UUserDto)
	 */
	@Override
	public UUserDto getUuser(UUserDto uuserDto) {
		// TODO Auto-generated method stub
		return uuserDao.getUuser(uuserDto);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.UUserService#getUuserList(com.cx.wxs.dto.UUserDto)
	 */
	@Override
	public List<UUserDto> getUuserList(UUserDto uuserDto) {
		// TODO Auto-generated method stub
		return uuserDao.getUuserList(uuserDto);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.UUserService#getCountByRank(java.lang.Integer)
	 */
	@Override
	public Integer getCountByRank(Integer rankID) {
		// TODO Auto-generated method stub
		return uuserDao.getCountByRank(rankID);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.UUserService#addUuser(com.cx.wxs.dto.UUserDto)
	 */
	@Override
	public Integer addUuser(UUserDto uuserDto) {
		// TODO Auto-generated method stub
		return uuserDao.addUuser(uuserDto);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.UUserService#updateUuser(com.cx.wxs.dto.UUserDto)
	 */
	@Override
	public Integer updateUuser(UUserDto uuserDto) {
		// TODO Auto-generated method stub
		return uuserDao.updateUuser(uuserDto);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.UUserService#deleteUuser(com.cx.wxs.dto.UUserDto)
	 */
	@Override
	public Integer deleteUuser(UUserDto uuserDto) {
		// TODO Auto-generated method stub
		return uuserDao.deleteUuser(uuserDto);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.UUserService#getUuserListByInvitationCode(com.cx.wxs.dto.UUserDto, java.util.List)
	 */
	@Override
	public List<UUserDto> getUuserListByInvitationCode(UUserDto userDto,
			List<Integer> codeIdList) {
		// TODO Auto-generated method stub
		return uuserDao.getUuserListByInvitationCode(userDto, codeIdList);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.UUserService#login(com.cx.wxs.dto.UUserDto)
	 */
	@Override
	public UUserDto login(UUserDto uuserDto) {
		// TODO Auto-generated method stub
		UUserDto userDto=uuserDao.login(uuserDto);
		if(userDto==null){
			return null;
		}else if(userDto.getStatusFlag()==null){
		if(uuserDto.getRoleId()==0&&userDto.getRoleId()==0){
			
				uuserDto.setStatusFlag("2");
		}else{
			uuserDto.setStatusFlag("1");
		}
		}
		return userDto;
	}

}
