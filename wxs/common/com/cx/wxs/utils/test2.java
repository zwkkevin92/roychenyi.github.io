package com.cx.wxs.utils;

import org.springframework.beans.BeanUtils;

import com.cx.wxs.dto.BSiteDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.po.UUser;

/**
 * @author 陈义
 * @date   2015-12-10 下午9:48:05
 */
public class test2 {

	public static void main(String[] args) {
	//	BeanToDto<UUser,UUserDto> B=new BeanToDto<UUser,UUserDto>();
		UUserDto userDto=new UUserDto();
		userDto.setUserId(1);
		BSiteDto s=new BSiteDto();
		s.setSiteId(1);
		userDto.setBSiteDto(s);
		UUser u=new UUser();
		BeanUtils.copyProperties(userDto, u);
	// 	u= B.ToDto(u,userDto);
	 	System.out.println(u.getUserId());
	// 	System.out.println(u.getBSite().getSiteId());
	 	System.out.println("^^^^^^^^^^^^^");

	}
}
