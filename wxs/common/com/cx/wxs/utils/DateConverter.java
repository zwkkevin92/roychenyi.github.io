package com.cx.wxs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @author 陈义
 * @date   2015-12-16 上午10:24:40
 */
public class DateConverter implements Converter<String,Date>{

	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
		//实现 将日期串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)
		
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				try {
					//转成直接返回
					return simpleDateFormat.parse(source);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//如果参数绑定失败返回null
				return null;
	}

}
