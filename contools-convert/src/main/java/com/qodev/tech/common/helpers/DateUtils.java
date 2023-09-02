package com.qodev.tech.common.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date stringToDate(String date) throws Exception {
        Date resultDate = null;
        if (date != null) {
            if (!date.isEmpty()) {
                resultDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
            }
        }
        return resultDate;
    }

    public static Date stringToTimestamp(String date) throws Exception {
        Date resultDate = null;
        if (date != null) {
            if (!date.isEmpty()) {
                resultDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(date);
            }
        }
        return resultDate;
    }

    public static Date periodYearMonth(String date) throws Exception {
        Date resultDate = null;
        if (date != null) {
            if (!date.isEmpty()) {
                resultDate = new SimpleDateFormat("yyyyMM").parse(date);
            }
        }
        return resultDate;
    }

    public static Date stringToTime(String date) throws Exception {
        Date resultDate = null;
        if (date != null) {
            if (!date.isEmpty()) {
                resultDate = new SimpleDateFormat("HH:mm:ss").parse(date);
            }
        }
        return resultDate;
    }

    public static String dateToString(Date date) {
        String format = "";
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            format = formatter.format(date);
        }
        return format;
    }

}
