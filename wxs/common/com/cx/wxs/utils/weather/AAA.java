package com.cx.wxs.utils.weather;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;


public class AAA {

	/**
	 * @param args
	 * @throws JSONException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, JSONException {
		String fileName = System.getProperty("user.dir");
		System.out.println(fileName);
		GetPlaceByIp getPlaceByIp = new GetPlaceByIp();
		JSONObject json =getPlaceByIp.readJsonFromUrl("http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip=61.183.36.13");
		System.out.println("json:"+json.toString());
		System.out.println("城市："+((JSONObject)((JSONObject) json.get("content")).get("address_detail")).get("city"));
		String[] addr = (json.get("address").toString()).split("\\|");
		String address = "";
		if(addr!=null&&addr.length>=3){
			address = addr[2];
		}
		System.out.println("address:"+address);
		for(String str:addr){
			System.out.println(str);
		}
		WeatherBean weatherBean= WeatherUitls.getWeatherBean(address);
		System.out.println(weatherBean.toString());
		DayWeather todayWeather = ((DayWeather)(WeatherUitls.getWeatherBean(address).getDayWeathers().toArray()[0]));
		System.out.println(todayWeather.getWeather()+";"+todayWeather.getDate()+";"+todayWeather.getTemperature()+";"+todayWeather.getPath1());
	}

}
