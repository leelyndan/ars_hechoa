package com.samsung.ars.flow.checkreservation;

import com.samsung.ars.datasource.service.IQueryDataService;
import com.samsung.ars.datasource.service.impl.QueryDataServiceImpl;
import com.samsung.ars.flow.Global;
import com.samsung.ars.flow.ReservationInfoVO;
import com.samsung.ars.flow.SimpleDoubleLinkedList;
import com.samsung.ars.flow.StepTemplate;
import com.samsung.ars.flow.checkreservation.check.CheckReservationService;
import com.samsung.ars.flow.checkreservation.review.ReviewService;

public class DefineCheckReservationFlow {

    private SimpleDoubleLinkedList<StepTemplate> doubleList = null;

    private ReservationInfoVO reservationInfoVO = null;

    private IQueryDataService queryDataService = null;

    public DefineCheckReservationFlow() {
	queryDataService = new QueryDataServiceImpl();
    }

    public SimpleDoubleLinkedList<StepTemplate> getFlow() {
	doubleList = new SimpleDoubleLinkedList<StepTemplate>();
	doubleList.add(getCheckReservationServiceEntity());
	doubleList.add(getReviewServiceEntity());
	return doubleList;
    }

    public void setReservationInfoVO(ReservationInfoVO reservationInfoVO) {
	this.reservationInfoVO = reservationInfoVO;
    }

    private StepTemplate getCheckReservationServiceEntity() {
	StepTemplate entity = new CheckReservationService();
	entity.setReservationInfoVO(reservationInfoVO);
	entity.setQueryDataService(queryDataService);
	entity.setOperationType(Global.PREVIOUS_TIPS + Global.QUIT_TIPS);
	entity.setExit(false);
	entity.setInputTips("Input :");
	return entity;
    }

    private StepTemplate getReviewServiceEntity() {
	StepTemplate entity = new ReviewService();
	entity.setReservationInfoVO(reservationInfoVO);
	entity.setQueryDataService(queryDataService);
	entity.setOperationType(Global.PREVIOUS_TIPS + Global.QUIT_TIPS);
	entity.setExit(false);
	entity.setInputTips("Input :");
	return entity;
    }

}
