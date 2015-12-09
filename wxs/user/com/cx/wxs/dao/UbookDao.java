package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.UbookDto;
import com.cx.wxs.po.UBook;
import com.cy.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date   2015-12-3 下午2:23:28
 */
public interface UbookDao extends IBaseDao<UBook,Integer>{

	/***
	 *通过ID、用户id等元素获取Book信息
	 * @return
	 * @author 陈义
	 * @date   2015-12-3下午2:38:06
	 */
	public UbookDto getUBookByID(UbookDto ubookDto);
	
	
	/***
	 *通过ID、用户id等元素获取Book的列表类型
	 * @param ubookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-3下午5:18:44
	 */
	public List<UbookDto> getUBookList(UbookDto ubookDto);
	/***
	 * 添加一个新的Ubook信息到Ubook中
	 * @param ubookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-3下午5:19:15
	 */
	public Integer addUBook(UbookDto ubookDto);
	/***
	 * 更新Ubook信息
	 * @param ubookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-3下午5:20:10
	 */
	public Integer updateUBook(UbookDto ubookDto);
	
	/***
	 * 通过id、userid等信息删除Ubook信息
	 * @param ubookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-3下午5:20:28
	 */
	public Integer deleteUBook(UbookDto ubookDto);
}
