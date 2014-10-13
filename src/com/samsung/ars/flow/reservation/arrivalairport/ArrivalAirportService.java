package com.samsung.ars.flow.reservation.arrivalairport;

import java.util.List;

import com.samsung.ars.flow.StepTemplate;

public class ArrivalAirportService extends StepTemplate {

    private List<String> list = null;

    @Override
    public String getTitle() {
	return "Arrival Airport";
    }

    @Override
    public String getTips() {
	return "";
    }

    @Override
    public String getContent() {
	list = this.queryDataService.getArrivalAirport();
	StringBuffer sb = new StringBuffer();
	for (int i = 1; i <= list.size(); i++) {
	    sb.append(i);
	    sb.append(".");
	    sb.append(list.get(i - 1));
	    sb.append("\n");
	}
	return sb.toString();
    }

    @Override
    public void saveInput() {
	try {
	    int selectNum = Integer.parseInt(this.input);
	    if (selectNum < 0 || selectNum > list.size()) {
		this.errorMessage = "ERROR!!! Wrong Input. Select Again\n";
	    } else if (this.reservationInfoVO.getDepartureAirport().equals(
		    list.get(selectNum - 1))) {
		this.errorMessage = "ERROR!!! Can¡¯t select the same airport as Departure\n";
	    } else {
		this.reservationInfoVO.setArrivalAirport(list
			.get(selectNum - 1));
		this.errorMessage = "";
	    }
	} catch (Throwable t) {
	    this.errorMessage = "ERROR!!! Wrong Input. Select Again.\n";
	}
    }
}
