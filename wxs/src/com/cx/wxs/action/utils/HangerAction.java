package com.cx.wxs.action.utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.cx.wxs.utils.clientInfo;
import com.cx.wxs.utils.weather.DayWeather;
import com.cx.wxs.utils.weather.GetPlaceByIp;
import com.cx.wxs.utils.weather.WeatherBean;
import com.cx.wxs.utils.weather.WeatherUitls;

/**
 * @author 陈义
 * @date   2016-5-9 下午3:55:17
 */
@Controller
@RequestMapping("/hanger")
public class HangerAction {

	@RequestMapping("/weather")
	@ResponseBody
	public WeatherBean wearthModule(HttpServletRequest request,
			HttpServletResponse response){
		Date date=new Date();
		WeatherBean weather=(WeatherBean) request.getSession().getAttribute("weather");		
		if(weather==null){
			try{ String ip=clientInfo.getIpAddr(request);
			GetPlaceByIp getPlaceByIp = new GetPlaceByIp();
			if(ip.contains("127.0.0.1")||ip.contains("192.168.")||ip.contains("10.")||ip.contains("169.254.")){
			//	ip="61.183.36.13";//荆州ip
				ip="47.153.128.0";//北京ip
			//	ip="74.82.169.23";//硅谷ip
			//	System.out.println( "服务器ip:"+RequestUtils.getServerIp(request));
			}
			JSONObject json =getPlaceByIp.readJsonFromUrl("http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip="+ip);
			String[] addr = (json.get("address").toString()).split("\\|");
			String address = "";
			if(addr!=null&&addr.length>=3){
				address = addr[2];
			}
		    weather= WeatherUitls.getWeatherBean(address);
		    request.getSession().setAttribute("weather",weather);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
		}
		return weather;
	//	DayWeather todayWeather = ((DayWeather)(weather.getDayWeathers().toArray()[0]));
	/*	if(todayWeather==null){
			return null;
		}else{
			
			return todayWeather ;
		}*/
	}
}
