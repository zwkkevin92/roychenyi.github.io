package com.cx.wxs.action.user;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.enums.EmailType;
import com.cx.wxs.service.EmailService;
import com.cx.wxs.service.UUserService;
import com.cx.wxs.utils.HtmlNodeFilters;
import com.cx.wxs.utils.StringUtils;
import com.cx.wxs.utils.ValidateCode;
import com.cx.wxs.utils.clientInfo;

/**
 * @author 陈义
 * @date   2016-3-21 下午9:03:08
 */
@Controller
public class userAction {
	
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
			uuserDto.setUrl(prev_rul);
//			HttpSession session=request.getSession();
//			session.setAttribute("user", uuserDto);			
		}else{
			uuserDto.setLoginFlag("-1");
		}
		return uuserDto;
	}
	
	@RequestMapping(value="/change/newpassword")
	public ModelAndView newPassword(HttpServletRequest request){
		ModelAndView mv=new ModelAndView("user/newpassword");
		String prev_url=request.getHeader("Referer");
		mv.addObject("prev_url", prev_url);
		return mv;
	}
	@ResponseBody
	@RequestMapping(value="/change/new")
	public UUserDto newPassword1(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		UUserDto uuserDto=(UUserDto) session.getAttribute("user");
		String oldPwd=StringUtils.md5(request.getParameter("oldPassword"));
		String newPwd=StringUtils.md5(request.getParameter("password"));
		String prev_url=request.getParameter("prev_url");
		if(uuserDto.getPassword().equals(oldPwd)){
		  	uuserDto.setPassword(newPwd);
			String ip=clientInfo.getIpAddr(request);
			uuserDto.setIp(ip);
			Date date=new Date();
			uuserDto.setLastTime(new Timestamp(date.getTime()));
			uuserDto.setUid(uuserDto.getUserId());
		  	int i=uuService.updateUuser(uuserDto);
		  	System.out.println(i);
		  	if(i>0){
		  		uuserDto.setLoginFlag("1");
		  		session.setAttribute("user", uuserDto);
		  	}else{
		  		uuserDto.setLoginFlag("0");
		  	}
		}else{
			uuserDto.setLoginFlag("-1");
		}
		uuserDto.setUrl(prev_url);
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
}
