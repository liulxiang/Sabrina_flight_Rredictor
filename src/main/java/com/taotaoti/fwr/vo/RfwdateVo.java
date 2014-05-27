package com.taotaoti.fwr.vo;

import java.util.List;

import com.taotaoti.fight.vo.FightVo;
import com.taotaoti.weather.vo.FightWeather;

public class RfwdateVo {
	//#风速
	//x1=speedknots+3.88
float x1=3.88f;
float x2;
float x3;
float wd;
float delay;

public RfwdateVo(){
	
}
public RfwdateVo(FightVo fightVo,FightWeather fightWeather){
	String visibility=fightWeather.getForecasts().get(0).getConditions().getVisibility().getMiles();
	float v=Float.valueOf(visibility);
	if(v==10){
		x2=0;
	}else if(v>=9&&v<10){
		x2=2;
	}else if(v>=8&&v<9){
		x2=4;
	}else if(v>=7&&v<8){
		x2=6;
	}else if(v>=5&&v<7){
	   x2=8;
     }else{
    	 x2=10;
	}
	
	String coverage=fightWeather.getForecasts().get(0).getConditions().getSkyConditions().get(0).getCoverage();
	List<String> weatherConditions=fightWeather.getForecasts().get(0).getConditions().getWeatherConditions();
	if(coverage.toLowerCase().contains("overcast")){
		x3=10;
	}else if(coverage.toLowerCase().contains("clouds")){
		x3=8;
	}else if(coverage.toLowerCase().contains("scattered cloudy")){
		x3=4;
	}else if(weatherConditions!=null&& weatherConditions.size()>0){
			if(weatherConditions.contains("heavy rain")||
					weatherConditions.contains("heavy snow")||
					weatherConditions.contains("heavy fog")||
					weatherConditions.contains("heavy drizzle")||
					weatherConditions.contains("heavy mist")||
					weatherConditions.contains("heavy haze")||
					weatherConditions.contains("heavy hail")||
					weatherConditions.contains("hurricane")||
					weatherConditions.contains("tornado")||
					weatherConditions.contains("thunderstorms")){
				x3=8;
			}
			if(weatherConditions.contains("moderate rain")||
					weatherConditions.contains("moderate snow")||
					weatherConditions.contains("moderate fog")||
					weatherConditions.contains("moderate drizzle")||
					weatherConditions.contains("moderate mist")||
					weatherConditions.contains("moderate haze")||
					weatherConditions.contains("moderate hail")){
				x3=6;
				
			}
			if(weatherConditions.contains("light rain")||
					weatherConditions.contains("light snow")||
					weatherConditions.contains("light fog")||
					weatherConditions.contains("light drizzle")||
					weatherConditions.contains("light mist")||
					weatherConditions.contains("light haze")||
					weatherConditions.contains("light hail")){
				x3=4;
			}
	}else 
	   x3=10;
    String speedknots=fightWeather.getForecasts().get(0).getConditions().getWind().getSpeedKnots();
	wd=8.15908f*x1+3.791154f*x2+3.010272f*x3-26.9445f;
	
}
public float getX1() {
	return x1;
}
public void setX1(float x1) {
	this.x1 = x1;
}
public float getX2() {
	return x2;
}
public void setX2(float x2) {
	this.x2 = x2;
}
public float getX3() {
	return x3;
}
public void setX3(float x3) {
	this.x3 = x3;
}
public float getWd() {
	return wd;
}
public void setWd(float wd) {
	this.wd = wd;
}
public float getDelay() {
	return delay;
}
public void setDelay(float delay) {
	this.delay = delay;
}

	
	
}
