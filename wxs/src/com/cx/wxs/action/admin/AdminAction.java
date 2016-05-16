package com.cx.wxs.action.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.action.IndexAction;
import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.service.UUserInfoService;
import com.cx.wxs.service.UUserService;
import com.cx.wxs.utils.RequestUtils;
import com.cx.wxs.utils.StringUtils;

/**
 * @author 陈义
 * @date   2016-5-14 下午5:00:20
 * 后台用户管理，登陆，权限提升等
 */
@Controller
@RequestMapping("/system")
public class AdminAction extends IndexAction{

	@Resource
	private UUserService userService;
	/***
	 * 进入后台登陆页面
	 * @param request
	 * @param response
	 * @return
	 * @author 陈义
	 * @date   2016-5-14下午9:51:39
	 */
	@RequestMapping(value="/login")
	public ModelAndView tologin(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView("admin/user/login");
		System.out.println();
		return mv;
	}
	/***
	 * 后台登陆验证
	 * @param request
	 * @param response
	 * @param userDto
	 * @return
	 * @author 陈义
	 * @date   2016-5-14下午9:51:53
	 */
	@RequestMapping(value="/loginCheck")
	@ResponseBody
	public UUserDto loginCheck(HttpServletRequest request,HttpServletResponse response ,UUserDto userDto){
		String verifyCode=request.getParameter("verifyCode");
		String verifyCodeSession=(String) request.getSession().getAttribute("verifycode");
		if(verifyCode.equalsIgnoreCase(verifyCodeSession)){
			userDto.setPassword(StringUtils.md5(userDto.getPassword()));
			userDto=userService.login(userDto);
			if(userDto.getStatusFlag().equals("2")){							
				request.getSession().setAttribute("admin", userDto);
				userDto.setUrl(RequestUtils.getDomain(request)+"system/mian");
			}else{
				userDto.setStatusFlag("-4");
			}
		}else{
			userDto.setStatusFlag("0");
		}
		return userDto;
	}
	@RequestMapping(value="/mian")
	public ModelAndView toAdminMain(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView("admin/main");
		return mv;
	}
}
