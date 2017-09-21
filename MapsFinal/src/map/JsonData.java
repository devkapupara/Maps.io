package map;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Jarvis on 9/15/17.
 */
public class JsonData
{
    public static void sop(Object o)
    {
        System.out.println(o.toString());
    }

    public static String getJsonData(String initUrl)
    {
        String str = "";
        try
        {
            URL url = new URL(initUrl);
            Scanner scan = new Scanner(url.openStream());
            while (scan.hasNext())
            {
                str += scan.nextLine();
            }
            scan.close();
            //sop(str);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return str;
    }

    public static String getInfo() throws UnsupportedEncodingException
    {
        BuildUrl url = new BuildUrl();

        Scanner scan = new Scanner(System.in);
        sop("How many locations will you enter? ");

        int numberOfLocations = scan.nextInt();
        scan.nextLine();
        sop("Enter locations one by one and press [ENTER]: ");

        for (int i = 0; i < numberOfLocations; i++)
        {
            if (i == 0)
            {
                url.addQuery("from", scan.nextLine());
            }
            else
            {
                url.addQuery("to", scan.nextLine());
            }
        }
        return url.getUrl();
    }
}
