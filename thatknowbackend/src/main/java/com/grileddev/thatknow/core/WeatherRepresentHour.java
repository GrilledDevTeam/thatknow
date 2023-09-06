package com.grileddev.thatknow.core;

import lombok.Data;

@Data
public class WeatherRepresentHour{

    // 평균 or 최빈값
    private double ATMPCelsiusMean; // 체감온도
    private Double THIMean; // 불쾌지수
    private double WSDMean; // 풍속

    private SKY SKYMode; // 하늘 상태 
    private PTY PTYMode; // 강수 형태 
    private double POPMean; // 강수 확률

    private double PCPMean; // 강수량
    private double SNOMean; // 적설량
    

    // 표준편차 (standard deviation(SD) (위키백과))
    private double ATMPCelsiusSD;            // 4 이상 차이나면 일교차가 크다 판단  ,  출처 : (https://bluesky4152.tistory.com/26)
    private Double THISD;                    // 4 이상 차이나면 불쾌지수가 크다 판단
                                                //https://news.samsungdisplay.com/32491
    private double WSDSD;                    // 2이상 차이나면 바람차가 크다 판단
                                                // https://ko.wiktionary.org/wiki/%EB%B6%80%EB%A1%9D:%EB%B3%B4%ED%8D%BC%ED%8A%B8%ED%92%8D%EB%A0%A5%EA%B3%84%EA%B8%89
    private boolean SKYValidity;             // 2/3 이상 일정 상태에 위치하면 true
    private boolean PTYValidity;             // 2/3 이상 일정 상태에 위치하면 true
    private double POPSD;                    // 30정도 차이나면 강수확률 차이가 크다고 판단

    private double PCPSD;                    // 8정도 차이나면 강수량 차이가 크다고 판단
                                                //https://m.blog.naver.com/kma_131/222073284939
    private double SNOSD;                    // 1cm정도 차이나면 적설량 차이가 크다고 판단
}



enum RepresentHourType{
        ATMP_CELSIUS,
        THI,
        WSD,
        PTY,
        SKY,
        POP,
        PCP,
        SNO
}

enum PTY{
    NONE(0 , "없음" , 0),
    RAIN(1, "비", 1),
    RAIN_SNOW(2 , "비/눈" , 2),
    SNOW(3, "눈", 3),
    SHOWER(4, "소나기" , 4);

    private int indexForCalculate;
    private String string;
    private int APIvalue;  

    private PTY(int indexForCalculate , String string , int APIvalue){
        this.indexForCalculate = indexForCalculate;
        this.string = string;
        this.APIvalue = APIvalue;
    }

    public int getIndexForCalculate(){
        return indexForCalculate;
    }

    public String getString(){
        return string;
    }

    public int getAPIvalue(){
        return APIvalue;
    }
}

enum PCP{
    NONE("강수 없음", 0.0),
    UNDER_1MM("1.0mm 미만" , 0.5),
    UNDER_50MM("30.0 mm 이상 50.0 mm 미만" , 40.0),
    OVER_50MM("50.0 mm 이상" , 65.0);  // 50.0mm 이상을 평균잡기엔 기준 모호

    private String string;
    private double meanValue;

    private PCP(String string , double meanValue){
        this.string = string;
        this.meanValue = meanValue;
    }

    public String getString(){
        return string;
    }

    public double getMeanValue(){
        return meanValue;
    }
}

enum SNO{
    NONE("적설 없음", 0.0),
    UNDER_1CM("1.0cm 미만" , 0.5),
    UNDER_5CM("1.0cm 이상 5.0cm 미만" , 2.5),
    OVER_5CM("5.0 cm 이상" , 6.5);  // 5.0cm 이상을 평균잡기엔 기준 모호

    private String string;
    private double meanValue;

    private SNO(String string , double meanValue){
        this.string = string;
        this.meanValue = meanValue;
    }

    public String getString(){
        return string;
    }

    public double getMeanValue(){
        return meanValue;
    }
}

enum SKY{
    SUNNY(0 , "맑음", 1),
    CLOUDY(1, "구름 많음" , 3),
    VERY_CLOUDY(2 , "흐림" , 4);

    private int indexForCalculate;
    private String string;
    private int APIvalue;

    private SKY(int indexForCalculate , String string , int APIvalue){
        this.indexForCalculate = indexForCalculate;
        this.string = string;
        this.APIvalue = APIvalue;
    }

    public int getIndexForCalculate(){
        return indexForCalculate;
    }

    public String getString(){
        return string;
    }

    public int getAPIvalue(){
        return APIvalue;
    }
}


