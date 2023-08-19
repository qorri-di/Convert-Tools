package com.qodev.tech.common.helpers;

import java.text.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateUtils extends GenerateUtils {

    public Date stringToDate(String date) throws Exception {
        Date resultDate = null;
        if (date != null) {
            if (!date.isEmpty()) {
                resultDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
            }
        }
        return resultDate;
    }

    public Date stringToTimestamp(String date) throws Exception {
        Date resultDate = null;
        if (date != null) {
            if (!date.isEmpty()) {
                resultDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(date);
            }
        }
        return resultDate;
    }

    public Date periodYearMonth(String date) throws Exception {
        Date resultDate = null;
        if (date != null) {
            if (!date.isEmpty()) {
                resultDate = new SimpleDateFormat("yyyyMM").parse(date);
            }
        }
        return resultDate;
    }

    public Date stringToTime(String date) throws Exception {
        Date resultDate = null;
        if (date != null) {
            if (!date.isEmpty()) {
                resultDate = new SimpleDateFormat("HH:mm:ss").parse(date);
            }
        }
        return resultDate;
    }

    public String dateToString(Date date) {
        String format = "";
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            format = formatter.format(date);
        }
        return format;
    }

}
