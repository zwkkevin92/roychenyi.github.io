package com.cx.wxs.velocity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.tools.view.context.ViewContext;

import com.cx.wxs.utils.StringUtils;

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
	
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://b.qzone.qq.com/cgi-bin/blognew/blog_get_titlelist?uin=315089752&vuin=0&property=GoRE&category=&numperpage=100&pos=0&direct=1");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.connect();
		InputStream	urlStream = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				urlStream));
		String tmp ="";
		StringBuffer sb=new StringBuffer();
		while ((tmp=reader.readLine())!=null) {
			sb.append(tmp);
		}
	//	byte[] fullByte= StringUtils.gbk2utf8(sb.toString());
		// String fullStr = new String(fullByte, "UTF-8");
       //  System.out.println("string from GBK to UTF-8 byte:  " + fullStr);
		System.out.println(sb.toString());
	}
}
