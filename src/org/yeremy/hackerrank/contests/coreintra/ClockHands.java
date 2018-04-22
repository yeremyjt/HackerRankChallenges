package org.yeremy.hackerrank.contests.coreintra;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ClockHands {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] times = new String[n];
        for (int i = 0; i < n; i++)
        {
            times[i] = sc.next();
            double angle = calculateAngle(times[i]);
            DecimalFormat df = new DecimalFormat("#.#");
            String formatted = df.format(angle);
            System.out.println(formatted);
        }
    }

    private static double calculateAngle(String time)
    {
        int hour = getHour(time);
        int minute = getMinute(time);

        double hourAngle = getHourAngle(hour, minute);
        double minuteAngle = getMinuteAngle(minute);

        double positiveAngle = hourAngle - minuteAngle;
        if (positiveAngle < 0)
            positiveAngle += 360;

        if (positiveAngle > 180)
            return 360 - positiveAngle;
        else return positiveAngle;
    }

    private static int getHour(String time)
    {
        String[] timeSplit = time.split(":");
        int hour =  Integer.valueOf(timeSplit[0]);
        if (hour >= 12)
            hour -= 12;
        return hour;
    }

    private static int getMinute(String time)
    {
        String[] timeSplit = time.split(":");
        return Integer.valueOf(timeSplit[1]);
    }

    private static double getHourAngle(int hour, int minute)
    {
        return (hour * 30) + (0.5 * minute);
    }

    private static double getMinuteAngle(int minute)
    {
        return minute * 6;
    }
}