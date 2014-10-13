package com.samsung.ars.datasource.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.samsung.ars.datasource.dao.IQueryDataDao;
import com.samsung.ars.datasource.dao.PlaneInfoVO;
import com.samsung.ars.datasource.dao.ReservationInfoStorageVO;

public class QueryDataDaoImpl implements IQueryDataDao {

    private List<PlaneInfoVO> planeInfoList = null;

    private List<ReservationInfoStorageVO> reservationInfoStorageList = null;

    public QueryDataDaoImpl() {
	planeInfoList = DataSource.getNewInstance().getPlaneInfoList();
	reservationInfoStorageList = DataSource.getNewInstance()
		.getReservationInfoStorageList();
    }

    @Override
    public List<String> getDepartureAirport() {
	List<String> list = new ArrayList<String>();
	for (PlaneInfoVO vo : planeInfoList) {
	    if (!list.contains(vo.getDepartureAirport())) {
		list.add(vo.getDepartureAirport());
	    }
	}
	return list;
    }

    @Override
    public List<String> getArrivalAirport() {
	List<String> list = new ArrayList<String>();
	for (PlaneInfoVO vo : planeInfoList) {
	    if (!list.contains(vo.getArrivalAirport())) {
		list.add(vo.getArrivalAirport());
	    }
	}
	return list;
    }

    @Override
    public List<String> getDepartTime(String departAirport,
	    String arrivalAirport) {
	List<String> list = new ArrayList<String>();
	for (PlaneInfoVO vo : planeInfoList) {
	    if (vo.getDepartureAirport().equals(departAirport)
		    && vo.getArrivalAirport().equals(arrivalAirport)) {
		List<String> timeList = vo.getDepartTimeList();
		for (String time : timeList) {
		    if (!list.contains(time)) {
			list.add(time);
		    }
		}
	    }
	}
	return list;
    }

    @Override
    public PlaneInfoVO getSeatClass(String id) {
	int index = Integer.parseInt(id);
	for (PlaneInfoVO vo : planeInfoList) {
	    if (vo.getId() == index) {
		return vo;
	    }
	}
	return null;
    }

    @Override
    public PlaneInfoVO getFlight(String departureAirport,
	    String arrivalAirport, String departTime) {
	for (PlaneInfoVO vo : planeInfoList) {
	    if (vo.getDepartureAirport().equals(departureAirport)
		    && vo.getArrivalAirport().equals(arrivalAirport)
		    && vo.getDepartTimeList().contains(departTime)) {
		return vo;
	    }
	}
	return null;
    }

    @Override
    public void saveReservationInfo(Map<String, Object> map) {
	ReservationInfoStorageVO vo = new ReservationInfoStorageVO();
	vo.translateMap2Attribute(map);
	DataSource.getNewInstance().saveData2File(vo);
    }

    @Override
    public boolean isExistReservation(String input) {
	for (ReservationInfoStorageVO vo : reservationInfoStorageList) {
	    if (vo.getReservationNumber().equals(input)) {
		return true;
	    }
	}
	return false;
    }

    @Override
    public Map<String, Object> queryReservation(String input) {
	for (ReservationInfoStorageVO vo : reservationInfoStorageList) {
	    if (vo.getReservationNumber().equals(input)) {
		return vo.translateAttribute2Map();
	    }
	}
	return null;
    }

    @Override
    public List<Map<String, Object>> queryReservationInfo(String date) {
	return new ArrayList<Map<String, Object>>();
    }
}
