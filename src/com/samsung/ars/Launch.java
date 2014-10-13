package com.samsung.ars;

import java.util.Scanner;

import com.samsung.ars.flow.ViewFramework;

public class Launch
{
    
    public static void main(String[] args)
    {
        String input = "mainview";
        ViewFramework framework = new ViewFramework();
        while (true)
        {
            String output = framework.ouputInformation(input);
            if (framework.isExit())
            {
                break;
            }
            System.out.print(output);
            Scanner s = new Scanner(System.in);
            input = s.nextLine();
        }
    }
    
}
