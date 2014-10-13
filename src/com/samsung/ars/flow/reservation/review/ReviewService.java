package com.samsung.ars.flow.reservation.review;

import com.samsung.ars.flow.StepTemplate;

public class ReviewService extends StepTemplate {

    @Override
    public String getTitle() {
	return "Review";
    }

    @Override
    public String getTips() {
	return "Please, Input any key.\n";
    }

    @Override
    public String getContent() {
	StringBuffer sb = new StringBuffer();
	sb.append("Flight : " + this.reservationInfoVO.getFlight() + "\n");
	sb.append("Departure Airport : "
		+ this.reservationInfoVO.getDepartureAirport() + "\n");
	sb.append("Arrival Airport : "
		+ this.reservationInfoVO.getArrivalAirport() + "\n");
	sb.append("Depart Date : " + this.reservationInfoVO.getDepartDate()
		+ "\n");
	sb.append("Depart Time : " + this.reservationInfoVO.getDepartTime()
		+ "\n");
	sb.append("Passenger : " + this.reservationInfoVO.getPassengerAdult()
		+ " Adult, " + this.reservationInfoVO.getPassengerChild()
		+ " Child" + "\n");
	sb.append("Seat Class : " + this.reservationInfoVO.getSeatClass()
		+ "\n");
	sb.append("Total Amount : " + this.reservationInfoVO.getTotal()
		+ " Yuan" + "\n");
	sb.append("Promotion Price : "
		+ this.reservationInfoVO.getPromotionPrice() + " Yuan" + "\n");
	sb.append("Payment : " + this.reservationInfoVO.getPayment()
		+ " Yuan\n");
	sb.append("Change : " + this.reservationInfoVO.getChange() + " Yuan\n");
	sb.append("Reservation Number : "
		+ this.reservationInfoVO.getReservationNumber() + "\n");
	return sb.toString();
    }

   

    @Override
    public void saveInput() {
    }

}
