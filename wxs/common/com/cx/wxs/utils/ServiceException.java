package com.cx.wxs.utils;



/**
 * @author 陈义
 * @date   2015-12-1 下午5:06:28
 */
/**
 * 类的说明：业务异常
 * <li>继承RuntimeException，用于回滚事务，并在前台弹出提示信息
 * @author Ou
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ServiceException(){
		super();
	}
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
	/**
	 * 回滚事务
	 * @author Ou
	 * 2014-7-18
	 */
	public static void rollback(){
		throw new ServiceException("测试，回滚事务。");
	}
}
