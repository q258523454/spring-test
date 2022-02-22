package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by
 *
 * @author :   zhang
 * @date :   2018-08-23
 */

public class Time {
    public static String randBetween(int start, int end) {
        //  Min + (int)(Math.random() * ((Max - Min) + 1))
        int year = start + (int) Math.round(Math.random() * (end - start));
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(gc.YEAR, year);
        int dayOfYear = 1 + (int) Math.round(Math.random() * (gc.getActualMaximum(gc.DAY_OF_YEAR) - 1));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyddMM");
        String sYear = simpleDateFormat.format(new Date(gc.getTimeInMillis()));
        return sYear;
    }
}
