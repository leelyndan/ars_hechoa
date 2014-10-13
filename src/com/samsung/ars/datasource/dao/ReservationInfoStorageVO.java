package com.samsung.ars.datasource.dao;

import java.util.HashMap;
import java.util.Map;

public class ReservationInfoStorageVO extends PlaneInfoVO {

    private String departDate = "";

    private String departTime = "";

    private int passengerAdult = 0;

    private int passengerChild = 0;

    private String seatClass = "";

    private int seatClassPirce = 0;

    private int payment = 0;

    private int total = 0;

    private int change = 0;

    private String reservationNumber = "";

    private int promotionPrice = 0;

    public void translateMap2Attribute(Map<String, Object> map) {
	this.setId(Integer.parseInt((String) map.get("id")));
	this.setDepartureAirport((String) map.get("departureAirport"));
	this.setArrivalAirport((String) map.get("arrivalAirport"));
	this.departDate = (String) map.get("departDate");
	this.departTime = (String) map.get("departTime");
	this.passengerAdult = (Integer) map.get("passengerAdult");
	this.passengerChild = (Integer) map.get("passengerChild");
	this.seatClass = (String) map.get("seatClass");
	this.payment = (Integer) map.get("payment");
	this.total = (Integer) map.get("total");
	this.change = (Integer) map.get("change");
	this.setFlight((String) map.get("flight"));
	this.reservationNumber = (String) map.get("reservationNumber");
	this.promotionPrice = (Integer) map.get("promotionPrice");
    }

    public Map<String, Object> translateAttribute2Map() {
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("id", this.getId());
	map.put("departureAirport", this.getDepartureAirport());
	map.put("arrivalAirport", this.getArrivalAirport());
	map.put("departDate", this.departDate);
	map.put("departTime", this.departTime);
	map.put("passengerAdult", this.passengerAdult);
	map.put("passengerChild", this.passengerChild);
	map.put("seatClass", this.seatClass);
	map.put("payment", this.payment);
	map.put("total", this.total);
	map.put("change", this.change);
	map.put("flight", this.getFlight());
	map.put("reservationNumber", this.reservationNumber);
	map.put("promotionPrice", this.promotionPrice);
	return map;
    }

    @Override
    public String toString() {
	StringBuffer sb = new StringBuffer();
	sb.append(this.getFlight() + ",");
	sb.append(this.getDepartureAirport() + ",");
	sb.append(this.getArrivalAirport() + ",");
	sb.append(this.departDate + ",");
	sb.append(this.departTime + ",");
	sb.append(this.passengerAdult + ",");
	sb.append(this.passengerChild + ",");
	sb.append(this.seatClass + ",");
	sb.append(this.total + ",");
	sb.append(this.promotionPrice + ",");
	sb.append(this.payment + ",");
	sb.append(this.change + ",");
	sb.append(this.reservationNumber);
	return sb.toString();
    }

    public String getDepartDate() {
	return departDate;
    }

    public void setDepartDate(String departDate) {
	this.departDate = departDate;
    }

    public String getDepartTime() {
	return departTime;
    }

    public void setDepartTime(String departTime) {
	this.departTime = departTime;
    }

    public int getPassengerAdult() {
	return passengerAdult;
    }

    public void setPassengerAdult(int passengerAdult) {
	this.passengerAdult = passengerAdult;
    }

    public int getPassengerChild() {
	return passengerChild;
    }

    public void setPassengerChild(int passengerChild) {
	this.passengerChild = passengerChild;
    }

    public String getSeatClass() {
	return seatClass;
    }

    public void setSeatClass(String seatClass) {
	this.seatClass = seatClass;
    }

    public int getSeatClassPirce() {
	return seatClassPirce;
    }

    public void setSeatClassPirce(int seatClassPirce) {
	this.seatClassPirce = seatClassPirce;
    }

    public int getPayment() {
	return payment;
    }

    public void setPayment(int payment) {
	this.payment = payment;
    }

    public int getTotal() {
	return total;
    }

    public void setTotal(int total) {
	this.total = total;
    }

    public int getChange() {
	return change;
    }

    public void setChange(int change) {
	this.change = change;
    }

    public String getReservationNumber() {
	return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
	this.reservationNumber = reservationNumber;
    }

    public int getPromotionPrice() {
	return promotionPrice;
    }

    public void setPromotionPrice(int promotionPrice) {
	this.promotionPrice = promotionPrice;
    }

}
