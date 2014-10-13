package com.samsung.ars.flow;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.samsung.ars.flow.checkreservation.CheckReservationController;
import com.samsung.ars.flow.reservation.ReservationController;
import com.samsung.ars.flow.statistics.FlightStatisticsController;

public class MainController implements IViewService
{
    
    private Map<Integer, IViewService> mainViewMap = new HashMap<Integer, IViewService>();
    
    private boolean isExit = false;
    
    private String errorMessage = "";
    
    private IViewService currentController = null;
    
    public MainController()
    {
        init();
    }
    
    private void init()
    {
        mainViewMap.clear();
        currentController = null;
        mainViewMap.put(1, new ReservationController());
        mainViewMap.put(2, new CheckReservationController());
        mainViewMap.put(3, new FlightStatisticsController());
    }
    
    public IViewService getView(String input)
    {
        if ("q".equalsIgnoreCase(input))
        {
            this.isExit = true;
            return this;
        }
        if ("mainview".equals(input))
        {
            return this;
        }
        else if (null != this.currentController)
        {
            this.currentController.input(input);
            if (this.currentController.isExit())
            {
                init();
                return this;
            }
            return this.currentController;
        }
        return loadNextView(input);
        
    }
    
    private IViewService loadNextView(String input)
    {
        try
        {
            int selectNum = Integer.parseInt(input);
            if (!mainViewMap.containsKey(selectNum))
            {
                this.errorMessage = "ERROR!!! Wrong Input. Select Again\n";
                return this;
            }
            else
            {
                this.currentController = mainViewMap.get(selectNum);
                this.currentController.input(input);
                return this.currentController;
            }
        }
        catch (Throwable t)
        {
            this.errorMessage = "ERROR!!! Wrong Input. Select Again\n";
            return this;
        }
    }
    
    @Override
    public void input(String iput)
    {
        
    }
    
    @Override
    public String getContent()
    {
        StringBuffer sb = new StringBuffer();
        for (Entry<Integer, IViewService> en : mainViewMap.entrySet())
        {
            sb.append(String.valueOf(en.getKey()));
            sb.append(".");
            sb.append(en.getValue().getTitle());
            sb.append("\n");
        }
        sb.append(Global.QUIT_TIPS);
        return sb.toString();
    }
    
    @Override
    public String getTips()
    {
        return "";
    }
    
    @Override
    public String getTitle()
    {
        return "Welcome to Xi¡¯an Airline";
    }
    
    @Override
    public String getInputTips()
    {
        return "Input :";
    }
    
    @Override
    public String getErrorMessage()
    {
        return this.errorMessage;
    }
    
    @Override
    public boolean isExit()
    {
        return this.isExit;
    }
    
}
