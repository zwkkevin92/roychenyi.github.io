package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.UBookDto;

/**
 * @author 陈义
 * @date   2015-12-3 下午2:29:23
 */
public interface UBookService {
	 /***
	  * 通过用户id获取Ubook信息
	  * @param UBookDto
	  * @return
	  * @author 陈义
	  * @date   2015-12-7下午4:24:26
	  */
	public UBookDto getUbookByID(UBookDto UBookDto);
	
	/***
	 * 通过UBookDto的一些信息获取UBook的list信息
	 * @param UBookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午4:25:18
	 */
	public List<UBookDto> getUbookList(UBookDto UBookDto);
	/***
	 * 添加Book信息
	 * @param UBookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-8上午9:46:38
	 */
	public Integer addUbook(UBookDto UBookDto);
	/***
	 * 更新Ubook的信息
	 * @param UBookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午4:26:04
	 */
	public Integer updateUbook(UBookDto UBookDto);
	
	/***
	 * 删除Ubook信息
	 * @param UBookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午4:39:31
	 */
	public Integer deleteUbook(UBookDto UBookDto);

}
