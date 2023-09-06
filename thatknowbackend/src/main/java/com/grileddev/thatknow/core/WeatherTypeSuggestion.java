package com.grileddev.thatknow.core;

import lombok.Data;

@Data
public class WeatherTypeSuggestion {
 
    private String ATMPCelsiusType;
    private String ATMPCelsiusSDType;  // 표준편차 (SD : Standard Deviation)
    private String THIType;  // 불쾌지수 (THI : Temperature-Humidity Index)
    private String THISDType;
    
    private String WSDType;  // 풍속
    private String WSDSDMType; 

    private String PTYType; // 강수형태 (없음, 비, 비/눈, 눈, 소나기)
    private String PTYValidityType;

    private String POPType;  // 강수확률
    private String POPSDType;

    private String SKYType; // 하늘상태 (맑음, 구름많음, 흐림)
    private String SKYValidityType;

    private String PCPType; // 강수량
    private String PCPSDType;

    private String SNOType; // 적설량
    private String SNOSDType;

}
