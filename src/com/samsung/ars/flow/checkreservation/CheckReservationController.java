package com.samsung.ars.flow.checkreservation;

import com.samsung.ars.flow.FlowControllerTemplate;
import com.samsung.ars.flow.ReservationInfoVO;
import com.samsung.ars.flow.SimpleDoubleLinkedList;
import com.samsung.ars.flow.StepTemplate;

public class CheckReservationController extends FlowControllerTemplate {

    @Override
    protected SimpleDoubleLinkedList<StepTemplate> getFlow() {
	ReservationInfoVO reservationInfoVO = new ReservationInfoVO();
	DefineCheckReservationFlow defineReservationFlow = new DefineCheckReservationFlow();
	defineReservationFlow.setReservationInfoVO(reservationInfoVO);
	return defineReservationFlow.getFlow();
    }

    @Override
    protected void init() {
	currentStep = new CheckReservationMenuName();
    }

}
