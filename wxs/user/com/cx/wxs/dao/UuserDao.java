package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.UuserDto;
import com.cx.wxs.po.UUser;
import com.cy.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date   2015-12-3 上午11:29:39
 */
public interface UuserDao extends IBaseDao<UUser, Integer>{
	/***
	 * 通过用户id，用户账户等信息获取User信息
	 * @param uuserDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午9:08:25
	 */
	public UuserDto getUuser(UuserDto uuserDto);
	/***
	 * 通过有效的信息获取用户列表
	 * @param uuserDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午9:09:59
	 */
	public List<UuserDto> getUuserList(UuserDto uuserDto);
	
	
	/***
	 * 通过用户级别获取用户数量
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午9:54:51
	 */
	public Integer getCountByRank(Integer rankID);
		
	/***
	 * 添加用户信息
	 * @param uuserDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午9:12:52
	 */
	public Integer addUuser(UuserDto uuserDto);
	/***
	 * 更新用户信息
	 * @param uuserDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午9:19:24
	 */
	public Integer updateUuser(UuserDto uuserDto);

	/***
	 * 删除用户信息
	 * @param uuserDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午9:20:08
	 */
	public Integer deleteUuser(UuserDto uuserDto);
	/***
	 * 通过邀请码列表获取用户列表
	 * @param userDto
	 * @param codeIdList 邀请码列表
	 * @return
	 * @author 陈义
	 * @date   2015-12-8下午3:35:52
	 */
	public List<UuserDto> getUuserListByInvitationCode(UuserDto userDto,List<Integer> codeIdList);
	/***
	 * 登录
	 * @param uuserDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-8下午4:29:18
	 */
	public UuserDto login(UuserDto uuserDto);
}
