package com.cx.wxs.action;

import java.sql.Timestamp;
import java.util.Date;
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
import com.cx.wxs.enums.DiaryRole;
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
	/**
	 * 文章访问权限管理 
	 * @param role
	 * @param userDto
	 * @param request
	 * @return
	 * @author 陈义
	 * @date   2016-5-12下午8:47:20
	 */
	public Integer getDiaryRole(Integer role,UUserDto userDto,HttpServletRequest request){
		//如果role为空，则是访问公开日志
		if(role==null){
			role=1;
		}
		//游客或者是普通用户，只能访问公开文章
		UUserDto userDto2=(UUserDto) request.getSession().getAttribute("user");
		if(userDto2==null){
			role=1;
		}else if(!userDto2.getNickname().equals(userDto.getNickname())&&!userDto2.getRoleId().equals(0)){				
				role=1;				
		}
		//如果role不是指定权限,那么role=1
		DiaryRole[] roles=DiaryRole.values();
		int i=roles.length;
		for(DiaryRole DR:roles){
			Integer a=Integer.parseInt(DR.toString());
			if(role.equals(a)){
				break;
			}else{
				i--;
			}
		}
		if(i<1){
			role=1;
		}
		//不是超级管理员，不能访问role=-2的文章（即管理员有权限浏览彻底删除的文章）
		if(role==-2&&!userDto.getRoleId().equals(0)){
			role=1;
		}
		return role;
	}
	//查看用户是否权限进行修改
	public boolean getUserRole(HttpServletRequest request,String nickname){
		UUserDto userDto=(UUserDto) request.getSession().getAttribute("user");
		if(userDto==null||!userDto.getNickname().equals(nickname)){
			return false;
		}else{
		return true;
		}
	}
	/***
	 * 更新文章的权限状态
	 * @param diaryDto
	 * @param role
	 * @param request
	 * @return
	 * @author 陈义
	 * @date   2016-5-12下午8:56:26
	 */
	public DDiaryDto updateDiaryRole(DDiaryDto diaryDto,short role,HttpServletRequest request){
		UUserDto userDto=(UUserDto) request.getSession().getAttribute("user");		
		diaryDto=diaryService.getDDiaryByID(diaryDto);
		if(diaryDto==null){
			diaryDto=new DDiaryDto();
			diaryDto.setStatusFlag("-1");
		}else if(!userDto.getUserId().equals(diaryDto.getUUserDto().getUserId())){
			diaryDto.setStatusFlag("-2");
		}else{
		Date date=new Date();
		diaryDto.setModifyTime(new Timestamp(date.getTime()));
		diaryDto.setRole(role);
		if(diaryService.updateDDiary(diaryDto)>0){
			diaryDto.setDCatalogDto(null);
			diaryService.setDiaryCountInfo(diaryDto);
			String basePath=RequestUtils.getDomain(request);
			String url=basePath+"/"+diaryDto.getUUserDto().getNickname()+"/article?time="+date.getTime();
			if(diaryDto.getPage()!=null&&diaryDto.getPage()>1){
				url+="&page="+diaryDto.getPage();
			}
			diaryDto.setStatusFlag("1");
			diaryDto.setUrl(url);
		}else{
			diaryDto.setStatusFlag("-1");
		}
		}
		return diaryDto;
	}

}
