package com.samsung.ars.datasource.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.samsung.ars.datasource.dao.IQueryDataDao;
import com.samsung.ars.datasource.dao.PlaneInfoVO;

public class QueryDataDao4JDBCImpl implements IQueryDataDao {

    private Connection conn = null;

    Statement statm = null;

    private void closeConn(Connection conn, Statement statm) {
	try {
	    if (null != statm) {
		statm.close();
	    }
	    if (null != conn) {
		conn.close();
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public List<String> getDepartureAirport() {
	conn = JDBCDataSource.getconnection();
	List<String> list = new ArrayList<String>();
	try {
	    statm = conn.createStatement();
	    ResultSet rs = statm
		    .executeQuery("select distinct departure_airport from plane_info");
	    while (rs.next()) {
		list.add(rs.getString("departure_airport"));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    closeConn(conn, statm);
	}
	return list;
    }

    @Override
    public List<String> getArrivalAirport() {
	conn = JDBCDataSource.getconnection();
	List<String> list = new ArrayList<String>();
	try {
	    statm = conn.createStatement();
	    ResultSet rs = statm
		    .executeQuery("select distinct arrival_airport from plane_info");
	    while (rs.next()) {
		list.add(rs.getString("arrival_airport"));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    closeConn(conn, statm);
	}
	return list;
    }

    @Override
    public List<String> getDepartTime(String departAirport,
	    String arrivalAirport) {
	conn = JDBCDataSource.getconnection();
	List<String> list = new ArrayList<String>();
	try {
	    statm = conn.createStatement();
	    String sql = "select distinct b.time from plane_info a, plane_time b where a.departure_airport = '"
		    + departAirport.replace("'", "\\'")
		    + "' and a.arrival_airport='"
		    + arrivalAirport.replace("'", "\\'")
		    + "' and a.id=b.id order by b.time asc";
	    ResultSet rs = statm.executeQuery(sql);
	    while (rs.next()) {
		list.add(rs.getString("time"));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    closeConn(conn, statm);
	}
	return list;
    }

    @Override
    public PlaneInfoVO getSeatClass(String id) {
	PlaneInfoVO vo = new PlaneInfoVO();
	conn = JDBCDataSource.getconnection();
	try {
	    statm = conn.createStatement();
	    ResultSet rs = statm
		    .executeQuery("select * from plane_info where id =" + id);
	    while (rs.next()) {
		vo.setId(rs.getInt("id"));
		vo.setDepartureAirport(rs.getString("departure_airport"));
		vo.setArrivalAirport(rs.getString("arrival_airport"));
		vo.setFirstClass(rs.getInt("first_class"));
		vo.setBusinessClass(rs.getInt("business_class"));
		vo.setEconomyClass(rs.getInt("economy_class"));
		vo.setFlight(rs.getString("flight"));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    closeConn(conn, statm);
	}
	return vo;
    }

    @Override
    public PlaneInfoVO getFlight(String departureAirport,
	    String arrivalAirport, String departTime) {
	PlaneInfoVO vo = new PlaneInfoVO();
	conn = JDBCDataSource.getconnection();
	try {
	    statm = conn.createStatement();
	    String sql = "select a.id, a.flight, a.departure_airport ,a.arrival_airport, a.first_class, a.business_class, a.economy_class from plane_info a, plane_time b where a.departure_airport = '"
		    + departureAirport.replace("'", "\\'")
		    + "' and a.arrival_airport='"
		    + arrivalAirport.replace("'", "\\'")
		    + "' and b.time = '"
		    + departTime + "' and a.id=b.id order by b.time asc";
	    ResultSet rs = statm.executeQuery(sql);
	    while (rs.next()) {
		vo.setId(rs.getInt("id"));
		vo.setDepartureAirport(rs.getString("departure_airport"));
		vo.setArrivalAirport(rs.getString("arrival_airport"));
		vo.setFirstClass(rs.getInt("first_class"));
		vo.setBusinessClass(rs.getInt("business_class"));
		vo.setEconomyClass(rs.getInt("economy_class"));
		vo.setFlight(rs.getString("flight"));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    closeConn(conn, statm);
	}
	return vo;
    }

    @Override
    public void saveReservationInfo(Map<String, Object> map) {
	String sql = "insert into reservation_info(plane_id, depart_date, depart_time, passenger_adult, passenger_child, seat_class, payment, total, `change`, reservation_number, promotion_price) values('"
		+ map.get("id")
		+ "','"
		+ map.get("departDate")
		+ "','"
		+ map.get("departTime")
		+ "','"
		+ map.get("passengerAdult")
		+ "','"
		+ map.get("passengerChild")
		+ "','"
		+ map.get("seatClass")
		+ "','"
		+ map.get("payment")
		+ "','"
		+ map.get("total")
		+ "','"
		+ map.get("change")
		+ "','"
		+ map.get("reservationNumber")
		+ "','"
		+ map.get("promotionPrice") + "')";
	conn = JDBCDataSource.getconnection();
	try {
	    statm = conn.createStatement();
	    statm.executeUpdate(sql);
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    closeConn(conn, statm);
	}
    }

    @Override
    public boolean isExistReservation(String reservationNumber) {
	String sql = " select * from reservation_info where reservation_number = '"
		+ reservationNumber + "'";
	conn = JDBCDataSource.getconnection();
	try {
	    statm = conn.createStatement();
	    ResultSet rs = statm.executeQuery(sql);
	    while (rs.next()) {
		return true;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    closeConn(conn, statm);
	}
	return false;
    }

    @Override
    public Map<String, Object> queryReservation(String reservationNumber) {
	String sql = " select b.flight, b.departure_airport, b.arrival_airport, a.depart_date, a.depart_time, a.passenger_adult, a.passenger_child, a.seat_class, a.payment, a.total, a.change, a.reservation_number, a.promotion_price from reservation_info a, plane_info b where reservation_number = '"
		+ reservationNumber + "' and a.plane_id =b.id";
	conn = JDBCDataSource.getconnection();
	Map<String, Object> map = new HashMap<String, Object>();
	try {
	    statm = conn.createStatement();
	    ResultSet rs = statm.executeQuery(sql);
	    while (rs.next()) {
		map.put("flight", rs.getString("flight"));
		map.put("departureAirport", rs.getString("departure_airport"));
		map.put("arrivalAirport", rs.getString("arrival_airport"));
		map.put("departDate", rs.getString("depart_date"));
		map.put("departTime", rs.getString("depart_time"));
		map.put("passengerAdult", rs.getString("passenger_adult"));
		map.put("passengerChild", rs.getString("passenger_child"));
		map.put("seatClass", rs.getString("seat_class"));
		map.put("total", rs.getString("total"));
		map.put("promotionPrice", rs.getString("promotion_price"));
		map.put("payment", rs.getString("payment"));
		map.put("change", rs.getString("change"));
		map.put("reservationNumber", rs.getString("reservation_number"));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    closeConn(conn, statm);
	}
	return map;
    }

    @Override
    public List<Map<String, Object>> queryReservationInfo(String date) {
	conn = JDBCDataSource.getconnection();
	String sql = "select b.flight, b.departure_airport, b.arrival_airport, a.depart_time,  sum(a.passenger_adult) as passenger_adult, sum(a.passenger_child) as passenger_child from reservation_info a, plane_info b where depart_date='"
		+ date + "' and a.plane_id = b.id group by  b.flight, b.departure_airport, b.arrival_airport, a.depart_time order by a.depart_time";
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	try {
	    statm = conn.createStatement();
	    ResultSet rs = statm.executeQuery(sql);
	    while (rs.next()) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flight", rs.getString("flight"));
		map.put("departureAirport", rs.getString("departure_airport"));
		map.put("arrivalAirport", rs.getString("arrival_airport"));
		map.put("departTime", rs.getString("depart_time"));
		map.put("passengerAdult", rs.getString("passenger_adult"));
		map.put("passengerChild", rs.getString("passenger_child"));
		list.add(map);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    closeConn(conn, statm);
	}
	return list;
    }

}
