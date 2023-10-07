package com.qodev.tech.common.helpers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GenerateUtils {
    public ZoneId jakartaZone = ZoneId.of("Asia/Jakarta");

    public String genMailTempId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return "MT:" + formattedTime;
    }

    public String genUserId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        return "USR:" + formattedTime;
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

    public String genVisibilityId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        return "VSB:" + formattedTime;
    }

    public String genCryptoId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        return "CPT:" + formattedTime;
    }

    public String genCryptoModeId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        return "CMI:" + formattedTime;
    }

    public String genByteModeId(){
        LocalDateTime currentTime = LocalDateTime.now(jakartaZone);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        return "BYM:" + formattedTime;
    }

    public String generatedPassword(String password, String salt) throws NoSuchAlgorithmException {
        String passwordEncripted;

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        passwordEncripted = sb.toString();

        return passwordEncripted;
    }

    public String generatedToken(String password, String salt, String userName) throws NoSuchAlgorithmException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String today = dateFormat.format(date);

        String tokenEncripted;
        salt = salt + today + userName;

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        tokenEncripted = sb.toString();

        return tokenEncripted;
    }
}
