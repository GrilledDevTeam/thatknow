package com.grileddev.thatknow.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DateToDate {

    //멤버
    private String baseDate;
    private String baseTime;

    //API 용 멤버
    private String numOfRows;

    //DB 용 멤버
    private String strfcstDate;
    private String strfcstTime;


    /**
    *@param strData "2300" : 내일 00시 ~ 23시      (내일) TMX TMN
    *@param strData -----------------------------
    *@param strData "0200" : 오늘 03시 ~ 23시      (오늘) TMX TMN
    *@param strData "0500" : 오늘 06시 ~ 23시      (오늘) TMX
    *@param strData "0800" : 오늘 09시 ~ 23시      (오늘) TMX
    *@param strData "1100" : 오늘 12시 ~ 23시      (오늘) TMX
    *@param strData "1400" : 오늘 15시 ~ 23시      
    *@param strData "1700" : 오늘 18시 ~ 23시      
    *@param strData "2000" : 오늘 21시 ~ 23시      
    */
    // API 통신에 필요한 시간포멧(20230726)으로 설정
    public void setTimeForAPIParameter(String strData){

        SimpleDateFormat apiDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);

        // 2300
        if (strData.equals("2300"))
        {
            // 어제 날짜
            Date date = new Date((new Date()).getTime()+(1000*60*60*24*-1));
            this.baseDate = apiDateFormat.format(date);

            // 2300 시간
            this.baseTime = "2300";

            // 데이터개수
            this.numOfRows = "290";
        }
        // 이외 매개변수
        else
        {
            // 오늘 날짜
            Date date = new Date((new Date()).getTime());
            this.baseDate = apiDateFormat.format(date);

            // 시간
            this.baseTime = strData;

            // 데이터개수
            int countTemp = 288 - (12 * ((Integer.parseInt(strData) / 100) + 1));

            // 데이터개수에서 TMX / TNX 값 고려
            if (strData.equals("2300") || strData.equals("0200"))
            {
                countTemp += 2;
            }
            if (strData.equals("0500") || strData.equals("0800") || strData.equals("1100"))
            {
                countTemp += 1;
            }

            this.numOfRows = String.valueOf(countTemp);
        }
    }


    // DB 용 구현예정
    /*
     * @param 
     */
    public void setTimeForDBManager(){

    }

    public String getBaseDate() {
        return baseDate;
    }

    public String getBaseTime() {
        return baseTime;
    }

    public String getNumOfRows() {
        return numOfRows;
    }

    public String getfcstDate() {
        return strfcstDate;
    }

    public String getfcstTime() {
        return strfcstTime;
    }
}
