package com.samsung.ars.flow;

import java.util.HashMap;
import java.util.Map;

public class ReservationInfoVO
{
    
    private String id = "";
    
    private String departureAirport = "";
    
    private String arrivalAirport = "";
    
    private String departDate = "";
    
    private String departTime = "";
    
    private int passengerAdult = -1;
    
    private int passengerChild = -1;
    
    private String seatClass = "";
    
    private int seatClassPirce = 0;
    
    private int payment = 0;
    
    private int total = 0;
    
    private int change = 0;
    
    private String flight = "";
    
    private String reservationNumber = "";
    
    private int promotionPrice = 0;
    
    public Map<String, Object> translateAttribute2Map()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("departureAirport", departureAirport);
        map.put("arrivalAirport", arrivalAirport);
        map.put("departDate", departDate);
        map.put("departTime", departTime);
        map.put("passengerAdult", passengerAdult);
        map.put("passengerChild", passengerChild);
        map.put("seatClass", seatClass);
        map.put("payment", payment);
        map.put("total", total);
        map.put("change", change);
        map.put("flight", flight);
        map.put("reservationNumber", reservationNumber);
        map.put("promotionPrice", promotionPrice);
        return map;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getDepartureAirport()
    {
        return departureAirport;
    }
    
    public void setDepartureAirport(String departureAirport)
    {
        this.departureAirport = departureAirport;
    }
    
    public String getArrivalAirport()
    {
        return arrivalAirport;
    }
    
    public void setArrivalAirport(String arrivalAirport)
    {
        this.arrivalAirport = arrivalAirport;
    }
    
    public String getDepartDate()
    {
        return departDate;
    }
    
    public void setDepartDate(String departDate)
    {
        this.departDate = departDate;
    }
    
    public String getDepartTime()
    {
        return departTime;
    }
    
    public void setDepartTime(String departTime)
    {
        this.departTime = departTime;
    }
    
    public int getPassengerAdult()
    {
        return passengerAdult;
    }
    
    public void setPassengerAdult(int passengerAdult)
    {
        this.passengerAdult = passengerAdult;
    }
    
    public int getPassengerChild()
    {
        return passengerChild;
    }
    
    public void setPassengerChild(int passengerChild)
    {
        this.passengerChild = passengerChild;
    }
    
    public String getSeatClass()
    {
        return seatClass;
    }
    
    public void setSeatClass(String seatClass)
    {
        this.seatClass = seatClass;
    }
    
    public int getPayment()
    {
        return payment;
    }
    
    public void setPayment(int payment)
    {
        this.payment = payment;
    }
    
    public int getTotal()
    {
        return total;
    }
    
    public void setTotal(int total)
    {
        this.total = total;
    }
    
    public int getChange()
    {
        return change;
    }
    
    public void setChange(int change)
    {
        this.change = change;
    }
    
    public String getFlight()
    {
        return flight;
    }
    
    public void setFlight(String flight)
    {
        this.flight = flight;
    }
    
    public String getReservationNumber()
    {
        return reservationNumber;
    }
    
    public void setReservationNumber(String reservationNumber)
    {
        this.reservationNumber = reservationNumber;
    }
    
    public int getSeatClassPirce()
    {
        return seatClassPirce;
    }
    
    public void setSeatClassPirce(int seatClassPirce)
    {
        this.seatClassPirce = seatClassPirce;
    }
    
    public int getPromotionPrice()
    {
        return promotionPrice;
    }
    
    public void setPromotionPrice(int promotionPrice)
    {
        this.promotionPrice = promotionPrice;
    }
    
}
