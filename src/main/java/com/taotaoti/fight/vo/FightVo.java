package com.taotaoti.fight.vo;

import java.util.Date;

public class FightVo {
	String departureTime;
	String arrivalTime;
	  String departureAirportFsCode;
	   String arrivalAirportFsCode;
	 String departureTerminal;
	   String arrivalTerminal;
	   boolean departing;
	   String flightNumber;
	   public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public FightVo() {
		// TODO Auto-generated constructor stub
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureAirportFsCode() {
		return departureAirportFsCode;
	}
	public void setDepartureAirportFsCode(String departureAirportFsCode) {
		this.departureAirportFsCode = departureAirportFsCode;
	}
	public String getArrivalAirportFsCode() {
		return arrivalAirportFsCode;
	}
	public void setArrivalAirportFsCode(String arrivalAirportFsCode) {
		this.arrivalAirportFsCode = arrivalAirportFsCode;
	}
	public String getDepartureTerminal() {
		return departureTerminal;
	}
	public void setDepartureTerminal(String departureTerminal) {
		this.departureTerminal = departureTerminal;
	}
	public String getArrivalTerminal() {
		return arrivalTerminal;
	}
	public void setArrivalTerminal(String arrivalTerminal) {
		this.arrivalTerminal = arrivalTerminal;
	}
	public boolean isDeparting() {
		return departing;
	}
	public void setDeparting(boolean departing) {
		this.departing = departing;
	}

}
