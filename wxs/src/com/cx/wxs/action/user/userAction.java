package com.cx.wxs.action.user;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
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
import com.cx.wxs.dto.BConfigDto;
import com.cx.wxs.dto.BSiteDto;
import com.cx.wxs.dto.DCatalogDto;
import com.cx.wxs.dto.SysStyleDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.enums.EmailType;
import com.cx.wxs.service.BConfigService;
import com.cx.wxs.service.BSiteService;
import com.cx.wxs.service.DCatalogService;
import com.cx.wxs.service.EmailService;
import com.cx.wxs.service.SysIllegalService;
import com.cx.wxs.service.UUserService;
import com.cx.wxs.utils.HtmlNodeFilters;
import com.cx.wxs.utils.RequestUtils;
import com.cx.wxs.utils.StringUtils;
import com.cx.wxs.utils.TemplateUtils;
import com.cx.wxs.utils.ValidateCode;
import com.cx.wxs.utils.clientInfo;

/**
 * 用户登陆、注册、用户验证
 * @author 陈义
 * @date   2016-3-21 下午9:03:08
 */
@Controller
public class userAction {
	
	@Resource
	private UUserService uuService;
	@Resource
	private EmailService emailService;
	@Resource
	private BSiteService bSiteService;
	@Resource
	private SysIllegalService sysIllegalService;
	@Resource
	private BConfigService bConfigService;
	@Resource
	private DCatalogService dCatalogService;

	


	/**
	 * @return the bConfigService
	 */
	public BConfigService getbConfigService() {
		return bConfigService;
	}

	/**
	 * @param bConfigService the bConfigService to set
	 */
	public void setbConfigService(BConfigService bConfigService) {
		this.bConfigService = bConfigService;
	}

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
	 * @return the sysIllegalService
	 */
	public SysIllegalService getSysIllegalService() {
		return sysIllegalService;
	}

	/**
	 * @param sysIllegalService the sysIllegalService to set
	 */
	public void setSysIllegalService(SysIllegalService sysIllegalService) {
		this.sysIllegalService = sysIllegalService;
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
   	if(verifyCode.equalsIgnoreCase(codeSession)){
		uuser.setUsername(username);
		uuser.setPassword(StringUtils.md5(password));
		uuser.setIp(ip);
		uuser= uuService.login(uuser);
		uuser.setUrl(prev_url);
		if(uuser==null){
			return null;
		}else if(uuser.getStatusFlag().equals("1")){
			if(uuser.getPopedom()!=1){
				uuser.setStatusFlag("-3");
			}else{
				RequestUtils.setUserInfo(request, response, uuser);
			}
		}
		}else{
			  return null;	
			}
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
		RequestUtils.removeCookie(request, response, "user");
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

	@ResponseBody 
	@RequestMapping(value="/register1",method=RequestMethod.POST)
	public UUserDto register(HttpServletRequest request,
			HttpServletResponse response,UUserDto userDto){
		String prev_url=request.getParameter("prev_url");
		String password=StringUtils.md5(request.getParameter("password"));
		userDto.setEmail(userDto.getUsername());
		userDto.setPassword(password);
		int popedom=(int)((Math.random()*9+1)*100000);
		userDto.setPopedom(popedom);
		userDto.setRoleId(0);
		if(uuService.addUuser(userDto)>0){
			StringBuffer url = request.getRequestURL();  
			String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString(); 
	        tempContextUrl+="register/check";
			try {
				tempContextUrl+="?username="+userDto.getUsername()+"&prev_url="+prev_url+"&popedom="+popedom+"&nocahe="+new Date().getTime();
				// 邮件内容
				String template=TemplateUtils.getRegisterCheckTemplate();
				String notify_content = MessageFormat.format(template,userDto.getNickname(),tempContextUrl,tempContextUrl);
//				String email_content = "<h1>欢迎验证</h1><p>请点击下面链接进行验证，若点击不成功，请充值url地址到浏览器跳转，谢谢合作。<br>地址：<a href=\""+tempContextUrl+"\" target=\"_blank\">"+tempContextUrl+"</a></p>";
//				Parser html = new Parser();
//				html.setEncoding("UTF-8");
//				html.setInputHTML(email_content);
//				Node[] nodes = html.extractAllNodesThatMatch(
//						HtmlNodeFilters.titleFilter).toNodeArray();
				String title = "文学社平台注册激活";
				String[] receivers=new String[]{userDto.getUsername()};
				emailService.sendEmail(title, receivers, notify_content, EmailType.VALIDATE);
				System.out.println("验证链接已发送！");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			userDto.setUrl(prev_url);
			userDto.setStatusFlag("1");
		}else{
			userDto.setStatusFlag("-1");
		}		
		return userDto;
	}
	
	@RequestMapping(value="register/check")
	public ModelAndView registerCheck(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv=new ModelAndView("user/regcheck");
	    String username=request.getParameter("username");
	    Integer popedom=Integer.parseInt(request.getParameter("popedom"));
	    String prev_url=request.getParameter("prev_url");
	    UUserDto userDto=new UUserDto();
	    userDto.setUsername(username);
	    userDto= uuService.getUuser(userDto);
	    if(userDto.getPopedom()==1){
	    	UUserDto user=(UUserDto) request.getSession().getAttribute("user");
	    	if(user!=null){
	    		mv.setViewName("redirect:"+prev_url);
	    		return mv;
	    	}else{
	    //	mv.addObject("user", userDto);
	    	return mv;
	    	}
	    }
	    if(userDto.getUserId()!=null&userDto.getPopedom().equals(popedom)){
	    	//验证成功
	    	userDto.setPopedom(1);
	    	userDto.setUid(userDto.getUserId());
	    	//开通空间
            BSiteDto siteDto=openBlog(userDto);
	    	if(siteDto!=null){
	    		userDto.setBSiteDto(siteDto);
	    	}
	    	if(uuService.updateUuser(userDto)>0){
	    		userDto.setStatusFlag("1");
	    		userDto.setUrl(prev_url);    		
	    	}else{
	    		userDto=null;
	    	}
	    	
	    }else{
	    	userDto=null;
	    }
	    mv.addObject("user", userDto); 
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
			String template=TemplateUtils.getPasswordTipTemplate();
			String notify_content = MessageFormat.format(template,
					user.getNickname(), tempContextUrl, tempContextUrl);
		//	String email_content = "<h1>欢迎验证</h1><p>请点击下面链接进行验证，<a href=\""+tempContextUrl+"\" target=\"_blank\">"+tempContextUrl+"</a></p>";
//			Parser html = new Parser();
//			html.setEncoding("UTF-8");
//			html.setInputHTML(email_content);
//			Node[] nodes = html.extractAllNodesThatMatch(
//					HtmlNodeFilters.titleFilter).toNodeArray();
			String title = "文学社平台重置密码邮箱验证";
			String[] receivers=new String[]{username};
			emailService.sendEmail(title, receivers, notify_content, EmailType.VALIDATE);
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
			uuserDto.setStatusFlag("1");
			uuserDto.setUrl(prev_rul);
//			HttpSession session=request.getSession();
//			session.setAttribute("user", uuserDto);			
		}else{
			uuserDto.setStatusFlag("-1");
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
		  	if(uuService.updateUuser(uuserDto)>0){
		  		uuserDto.setStatusFlag("1");
		  		session.setAttribute("user", uuserDto);
		  	}else{
		  		uuserDto.setStatusFlag("0");
		  	}
		}else{
			uuserDto.setStatusFlag("-1");
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
	/***
	 * 验证用户名唯一性和可用性
	 * @param username
	 * @return
	 * @author 陈义
	 * @date   2016-3-22上午11:11:07
	 */
	@ResponseBody
	@RequestMapping(value="/user/checkusername")
	public String usernameCheck(String username){
		UUserDto user=new UUserDto();
		user.setUsername(username);
		user=uuService.getUuser(user);
		String flag="1";
		if(user==null){
			flag="1";
		}else{
			flag="0";
		}
		return flag;
	}
	/***
	 * 验证昵称的唯一性和可用性
	 * @param nickname
	 * @return
	 * @author 陈义
	 * @date   2016-3-22上午11:11:49
	 */
	@ResponseBody
	@RequestMapping(value="/user/checknickname")
	public String nicknameCheck(String nickname){
		//检查是否包含非法字符
		String flag="0";
		if(!sysIllegalService.IllegalCheck(nickname)){
		 flag="-1";
		return flag;
		}		
		//验证用户表中是否有昵称为这个名字的
		UUserDto user=new UUserDto();
		user.setNickname(nickname);
		user=uuService.getUuser(user);
		if(user==null){
			flag="1";
		}else{
			flag="0";
		}
		return flag;
	}
	
	public String sendPasswordNotify(){
		return null;
	}
	/***
	 * 开通博客
	 * @param userDto
	 * @return
	 * @author 陈义
	 * @date   2016-3-24下午3:23:04
	 */
	public  BSiteDto openBlog(UUserDto userDto){
		Date date=new Date();
		BSiteDto bSiteDto=new BSiteDto();
    	bSiteDto.setUUserDto(userDto);
    	bSiteDto.setName(userDto.getNickname());
    	bSiteDto.setTitle(userDto.getNickname()+"的博客");
    	bSiteDto.setSiteUrl("/"+userDto.getNickname());
    	SysStyleDto styleDto=new SysStyleDto();
    	styleDto.setStyleId(1);	    	
    	bSiteDto.setSysStyleDto(styleDto);
    	bSiteDto.setMode((short)1);
    	bSiteDto.setCreateTime(new Timestamp(date.getTime()));
    	int id=bSiteService.addBSite(bSiteDto);
    	if(id>0){
    		bSiteDto.setSiteId(id);
    		//日志分类添加一个默认分类：个人日记
    		DCatalogDto catalogDto=new DCatalogDto();
    		catalogDto.setUUserDto(userDto);
    		catalogDto.setCatalogName("个人日记");
    		catalogDto.setCatalogType(1);
    		catalogDto.setCreateTime(new Timestamp(date.getTime()));
    		dCatalogService.addDCatalog(catalogDto);
    		//空间配置：添加允许投稿
    		BConfigDto configDto=new BConfigDto();
    		configDto.setBSiteDto(bSiteDto);
    		configDto.setConfigKey("allow_pull");
    		configDto.setValue("1");
    		configDto.setCreateTime(new Timestamp(date.getTime()));
    		bConfigService.addBConfig(configDto);
    		return bSiteDto;
    	}else{
    		return null;
    	}
	}
}
