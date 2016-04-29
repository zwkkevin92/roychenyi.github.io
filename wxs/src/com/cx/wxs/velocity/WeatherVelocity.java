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
				ip="61.183.36.13";
			}
			JSONObject json =getPlaceByIp.readJsonFromUrl("http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip="+ip);
			String[] addr = (json.get("address").toString()).split("\\|");
			String address = "";
			if(addr!=null&&addr.length>=3){
				address = addr[2];
			}
		    weather= WeatherUitls.getWeatherBean(address);
		    request.getSession().setAttribute("weather",weather);
			DayWeather todayWeather = ((DayWeather)(weather.getDayWeathers().toArray()[0]));
		}
		
		return " <div class='weather-module' id='weather-module'>"+
                                "<div class='other-info' id='weather-info'>"+
                                    <div class='shadow-wrapper city-wrapper' title='厦门' id='weather_city_name'>
                                        <p class='city textoverflow'>厦门</p>
                                     </div>
                                    <div class='shadow-wrapper date-wrapper'>
                                        <p class='date'>4月29日</p>

                                    </div>
                                </div>
                                <div class='weather-temperature shadow-wrapper'>
                                    <h5 class='temperature-num'>23</h5>

                                    <span class='temperature-unit'>°</span>
                                   <!-- <span class='anti-text anti-temperature-unit'>°</span>-->
                                </div>
                                <img class='weather-icon' src='http://ctc.qzonestyle.gtimg.cn/aoi/img/weather/weather-cloudy-sunny.png' alt='' title='多云'>
                            </div>";
	}
}
