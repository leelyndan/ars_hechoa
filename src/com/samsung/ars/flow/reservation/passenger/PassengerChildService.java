package com.samsung.ars.flow.reservation.passenger;

import com.samsung.ars.flow.StepTemplate;

public class PassengerChildService extends StepTemplate {

    @Override
    public String getTitle() {
	return "Passenger";
    }

    @Override
    public String getTips() {
	return "Please, Input the number of Child.\n(0 ~ 10)\n";
    }

    @Override
    public String getContent() {
	return "\n";
    }

    @Override
    public void saveInput() {
	try {
	    int inputNum = Integer.parseInt(this.input);
	    if (inputNum < 0 || inputNum > 11) {
		this.errorMessage = "ERROR!!! Please, Input the number of Child.(0 ~ 10)\n";
	    } else {
		this.reservationInfoVO.setPassengerChild(inputNum);
		this.errorMessage = "";
	    }
	    if (0 == this.reservationInfoVO.getPassengerAdult()
		    && 0 == inputNum) {
		isPrevious = true;
	    }
	} catch (Throwable t) {
	    this.errorMessage = "ERROR!!! Please, Input the number of Child.(0 ~ 10)\n";
	}

    }
}
