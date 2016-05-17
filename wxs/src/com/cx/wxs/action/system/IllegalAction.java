package com.cx.wxs.action.system;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.dto.SysIllegalDto;
import com.cx.wxs.service.SysIllegalService;

/**
 * @author 陈义
 * @date   2016-5-16 下午8:53:06
 */
@Controller
@RequestMapping("/system/illegal")
public class IllegalAction {

	@Resource
	private SysIllegalService sysIllegalService;
	@RequestMapping(value="")
	public ModelAndView illegalManage(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		return mv;
	}
	/**
	 * 创建一个敏感词
	 * @param request
	 * @param response
	 * @param sysIllegalDto
	 * @return
	 * @author 陈义
	 * @date   2016-5-16下午9:07:26
	 */
	@RequestMapping(value="add")
	@ResponseBody
	public SysIllegalDto addIllegal(HttpServletRequest request,HttpServletResponse response,SysIllegalDto sysIllegalDto){
		return sysIllegalDto;
	}
}
