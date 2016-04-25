package com.cx.wxs.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

/**
 * @author 陈义
 * @date   2015-12-16 上午10:24:40
 */
public class DateConverter implements Converter<String,Date>{


	
/*	public Date convert1(String source) {
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
	}*/
	
	private static final List<String> formarts = new ArrayList<String>(4);
    static{
        formarts.add("yyyy-MM");
        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy-MM-dd HH:mm");
        formarts.add("yyyy-MM-dd HH:mm:ss");
        formarts.add("yyyy/MM/dd HH:mm:ss");
    }
    @Override 
    public Date convert(String source) {
        String value = source.trim();
        if ("".equals(value)) {
            return null;
        }
        if(source.matches("^\\d{4}-\\d{1,2}$")){ 
            return parseDate(source, formarts.get(0));
        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
            return parseDate(source, formarts.get(1));
        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
            return parseDate(source, formarts.get(2));
        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
            return parseDate(source, formarts.get(3));
        }else if(source.matches("^\\d{4}\\/\\d{1,2}\\/\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
        	return parseDate(source, formarts.get(4));
        } else {
            throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
        }
    }
 
    /**
     * 功能描述：格式化日期
     * 
     * @param dateStr
     *            String 字符型日期
     * @param format
     *            String 格式
     * @return Date 日期
     */
    public  Date parseDate(String dateStr, String format) {
        Date date=null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = (Date) dateFormat.parse(dateStr);
        } catch (Exception e) {
        }
        return date;
    }
    
  

}
