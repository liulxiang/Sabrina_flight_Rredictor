package com.taotaoti.weather.vo;

import java.util.List;


public class FightWeather {
	String report;
    String reportTime;
    String observationTime;
    String reportType;
    String weatherStationIcao;
	List<Forecast>  forecasts;
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	public String getObservationTime() {
		return observationTime;
	}
	public void setObservationTime(String observationTime) {
		this.observationTime = observationTime;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getWeatherStationIcao() {
		return weatherStationIcao;
	}
	public void setWeatherStationIcao(String weatherStationIcao) {
		this.weatherStationIcao = weatherStationIcao;
	}
	public List<Forecast> getForecasts() {
		return forecasts;
	}
	public void setForecasts(List<Forecast> forecasts) {
		this.forecasts = forecasts;
	}
	
	

}
