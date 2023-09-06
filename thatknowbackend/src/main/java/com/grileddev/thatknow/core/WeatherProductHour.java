package com.grileddev.thatknow.core;

import com.grileddev.thatknow.util.WeatherResponseHour;

import lombok.Data;

@Data
public class WeatherProductHour{

    private int gridX;
    private int gridY;

    private String BaseDate;
    private String BaseTime;

    private String fcstDate;
    private String fcstTime;

    private double TMPCelsius; // 1시간 기온
    private double TMNCelsius; // 일 최저 기온
    private double TMXCelsius; // 일 최고 기온
    private int REH; // 1시간 습도 (%)
    private double WSD; // 1시간 풍속 (m/s)

    private int PTY; // 강수 형태 (없음(0) , 비(1), 비/눈(2) , 눈(3) , 소나기(4))
    private int SKY; // 하늘 상태 (맑은(1), 구름 많음(3), 흐림(4))
    private int POP; // 강수 확률 (%)
    
    private String PCP; // 강수량 (mm)
    private String SNO; // 적설량 (cm)
    
    private int ATMPCelsius;   //  체감온도 (AT : Apparent Temperature) 위키백과
    private Integer THI;   // 불쾌지수 (%) (THI : Temperature-Humidity Index) 위키백과
                            // 겨울 = null

    public WeatherProductHour(WeatherResponseHour weatherResponseHour){
        this.gridX = weatherResponseHour.getNx();
        this.gridY = weatherResponseHour.getNy();

        this.BaseDate = weatherResponseHour.getBaseDate();
        this.BaseTime = weatherResponseHour.getBaseTime();

        this.fcstDate = weatherResponseHour.getFcstDate();
        this.fcstTime = weatherResponseHour.getFcstTime();
        
        this.TMPCelsius = weatherResponseHour.getTMP();
        this.TMNCelsius = weatherResponseHour.getTMN();
        this.TMXCelsius = weatherResponseHour.getTMX();
        this.REH = weatherResponseHour.getREH();
        this.WSD = weatherResponseHour.getWSD();

        this.SKY = weatherResponseHour.getSKY();
        this.PTY = weatherResponseHour.getPTY();
        this.POP = weatherResponseHour.getPOP();

        this.PCP = weatherResponseHour.getPCP();
        this.SNO = weatherResponseHour.getSNO();
    }
}