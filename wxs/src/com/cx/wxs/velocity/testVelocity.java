package com.cx.wxs.velocity;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.tools.view.context.ViewContext;

/**
 * @author 陈义
 * @date   2016-1-10 下午11:14:07
 */
public class testVelocity extends HttpServlet{
	
	/* protected HttpServletRequest request;
	    protected HttpServletResponse response;
	
	public testVelocity(){}
	
	 public void init(Object obj)
	    {
	        if(obj instanceof ViewContext)
	        {
	            ViewContext ctx = (ViewContext)obj;
	            setRequest(ctx.getRequest());
	            setResponse(ctx.getResponse());
	        }
	    }

	  public void setRequest(HttpServletRequest request)
	    {
	        if(request == null)
	        {
	            throw new NullPointerException("request should not be null");
	        } else
	        {
	            this.request = request;
	            return;
	        }
	    }

	    public void setResponse(HttpServletResponse response)
	    {
	        if(response == null)
	        {
	            throw new NullPointerException("response should not be null");
	        } else
	        {
	            this.response = response;
	            return;
	        }
	    }
*/
	public  void init(){
		System.out.println();
	}
	
	public String test(){
		return "1234";
	}
	
	public String toString(String str){
		return "测试："+str;
	}
	
	public static String getBaseUrl(HttpServletRequest request) {
		        return request.getRequestURL().substring(0,
		                 request.getRequestURL().indexOf(request.getContextPath()) + request.getContextPath().length()) + "/";
		    }

	public static String getBaseUrl(HttpServletRequest request,String str) {
        return request.getRequestURL().substring(0,
                 request.getRequestURL().indexOf(request.getContextPath()) + request.getContextPath().length()) + "/";
    }

	
	protected HttpServletRequest request;
}
