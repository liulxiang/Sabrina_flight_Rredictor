package com.taotaoti.weather.vo;


public class FightWeather {
	float latitude;
	float longitude;
	String timezone;
	int offset;
	CurrentWeather  currently;
	public FightWeather() {
		// TODO Auto-generated constructor stub
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public CurrentWeather getCurrently() {
		return currently;
	}
	public void setCurrently(CurrentWeather currently) {
		this.currently = currently;
	} 

}
