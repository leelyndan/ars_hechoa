package com.samsung.ars.flow.statistics.query;

import java.util.List;

import com.samsung.ars.flow.StepTemplate;

public class QueryStatisticsShowService extends StepTemplate {

    @Override
    public String getTitle() {
	return "Flight Statistics";
    }

    @Override
    public String getTips() {
	return "Please, Input any key to return to previous\n";
    }

    @Override
    public String getContent() {
	List<String> list = statisticsInfo();
	StringBuffer sb = new StringBuffer();
	for (String str : list) {
	    sb.append(str);
	    sb.append("\n");
	}
	this.setInputTips("Here is statistics on " + this.paramMap.get("date"));
	return sb.toString();
    }

    private List<String> statisticsInfo() {
	String date = (String) paramMap.get("date");
	return this.queryDataService.queryReservationInfo(date);
    }

    @Override
    public void saveInput() {
	isPrevious = true;
    }

}
