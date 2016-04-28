package com.cx.wxs.utils.weather;

public class DayWeather {
	//天气日期
	private String date;
	//天气情况
	private String weather;
	//温度
	private String temperature;
	//风力
	private String cloud;
	//图片路径1
	private String path1;
	//图片路径2
	private String path2;
	
	public DayWeather() {
		super();
	}

	public DayWeather(String date, String weather, String temperature,
			String cloud, String path1, String path2) {
		super();
		this.date = date;
		this.weather = weather;
		this.temperature = temperature;
		this.cloud = cloud;
		this.path1 = path1;
		this.path2 = path2;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getCloud() {
		return cloud;
	}

	public void setCloud(String cloud) {
		this.cloud = cloud;
	}

	public String getPath1() {
		return path1;
	}

	public void setPath1(String path1) {
		this.path1 = path1;
	}

	public String getPath2() {
		return path2;
	}

	public void setPath2(String path2) {
		this.path2 = path2;
	}

	@Override
	public String toString() {
		return "DayWeather [date=" + date + ", weather=" + weather
				+ ", temperature=" + temperature + ", cloud=" + cloud
				+ ", path1=" + path1 + ", path2=" + path2 + "]";
	}
}
