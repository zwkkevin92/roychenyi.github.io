package com.cx.wxs.action.blog;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.dto.USignDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.service.BSiteService;
import com.cx.wxs.service.USignService;
import com.cx.wxs.service.UUserService;
import com.cx.wxs.utils.RequestUtils;

/**
 * @author 陈义
 * @date   2016-4-2 下午3:08:20
 */
@Controller
@RequestMapping("/{vip}/set")
public class settingAction {
	@Resource
	private BSiteService bSiteService;
	@Resource
	private UUserService uUserService;
	@Resource
	private USignService uSignService;
	/**
	 * @return the bSiteService
	 */
	public BSiteService getbSiteService() {
		return bSiteService;
	}
	/**
	 * @param bSiteService the bSiteService to set
	 */
	public void setbSiteService(BSiteService bSiteService) {
		this.bSiteService = bSiteService;
	}
	/**
	 * @return the uUserService
	 */
	public UUserService getuUserService() {
		return uUserService;
	}
	/**
	 * @param uUserService the uUserService to set
	 */
	public void setuUserService(UUserService uUserService) {
		this.uUserService = uUserService;
	}
	
	/**
	 * @return the uSignService
	 */
	public USignService getuSignService() {
		return uSignService;
	}
	/**
	 * @param uSignService the uSignService to set
	 */
	public void setuSignService(USignService uSignService) {
		this.uSignService = uSignService;
	}
	
	@RequestMapping(value="/index")
	public ModelAndView toSettingIndex(@PathVariable("vip") String vip,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView("blog/setting/index");
		UUserDto userDto=(UUserDto) request.getSession().getAttribute("user");
		if(userDto==null){
			mv.setViewName("404");
		}
		return mv;
	}
	@RequestMapping(value="/site")
	public ModelAndView toSettingSite(@PathVariable("vip") String vip,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView("blog/setting/site");
		UUserDto userDto=(UUserDto) request.getSession().getAttribute("user");
		if(userDto==null){
			mv.setViewName("404");
		}
		return mv;
	}
	
	@RequestMapping(value="/privacy")
	public ModelAndView toSettingPrivacy(@PathVariable("vip") String vip,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView("blog/setting/privacy");
		UUserDto userDto=(UUserDto) request.getSession().getAttribute("user");
		if(userDto==null){
			mv.setViewName("404");
		}
		return mv;
	}
	
	@RequestMapping(value="/avatar")
	public ModelAndView toSettingAvatar(@PathVariable("vip") String vip,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView("blog/setting/avatar");
		UUserDto userDto=(UUserDto) request.getSession().getAttribute("user");
		if(userDto==null){
			mv.setViewName("404");
		}
		return mv;
	}
	@RequestMapping(value="/setUserInfo")
	@ResponseBody
	public UUserDto setUserInfo(@PathVariable("vip") String vip,HttpServletRequest request,HttpServletResponse response,UUserDto userDto){
		userDto.setNickname(vip);
		String signstr=request.getParameter("sign");
		if(signstr!=null){
			USignDto uSignDto=new USignDto();
			uSignDto.setUUserDto(userDto);
			uSignDto.setContent(signstr);
			uSignService.setUserSign(uSignDto);
		}
		if(uUserService.updateUuser(userDto)>0){
			userDto=uUserService.getUuser(userDto);
			userDto.setLoginFlag("1");
			RequestUtils.setUserInfo(request, response, userDto);
		}else{
			userDto.setLoginFlag("-1");
		}
		return userDto;
	}

}
