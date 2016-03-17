package com.cx.wxs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.service.UUserService;
import com.cx.wxs.utils.StringUtils;

/**
 * @author 陈义
 * @date   2016-1-7 下午4:21:18
 */
@Controller
public class indexAction {
	
	@Resource
	UUserService uuService;
	
	
	
	/**
	 * @return the uuService
	 */
	public UUserService getUuService() {
		return uuService;
	}

	/**
	 * @param uuService the uuService to set
	 */
	public void setUuService(UUserService uuService) {
		this.uuService = uuService;
	}

	@RequestMapping(value="/")
	public  ModelAndView index(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv=new ModelAndView("user/main");
		return mv;
	}
	
	/***
	 *跳转进入登陆页面 
	 * @param request
	 * @param response
	 * @return
	 * @author 陈义
	 * @date   2016-2-29下午9:29:54
	 */
	@RequestMapping(value="/login")
	public ModelAndView tologin(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView("user/login");
		return mv;
		
	}
	/***
	 * 前端登陆
	 * @return
	 * @author 陈义
	 * @date   2016-1-7下午4:28:12
	 */
	
	@RequestMapping(value="/login1")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		HttpSession session= request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String verifyCode=request.getParameter("verifyCode");
		String codeSession=(String) request.getSession().getAttribute("verifycode");
		UUserDto uuser=new UUserDto();
		if(verifyCode.equals(codeSession)){
			uuser.setUsername(username);
			uuser.setPassword(StringUtils.md5(password));
			uuser= uuService.login(uuser);
			session.setAttribute("user",uuser);
			mv.addObject("user", uuser);
			mv.setViewName("user/login");
		}else{
			
			mv.setViewName("user/login");
		}
//		String url=request.getServletPath();
		
		return mv;
	}
	@ResponseBody
	@RequestMapping(value="/checkVerifyCode")
	public String checkVerifyCode(String VerifyCode,HttpServletRequest request){
        String verifyCode=(String) request.getAttribute("VerifyCode");
		String codeSession=(String) request.getSession().getAttribute("verifycode");
		String  flag="0";
		if(VerifyCode.equalsIgnoreCase(codeSession)){
			flag="1";
			return flag;
		}else{
		return flag;
		}
	}
	/***
	 * 进入专属页面
	 * @param vip  专属页面后缀
	 * @return
	 * @author 陈义
	 * @date   2016-1-8下午9:20:30
	 */
	@RequestMapping(value="/{vip}")
	public ModelAndView home(@PathVariable(value = "vip") String nickname){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("user/main");
		return mv;
	}

}
