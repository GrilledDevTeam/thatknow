package com.grileddev.thatknow.util;

import java.util.StringTokenizer;

import com.grileddev.thatknow.web.entity.weatherResponseHourEntity.WeatherResponseHourEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponseHour {
    private String nx;
    private String ny;

    // 발표 날짜
    private String baseDate;
    private String baseTime;

    // 예보 날짜
    private String fcstDate;
    private String fcstTime;

    // 예보 분류
    private String TMP; // 1시간 기온
    private String TMN; // 일 최저 기온
    private String TMX; // 일 최고 기온
    private String REH; // 1시간 습도
    private String SKY; // 하늘 상태 (맑은, 구름 많음, 흐림)
    private String POP; // 강수 확률
    private String PTY; // 강수 형태 (비, 소나기, 눈)
    private String PCP; // 강수량
    private String SNO; // 적설량
    private String WSD; // 1시간 풍속

    public WeatherResponseHour(String hourData) {
        StringTokenizer splitToken = new StringTokenizer(hourData, "/");

        // 공통 데이터 (발표 날짜, 시간 / 예측 날짜 시간 / 위치)
        this.baseDate = splitToken.nextToken();
        this.baseTime = splitToken.nextToken();
        this.fcstDate = splitToken.nextToken();
        this.fcstTime = splitToken.nextToken();
        this.nx = splitToken.nextToken();
        this.ny = splitToken.nextToken();

        // 나머지 category 와 fcstValue 예측 값 저장
        while (splitToken.hasMoreTokens())
        {
            String category = splitToken.nextToken();

            // 각 카테고리에 대응하는 fcstValue 값 저장
            switch (category)
            {
                case "TMP":
                    this.TMP = splitToken.nextToken();
                    break;

                case "TMN":
                    this.TMN = splitToken.nextToken();

                    break;
                case "TMX":
                    this.TMX = splitToken.nextToken();
                    break;

                case "REH":
                    this.REH = splitToken.nextToken();
                    break;

                case "SKY":
                    this.SKY = splitToken.nextToken();
                    break;

                case "POP":
                    this.POP = splitToken.nextToken();
                    break;

                case "PTY":
                    this.PTY = splitToken.nextToken();
                    break;

                case "PCP":
                    this.PCP = splitToken.nextToken();
                    break;

                case "SNO":
                    this.SNO = splitToken.nextToken();
                    break;

                case "WSD":
                    this.WSD = splitToken.nextToken();
                    break;

                default:
                    break;
            }
        }


        if (this.TMP == null)
        {
            this.TMP = "null";
        }

        if (this.TMN == null)
        {
            this.TMN = "null";
        }

        if (this.TMX == null)
        {
            this.TMX = "null";
        }

        if (this.REH == null)
        {
            this.REH = "null";
        }

        if (this.SKY == null)
        {
            this.SKY = "null";
        }

        if (this.POP == null)
        {
            this.POP = "null";
        }

        if (this.PTY == null)
        {
            this.PTY = "null";
        }

        if (this.PCP == null)
        {
            this.PCP = "null";
        }

        if (this.SNO == null)
        {
            this.SNO = "null";
        }

        if (this.WSD == null)
        {
            this.WSD = "null";
        }
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