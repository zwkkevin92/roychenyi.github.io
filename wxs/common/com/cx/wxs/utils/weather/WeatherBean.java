package com.cx.wxs.utils.weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherBean {
	//省、直辖市、特别行政区
	private String province;
	//地区、市、县
	private String city;
	//编码
	private String code;
	//更新时间
	private String updateTime;
	//今日天气实况
	private String todayWeather;
	//紫外线强度
	private String UV;
	//其他指数
	private String otherIndex;
	//更多天气
	private List<DayWeather> dayWeathers = new ArrayList<DayWeather>();
	
	public WeatherBean() {
		super();
	}

	public WeatherBean(String province, String city, String code,
			String updateTime, String todayWeather, String uV,
			String otherIndex, List<DayWeather> dayWeathers) {
		super();
		this.province = province;
		this.city = city;
		this.code = code;
		this.updateTime = updateTime;
		this.todayWeather = todayWeather;
		UV = uV;
		this.otherIndex = otherIndex;
		this.dayWeathers = dayWeathers;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getTodayWeather() {
		return todayWeather;
	}

	public void setTodayWeather(String todayWeather) {
		this.todayWeather = todayWeather;
	}

	public String getUV() {
		return UV;
	}

	public void setUV(String uV) {
		UV = uV;
	}

	public String getOtherIndex() {
		return otherIndex;
	}

	public void setOtherIndex(String otherIndex) {
		this.otherIndex = otherIndex;
	}

	public List<DayWeather> getDayWeathers() {
		return dayWeathers;
	}

	public void setDayWeathers(List<DayWeather> dayWeathers) {
		this.dayWeathers = dayWeathers;
	}

	@Override
	public String toString() {
		return "WeatherBean [province=" + province + ", city=" + city
				+ ", code=" + code + ", updateTime=" + updateTime
				+ ", todayWeather=" + todayWeather + ", UV=" + UV
				+ ", otherIndex=" + otherIndex + ", dayWeathers=" + dayWeathers
				+ "]";
	}
	
	public String toTodayHtml(){
		return "";
	}
	
	
	
}
