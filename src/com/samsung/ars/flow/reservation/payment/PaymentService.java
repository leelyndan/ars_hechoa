package com.samsung.ars.flow.reservation.payment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.samsung.ars.flow.StepTemplate;

public class PaymentService extends StepTemplate
{
    
    @Override
    public String getTitle()
    {
        return "Payment";
    }
    
    @Override
    public String getTips()
    {
        return "Please, Input money for payment.";
    }
    
    @Override
    public String getContent()
    {
        calculateCosts();
        StringBuffer sb = new StringBuffer();
        sb.append("Flight : " + this.reservationInfoVO.getFlight() + "\n");
        sb.append("Departure Airport : " + this.reservationInfoVO.getDepartureAirport() + "\n");
        sb.append("Arrival Airport : " + this.reservationInfoVO.getArrivalAirport() + "\n");
        sb.append("Depart Date : " + this.reservationInfoVO.getDepartDate() + "\n");
        sb.append("Depart Time : " + this.reservationInfoVO.getDepartTime() + "\n");
        sb.append("Passenger : " + this.reservationInfoVO.getPassengerAdult() + " Adult, "
            + this.reservationInfoVO.getPassengerChild() + " Child" + "\n");
        sb.append("Seat Class : " + this.reservationInfoVO.getSeatClass() + "\n");
        sb.append("Total Amount : " + this.reservationInfoVO.getTotal() + " Yuan" + "\n");
        sb.append("Promotion Price : " + this.reservationInfoVO.getPromotionPrice() + " Yuan" + "\n");
        sb.append("\n");
        return sb.toString();
    }
    
    // step 2
    private void calculateCosts()
    {
        int adultNum = this.reservationInfoVO.getPassengerAdult();
        int childNum = this.reservationInfoVO.getPassengerChild();
        int seatClassPrice = this.reservationInfoVO.getSeatClassPirce();
        int min = +(int)Math.rint(adultNum * seatClassPrice + childNum * 0.5 * seatClassPrice);
        this.reservationInfoVO.setTotal(min);
        int d1 = discount1(adultNum, childNum, seatClassPrice);
        if (d1 != -1)
        {
            min = min > d1 ? d1 : min;
        }
        int d2 = discount2(adultNum, childNum, seatClassPrice);
        if (d2 != -1)
        {
            min = min > d2 ? d2 : min;
        }
        int d3 = discount3(adultNum, childNum, seatClassPrice);
        if (d3 != -1)
        {
            min = min > d3 ? d3 : min;
        }
        this.reservationInfoVO.setPromotionPrice(min);
    }
    
    private void generateReservationNumber()
    {
        StringBuffer sb = new StringBuffer();
        sb.append(this.reservationInfoVO.getFlight());
        sb.append(this.reservationInfoVO.getDepartureAirport().substring(0, 1));
        sb.append(this.reservationInfoVO.getArrivalAirport().substring(0, 1));
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String timeStmp = df.format(new Date());
        sb.append(timeStmp);
        this.reservationInfoVO.setReservationNumber(sb.toString());
    }
    
    @Override
    public void saveInput()
    {
        try
        {
            int inputNum = Integer.parseInt(this.input);
            if (inputNum <= 0 || inputNum >= 999999)
            {
                this.errorMessage = "ERROR!!! Wrong Input. Select Again.\n";
            }
            else if (inputNum < this.reservationInfoVO.getTotal())
            {
                this.errorMessage = "ERROR!!! Not enough money.\n";
            }
            else
            {
                generateReservationNumber();
                this.reservationInfoVO.setPayment(inputNum);
                this.reservationInfoVO.setChange(inputNum - this.reservationInfoVO.getTotal());
                this.queryDataService.saveReservationInfo(this.reservationInfoVO.translateAttribute2Map());
                this.errorMessage = "";
            }
        }
        catch (Throwable t)
        {
            this.errorMessage = "ERROR!!! Wrong Input. Select Again.\n";
        }
        
    }
    
    private int discount1(int adultNum, int childNum, int seatClassPrice)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Date reservationDate = df.parse(this.reservationInfoVO.getDepartDate());
            Date later6MDate = DateUtils.addMonths(new Date(), 6);
            if (reservationDate.getTime() > later6MDate.getTime())
            {
                return (int)Math.rint((adultNum * seatClassPrice + childNum * 0.5 * seatClassPrice) * 0.85);
            }
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    private int discount2(int adultNum, int childNum, int seatClassPrice)
    {
        if (adultNum >= 4)
        {
            return (int)Math.rint(adultNum * 0.9 * seatClassPrice + childNum * 0.5 * seatClassPrice);
        }
        return -1;
    }
    
    private int discount3(int adultNum, int childNum, int seatClassPrice)
    {
        String time = this.reservationInfoVO.getDepartTime();
        int hour = Integer.parseInt(time.split(":")[0]);
        if (hour <= 12)
        {
            return (int)Math.rint((adultNum * seatClassPrice + childNum * 0.5 * seatClassPrice) * 0.95);
        }
        return -1;
    }
}
