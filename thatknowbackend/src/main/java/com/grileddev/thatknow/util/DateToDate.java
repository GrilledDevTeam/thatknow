package com.grileddev.thatknow.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateToDate {
    
    private final static String defaultDateFormatPattern = "yyyyMMdd";
    private final static String defaultTimeFormatPattern = "HHmm";
    private LocalDateTime localDateTime;

    

    private DateToDate(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String toDateString() {
        return this.localDateTime.format(DateTimeFormatter.ofPattern(defaultDateFormatPattern));
    }

    public String toTimeString() {
        return this.localDateTime.format(DateTimeFormatter.ofPattern(defaultTimeFormatPattern));
    }

    public int toTimeHour() {
        return this.localDateTime.getHour();
    }

    public int toTimeMinute() {
        return this.localDateTime.getMinute();
    }

    @Override
    public String toString() {
        return localDateTime.toString();
    }
    
    /** 현재 시각에 대한 DateToDate 반환
     * @return DateToDate 반환
     */
    public static DateToDate now() {
        return new DateToDate(LocalDateTime.now());
    }

    /** 현재 시각에 대한 어제 DateToDate 반환
     * @return DateToDate 반환
     */
    public static DateToDate yesterday() {
        DateToDate date = now();
        date.beforeDays(1);
        return date;
    }

    /** 현재 시각에 대한 내일 DateToDate 반환
     * @return DateToDate 반환
     */
    public static DateToDate tomorrow() {
        DateToDate date = now();
        date.afterDays(1);
        return date;
    }

    /** 현재 시각에 대한 모레 DateToDate 반환
     * @return DateToDate 반환
     */
    public static DateToDate afterTomorrow() {
        DateToDate date = now();
        date.afterDays(2);
        return date;
    }

    /** 문자열데이터 와 pattern 으로 지정한 날 DateToDate 반환
     */
    public static DateToDate date(String date , String formatPattern) {
        return new DateToDate(LocalDateTime.parse(date, DateTimeFormatter.ofPattern(formatPattern)));
    }

    /** 시간을 원하는 패턴으로 문자열 반환  
     * @param formatPattern 포맷형태
     * @return String 반환
     */
    public String DateToString(String formatPattern) {
        return this.localDateTime.format(DateTimeFormatter.ofPattern(formatPattern));
    }
    
    public void beforeYears(long years) {
        this.localDateTime = this.localDateTime.minusYears(years);
    }

    public void beforeMonths(long months) {
        this.localDateTime = this.localDateTime.minusMonths(months);
    }

    public void beforeDays(long days) {
        this.localDateTime = this.localDateTime.minusDays(days);
    }

    public void beforeHours(long hours) {
        this.localDateTime = this.localDateTime.minusHours(hours);
    }

    public void beforeMinutes(long minutes) {
        this.localDateTime = this.localDateTime.minusMinutes(minutes);
    }
    
    public void beforeSeconds(long seconds) {
        this.localDateTime = this.localDateTime.minusSeconds(seconds);
    }

    public void afterYears(long years) {
        this.localDateTime = this.localDateTime.plusYears(years);
    }

    public void afterMonths(long months) {
        this.localDateTime = this.localDateTime.plusMonths(months);
    }

    public void afterDays(long days) {
        this.localDateTime = this.localDateTime.plusDays(days);
    }

    public void afterHours(long hours) {
        this.localDateTime = this.localDateTime.plusHours(hours);
    }

    public void afterMinutes(long minutes) {
        this.localDateTime = this.localDateTime.plusMinutes(minutes);
    }

    public void afterSeconds(long seconds) {
        this.localDateTime = this.localDateTime.plusSeconds(seconds);
    }
}