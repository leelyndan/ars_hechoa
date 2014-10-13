package com.samsung.ars.flow.reservation;

import com.samsung.ars.datasource.service.IQueryDataService;
import com.samsung.ars.datasource.service.impl.QueryDataServiceImpl;
import com.samsung.ars.flow.Global;
import com.samsung.ars.flow.ReservationInfoVO;
import com.samsung.ars.flow.SimpleDoubleLinkedList;
import com.samsung.ars.flow.StepTemplate;
import com.samsung.ars.flow.reservation.arrivalairport.ArrivalAirportService;
import com.samsung.ars.flow.reservation.departdate.DepartDateService;
import com.samsung.ars.flow.reservation.departtime.DepartTimeService;
import com.samsung.ars.flow.reservation.departureairpot.DepartureAirportService;
import com.samsung.ars.flow.reservation.passenger.PassengerAdultService;
import com.samsung.ars.flow.reservation.passenger.PassengerChildService;
import com.samsung.ars.flow.reservation.payment.PaymentService;
import com.samsung.ars.flow.reservation.review.ReviewService;
import com.samsung.ars.flow.reservation.seatclass.SeatClassService;

public class DefineReservationFlow {

    private SimpleDoubleLinkedList<StepTemplate> doubleList = null;

    private ReservationInfoVO reservationInfoVO = null;

    private IQueryDataService queryDataService = null;

    public DefineReservationFlow() {
	queryDataService = new QueryDataServiceImpl();
    }

    public void setReservationInfoVO(ReservationInfoVO reservationInfoVO) {
	this.reservationInfoVO = reservationInfoVO;
    }

    public SimpleDoubleLinkedList<StepTemplate> getFlow() {
	doubleList = new SimpleDoubleLinkedList<StepTemplate>();
	doubleList.add(getDepartureairporteServiceEntity());
	doubleList.add(getArrivalAirportServiceEntity());
	doubleList.add(getDepartDateServiceEntity());
	doubleList.add(getDepartTimeServiceEntity());
	doubleList.add(getPassengerAdultServiceEntity());
	doubleList.add(getPassengerChildServiceEntity());
	doubleList.add(getSeatClassServiceEntity());
	doubleList.add(getPaymentServiceEntity());
	doubleList.add(getReviewServiceEntity());
	return doubleList;
    }

    private StepTemplate getDepartureairporteServiceEntity() {
	StepTemplate entity = new DepartureAirportService();
	entity.setReservationInfoVO(reservationInfoVO);
	entity.setQueryDataService(queryDataService);
	entity.setOperationType(Global.PREVIOUS_TIPS + Global.QUIT_TIPS);
	entity.setExit(false);
	entity.setInputTips("Input :");
	return entity;
    }

    private StepTemplate getArrivalAirportServiceEntity() {
	StepTemplate entity = new ArrivalAirportService();
	entity.setReservationInfoVO(reservationInfoVO);
	entity.setQueryDataService(queryDataService);
	entity.setOperationType(Global.PREVIOUS_TIPS + Global.QUIT_TIPS);
	entity.setExit(false);
	entity.setInputTips("Input :");
	return entity;
    }

    private StepTemplate getDepartDateServiceEntity() {
	StepTemplate entity = new DepartDateService();
	entity.setReservationInfoVO(reservationInfoVO);
	entity.setQueryDataService(queryDataService);
	entity.setOperationType(Global.PREVIOUS_TIPS + Global.QUIT_TIPS);
	entity.setExit(false);
	entity.setInputTips("Input :");
	return entity;
    }

    private StepTemplate getDepartTimeServiceEntity() {
	StepTemplate entity = new DepartTimeService();
	entity.setReservationInfoVO(reservationInfoVO);
	entity.setQueryDataService(queryDataService);
	entity.setOperationType(Global.PREVIOUS_TIPS + Global.QUIT_TIPS);
	entity.setExit(false);
	entity.setInputTips("Input :");
	return entity;
    }

    private StepTemplate getPassengerAdultServiceEntity() {
	StepTemplate entity = new PassengerAdultService();
	entity.setReservationInfoVO(reservationInfoVO);
	entity.setQueryDataService(queryDataService);
	entity.setOperationType(Global.PREVIOUS_TIPS + Global.QUIT_TIPS);
	entity.setExit(false);
	entity.setInputTips("Input :");
	return entity;
    }

    private StepTemplate getPassengerChildServiceEntity() {
	StepTemplate entity = new PassengerChildService();
	entity.setReservationInfoVO(reservationInfoVO);
	entity.setQueryDataService(queryDataService);
	entity.setOperationType(Global.PREVIOUS_TIPS + Global.QUIT_TIPS);
	entity.setExit(false);
	entity.setInputTips("Input :");
	return entity;
    }

    private StepTemplate getSeatClassServiceEntity() {
	StepTemplate entity = new SeatClassService();
	entity.setReservationInfoVO(reservationInfoVO);
	entity.setQueryDataService(queryDataService);
	entity.setOperationType(Global.PREVIOUS_TIPS + Global.QUIT_TIPS);
	entity.setExit(false);
	entity.setInputTips("Input :");
	return entity;
    }

    private StepTemplate getPaymentServiceEntity() {
	StepTemplate entity = new PaymentService();
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
	entity.setExit(false);
	entity.setInputTips("Thank you for reservation!\n");
	return entity;
    }
}
