package com.qodev.tech.common.helpers;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class GenerateUtils {
    public ZoneId jakartaZone = ZoneId.of("Asia/Jakarta");

    public String genMailTempId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return "MT:" + formattedTime;
    }

    public String genUserId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);

        return currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    public String genMenuId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        return "MNU:" + formattedTime;
    }

    public String genFeatureId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        return "FTR:" + formattedTime;
    }

    public String genPacketId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        return "PCT:" + formattedTime;
    }

    public String genRoleId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        return "ROL:" + formattedTime;
    }

    public String genActivityId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        return "ACT:" + formattedTime;
    }

    public String genBannedId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        return "BND:" + formattedTime;
    }

    public String genVisitorId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        return "VST:" + formattedTime;
    }

    public String genFeatureLogId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        return "FTL:" + formattedTime;
    }
}
