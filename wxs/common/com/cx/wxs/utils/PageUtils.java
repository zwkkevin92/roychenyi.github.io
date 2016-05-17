package com.cx.wxs.utils;

public class PageUtils {
	public static Integer getTotalPage(Integer count,Integer rows){
		if(count>0){
			if(rows==null||rows==0){
				rows = 10;
			}
			return count%rows==0?count%rows:(count/rows+1);
		}
		return 0;
	}
}
