package com.taotaoti.weather.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conditions {
	Wind wind;
	Visibility visibility;
	List<String> weatherConditions;
	List<SkyCondition> skyConditions;
	public Wind getWind() {
		return wind;
	}
	public List<SkyCondition> getSkyConditions() {
		return skyConditions;
	}
	public void setSkyConditions(List<SkyCondition> skyConditions) {
		this.skyConditions = skyConditions;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Visibility getVisibility() {
		return visibility;
	}
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
	public List<String> getWeatherConditions() {
		return weatherConditions;
	}
	public void setWeatherConditions(List<String> weatherConditions) {
		this.weatherConditions = weatherConditions;
	}
	

}
