package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.UfriendDto;
import com.cx.wxs.po.UFriend;
import com.cy.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date   2015-12-3 下午2:25:48
 */
public interface UfriendDao extends IBaseDao<UFriend,Integer>{
	
	/***
	 * 通过Ufriend的ID获取Ufriend
	 * @param ufriendDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午5:16:21
	 */
	public UfriendDto getUfriendByID(UfriendDto ufriendDto);
	
	/***
	 * 通过用户group获取friend的列表
	 * @param ufriendDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午5:16:52
	 */
	public List<UfriendDto> getUfriendList(UfriendDto ufriendDto);
	/***
	 * 通过用户获取好友列表
	 * @param ufriendDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-8下午4:45:46
	 */
	public List<UfriendDto> getUfriendListByUserId(UfriendDto ufriendDto,List<Integer> userid);
	/***
	 *通过用户和分类获取好友的数量
	 * @param ufriendDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-8下午9:07:44
	 */
	public Integer getFriendCountByGroup(UfriendDto ufriendDto);
	/***
	 * 获取好友的数量
	 * @param ufriendDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-8下午9:08:56
	 */
	public Integer getFriendCountByUser(UfriendDto ufriendDto);
	/***
	 * 
	 * @param ufriendDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午5:35:15
	 */
	public Integer addUfriend(UfriendDto ufriendDto);
	/***
	 * 更新用户的信息
	 * @param ufriendDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午5:18:15
	 */
	public Integer updateUfriend(UfriendDto ufriendDto);
	
	/***
	 * 删除用户的信息
	 * @param ufriendDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午5:18:32
	 */
	public Integer deleteUfriend(UfriendDto ufriendDto);
	/***
	 * 通过好友分组类型删除所有好友
	 * @param ufriendDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-8下午6:35:10
	 */
	public Integer deleteUfriendByGroupID(UfriendDto ufriendDto);

}
