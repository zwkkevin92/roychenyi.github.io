package com.cx.wxs.action.diary;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.action.BaseAction;
import com.cx.wxs.dto.BConfigDto;
import com.cx.wxs.dto.DCatalogDto;
import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.dto.SysTypeDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.service.BConfigService;
import com.cx.wxs.service.BSiteService;
import com.cx.wxs.service.DCatalogService;
import com.cx.wxs.service.DDiaryService;
import com.cx.wxs.service.SysTypeService;
import com.cx.wxs.service.UUserService;

/**
 * @author 陈义
 * @date   2016-4-7 下午4:03:13
 */
@Controller
@RequestMapping("/{vip}/article")
public class diaryAction extends BaseAction{
	@Resource
	private UUserService userService;
	@Resource
	private DDiaryService diaryService;
	@Resource
	private BSiteService siteService;
	@Resource
	private BConfigService configService;
	@Resource
	private DCatalogService catalogService;
	@Resource
	private SysTypeService sysTypeService;
	
	/***
	 * 跳转到更新日志的界面
	 * @param vip
	 * @param request
	 * @param reqResponse
	 * @return
	 * @author 陈义
	 * @date   2016-4-7下午4:20:48
	 */
	@RequestMapping(value="/article_add")
	public ModelAndView toArticleAdd(@PathVariable("vip") String vip,
			HttpServletRequest request,HttpServletResponse reqResponse ){
		ModelAndView mv=new ModelAndView("diary/d_edite");
		UUserDto userDto=(UUserDto)request.getSession().getAttribute("user");
		if(userDto.getNickname().equals(vip)){
			mv.addObject("author",userDto);
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
		}else{
			mv.setViewName("404");
		}
		return mv;
	}
	//保存日志
	@RequestMapping(value="/article_save")
	@ResponseBody
	public DDiaryDto articleAdd(@PathVariable("vip") String vip, HttpServletRequest request,HttpServletResponse reqResponse ,DDiaryDto diaryDto){
		
		UUserDto userDto=(UUserDto) request.getSession().getAttribute("user");
		if(userDto==null){
			diaryDto.setStatusFlag("-1");
		}else{
			short contribute =new Short(request.getParameter("contribute"));
			diaryDto.setContribute(contribute);
			diaryDto.setBSiteDto(userDto.getBSiteDto());
			diaryDto.setUUserDto(userDto);
			Date date=new Date();
			diaryDto.setWriteTime(new Timestamp(date.getTime()));
			int diaryId= diaryService.addDDiary(diaryDto);
			if(diaryId>0){
				diaryDto.setDiaryId(diaryId);
				diaryDto.setStatusFlag("1");
			}else{
				diaryDto.setStatusFlag("-1");
			}
		}
		return diaryDto;
	}
	@RequestMapping(value="/article_edite")
	public ModelAndView toArticleEdite(@PathVariable("vip") String vip,
			HttpServletRequest request,HttpServletResponse reqResponse ){
		ModelAndView mv=new ModelAndView("diary/d_edite");
		return mv;
	}
	@RequestMapping(value="/article_draft")
	public ModelAndView toArticleDraft(@PathVariable("vip") String vip,
			HttpServletRequest request,HttpServletResponse reqResponse ){
		ModelAndView mv=new ModelAndView("diary/d_edite");
		return mv;
	}
	@RequestMapping(value="/article_list")
	public ModelAndView articleList(@PathVariable("vip") String vip,
			HttpServletRequest request,HttpServletResponse reqResponse){
		ModelAndView mv=new ModelAndView("diary/d_edite");
		return mv;
	}
	@RequestMapping(value="/details/{diaryId}")
	public ModelAndView articlePreview(@PathVariable("vip") String vip,@PathVariable("diaryId") Integer diaryId,
			HttpServletRequest request,HttpServletResponse reqResponse,DDiaryDto diaryDto){
		ModelAndView mv=new ModelAndView("diary/d_details");
		UUserDto userDto=(UUserDto) request.getSession().getAttribute("user");
		UUserDto author=getUserDtoByNickname(vip);
		diaryDto.setDiaryId(diaryId);
		diaryDto.setUUserDto(author);
		List<DDiaryDto> list=diaryService.getCurrentDiarys(diaryDto);
		//如果访问者和作者不是同一人，那么访问量+1
		if(userDto!=null){
		if(!userDto.getUserId().equals(author.getUserId())){
			if(diaryDto.getViewCount()==null){
			diaryDto.setViewCount(1);
			}
			Date date=new Date();
			diaryDto.setLastReadTime(new Timestamp(date.getTime()));
			diaryService.updateDDiary(diaryDto);			
		}else{
			author.setIsUsers(true);
		}}else{
			author.setIsUsers(false);
		
		}
		mv.addObject("author", author);
		mv.addObject("diary",list.get(0));
		mv.addObject("prev_diary",list.get(2));
		mv.addObject("next_diary",list.get(1));
		return mv;
	}

}
