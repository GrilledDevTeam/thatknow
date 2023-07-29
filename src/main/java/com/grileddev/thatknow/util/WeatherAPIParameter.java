package com.grileddev.thatknow.util;

import java.text.SimpleDateFormat;
import java.util.Date; // -> Date 사장된거 time.LocalDate
import java.util.Locale;

// API 통신에 사용할 파라미터 클래스
public class WeatherAPIParameter {
    
    //멤버
    private String numOfRows;
    private String pageNo;
    private String dataType;
    private String baseDate;
    private String baseTime;
    private String nx;
    private String ny;


    /**
     *@param numOfRows Default : 290
     *@param pageNo Default : 1
     *@param dataType Default : JSON
     *@param baseDate Default : Yesterday(Type : SimpleDateFormat)
     *@param baseTime Default : 2300
     *@param nx Default : NONE
     *@param ny Default : NONE
     */
    public WeatherAPIParameter() {
        this.numOfRows = "290";
        this.pageNo = "1";
        this.dataType = "JSON";
        this.baseDate = new SimpleDateFormat("yyyyMMdd", Locale.KOREA).format(new Date((new Date()).getTime()+(1000*60*60*24*-1)));
        this.baseTime = "2300";
    }


    public void setNumOfRows(String numOfRows) {
        this.numOfRows = numOfRows;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setBaseDate(String baseDate) {
        this.baseDate = baseDate;
    }

    public void setBaseTime(String baseTime) {
        this.baseTime = baseTime;
    }

    public void setNx(String nx) {
        this.nx = nx;
    }

    public void setNy(String ny) {
        this.ny = ny;
    }

    
    public String getNumOfRows() {
        return numOfRows;
    }

    public String getPageNo() {
        return pageNo;
    }

    public String getDataType() {
        return dataType;
    }

    public String getBaseDate() {
        return baseDate;
    }

    public String getBaseTime() {
        return baseTime;
    }

    public String getNx() {
        return nx;
    }

    public String getNy() {
        return ny;
    }
}
