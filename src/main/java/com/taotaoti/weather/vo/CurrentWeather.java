package com.taotaoti.weather.vo;

public class CurrentWeather {

	  long time;
      String summary;
      String icon;
      String precipType;
      float temperature;
      float apparentTemperature;
      float windSpeed;
      int windBearing;
      float pressure;
      String visibility;
      String cloudCover;
      String ozone;
      
      public CurrentWeather() {
	}
      
	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getCloudCover() {
		return cloudCover;
	}

	public void setCloudCover(String cloudCover) {
		this.cloudCover = cloudCover;
	}

	public String getOzone() {
		return ozone;
	}

	public void setOzone(String ozone) {
		this.ozone = ozone;
	}

	public CurrentWeather(long time, String summary, String icon,
			String precipType, float temperature, float apparentTemperature,
			float windSpeed, int windBearing, float pressure) {
		super();
		this.time = time;
		this.summary = summary;
		this.icon = icon;
		this.precipType = precipType;
		this.temperature = temperature;
		this.apparentTemperature = apparentTemperature;
		this.windSpeed = windSpeed;
		this.windBearing = windBearing;
		this.pressure = pressure;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getPrecipType() {
		return precipType;
	}
	public void setPrecipType(String precipType) {
		this.precipType = precipType;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public float getApparentTemperature() {
		return apparentTemperature;
	}
	public void setApparentTemperature(float apparentTemperature) {
		this.apparentTemperature = apparentTemperature;
	}
	public float getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}
	public int getWindBearing() {
		return windBearing;
	}
	public void setWindBearing(int windBearing) {
		this.windBearing = windBearing;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
      
}
