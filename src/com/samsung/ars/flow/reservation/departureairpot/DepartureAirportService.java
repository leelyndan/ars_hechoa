package com.samsung.ars.flow.reservation.departureairpot;

import java.util.List;

import com.samsung.ars.flow.StepTemplate;

public class DepartureAirportService extends StepTemplate {

    private List<String> list = null;

    @Override
    public String getTitle() {
	return "Departure Airport";
    }

    @Override
    public String getTips() {
	return "";
    }

    @Override
    public String getContent() {
	list = this.queryDataService.getDepartureAirport();
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
		this.errorMessage = "ERROR!!! Wrong Input. Select Again.\n";
	    } else {
		this.reservationInfoVO.setDepartureAirport(list
			.get(selectNum - 1));
		this.errorMessage = "";
	    }
	} catch (Throwable t) {
	    this.errorMessage = "ERROR!!! Wrong Input. Select Again.\n";
	}
    }
}
