package com.cx.wxs.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cx.wxs.dao.UUserDao;
import com.cx.wxs.dao.impl.UUserDaoImpl;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.service.UUserService;
import com.cx.wxs.utils.GlobalContext;
import com.cx.wxs.utils.RequestUtils;
import com.cx.wxs.utils.StringUtils;

/**
 * @author 陈义
 * @date   2016-4-4 下午5:10:10
 */
public class SessionFilter extends OncePerRequestFilter {

	
	private String[] allowUrls;
	private UUserService uUserService;
	

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
	        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());  
	        this.uUserService =  (UUserService) ctx.getBean("uUserService");  
	
	    //	this.uUserService = uUserService;
	}


	/**
	 * @return the allowUrls
	 */
	public String[] getAllowUrls() {
		return allowUrls;
	}

	/**
	 * @param allowUrls the allowUrls to set
	 */
	public void setAllowUrls(String allowUrls) {
		this.allowUrls = allowUrls.split(",");
	}



	/* (non-Javadoc)
	 * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@SuppressWarnings("null")
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterchain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");    
	      //  System.out.println(requestUrl);  
	        if(null != allowUrls && allowUrls.length>=1)  
	            for(String url : allowUrls) {    
	                if(requestUrl.contains(url)) {    
	                	filterchain.doFilter(request, response); 
	                	return ;
	                }    
	          } 
		System.out.println("进入Filter.....");
		System.out.println(request.getRequestURI());
		//获取userid
		Cookie cookie=RequestUtils.getCookie(request, "user");
		HttpSession session=request.getSession();
		UUserDto userDto=(UUserDto) session.getAttribute("user");
		String url=request.getRequestURL().toString();
		
		if(cookie!=null&&userDto==null){
	//		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
			UUserDto user = new UUserDto();
			
			int i=Integer.parseInt(StringUtils.decryptPassword(cookie.getValue()));
			user.setUserId(i);
			UUserDao userDao=new UUserDaoImpl();
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());  
			UUserService userService=(UUserService) ctx.getBean("UuserService");
		//	UUserService userService=GlobalContext.getBean("")
			user=userService.getUuser(user);
			session.setAttribute("user", user);
		}
		userDto=(UUserDto) session.getAttribute("user");
		if(userDto!=null&&(url.contains("login")||url.contains("register"))){
			request.getSession().setAttribute("goUrl", request.getRequestURL()+"?"+request.getQueryString());
            //跳转到login.jsp
			System.out.println(request.getSession().getAttribute("goUrl"));
            //跳转到首页
			response.sendRedirect(request.getContextPath());
		}
		filterchain.doFilter(request, response);
	}
	
	 

	

}