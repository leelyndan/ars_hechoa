package com.samsung.ars.flow;

import org.apache.commons.lang3.StringUtils;

public class ViewFramework
{
    
    private MainController controller = null;
    
    private boolean isExit = false;
    
    public ViewFramework()
    {
        controller = new MainController();
    }
    
    public String ouputInformation(String input)
    {
        IViewService view = controller.getView(input);
        isExit = view.isExit();
        if (isExit)
        {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\n\n\n");
        sb.append("****************************************\n");
        sb.append(view.getTitle());
        sb.append("\n");
        sb.append("****************************************\n");
        sb.append(StringUtils.isEmpty(view.getTips()) ? "" : view.getTips() + "\n");
        sb.append(view.getContent());
        sb.append("\n");
        sb.append("****************************************\n");
        sb.append(StringUtils.isEmpty(view.getErrorMessage()) ? "" : view.getErrorMessage() + "\n");
        sb.append(view.getInputTips());
        return sb.toString();
    }
    
    public boolean isExit()
    {
        return isExit;
    }
    
}
