package com.cx.wxs.service;

import com.cx.wxs.dto.UUserDto;

/**
 * @author 陈义
 * @date   2016-4-26 上午9:39:47
 */
public interface UUserInfoService {
	/**
	 * 设置文章数量
	 * @param uUserDto
	 * @return
	 * @author 陈义
	 * @date   2016-4-26上午9:41:06
	 */
	public Integer setArticleCount(UUserDto uUserDto);
	//评论数量
	public Integer setArticleReplyCount(UUserDto uUserDto);
	//帖子数量
	public Integer setTopicCount(UUserDto uUserDto);
	//帖子回复数
	public Integer setTopicReplyCount(UUserDto uUserDto);
	//图片数量
	public Integer setImageCount(UUserDto uUserDto);
	//图片评论数
	public Integer setImageReplyCount(UUserDto uUserDto);
	//粉丝数量
	public Integer setFans(UUserDto uUserDto);
	//关注数量
	public Integer setFollows(UUserDto uUserDto);

}
