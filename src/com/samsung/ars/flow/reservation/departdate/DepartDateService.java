package com.samsung.ars.flow.reservation.departdate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.samsung.ars.flow.StepTemplate;

public class DepartDateService extends StepTemplate {

    @Override
    public String getTitle() {
	return "Depart Date";
    }

    @Override
    public String getTips() {
	return "Please, Input depart date. (YYYY-MM-DD)\n";
    }

    @Override
    public String getContent() {
	return "";
    }

    @Override
    public void saveInput() {
	Date date = null;
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	try {
	    df.setLenient(false);
	    date = df.parse(this.input);
	} catch (Throwable t) {
	    this.errorMessage = "ERROR!!! You have to input date in right format.\n";
	    return;
	}
	long inputTime = date.getTime();
	Date startDate = DateUtils.addDays(new Date(), 1);
	startDate = DateUtils.setHours(startDate, 0);
	startDate = DateUtils.setMinutes(startDate, 0);
	startDate = DateUtils.setSeconds(startDate, 0);
	long startTime = startDate.getTime();

	Date endtDate = DateUtils.addYears(new Date(), 1);
	long endTime = endtDate.getTime();
	if (inputTime < startTime || inputTime > endTime) {
	    this.errorMessage = "ERROR!!! You can input date from "
		    + df.format(startDate) + " to " + df.format(endtDate)
		    + ".\n";
	    return;
	}
	this.reservationInfoVO.setDepartDate(df.format(date));
	this.errorMessage = "";
    }
}
