package com.samsung.ars.flow.statistics;

import java.util.Map;

import com.samsung.ars.datasource.service.IQueryDataService;
import com.samsung.ars.datasource.service.impl.QueryDataServiceImpl;
import com.samsung.ars.flow.Global;
import com.samsung.ars.flow.SimpleDoubleLinkedList;
import com.samsung.ars.flow.StepTemplate;
import com.samsung.ars.flow.statistics.query.QueryStatisticsService;
import com.samsung.ars.flow.statistics.query.QueryStatisticsShowService;

public class DefineFlightStatisticsFlow {

    private SimpleDoubleLinkedList<StepTemplate> doubleList = null;

    private Map<String, Object> map = null;

    private IQueryDataService queryDataService = null;

    public DefineFlightStatisticsFlow() {
	queryDataService = new QueryDataServiceImpl();
    }

    public SimpleDoubleLinkedList<StepTemplate> getFlow() {
	doubleList = new SimpleDoubleLinkedList<StepTemplate>();
	doubleList.add(getQueryStatisticsServiceEntity());
	doubleList.add(getQueryStatisticsShowServiceEntity());
	return doubleList;
    }

    private StepTemplate getQueryStatisticsServiceEntity() {
	StepTemplate entity = new QueryStatisticsService();
	entity.setQueryDataService(queryDataService);
	entity.setOperationType(Global.PREVIOUS_TIPS + Global.QUIT_TIPS);
	entity.setParamMap(map);
	entity.setExit(false);
	entity.setInputTips("Input :");
	return entity;
    }

    private StepTemplate getQueryStatisticsShowServiceEntity() {
	StepTemplate entity = new QueryStatisticsShowService();
	entity.setQueryDataService(queryDataService);
	entity.setParamMap(map);
	entity.setExit(false);
	return entity;
    }

    public void setMap(Map<String, Object> map) {
	this.map = map;
    }

}
