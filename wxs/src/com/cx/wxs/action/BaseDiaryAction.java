package com.cx.wxs.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.action.diary.DiaryAction;
import com.cx.wxs.dto.BConfigDto;
import com.cx.wxs.dto.DCatalogDto;
import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.dto.DFavoriteDto;
import com.cx.wxs.dto.DUpvoteDto;
import com.cx.wxs.dto.SysTypeDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.service.BConfigService;
import com.cx.wxs.service.DCatalogService;
import com.cx.wxs.service.DDiaryService;
import com.cx.wxs.service.DFavoriteService;
import com.cx.wxs.service.DUpvoteService;
import com.cx.wxs.service.SysTypeService;
import com.cx.wxs.utils.RequestUtils;
import com.cx.wxs.utils.StringUtils;

/**
 * @author 陈义
 * @date   2016-4-16 下午4:42:27
 */
@Controller
public class BaseDiaryAction extends BaseAction{

	@Resource
	private BConfigService configService;
	@Resource
	private DCatalogService catalogService;
	@Resource
	private SysTypeService sysTypeService;
	@Resource
	private DUpvoteService upvoteService;
	@Resource
	private DFavoriteService favoriteService;
	@Resource
	private DDiaryService diaryService;


	public void getDiarySetting(UUserDto userDto,ModelAndView mv){
		//是否可以上传日志
		BConfigDto configDto=new BConfigDto();
		configDto.setBSiteDto(userDto.getBSiteDto());
		configDto.setConfigKey("allow_pull");
		configDto=configService.getBConfig(configDto);
		mv.addObject("contribute", configDto);
		//用户分类列表
		DCatalogDto catalogDto=new DCatalogDto();
		catalogDto.setUUserDto(userDto);
		List<DCatalogDto> catalogList=catalogService.getDCatalogList(catalogDto);
		mv.addObject("catalogList", catalogList);
		//获取系统分类
		SysTypeDto sysTypeDto=new SysTypeDto();
		sysTypeDto.setParentId(0);
		List<SysTypeDto> sysTypeList=sysTypeService.getSysTypeList(sysTypeDto);
		mv.addObject("sysTypeList", sysTypeList);
	}
	/**
	 * 获取分页信息
	 * @param catalogDto
	 * @param mv
	 * @author 陈义
	 * @date   2016-4-25下午7:45:48
	 */
	public void getDcatolog(DCatalogDto catalogDto,ModelAndView mv){
		List<DCatalogDto> catalogDtos=catalogService.getDCatalogList(catalogDto);
		mv.addObject("catalogs", catalogDtos);
	}
	/**
	 * 将日志的分页信息存入cookie和session
	 * @param diaryDto
	 * @author 陈义
	 * @date   2016-4-25下午7:46:57
	 */
	public void setCookie_page(DDiaryDto diaryDto,HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		Integer pageCount=diaryDto.getPageCount();
		Integer page=diaryDto.getPage();
		RequestUtils.setCookie(request, response, "page", page.toString(),12*3600);
		RequestUtils.setCookie(request, response, "pageCount", pageCount.toString(),12*3600);
		session.setAttribute("page", page);
		session.setAttribute("pageCount", pageCount);
	}
	/**
	 * 通过日记id和用户userID获取用户的点赞信息
	 * @param diaryDto
	 * @param userDto
	 * @return
	 * @author 陈义
	 * @date   2016-4-30上午9:33:09
	 */
	public DUpvoteDto getDUpvoteDto(DDiaryDto diaryDto,UUserDto userDto){
		DUpvoteDto upvoteDto=new DUpvoteDto();
		upvoteDto.setUUserDto(userDto);
		upvoteDto.setDDiaryDto(diaryDto);
		upvoteDto=upvoteService.getDUpvote(upvoteDto);
		return upvoteDto;
	}
	/**
	 * 通过日记id和用户userID获取用户的点赞信息
	 * @param diaryDto
	 * @param userDto
	 * @return
	 * @author 陈义
	 * @date   2016-4-30上午9:33:49
	 */
	public DFavoriteDto getDFavoriteDto(DDiaryDto diaryDto,UUserDto userDto){
		DFavoriteDto favoriteDto=new DFavoriteDto();
		favoriteDto.setUUserDto(userDto);
		favoriteDto.setDDiaryDto(diaryDto);
		favoriteDto=favoriteService.getDFavorite(favoriteDto);
		return favoriteDto;
	}
	/**
	 * 添加点赞计数
	 * @param diaryDto
	 * @author 陈义
	 * @date   2016-4-30上午9:35:35
	 */
	public void addDUpvoteCount(DDiaryDto diaryDto){
		//点赞+1
		if(diaryDto.getFavoriteCount()==null){
			diaryDto.setFavoriteCount(1);
		}else{
			diaryDto.setFavoriteCount(diaryDto.getFavoriteCount()+1);
		}
		diaryService.updateDDiary(diaryDto);
	}
	/**
	 * 点赞数量减少
	 * @param diaryDto
	 * @author 陈义
	 * @date   2016-4-30上午9:39:25
	 */
	public void reduceDUpvoteCount(DDiaryDto diaryDto){
		//点赞-1
		diaryDto.setFavoriteCount(diaryDto.getFavoriteCount()-1);
		diaryService.updateDDiary(diaryDto);
	}
	/**
	 * 收藏+1
	 * @param diaryDto
	 * @author 陈义
	 * @date   2016-4-30上午9:41:39
	 */
	public void addDFavoriteCount(DDiaryDto diaryDto){
		//收藏+1
		if(diaryDto.getFavoriteCount()==null){
			diaryDto.setFavoriteCount(1);
		}else{
			diaryDto.setFavoriteCount(diaryDto.getFavoriteCount()+1);
		}
		diaryService.updateDDiary(diaryDto);
	}
	/***
	 * 收藏-1
	 * @param diaryDto
	 * @author 陈义
	 * @date   2016-4-30上午9:42:33
	 */
	public void reduceDFavoriteCount(DDiaryDto diaryDto){
		//收藏-1
		diaryDto.setFavoriteCount(diaryDto.getFavoriteCount()-1);
		diaryService.updateDDiary(diaryDto);

	}

	/***
	 * 评论+1
	 * @param diaryDto
	 * @author 陈义
	 * @date   2016-4-30上午9:45:06
	 */
	public void addDCommentCount(DDiaryDto diaryDto){

		if(diaryDto.getReplyCount()==null){
			diaryDto.setReplyCount(1);
		}else{
			diaryDto.setReplyCount(diaryDto.getReplyCount()+1);
		}
		diaryService.updateDDiary(diaryDto);
	}
	/**
	 * 评论-1
	 * @param diaryDto
	 * @author 陈义
	 * @date   2016-4-30上午9:46:48
	 */
	public void reduceDCommentCount(DDiaryDto diaryDto){
		diaryDto.setReplyCount(diaryDto.getReplyCount()-1);
		diaryService.updateDDiary(diaryDto);
	}

}
