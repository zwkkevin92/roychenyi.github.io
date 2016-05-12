package com.cx.wxs.utils;

import com.cx.wxs.enums.DiaryRole;

/**
 * @author 陈义
 * @date   2016-5-12 下午4:25:11
 */
public class Test {

	/**
	 * @param args
	 * @author 陈义
	 * @date   2016-5-12下午4:25:11
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DiaryRole.COMMEN);
		DiaryRole[] role= DiaryRole.values();
		int i=3;
		for(DiaryRole a:role){
			int b=Integer.parseInt(a.toString());
			System.out.println(a.name()+":"+a);
			if(i==b){
				break;
			}else{
				System.out.println("1  ,");
			}
		}
		System.out.println(DiaryRole.values().toString());
		
	}

}
