package com.samsung.ars.flow;

public interface IViewService {

    public String getTitle();

    public String getTips();

    public String getContent();

    public String getInputTips();

    public String getErrorMessage();

    public boolean isExit();
    
    public void input(String iput);

}
