package com.cx.wxs.utils;

import java.io.UnsupportedEncodingException;

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
    public static void main(String[] args)
    {
        Thread thread = new test();
        
//        thread.run();
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
}
