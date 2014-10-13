package com.samsung.ars.common;

import java.io.Closeable;
import java.io.IOException;

public class CommonUtils
{
    
    public static void CloseStream(Closeable... closeables)
    {
        for (Closeable closeable : closeables)
        {
            if (null != closeable)
            {
                try
                {
                    closeable.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
