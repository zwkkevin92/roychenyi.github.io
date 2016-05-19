package com.cx.wxs.action.system;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.dto.SysInvitationCodeDto;
import com.cx.wxs.service.SysInvitationCodeService;

/**
 * @author 陈义
 * @date   2016-5-16 下午8:46:10
 * 验证码
 */
@Controller
@RequestMapping("/system/invite")
public class InvitationCodeAction {

	@Resource
	private SysInvitationCodeService sysInvitationCodeService;
	@RequestMapping(value="")
	public ModelAndView invitaionManage(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView("system/common/invite");
		return mv;
	}
	@RequestMapping(value="/add")
	@ResponseBody
	public List<SysInvitationCodeDto> addInviteCode(HttpServletRequest request,HttpServletResponse response,SysInvitationCodeDto invitationCodeDto){
		return null;
	}
	
}
