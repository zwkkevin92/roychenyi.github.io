package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.base.dao.IBaseDao;
import com.cx.wxs.dto.UBookDto;
import com.cx.wxs.po.UBook;

/**
 * @author 陈义
 * @date   2015-12-3 下午2:23:28
 */
public interface UBookDao extends IBaseDao<UBook,Integer>{

	/***
	 *通过ID、用户id等元素获取Book信息
	 * @return
	 * @author 陈义
	 * @date   2015-12-3下午2:38:06
	 */
	public UBookDto getUBookByID(UBookDto ubookDto);
	
	
	/***
	 *通过ID、用户id等元素获取Book的列表类型
	 * @param ubookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-3下午5:18:44
	 */
	public List<UBookDto> getUBookList(UBookDto ubookDto);
	/***
	 * 添加一个新的Ubook信息到Ubook中
	 * @param ubookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-3下午5:19:15
	 */
	public Integer addUBook(UBookDto ubookDto);
	/***
	 * 更新Ubook信息
	 * @param ubookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-3下午5:20:10
	 */
	public Integer updateUBook(UBookDto ubookDto);
	
	/***
	 * 通过id、userid等信息删除Ubook信息
	 * @param ubookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-3下午5:20:28
	 */
	public Integer deleteUBook(UBookDto ubookDto);
}
