package map;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by Jarvis on 9/16/17.
 */
public class Output
{
    private int time;
    private double distance;
    private String steps;
    private Map[] latLong;

    public Output(int iTime, double iDistance, String iSteps, Map[] iLatLong)
    {
        time = iTime;
        distance = iDistance;
        steps = iSteps;
        latLong = iLatLong;
    }

    public int getTime()
    {
        return time;
    }

    public double getDistance()
    {
        return distance;
    }

    public String getSteps()
    {
        return steps;
    }

    public String getLatLong()
    {
        String ll = "";
        int counter = 0;
        for (Map m: latLong)
        {
            ll += counter + ") Latitude: " + m.get("lat") + " Longitude:" + m.get("lng") + "\n";
            counter++;
        }
        return ll;
    }
}
