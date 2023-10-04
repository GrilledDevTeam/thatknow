package com.grileddev.thatknow.core;

import lombok.Data;

@Data
public class RepresentationJudgementForDressCode {

    private double ATMPCelsiusForDressCode;

    private ATMPCelsiusDressCodeType ATMPCelsiusDressCodeType; // 체감온도
    private WeatherStateDressCodeType WeatherStateDressCodeType; // 날씨상태

}


enum ATMPCelsiusDressCodeType {
    VERY_HOT,
    HOT,
    WARM,
    NORMAL_WARM,
    NORMAL,
    COOL,
    COLD,
    VERY_COLD
}

enum WeatherStateDressCodeType {
    SUNNY,
    SUNNY_RAINY,
    RAINY,
    VERY_RAINY,
    SNOWY,
    VERY_SNOWY
}
