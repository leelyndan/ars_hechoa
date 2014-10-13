package com.samsung.ars.flow.reservation.seatclass;

import java.util.Map;
import java.util.Map.Entry;

import com.samsung.ars.flow.StepTemplate;

public class SeatClassService extends StepTemplate {

    private Map<String, Integer> map = null;

    @Override
    public String getTitle() {
	return "Seat Class";
    }

    @Override
    public String getTips() {
	return "";
    }

    @Override
    public String getContent() {
	map = this.queryDataService.getSeatClass(this.reservationInfoVO.getId());
	StringBuffer sb = new StringBuffer();
	int index = 1;
	for (Entry<String, Integer> en : map.entrySet()) {
	    sb.append(index);
	    sb.append(".");
	    sb.append(en.getKey());
	    sb.append(" (");
	    sb.append(en.getValue());
	    sb.append(")");
	    sb.append("\n");
	    index++;
	}
	return sb.toString();
    }

    @Override
    public void saveInput() {
	try {
	    int selectNum = Integer.parseInt(this.input);
	    if (selectNum < 0 || selectNum > map.size()) {
		this.errorMessage = "ERROR!!! Wrong Input. Select Again\n";
	    } else {
		int index = 1;
		for (Entry<String, Integer> en : map.entrySet()) {
		    if (index == selectNum) {
			this.reservationInfoVO.setSeatClass(en.getKey());
			this.reservationInfoVO.setSeatClassPirce(en.getValue());
			break;
		    }
		    index++;
		}
		this.errorMessage = "";
	    }
	} catch (Throwable t) {
	    this.errorMessage = "ERROR!!! Wrong Input. Select Again.\n";
	}
    }
}
