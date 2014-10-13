package com.samsung.ars.flow.statistics.query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.samsung.ars.flow.StepTemplate;

public class QueryStatisticsService extends StepTemplate {

    @Override
    public String getTitle() {
	return "Flight Statistics";
    }

    @Override
    public String getTips() {
	return "Please, Input date for inquiring.\n";
    }

    @Override
    public String getContent() {
	return "";
    }

    @Override
    public void saveInput() {
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	try {
	    df.setLenient(false);
	    df.parse(this.input);
	    this.paramMap.put("date", input);
	} catch (Throwable t) {
	    this.errorMessage = "ERROR!!! You have to input date in right format.\n";
	    return;
	}
    }

}
