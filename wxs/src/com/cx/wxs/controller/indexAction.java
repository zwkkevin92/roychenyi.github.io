package com.cx.wxs.controller;

import java.awt.Color;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cx.wxs.bean.EmailInfo;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.enums.EmailType;
import com.cx.wxs.service.EmailService;
import com.cx.wxs.service.UUserService;
import com.cx.wxs.servlet.MailTransportQueue;
import com.cx.wxs.utils.Globals;
import com.cx.wxs.utils.HtmlNodeFilters;
import com.cx.wxs.utils.MailSender;
import com.cx.wxs.utils.StringUtils;
import com.cx.wxs.utils.ValidateCode;
import com.cx.wxs.utils.clientInfo;


/**
 * @author 陈义
 * @date   2016-1-7 下午4:21:18
 */
@Controller
public class indexAction {

	@Resource
	UUserService uuService;
	@Resource
	EmailService emailService;



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
	
	

	/**
	 * @return the emailService
	 */
	public EmailService getEmailService() {
		return emailService;
	}

	/**
	 * @param emailService the emailService to set
	 */
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
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
		String prev_url=request.getHeader("Referer");
		mv.addObject("prev_url", prev_url);
		return mv;

	}

	/***
	 * 前端登陆
	 * @return
	 * @author 陈义
	 * @date   2016-1-7下午4:28:12
	 */
	@RequestMapping(value="/login1")

	public @ResponseBody JSONObject login(HttpServletRequest request,
			HttpServletResponse response){		
		String prev_url=request.getParameter("prev_url");
		if(prev_url==null||prev_url==""){
			prev_url=request.getHeader("Referer");
		}
		HttpSession session= request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String verifyCode=request.getParameter("verifyCode");
		String ip=clientInfo.getIpAddr(request);
		String codeSession=(String) request.getSession().getAttribute("verifycode");
		UUserDto uuser=new UUserDto();
		//		String flag="1";    //flag:1:登陆成功；-1 ：登陆失败，密码或用户名错误；0：验证码错误
		//	if(verifyCode.equals(codeSession)){
		uuser.setUsername(username);
		uuser.setPassword(StringUtils.md5(password));
		uuser.setIp(ip);
		uuser= uuService.login(uuser);
		session.setAttribute("user",uuser);
		uuser.setUrl(prev_url);

		//	mv.setViewName("user/login");
		//		}else{
		//			uuser.setUrl(prev_url);
		//			uuser.setLoginFlag("0");
		//		}
		//		String url=request.getServletPath();
		//		mv.addObject("flag",flag);
		JSONObject json=(JSONObject) JSONObject.toJSON(uuser);
		return json;
	}

	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response){
		String prev_url=request.getHeader("Referer");
		ModelAndView  mv=new ModelAndView("redirect:"+prev_url);
		HttpSession session= request.getSession();
		session.removeAttribute("user");
		return mv;
	}

	@RequestMapping(value="/register")
	public ModelAndView toRegister(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv=new ModelAndView("user/register");
		String prev_url=request.getHeader("Referer");
		mv.addObject("prev_url", prev_url);
		return mv;
	}

	@RequestMapping(value="/register1",method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		String prev_url=request.getParameter("prev_url");
		if(prev_url!=null&&prev_url!=""){
			mv.setViewName("redirect:"+prev_url);
		}else{
			mv.setViewName("redirect:register");
		}
		return mv;
	}

	@RequestMapping(value="/forgot")
	public ModelAndView toforgot(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv=new ModelAndView("user/iforgot");
		String prev_url=request.getHeader("Referer");
		mv.addObject("prev_url", prev_url);
		return mv;
	}


	@RequestMapping(value="/forgot/result")
	@ResponseBody
	public UUserDto forgot(HttpServletRequest request,HttpServletResponse response){
		UUserDto user=new UUserDto();
		String prev_url=request.getParameter("prev_url");
		if(prev_url==null||prev_url==""){
			prev_url=request.getHeader("Referer");
		}
		String username=request.getParameter("username");
		user.setUsername(username);

		HttpSession session=request.getSession();
		String verifyCode=request.getParameter("verifyCode");
		String codeSession=(String) request.getSession().getAttribute("verifycode");
		if(!verifyCode.equalsIgnoreCase(codeSession)){
			return null;
		}
		StringBuffer url = request.getRequestURL();  
		String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString(); 
        tempContextUrl+="forgot/changepassword";
		try {
			user=uuService.getUuser(user);
			if(user==null){
				return null;
			}
			user.setUrl(prev_url);
			ValidateCode code=new ValidateCode();
			String checkCode=code.getCkeckCode();
			session.setAttribute("newCheckCode", checkCode);
			tempContextUrl+="?uid="+user.getUserId()+"&username="+user.getUsername()+"&prev_url="+prev_url+"&newCheckCode="+checkCode+"&nocahe="+new Date().getTime();
			// 邮件内容
			String email_content = "<h1>欢迎验证</h1><p>请点击下面链接进行验证，<a herf=\""+tempContextUrl+"\">"+tempContextUrl+"</a></p>";
			Parser html = new Parser();
			html.setEncoding("UTF-8");
			html.setInputHTML(email_content);
			Node[] nodes = html.extractAllNodesThatMatch(
					HtmlNodeFilters.titleFilter).toNodeArray();
			String title = "文学社平台重置密码邮箱验证";
			String[] receivers=new String[]{username};
			emailService.sendEmail(title, receivers, email_content, EmailType.VALIDATE);
			System.out.println("验证链接已发送！");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
	
	@RequestMapping(value="/forgot/changepassword")
	public ModelAndView changePassword(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		String newCheckCode=request.getParameter("newCheckCode");
		String checkCode=(String) request.getSession().getAttribute("newCheckCode");
		String prev_url=request.getParameter("prev_url");
		String username=request.getParameter("username");
		String uid=request.getParameter("uid");
		mv.addObject("uid", uid);
		mv.addObject("username",username);
		mv.addObject("prev_url",prev_url);
		if(newCheckCode.equals(checkCode)||newCheckCode==checkCode){
			mv.setViewName("user/changepassword");
		}else{
			mv.setViewName("404");
		}
		return mv;
	}
	@ResponseBody
	@RequestMapping(value="/forgot/change" , method = { RequestMethod.GET, RequestMethod.POST }, produces="application/json")
	public UUserDto changePassword1(Integer uid, HttpServletRequest request,HttpServletResponse response){
		UUserDto uuserDto =new UUserDto();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String prev_rul=request.getParameter("prev_url");
		password=StringUtils.md5(password);
		uuserDto.setUrl(prev_rul);
		uuserDto.setUid(uid);
		uuserDto.setUserId(uid);
		uuserDto.setUsername(username);
		uuserDto=uuService.getUuser(uuserDto);
		uuserDto.setUid(uuserDto.getUserId());
		uuserDto.setPassword(password);
		if(uuService.updateUuser(uuserDto)>0){
			uuserDto.setLoginFlag("1");
			HttpSession session=request.getSession();
			session.setAttribute("user", uuserDto);			
		}else{
			uuserDto.setLoginFlag("-1");
		}
		return uuserDto;
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
		mv.addObject("nickname", nickname);
		return mv;
	}
	@RequestMapping(value="/404")
	public ModelAndView to404(){
		ModelAndView mv=new ModelAndView("404");
		return mv;
	}
	@RequestMapping(value="/500")
	public ModelAndView to500(){
		ModelAndView mv=new ModelAndView("500");
		return mv;
	}

}
