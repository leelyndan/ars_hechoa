package com.samsung.ars.flow.checkreservation.check;

import com.samsung.ars.flow.StepTemplate;

public class CheckReservationService extends StepTemplate {

    @Override
    public String getTitle() {
	return "Check Reservation";
    }

    @Override
    public String getTips() {
	return "Pease, Input reservation number.\n";
    }

    @Override
    public String getContent() {
	return "";
    }

    @Override
    public void saveInput() {
	boolean isExist = this.queryDataService.isExistReservation(input);
	if (isExist) {
	    this.reservationInfoVO.setReservationNumber(input);
	    this.errorMessage = "";
	} else {
	    this.errorMessage = "ERROR!!! There is no such data.";
	}
    }

}
