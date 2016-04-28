package com.cx.wxs.velocity;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;

import com.cx.wxs.utils.clientInfo;
import com.cx.wxs.utils.weather.DayWeather;
import com.cx.wxs.utils.weather.GetPlaceByIp;
import com.cx.wxs.utils.weather.WeatherBean;
import com.cx.wxs.utils.weather.WeatherUitls;

/**
 * @author 陈义
 * @date   2016-4-28 下午4:20:31
 */
public class WeatherVelocity extends VelocityTool{

	public String getTodayWeather(HttpServletRequest request) throws IOException, JSONException{
		WeatherBean weather=(WeatherBean) request.getSession().getAttribute("weather");
		if(weather==null){
			String ip=clientInfo.getIpAddr(request);
			GetPlaceByIp getPlaceByIp = new GetPlaceByIp();
			if(ip.contains("127.0.0.1")||ip.contains("19.168.")||ip.contains("10.")){
				ip="";
			}
			JSONObject json =getPlaceByIp.readJsonFromUrl("http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip="+ip);
			String[] addr = (json.get("address").toString()).split("\\|");
			String address = "";
			if(addr!=null&&addr.length>=3){
				address = addr[2];
			}
		//	weather.setProvince();
			DayWeather todayWeather = ((DayWeather)(WeatherUitls.getWeatherBean(address).getDayWeathers().toArray()[0]));
		}
		
		return weather.toTodayHtml();
	}
}
