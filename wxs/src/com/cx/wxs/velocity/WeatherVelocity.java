package com.cx.wxs.velocity;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;

import com.cx.wxs.utils.DateUtils;
import com.cx.wxs.utils.RequestUtils;
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

	public String getTodayWeather(HttpServletRequest request) {
		Date date=new Date();
		WeatherBean weather=(WeatherBean) request.getSession().getAttribute("weather");		
		if(weather==null){
			try{ String ip=clientInfo.getIpAddr(request);
			GetPlaceByIp getPlaceByIp = new GetPlaceByIp();
			if(ip.contains("127.0.0.1")||ip.contains("192.168.")||ip.contains("10.")){
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
		DayWeather todayWeather = ((DayWeather)(weather.getDayWeathers().toArray()[0]));
		if(todayWeather==null){
			return "";
		}
		StringBuffer  stringBuffer=new StringBuffer();
		stringBuffer.append("<div class='weather-module' id='weather-module'><div class='other-info' id='weather-info'>");
		stringBuffer.append("<div class='shadow-wrapper city-wrapper' title='"+weather.getCity()+"' id='weather_city_name'>");
		stringBuffer.append("<p class='city textoverflow'>"+weather.getCity()+"</p></div>");
		stringBuffer.append("<div class='shadow-wrapper date-wrapper'><p class='date'>"+todayWeather.getDate()+" "+todayWeather.getWeather()+"</p></div></div>");
		stringBuffer.append("<div class='weather-temperature shadow-wrapper'> <h5 class='temperature-num'>"+todayWeather.getTemperature()+"</h5><!--<span class='temperature-unit'>°</span>--></div>");
		stringBuffer.append(" <img class='weather-icon' src='"+RequestUtils.getDomain(request)+"/images/weather/a_"+todayWeather.getPath1()+"' alt='' title='"+todayWeather.getWeather()+"'></div>");
		System.out.println("请求时间："+(new Date().getTime()-date.getTime()));
		return stringBuffer.toString();
	}
}
