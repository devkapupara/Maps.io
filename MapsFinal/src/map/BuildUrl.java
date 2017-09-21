package map;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Jarvis on 9/16/17.
 */
public class BuildUrl {
    private static final String key = "vpBbTgx7rQzk1wgBG4jz6QdOsXF8j16m";

    private String url;

    public BuildUrl() {
        url = "http://open.mapquestapi.com/directions/v2/route?key=" + key;
    }

    public void addQuery(String key, String value) throws UnsupportedEncodingException
    {
        url += "&" + URLEncoder.encode(key, "UTF-8") + "=" +  URLEncoder.encode(value, "UTF-8");
    }

    public String getUrl()
    {
        return url;
    }
}

