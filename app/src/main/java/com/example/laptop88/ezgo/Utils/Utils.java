package com.example.laptop88.ezgo.Utils;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static long getTime(String releaseDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date startDate = null;
        try {
            startDate = df.parse(releaseDate);
            String newDateString = df.format(startDate);
            System.out.println(newDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return startDate.getTime();
    }

    public  static Date convertStringToDate(String dateST){
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            date = sdf.parse(dateST);
        }catch (ParseException e){
            e.printStackTrace();
        }
    return date;
    }


    public static String[] splitDate(String date){
        String[] parts = date.split(" ");
        return parts;
    }

    public static Long[] getDuration(String date1, String date2){
        Date startDate = convertStringToDate(date1);
        Date endDate = convertStringToDate(date2);


        long different = endDate.getTime() - startDate.getTime();

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;

        long elapsedHours = (different / hoursInMilli);
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;

        Long[] result =  {elapsedHours, elapsedMinutes};
        return result;
    }

    public static long getDurationInLongFormat(String date1, String date2){
        Date startDate = convertStringToDate(date1);
        Date endDate = convertStringToDate(date2);


        long different = endDate.getTime() - startDate.getTime();

        return different;
    }

}
