package com.samsung.ars.flow;

import java.util.Map;

import com.samsung.ars.datasource.service.IQueryDataService;

public abstract class StepTemplate implements IViewService {

    protected Map<String, Object> paramMap = null;

    protected String errorMessage = "";

    protected ReservationInfoVO reservationInfoVO = null;

    private String inputTips = "";

    private boolean isExit = false;

    protected String input = "";

    protected IQueryDataService queryDataService = null;

    public boolean isPrevious = false;

    private String operationType = "";

    abstract public void saveInput();

    public String getOperationType() {
	return operationType;
    }

    public void setOperationType(String operationType) {
	this.operationType = operationType;
    }

    public ReservationInfoVO getReservationInfoVO() {
	return reservationInfoVO;
    }

    public void setReservationInfoVO(ReservationInfoVO reservationInfoVO) {
	this.reservationInfoVO = reservationInfoVO;
    }

    public void setExit(boolean isExit) {
	this.isExit = isExit;
    }

    public void setParamMap(Map<String, Object> paramMap) {
	this.paramMap = paramMap;
    }

    @Override
    public boolean isExit() {
	return isExit;
    }

    @Override
    public String getErrorMessage() {
	return errorMessage;
    }

    @Override
    public String getInputTips() {
	return inputTips;
    }

    public void setInputTips(String inputTips) {
	this.inputTips = inputTips;
    }

    @Override
    public void input(String input) {
	this.input = input;
	if ("p".equalsIgnoreCase(input)) {
	    isPrevious = true;
	    return;
	} else {
	    isPrevious = false;
	}
	saveInput();
    }

    public void setQueryDataService(IQueryDataService queryDataService) {
	this.queryDataService = queryDataService;
    }

}
