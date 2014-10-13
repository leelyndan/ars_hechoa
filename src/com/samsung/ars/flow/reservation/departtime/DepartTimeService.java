package com.samsung.ars.flow.reservation.departtime;

import java.util.List;
import java.util.Map;

import com.samsung.ars.flow.StepTemplate;

public class DepartTimeService extends StepTemplate {

    private List<String> list = null;

    @Override
    public String getTitle() {
	return "Depart Time";
    }

    @Override
    public String getTips() {
	return "";
    }

    @Override
    public String getContent() {
	String departAirport = this.reservationInfoVO.getDepartureAirport();
	String arrivalAirport = this.reservationInfoVO.getArrivalAirport();
	list = this.queryDataService.getDepartTime(departAirport,
		arrivalAirport);
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
	    } else {
		String selectTime = list.get(selectNum - 1);
		this.reservationInfoVO.setDepartTime(selectTime);
		Map<String, String> map = this.queryDataService.getFlight(
			this.reservationInfoVO.getDepartureAirport(),
			this.reservationInfoVO.getArrivalAirport(), selectTime);
		this.reservationInfoVO.setFlight(map.get("flight"));
		this.reservationInfoVO.setId(map.get("id"));
		this.errorMessage = "";
	    }
	} catch (Throwable t) {
	    this.errorMessage = "ERROR!!! Wrong Input. Select Again.\n";
	}
    }

}
