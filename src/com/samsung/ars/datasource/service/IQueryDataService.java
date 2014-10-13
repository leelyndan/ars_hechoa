package com.samsung.ars.datasource.service;

import java.util.List;
import java.util.Map;

public interface IQueryDataService {

    public List<String> getDepartureAirport();

    public List<String> getArrivalAirport();

    public List<String> getDepartTime(String departAirport,
	    String arrivalAirport);

    public Map<String, Integer> getSeatClass(String string);

    public Map<String, String> getFlight(String departureAirport,
	    String arrivalAirport, String departTime);

    public void saveReservationInfo(Map<String,Object> map);

    public Map<String, Object> queryReservation(String input);

    public boolean isExistReservation(String input);

    public List<String> queryReservationInfo(String date);

}
