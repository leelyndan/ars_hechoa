package com.samsung.ars.flow.reservation.passenger;

import com.samsung.ars.flow.StepTemplate;

public class PassengerAdultService extends StepTemplate {

    @Override
    public String getTitle() {
	return "Passenger";
    }

    @Override
    public String getTips() {
	return "Please, Input the number of Adult.\n(0 ~ 10)\n";
    }

    @Override
    public String getContent() {
	if (0 == this.reservationInfoVO.getPassengerAdult()
		&& 0 == this.reservationInfoVO.getPassengerChild()) {
	    this.errorMessage = "ERROR!!! You have to input more than 0.\n";
	}
	return "";
    }

    @Override
    public void saveInput() {
	try {
	    int inputNum = Integer.parseInt(this.input);
	    if (inputNum < 0 || inputNum > 11) {
		this.errorMessage = "ERROR!!! Please, Input the number of Adult.(0 ~ 10)\n";
	    } else {
		this.reservationInfoVO.setPassengerAdult(inputNum);
		this.errorMessage = "";
	    }
	} catch (Throwable t) {
	    this.errorMessage = "ERROR!!! Please, Input the number of Adult.(0 ~ 10)\n";
	}
    }

}
