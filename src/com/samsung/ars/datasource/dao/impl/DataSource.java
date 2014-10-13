package com.samsung.ars.datasource.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.samsung.ars.common.CommonUtils;
import com.samsung.ars.datasource.dao.PlaneInfoVO;
import com.samsung.ars.datasource.dao.ReservationInfoStorageVO;

public class DataSource
{
    
    private static final String PLANE_DATE_PATH = System.getProperty("user.dir") + File.separator + "plane.properties";
    
    private static final String RESERVATION_SOURCE_PATH = System.getProperty("user.dir") + File.separator
        + "reservation_history.dat";
    
    private static DataSource dataSource = null;
    
    private List<PlaneInfoVO> planeInfoList = new ArrayList<PlaneInfoVO>();
    
    private List<ReservationInfoStorageVO> reservationInfoStorageList = new ArrayList<ReservationInfoStorageVO>();
    
    private DataSource()
    {
        readFileInfo(PLANE_DATE_PATH, "plane");
        readFileInfo(RESERVATION_SOURCE_PATH, "reservation");
    }
    
    public static DataSource getNewInstance()
    {
        if (null == dataSource)
        {
            dataSource = new DataSource();
        }
        return dataSource;
    }
    
    private void readFileInfo(String filePath, String type)
    {
        BufferedReader reader = null;
        try
        {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), "ISO8859-1");
            reader = new BufferedReader(inputStreamReader);
            String data = "";
            int index = 0;
            while ((data = reader.readLine()) != null)
            {
                index++;
                loadInfo2Memory(type, index, data);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            CommonUtils.CloseStream(reader);
        }
    }
    
    private void loadInfo2Memory(String type, int index, String row)
    {
        if ("plane".equals(type))
        {
            loadPlaneData(index, row);
        }
        else
        {
            loadReservationData(index, row);
        }
    }
    
    private void loadReservationData(int index, String reservationInfo)
    {
        String[] infoStr = reservationInfo.split(",");
        ReservationInfoStorageVO info = new ReservationInfoStorageVO();
        info.setId(index);
        info.setFlight(infoStr[0]);
        info.setDepartureAirport(infoStr[1]);
        info.setArrivalAirport(infoStr[2]);
        info.setDepartDate(infoStr[3]);
        info.setDepartTime(infoStr[4]);
        info.setPassengerAdult(Integer.parseInt(infoStr[5]));
        info.setPassengerChild(Integer.parseInt(infoStr[6]));
        info.setSeatClass(infoStr[7]);
        info.setTotal(Integer.parseInt(infoStr[8]));
        info.setPromotionPrice(Integer.parseInt(infoStr[9]));
        info.setPayment(Integer.parseInt(infoStr[10]));
        info.setChange(Integer.parseInt(infoStr[11]));
        info.setReservationNumber(infoStr[12]);
        reservationInfoStorageList.add(info);
    }
    
    private void loadPlaneData(int index, String flightInfo)
    {
        String[] infoStr = flightInfo.split(",");
        PlaneInfoVO info = new PlaneInfoVO();
        info.setId(index);
        info.setFlight(infoStr[0]);
        info.setDepartureAirport(infoStr[1]);
        info.setArrivalAirport(infoStr[2]);
        info.getDepartTimeList().add(infoStr[3]);
        info.getDepartTimeList().add(infoStr[4]);
        info.setFirstClass(Integer.parseInt(infoStr[5]));
        info.setBusinessClass(Integer.parseInt(infoStr[6]));
        info.setEconomyClass(Integer.parseInt(infoStr[7]));
        planeInfoList.add(info);
    }
    
    public List<PlaneInfoVO> getPlaneInfoList()
    {
        return planeInfoList;
    }
    
    public List<ReservationInfoStorageVO> getReservationInfoStorageList()
    {
        return reservationInfoStorageList;
    }
    
    public void saveData2File(ReservationInfoStorageVO reservationInfoStorageVO)
    {
        writeFile(reservationInfoStorageVO.toString());
        reservationInfoStorageList.add(reservationInfoStorageVO);
    }
    
    private void writeFile(String str)
    {
        FileWriter writer = null;
        try
        {
            writer = new FileWriter(RESERVATION_SOURCE_PATH, true);
            writer.write(str + "\r\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            CommonUtils.CloseStream(writer);
        }
    }
}
