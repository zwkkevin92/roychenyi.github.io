package com.cx.wxs.utils.weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherUitls {
	public static WeatherBean getWeatherBean(String city) {
		WeatherWS weatherWS = new WeatherWS();
		WeatherWSSoap weatherWSSoap = weatherWS.getWeatherWSSoap();
		ArrayOfString weather = null;
		weather = weatherWSSoap.getWeather(city.trim(), null);
		List<String> listSub = weather.getString();
		System.out.println("listSub:"+listSub);
		Object[] strSet = (Object[]) listSub.toArray();
		WeatherBean weatherBean = null;
		if (strSet != null && strSet.length >= 1) {
			weatherBean = new WeatherBean();
			List<DayWeather> list = new ArrayList<DayWeather>();
			DayWeather dayWeather = null;
			for (int i = 0; i < strSet.length; i++) {
				String str = (String) strSet[i];
				switch (i) {
				case 0:
					weatherBean
							.setProvince(str.substring(0,str.indexOf(" ")));
					System.out.println("province:"+weatherBean.getProvince());
					break;
				case 1:
					weatherBean.setCountry(str);
					break;
				case 2:
					weatherBean.setCode(str);
					break;
				case 3:
					weatherBean.setUpdateTime(str);
					break;
				case 4:
					weatherBean.setTodayWeather(str);
					break;
				case 5:
					weatherBean.setUV(str);
					break;
				case 6:
					weatherBean.setOtherIndex(str);
					break;
				default:
					if ((i - 7) % 5 == 0) {
						dayWeather = new DayWeather();
					}
					switch ((i - 7) % 5) {
					case 0:
						dayWeather.setDate(str.substring(0, str.indexOf(" ")));
						dayWeather
								.setWeather(str.substring(str.indexOf(" ") + 1));
						break;
					case 1:
						dayWeather.setTemperature(str);
						break;
					case 2:
						dayWeather.setCloud(str);
						break;
					case 3:
						dayWeather.setPath1(str);
						break;
					case 4:
						dayWeather.setPath2(str);
						break;
					}
					break;
				}
				if (i >= 7 && (i - 6) % 5 == 0) {
					list.add(dayWeather);
				}
			}
			weatherBean.setDayWeathers(list);
		}
		//System.out.println(weatherBean);
		return weatherBean;
	}
}
