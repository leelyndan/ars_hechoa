package com.samsung.ars.flow.checkreservation.review;

import java.util.Map;

import com.samsung.ars.flow.StepTemplate;

public class ReviewService extends StepTemplate {

    @Override
    public String getTitle() {
	return "Review";
    }

    @Override
    public String getTips() {
	return "";
    }

    @Override
    public String getContent() {
	Map<String, Object> map = this.queryDataService
		.queryReservation(this.reservationInfoVO.getReservationNumber());
	StringBuffer sb = new StringBuffer();
	sb.append("Flight : " + map.get("flight") + "\n");
	sb.append("Departure Airport : " + map.get("departureAirport") + "\n");
	sb.append("Arrival Airport : " + map.get("arrivalAirport") + "\n");
	sb.append("Depart Date : " + map.get("departDate") + "\n");
	sb.append("Depart Time : " + map.get("departTime") + "\n");
	sb.append("Passenger : " + map.get("passengerAdult") + " Adult, "
		+ map.get("passengerChild") + " Child" + "\n");
	sb.append("Seat Class : " + map.get("seatClass") + "\n");
	sb.append("Total Amount : " + map.get("total") + " Yuan" + "\n");
	sb.append("Promotion Price : " + map.get("promotionPrice") + " Yuan"
		+ "\n");
	sb.append("Payment : " + map.get("payment") + " Yuan\n");
	sb.append("Change : " + map.get("change") + " Yuan\n");
	sb.append("Reservation Number : " + map.get("reservationNumber")
		+ "\n\n");

	return sb.toString();
    }

    @Override
    public void saveInput() {

    }

}
