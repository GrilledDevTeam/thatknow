package com.grileddev.thatknow.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 원하는 시간을 원하는 포맷으로 변환해서 반환해주는 클래스
 */
public class DateToDate {
    
    private final static String defaultFormatPattern = "yyyyMMdd";

    /** 현재시각 반환
     * @return LocalDateTime 반환
     */
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    /** 현재 시각의 어제 날짜 반환
     * @return LocalDateTime 반환
     */
    public static LocalDateTime yesterday() {
        return now().minusDays(1);
    }

    /** 시간을 원하는 "yyyyMMdd" 형태로 출력
     * @param localDateTime 시간
     * @return String 반환
     */
    public static String DateToString(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(defaultFormatPattern));
    }

    /** 시간을 원하는 패턴으로 문자열 반환  
     * @param localDateTime 시간
     * @param formatPattern 포맷형태
     * @return String 반환
     */
    public static String DateToString(LocalDateTime localDateTime, String formatPattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(formatPattern));
    }

    /** 현재시간을 "yyyyMMdd" 형태로 반환
     * @return String 반환
     */
    public static String NowDateToString() {
        return DateToString(now());
    }


    /** 현재시간을 원하는 패턴으로 문자열 반환  
     * @param formatPattern 포맷형태
     * @return String 반환
     */
    public static String NowDateToString(String formatPattern) {
        return DateToString(now(), formatPattern);
    }


    /**
     * 기준시간에서 원하는 시간을 빼서 반환
     * 
     * @param localDateTime 기준시간
     * @param years 변화량
     * @return LocalDateTime 반환
     */
    public static LocalDateTime beforeYears(LocalDateTime localDateTime, long years) {
        return localDateTime.minusYears(years);
    }

    /**
     * 기준시간에서 원하는 시간을 빼서 반환
     * 
     * @param localDateTime 기준시간
     * @param months 변화량
     * @return LocalDateTime 반환
     */
    public static LocalDateTime beforeMonths(LocalDateTime localDateTime, long months) {
        return localDateTime.minusYears(months);
    }

    /**
     * 기준시간에서 원하는 시간을 빼서 반환
     * 
     * @param localDateTime 기준시간
     * @param days 변화량
     * @return LocalDateTime 반환
     */
    public static LocalDateTime beforeDays(LocalDateTime localDateTime, long days) {
        return localDateTime.minusYears(days);
    }

    /**
     * 기준시간에서 원하는 시간을 빼서 반환
     * 
     * @param localDateTime 기준시간
     * @param hours 변화량
     * @return LocalDateTime 반환
     */
    public static LocalDateTime beforeHours(LocalDateTime localDateTime, long hours) {
        return localDateTime.minusYears(hours);
    }

    /**
     * 기준시간에서 원하는 시간을 빼서 반환
     * 
     * @param localDateTime 기준시간
     * @param minutes 변화량
     * @return LocalDateTime 반환
     */
    public static LocalDateTime beforeMinutes(LocalDateTime localDateTime, long minutes) {
        return localDateTime.minusYears(minutes);
    }
    
    /**
     * 기준시간에서 원하는 시간을 빼서 반환
     * 
     * @param localDateTime 기준시간
     * @param seconds 변화량
     * @return LocalDateTime 반환
     */
    public static LocalDateTime beforeSeconds(LocalDateTime localDateTime, long seconds) {
        return localDateTime.minusYears(seconds);
    }


    /**
     * 기준시간에서 원하는 시간을 더해서 반환
     * 
     * @param localDateTime 기준시간
     * @param years 변화량
     * @return LocalDateTime 반환
     */
    public static LocalDateTime afterYears(LocalDateTime localDateTime,long years) {
        return localDateTime.plusYears(years);
    }

    /**
     * 기준시간에서 원하는 시간을 더해서 반환
     * 
     * @param localDateTime 기준시간
     * @param mounths 변화량
     * @return LocalDateTime 반환
     */
    public static LocalDateTime afterMonths(LocalDateTime localDateTime,long months) {
        return localDateTime.plusMonths(months);
    }

    /**
     * 기준시간에서 원하는 시간을 더해서 반환
     * 
     * @param localDateTime 기준시간
     * @param days 변화량
     * @return LocalDateTime 객체
     */
    public static LocalDateTime afterDays(LocalDateTime localDateTime,long days) {
        return localDateTime.plusDays(days);
    }

    /**
     * 기준시간에서 원하는 시간을 더해서 반환
     * 
     * @param localDateTime 기준시간
     * @param hours 변화량
     * @return LocalDateTime 반환
     */
    public static LocalDateTime afterHours(LocalDateTime localDateTime,long hours) {
        return localDateTime.plusHours(hours);
    }

    /**
     * 기준시간에서 원하는 시간을 더해서 반환
     * 
     * @param localDateTime 기준시간
     * @param minutes 변화량
     * @return LocalDateTime 반환
     */
    public static LocalDateTime afterMinutes(LocalDateTime localDateTime,long minutes) {
        return localDateTime.plusMinutes(minutes);
    }

    /**
     * 기준시간에서 원하는 시간을 더해서 반환
     * 
     * @param localDateTime 기준시간
     * @param seconds 변화량
     * @return LocalDateTime 반환
     */
    public static LocalDateTime afterSeconds(LocalDateTime localDateTime,long seconds) {
        return localDateTime.plusSeconds(seconds);
    }
}