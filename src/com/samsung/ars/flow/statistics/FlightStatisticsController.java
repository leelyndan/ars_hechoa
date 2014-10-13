package com.samsung.ars.flow.statistics;

import java.util.HashMap;
import java.util.Map;

import com.samsung.ars.flow.FlowControllerTemplate;
import com.samsung.ars.flow.SimpleDoubleLinkedList;
import com.samsung.ars.flow.StepTemplate;

public class FlightStatisticsController extends FlowControllerTemplate {

    @Override
    protected SimpleDoubleLinkedList<StepTemplate> getFlow() {
	Map<String, Object> paramMap = new HashMap<String, Object>();
	DefineFlightStatisticsFlow defineFlightStatisticsFlow = new DefineFlightStatisticsFlow();
	defineFlightStatisticsFlow.setMap(paramMap);
	return defineFlightStatisticsFlow.getFlow();
    }

    @Override
    protected void init() {
	currentStep = new FlightStatisticsMenuName();
    }

}
