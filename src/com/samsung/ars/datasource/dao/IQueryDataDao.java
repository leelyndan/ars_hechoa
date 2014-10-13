package com.samsung.ars.datasource.dao;

import java.util.List;
import java.util.Map;


public interface IQueryDataDao {

    public List<String> getDepartureAirport();

    public List<String> getArrivalAirport();

    public List<String> getDepartTime(String departAirport,
	    String arrivalAirport);

    public PlaneInfoVO getSeatClass(String id);

    public PlaneInfoVO getFlight(String departureAirport, String arrivalAirport,
	    String departTime);

    public void saveReservationInfo(Map<String, Object> map);

    public boolean isExistReservation(String input);

    public Map<String, Object> queryReservation(String input);

    public List<Map<String, Object>> queryReservationInfo(String date);

}
