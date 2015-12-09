package com.cx.wxs.utils;



import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * spring等bean工具类
 * @author 陈义
 * @date   2015-12-1 下午5:11:33
 */
public class SpringUtils {
	/**
	 * 根据业务bean名称，获取当前业务的对象
	 * @param beanId 业务beanId，必选
	 * @return
	 * @author 微蓝星空
	 * @date 2015-3-9 上午11:45:37
	 */
	public static Object getBean(String beanId){
		if(!StringUtils.isNotEmpty(beanId))return null;
		//获得spring上下文对象
//		String[] configLocations = new String[]{"classpath:spring.xml","classpath:spring-hibernate.xml"};
//		ApplicationContext ac = new ClassPathXmlApplicationContext(configLocations);
		WebApplicationContext ac = ContextLoader.getCurrentWebApplicationContext();
		return ac.getBean(beanId);
	}
}

