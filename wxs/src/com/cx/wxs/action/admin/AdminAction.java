package com.cx.wxs.action.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.action.IndexAction;
import com.cx.wxs.service.UUserInfoService;
import com.cx.wxs.service.UUserService;

/**
 * @author 陈义
 * @date   2016-5-14 下午5:00:20
 * 后台用户管理，登陆，权限提升等
 */
@Controller
@RequestMapping("/admin")
public class AdminAction extends IndexAction{

	@Resource
	private UUserService userService;
	
	@RequestMapping(value="/login")
	public ModelAndView tologin(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView("admin/user/login");
		return mv;
	}
	
}
