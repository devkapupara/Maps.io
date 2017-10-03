package map;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Jarvis on 9/16/17.
 */
public class MapData
{
    public static Output accumulateData(String str)
    {
        JSONObject jo = new JSONObject(str);
        Map<?,?> data = jo.toMap();                                     // Convert JSON Object to Map.

        data = (Map)data.get("route");                                  // JSON Data as Map Object["route"].

        double distance = (Double)data.get("distance");                 // Total Distance
        int time = (Integer)data.get("time");                           // Total Time

        ArrayList<?> loc = (ArrayList)data.get("locations");            // Get the location list from the data map.

        Map[] latlong = new Map[loc.size()];                            // Create an Array of Map objects that store lat longs of location.

        for (int i = 0; i < loc.size(); i++)                            // Add each locations latlong to the above array.
        {
            Map<?,?> tempLoc = (Map) loc.get(i);
            Map<String, Double> tempLocLatLong = (Map) tempLoc.get("displayLatLng");
            latlong[i] = tempLocLatLong;
        }

        Map legData = (Map)((ArrayList)data.get("legs")).get(0);
        ArrayList<Map> legs = (ArrayList<Map>)legData.get("maneuvers");
        //sop(legs);

        String steps = "";

        for (Map m: legs)
        {
            steps += m.get("narrative") + "\n";
        }

        Output op = new Output(time, distance, steps, latlong);
        return op;
    }

    public static void sop(Object o)
    {
        System.out.println(o.toString());
    }
}
