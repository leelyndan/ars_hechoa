package com.samsung.ars.datasource.dao;

import java.util.ArrayList;
import java.util.List;

public class PlaneInfoVO {

    private int id = 0;

    private String flight = "";

    private String departureAirport = "";

    private String arrivalAirport = "";

    private List<String> departTimeList = new ArrayList<String>();

    private int firstClass = 0;

    private int businessClass = 0;

    private int economyClass = 0;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getFlight() {
	return flight;
    }

    public void setFlight(String flight) {
	this.flight = flight;
    }

    public String getDepartureAirport() {
	return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
	this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
	return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
	this.arrivalAirport = arrivalAirport;
    }

    public List<String> getDepartTimeList() {
	return departTimeList;
    }

    public void setDepartTimeList(List<String> departTimeList) {
	this.departTimeList = departTimeList;
    }

    public int getFirstClass() {
	return firstClass;
    }

    public void setFirstClass(int firstClass) {
	this.firstClass = firstClass;
    }

    public int getBusinessClass() {
	return businessClass;
    }

    public void setBusinessClass(int businessClass) {
	this.businessClass = businessClass;
    }

    public int getEconomyClass() {
	return economyClass;
    }

    public void setEconomyClass(int economyClass) {
	this.economyClass = economyClass;
    }

}
