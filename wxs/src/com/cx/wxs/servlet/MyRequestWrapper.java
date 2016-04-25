package com.cx.wxs.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.IOUtils;

import com.cx.wxs.utils.clientInfo;

/**
 * @author 陈义
 * @date   2016-4-10 下午9:57:09
 */
public class MyRequestWrapper extends HttpServletRequestWrapper{
	private HttpServletRequest request;  
	private Map<String, String[]> params;
	  
    public MyRequestWrapper(HttpServletRequest request,Map<String, String[]> newParams) {  
        super(request);  
        this.request = request;  
        this.params = newParams;
    }  
    
    @Override  
    public ServletInputStream getInputStream() {          
        ServletInputStream stream = null;
        String data=null;
        try {  
            stream = request.getInputStream();  
            data = IOUtils.toString(stream, "UTF-8");  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        System.out.println("参数输出："+data);
        String ip=clientInfo.getIpAddr(request);
        String clientAgent=clientInfo.getAgent(request);
        boolean isMoblie=clientInfo.isMoblie(request);
        short clientType=(short) (isMoblie?0:1);
        if(data.substring(0, 1).equals("?")){
    		data="&ip="+ip+"&clientIp="+ip+"&clientAgent="+clientAgent+"&clientType="+clientType;
        }else{
        	data="?ip="+ip+"&clientIp="+ip+"&clientAgent="+clientAgent+"&clientType="+clientType;
        }
        byte[] buffer = null;  
        try {  
            buffer = data.getBytes("UTF-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        final ByteArrayInputStream bais = new ByteArrayInputStream(buffer);  
  
        ServletInputStream newStream = new ServletInputStream() {  
  
            @Override  
            public int read() throws IOException {  
                return bais.read();  
            }  
        };  
        return newStream; 
    }
    
    @Override  
    public String getParameter(String name) {  
        String result = "";  
          
        Object v = params.get(name);  
        if (v == null) {  
            result = null;  
        } else if (v instanceof String[]) {  
            String[] strArr = (String[]) v;  
            if (strArr.length > 0) {  
                result =  strArr[0];  
            } else {  
                result = null;  
            }  
        } else if (v instanceof String) {  
            result = (String) v;  
        } else {  
            result =  v.toString();  
        }  
          
        return result;  
    }  
  
    @Override  
    public Map getParameterMap() {  
        return params;  
    }  
  
    @Override  
    public Enumeration getParameterNames() {  
        return new Vector(params.keySet()).elements();  
    }  
  
    @Override  
    public String[] getParameterValues(String name) {  
        String[] result = null;  
       
        Object v = params.get(name);  
        if (v == null) {  
            result =  null;  
        } else if (v instanceof String[]) {  
            result =  (String[]) v;  
        } else if (v instanceof String) {  
            result =  new String[] { (String) v };  
        } else {  
            result =  new String[] { v.toString() };  
        }  
          
        return result;  
    }  
    
    
}
