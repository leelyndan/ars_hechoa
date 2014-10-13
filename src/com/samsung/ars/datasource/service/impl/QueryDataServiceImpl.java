package com.samsung.ars.datasource.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.samsung.ars.datasource.dao.IQueryDataDao;
import com.samsung.ars.datasource.dao.PlaneInfoVO;
import com.samsung.ars.datasource.dao.impl.QueryDataDao4JDBCImpl;
import com.samsung.ars.datasource.service.IQueryDataService;

public class QueryDataServiceImpl implements IQueryDataService {

    private IQueryDataDao queryDataDao = null;

    public QueryDataServiceImpl() {
	queryDataDao = new QueryDataDao4JDBCImpl();
    }

    @Override
    public List<String> getDepartureAirport() {
	return queryDataDao.getDepartureAirport();
    }

    @Override
    public List<String> getArrivalAirport() {
	return queryDataDao.getArrivalAirport();
    }

    @Override
    public List<String> getDepartTime(String departAirport,
	    String arrivalAirport) {
	List<String> list = queryDataDao.getDepartTime(departAirport,
		arrivalAirport);
	Collections.sort(list);
	return list;
    }

    @Override
    public Map<String, Integer> getSeatClass(String id) {
	PlaneInfoVO info = queryDataDao.getSeatClass(id);
	Map<String, Integer> map = new LinkedHashMap<String, Integer>();
	map.put("First Class", info.getFirstClass());
	map.put("Business Class", info.getBusinessClass());
	map.put("Economy Class", info.getEconomyClass());
	return map;
    }

    @Override
    public Map<String, String> getFlight(String departureAirport,
	    String arrivalAirport, String departTime) {
	PlaneInfoVO infoVO = queryDataDao.getFlight(departureAirport,
		arrivalAirport, departTime);
	Map<String, String> map = new HashMap<String, String>();
	map.put("flight", infoVO.getFlight());
	map.put("id", String.valueOf(infoVO.getId()));
	return map;
    }

    @Override
    public void saveReservationInfo(Map<String, Object> map) {
	queryDataDao.saveReservationInfo(map);
    }

    @Override
    public boolean isExistReservation(String input) {
	return queryDataDao.isExistReservation(input);
    }

    @Override
    public Map<String, Object> queryReservation(String input) {
	return queryDataDao.queryReservation(input);
    }

    @Override
    public List<String> queryReservationInfo(String date) {
	List<String> rsList = new ArrayList<String>();
	List<Map<String, Object>> list = queryDataDao
		.queryReservationInfo(date);
	for (Map<String, Object> map : list) {
	    StringBuffer sb = new StringBuffer();
	    sb.append(map.get("flight") + ",");
	    sb.append(map.get("departureAirport") + ",");
	    sb.append(map.get("arrivalAirport") + ",");
	    sb.append(map.get("departTime") + " : ");
	    sb.append(map.get("passengerAdult") + " Adult, ");
	    sb.append(map.get("passengerChild") + " Child");
	    rsList.add(sb.toString());
	}
	return rsList;
    }
}
