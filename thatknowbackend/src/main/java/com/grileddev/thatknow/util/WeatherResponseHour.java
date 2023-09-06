package com.grileddev.thatknow.util;

import com.grileddev.thatknow.web.entity.weatherResponseHourEntity.WeatherResponseHourEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class WeatherResponseHour {
    private int nx;
    private int ny;

    // 발표 날짜
    private String baseDate;
    private String baseTime;

    // 예보 날짜
    private String fcstDate;
    private String fcstTime;

    // 예보 분류
    private double TMP; // 1시간 기온
    private double TMN; // 일 최저 기온
    private double TMX; // 일 최고 기온
    private int REH; // 1시간 습도
    private int SKY; // 하늘 상태 (맑은, 구름 많음, 흐림)
    private int POP; // 강수 확률
    private int PTY; // 강수 형태 (비, 소나기, 눈)
    private String PCP; // 강수량
    private String SNO; // 적설량
    private double WSD; // 1시간 풍속


    public WeatherResponseHour() {
    }

    //복사생성자
    public WeatherResponseHour(WeatherResponseHour responseHour){
        nx = responseHour.nx;
        ny = responseHour.ny;
        baseDate = responseHour.baseDate;
        baseTime = responseHour.baseTime;
        fcstDate = responseHour.fcstDate;
        fcstTime = responseHour.fcstTime;
        TMP = responseHour.TMP;
        TMN = responseHour.TMN;
        TMX = responseHour.TMX;
        REH = responseHour.REH;
        SKY = responseHour.SKY;
        POP = responseHour.POP;
        PTY = responseHour.PTY;
        PCP = responseHour.PCP;
        SNO = responseHour.SNO;
        WSD = responseHour.WSD;
    }

    @Override
    public String toString() {
        final String data = "nx : " + nx + " ny : " + ny + "baseDate : " + baseDate + " baseTime : " + baseTime +
        " fcstDate : " + fcstDate + " fcstTime : " + fcstTime + " TMP : " + TMP + " TMN : " + TMN + " TMX : " + TMX +
        " REH : " + REH + " SKY : " + SKY + " POP : " + POP + " PTY : " + PTY + " PCP : " + PCP + " SNO : " + SNO +
        " WSD : " + WSD;

        return data;
    }

    public WeatherResponseHourEntity toEntity() {
        return WeatherResponseHourEntity.builder()
        .nx(nx)
        .ny(ny)
        .baseDate(baseDate)
        .baseTime(baseTime)
        .fcstDate(fcstDate)
        .fcstTime(fcstTime)
        .TMP(TMP)
        .TMN(TMN)
        .TMX(TMX)
        .REH(REH)
        .SKY(SKY)
        .POP(POP)
        .PTY(PTY)
        .PCP(PCP)
        .SNO(SNO)
        .WSD(WSD)
        .build();
    }
}