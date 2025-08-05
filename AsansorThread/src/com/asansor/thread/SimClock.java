package com.asansor.thread;

public class SimClock // Simüle Edilmis Zamanı Gösteren Sınıf
{
    private static int simTime;

    public void SimClock()
    {
        simTime = 0;
    }

    public static synchronized void tick()
    {
        simTime++;
    }

    public static synchronized int getTime()
    {
        return simTime;
    }
}