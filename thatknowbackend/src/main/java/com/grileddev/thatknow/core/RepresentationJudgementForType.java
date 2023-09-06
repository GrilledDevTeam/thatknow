package com.grileddev.thatknow.core;

import lombok.Data;

@Data
public class RepresentationJudgementForType{

    private ATMPCelsiusType ATMPCelsiusType; // 체감온도
    private ATMPCelsiusSDType ATMPCelsiusSDType; // 체감온도 표준편차

    private THIType THIType; // 불쾌지수
    private THISDType THISDType; // 불쾌지수 표준편차

    private WSDType WSDType; // 바람세기
    private WSDSDType WSDSDType; // 바람세기 표준편차


    private PTYType PTYType; // 강수형태
    private PTYValidityType PTYValidityType; // 강수형태 표준편차
    

    private POPType POPType; // 강수확률
    private POPSDType POPSDType; // 강수확률 표준편차

    private SKYType SKYType; // 하늘상태
    private SKYValidityType SKYValidityType; // 하늘상태 표준편차

    
    // PTY = RAIN
    private PCPType PCPType; // 강수량
    private PCPSDType PCPSDType; // 강수량 표준편차

    // PTY = SNOW
    private SNOType SNOType; // 적설량
    private SNOSDType SNOSDType; // 적설량 표준편차

}

enum ATMPCelsiusType{
    VERY_HOT("veryHot"),
    HOT("hot"),
    WARM("warm"),
    NORMAL_WARM("normalWarm"),
    NORMAL("normal"),
    COOL("cool"),
    COLD("cold"),
    VERY_COLD("veryCold");

    private String string;

    private ATMPCelsiusType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}

enum ATMPCelsiusSDType{
    BIG("big"),
    NORMAL("normal");

    private String string;

    private ATMPCelsiusSDType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}

enum THIType{
    VERY_DISCOMFORT("veryDiscomfort"),
    DISCOMFORT("discomfort"),
    LITTLE_DISCOMFORT("littleDiscomfort"),
    COMFORT("comfort"),
    NOT_DIFINED("notDifined");

    private String string;

    private THIType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}

enum THISDType{
    BIG("big"),
    NORMAL("normal"),
    NOT_DIFINED("notDifined");

    private String string;

    private THISDType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}

enum WSDType{
    HURRICANE("hurricane"),
    VIOLENT_STORM("violentStorm"),
    STORM("storm"),
    STRONG_GALE("strongGale"),
    GALE("gale"),
    NEAR_GALE("nearGale"),
    STRONG_BREEZE("strongBreeze"),
    FRESH_BREEZE("freshBreeze"),
    MODERATE_BREEZE("moderateBreeze"),
    GENTLE_BREEZE("gentleBreeze"),
    LIGHT_BREEZE("lightBreeze"),
    LIGHT_AIR("lightAir"),
    CALM("calm");

    private String string;

    private WSDType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}

enum WSDSDType{
    BIG("big"),
    NORMAL("normal");

    private String string;

    private WSDSDType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}



enum PTYType{
    SHOWER("shower"),
    SNOWY("snowy"),
    RAINY_SNOWY("rainySnowy"),
    RAINY("rainy"),
    NONE("none");

    private String string;

    private PTYType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}

enum PTYValidityType{
    TRUE("true"),
    FALSE("false");

    private String string;

    private PTYValidityType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}

enum POPType{
    VERY_HIGH("veryHigh"),
    HIGH("high"),
    MEDIUM("medium"),
    LOW("low");

    private String string;

    private POPType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}

enum POPSDType{
    BIG("big"),
    NORMAL("normal");

    private String string;

    private POPSDType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}

enum SKYType{
    VERY_CLOUDY("veryCloudy"),
    CLOUDY("cloudy"),
    SUNNY("sunny");

    private String string;

    private SKYType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}

enum SKYValidityType{
    TRUE("true"),
    FALSE("false");

    private String string;

    private SKYValidityType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}

enum PCPType{
    OVER_50MM("over50mm"),
    UNDER_50MM("under50mm"),
    UNDER_30MM("under30mm"),
    UNDER_15MM("under15mm"),
    UNDER_1MM("under1mm"),
    NONE("none");

    private String string;

    private PCPType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}

enum PCPSDType{
    BIG("big"),
    NORMAL("normal");

    private String string;

    private PCPSDType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}

enum SNOType{
    OVER_5CM("over5cm"),
    UNDER_5CM("under5cm"),
    UNDER_3CM("under3cm"),
    UNDER_1CM("under1cm"),
    NONE("none");

    private String string;

    private SNOType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}

enum SNOSDType{
    BIG("big"),
    NORMAL("normal");

    private String string;

    private SNOSDType(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}


