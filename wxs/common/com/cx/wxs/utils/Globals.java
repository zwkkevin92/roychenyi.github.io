package com.cx.wxs.utils;

public class Globals {

	public final static String DEFAULT_CONTENT_TYPE = "text/html;charset=UTF-8";
	
	public final static String LOCAL_PATH_PREFIX = "file://";
	
	public final static String ENC_UTF_8 = "UTF-8";
	public final static String ENC_8859_1 = "8859_1";

	public final static String RANDOM_LOGIN_KEY = "RANDOM_LOGIN_KEY";
	
	public final static String PARAM_SID = "sid";
	
	public final static String MAIL_QUEUE = "MAIL_QUEUE";

	public final static String USER_AGENT = "user-agent";
	
	public final static String SESSION_ID_KEY_IN_COOKIE = "DLOG_SESSION_ID";
	
	public final static String ALBUM_VERIFY_KEY = "ALBUM_";
	
	/**
	 * 运行过程中webapp所在的路径
	 * 由DLOG_ActionServlet进行赋值
	 * @see com.liusoft.dlog4j.servlet.DLOG_ActionServlet#init()
	 */
	public static String WEBAPP_PATH ;

}
