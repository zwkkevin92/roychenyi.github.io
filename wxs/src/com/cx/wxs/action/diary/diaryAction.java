package com.cx.wxs.action.diary;

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
import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.service.BSiteService;
import com.cx.wxs.service.DDiaryService;
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
	/**
	 * @return the userService
	 */
	public UUserService getUserService() {
		return userService;
	}
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UUserService userService) {
		this.userService = userService;
	}
	/**
	 * @return the diaryService
	 */
	public DDiaryService getDiaryService() {
		return diaryService;
	}
	/**
	 * @param diaryService the diaryService to set
	 */
	public void setDiaryService(DDiaryService diaryService) {
		this.diaryService = diaryService;
	}
	/**
	 * @return the siteService
	 */
	public BSiteService getSiteService() {
		return siteService;
	}
	/**
	 * @param siteService the siteService to set
	 */
	public void setSiteService(BSiteService siteService) {
		this.siteService = siteService;
	}
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
		if( !setAuthor(mv, vip)){
			mv.setViewName("404");
		}
		return mv;
	}
	//保存日志
	@RequestMapping(value="/article_save")
	@ResponseBody
	public DDiaryDto articleAdd(@PathVariable("vip") String vip, HttpServletRequest request,HttpServletResponse reqResponse ){
		DDiaryDto diaryDto=new DDiaryDto();
		
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

}
