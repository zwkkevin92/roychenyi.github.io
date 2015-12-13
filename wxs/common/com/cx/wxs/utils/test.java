package com.cx.wxs.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


import org.springframework.beans.BeanUtils;



import com.cx.wxs.dto.BSiteDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.po.UUser;

/**
 *
 * @author 陈义
 * @date   2015-11-26 下午5:29:24
 */
public class test extends Thread{
	@Override
	public void run()
	{
		String[] a={"799047887@qq.com"};
		EmailSender email= new EmailSender("852416288@qq.com","chenyi9347","smtp.qq.com","25",a);
		email.initProperties();
		email.setReceiver();	   

		try {
			email.setMessage("周泽红是大傻逼","周泽红，傻逼，傻逼，傻逼，大傻逼！！");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		email.sendEmail();
		System.out.println("sussess!!!");
	}

	public void sendmail(){
		Thread thread = new test();

		//      thread.run();
		do{
			try
			{
				thread.run();
				Thread.sleep(1);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}while(true);

	}
	
	public static void BeanToDtoTest(){
		BeanToDto<UUser,UUserDto> B=new BeanToDto<UUser,UUserDto>();
		UUserDto userDto=new UUserDto();
	    UUser u=new UUser();
		userDto.setUserId(1);
		BSiteDto s=new BSiteDto();
		s.setSiteId(12452525);
		userDto.setBSiteDto(s);
	
	 	u=B.D1ToT1(new UUser(), userDto);
	 	System.out.println(u.getUserId());
	 	System.out.println(u.getBSite().getSiteId());
	 	u.getBSite().setSiteId(2015);
	 	userDto=B.T1ToD1(u,userDto);
	 	System.out.println(userDto.getBSiteDto().getSiteId());
	//	System.out.println(user.getUserId());
	}

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException
	{
		BeanToDtoTest();
		
	}
}
