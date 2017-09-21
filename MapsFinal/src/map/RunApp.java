package map;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Created by Jarvis on 9/16/17.
 */
public class RunApp
{
    public static void main(String[] args) throws UnsupportedEncodingException
    {
        String url = JsonData.getInfo();
        String jsonData = JsonData.getJsonData(url);

        Output op = MapData.accumulateData(jsonData);

        int[] options = getOutputOptions();
        for (int i: options)
        {
            switch(i)
            {
                case 1:
                    sop("LatLong:\n" + op.getLatLong() + "\n");
                    break;
                case 2:
                    sop("Steps:\n" + op.getSteps() + "\n");
                    break;
                case 3:
                    sop("Total Time:\n" + op.getTime() + " minutes\n");
                    break;
                case 4:
                    sop("Total Distance:\n" + op.getDistance() + " miles\n");
                    break;
                default:
                    sop("Invalid Option. Exiting...");
                    return;
            }
        }
    }

    public static int[] getOutputOptions()
    {
        sop("How many outputs do you need?");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        scan.nextLine();
        int[] options = new int[choice];
        sop("Enter all option numbers you wish:\n1) LatLong\n2) Steps\n3) Total Time\n4) Total Distance");
        for (int i = 0; i < choice; i++)
        {
            options[i] = scan.nextInt();
            scan.nextLine();
        }
        scan.close();
        return options;
    }

    public static void sop(Object o)
    {
        System.out.println(o.toString());
    }

}
