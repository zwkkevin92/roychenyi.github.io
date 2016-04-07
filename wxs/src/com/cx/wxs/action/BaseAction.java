package com.cx.wxs.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.service.UUserService;

/**
 * @author 陈义
 * @date   2016-4-7 下午4:53:07
 */
@Controller
public class BaseAction {
	@Resource
	private UUserService userService;

	/**
	 * @return the userService
	 */
	public UUserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UUserService userService) {
		this.userService = userService;
	}
	
	public boolean setAuthor(ModelAndView mv,String name){
		UUserDto userDto=new UUserDto();
		userDto.setNickname(name);
		userDto=userService.getUuser(userDto);
		if(userDto==null){
			return false;
		}else{
			
			mv.addObject("author",userDto);
			return true;
		}
	}

}
