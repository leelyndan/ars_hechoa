package com.samsung.ars.flow.reservation;

import com.samsung.ars.flow.FlowControllerTemplate;
import com.samsung.ars.flow.ReservationInfoVO;
import com.samsung.ars.flow.SimpleDoubleLinkedList;
import com.samsung.ars.flow.StepTemplate;

public class ReservationController extends FlowControllerTemplate
{
    
    @Override
    protected SimpleDoubleLinkedList<StepTemplate> getFlow()
    {
        ReservationInfoVO reservationInfoVO = new ReservationInfoVO();
        DefineReservationFlow defineReservationFlow = new DefineReservationFlow();
        defineReservationFlow.setReservationInfoVO(reservationInfoVO);
        return defineReservationFlow.getFlow();
    }
    
    @Override
    protected void init()
    {
        currentStep = new ReservationMenuName();
    }
    
}
