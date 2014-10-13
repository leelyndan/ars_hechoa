package com.samsung.ars.flow;

import org.apache.commons.lang3.StringUtils;

public abstract class FlowControllerTemplate implements IViewService {

    private SimpleDoubleLinkedList<StepTemplate> doubleList = null;

    protected StepTemplate currentStep = null;

    private boolean isExit = false;

    public FlowControllerTemplate() {
	init();
	doubleList = getFlow();
    }

    protected abstract void init();

    protected abstract SimpleDoubleLinkedList<StepTemplate> getFlow();

    @Override
    public void input(String input) {
	currentStep.input(input);
	if (currentStep.isPrevious) {
	    currentStep = doubleList.getPreviousObject();
	} else if (StringUtils.isEmpty(currentStep.getErrorMessage())) {
	    currentStep = doubleList.getNextObject();
	}
	if (null == currentStep) {
	    isExit = true;
	}
    }

    @Override
    public String getContent() {
	return currentStep.getContent() + currentStep.getOperationType();
    }

    @Override
    public String getTips() {
	return currentStep.getTips();
    }

    @Override
    public String getTitle() {
	return currentStep.getTitle();
    }

    @Override
    public String getErrorMessage() {
	return currentStep.getErrorMessage();
    }

    @Override
    public String getInputTips() {
	return currentStep.getInputTips();
    }

    @Override
    public boolean isExit() {
	return isExit;
    }

}
