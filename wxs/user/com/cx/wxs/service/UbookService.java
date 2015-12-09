package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.UbookDto;

/**
 * @author 陈义
 * @date   2015-12-3 下午2:29:23
 */
public interface UbookService {
	 /***
	  * 通过用户id获取Ubook信息
	  * @param ubookDto
	  * @return
	  * @author 陈义
	  * @date   2015-12-7下午4:24:26
	  */
	public UbookDto getUbookByID(UbookDto ubookDto);
	
	/***
	 * 通过UbookDto的一些信息获取UBook的list信息
	 * @param ubookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午4:25:18
	 */
	public List<UbookDto> getUbookList(UbookDto ubookDto);
	/***
	 * 添加Book信息
	 * @param ubookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-8上午9:46:38
	 */
	public Integer addUbook(UbookDto ubookDto);
	/***
	 * 更新Ubook的信息
	 * @param ubookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午4:26:04
	 */
	public Integer updateUbook(UbookDto ubookDto);
	
	/***
	 * 删除Ubook信息
	 * @param ubookDto
	 * @return
	 * @author 陈义
	 * @date   2015-12-7下午4:39:31
	 */
	public Integer deleteUbook(UbookDto ubookDto);

}
