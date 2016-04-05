package com.cx.wxs.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

/**
 * @author 陈义
 * @date   2016-4-5 下午7:38:17
 */
public class TimestampConverter implements Converter<String,Timestamp> {

	private static final List<String> formarts = new ArrayList<String>(4);
    static{
        formarts.add("yyyy-MM");
        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy-MM-dd HH:mm");
        formarts.add("yyyy-MM-dd HH:mm:ss");
        formarts.add("yyyy/MM/dd HH:mm:ss");
    }
	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Timestamp convert(String source) {
		// TODO Auto-generated method stub
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
    public  Timestamp parseDate(String dateStr, String format) {
        Timestamp date=null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = new Timestamp(dateFormat.parse(dateStr).getTime());
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * @param avg
     * @author 陈义
     * @date   2016-4-5下午8:29:24
     */
    public static void main(String[] avg){
    	System.out.println(new TimestampConverter().convert("2016/01/03 00:00:00"));
    	System.out.println(new DateConverter().convert("2014/04/03 00:00:00"));
    	String str="2014/12/12 12:12:12";
    	System.out.println(str);
    	System.out.println(str.matches("^\\d{4}\\/\\d{1,2}\\/\\d{2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$"));
    } 
}
