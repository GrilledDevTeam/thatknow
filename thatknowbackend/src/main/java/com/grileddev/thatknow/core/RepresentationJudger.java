package com.grileddev.thatknow.core;

public class RepresentationJudger
{
    // 생성자
    private static RepresentationJudger instance = new RepresentationJudger();
    private RepresentationJudger() {
    }
    public static RepresentationJudger getInstance() {
        return instance;
    }


    public RepresentationJudgementForType getRepresentationJudgementForType (WeatherRepresentHour weatherRepresentHour) {
        RepresentationJudgementForType representationJudjmentFor = new RepresentationJudgementForType();

        representationJudjmentFor.setATMPCelsiusType(createATMPCelsiusType(weatherRepresentHour));
        representationJudjmentFor.setATMPCelsiusSDType(createATMPCelsiusSDType(weatherRepresentHour));
        representationJudjmentFor.setTHIType(createTHIType(weatherRepresentHour));
        representationJudjmentFor.setTHISDType(createTHISDType(weatherRepresentHour));
        representationJudjmentFor.setWSDType(createWSDType(weatherRepresentHour));
        representationJudjmentFor.setWSDSDType(createWSDSDType(weatherRepresentHour));
        representationJudjmentFor.setPTYType(createPTYType(weatherRepresentHour));
        representationJudjmentFor.setPTYValidityType(createPTYSDType(weatherRepresentHour));
        representationJudjmentFor.setPOPType(createPOPType(weatherRepresentHour));
        representationJudjmentFor.setPOPSDType(createPOPSDType(weatherRepresentHour));
        representationJudjmentFor.setSKYType(createSKYType(weatherRepresentHour));
        representationJudjmentFor.setSKYValidityType(createSKYSDType(weatherRepresentHour));
        representationJudjmentFor.setPCPType(createPCPType(weatherRepresentHour));
        representationJudjmentFor.setPCPSDType(createPCPSDType(weatherRepresentHour));
        representationJudjmentFor.setSNOType(createSNOType(weatherRepresentHour));
        representationJudjmentFor.setSNOSDType(createSNOSDType(weatherRepresentHour));


        return representationJudjmentFor;
    }


    public RepresentationJudgementForDressCode getRepresentationJudgementForDressCode (WeatherRepresentHour weatherRepresentHour) {
        RepresentationJudgementForDressCode representationJudjmentForDressCode = new RepresentationJudgementForDressCode();

        representationJudjmentForDressCode.setATMPCelsiusForDressCode(setATMPCelsiusForDressCode(weatherRepresentHour));

        representationJudjmentForDressCode.setATMPCelsiusDressCodeType(createATMPCelsiusDressCodeType(weatherRepresentHour));
        representationJudjmentForDressCode.setWeatherStateDressCodeType(createWeatherStateDressCodeType(weatherRepresentHour));


        return representationJudjmentForDressCode;
    }






    // ----------------------------- private method -----------------------------------------------



    // 체감온도 타입설정
    private ATMPCelsiusType createATMPCelsiusType (WeatherRepresentHour weatherRepresentHour){
        final double ATMPCelsius = weatherRepresentHour.getATMPCelsiusMean();

        if (28 <= ATMPCelsius)
        {
            return ATMPCelsiusType.VERY_HOT;
        }
        else if ( 23 <= ATMPCelsius)
        {
            return ATMPCelsiusType.HOT;
        }
        else if ( 20 <= ATMPCelsius)
        {
            return ATMPCelsiusType.WARM;
        }
        else if ( 17 <= ATMPCelsius)
        {
            return ATMPCelsiusType.NORMAL_WARM;
        }
        else if ( 12 <= ATMPCelsius)
        {
            return ATMPCelsiusType.NORMAL;
        }
        else if ( 9 <= ATMPCelsius)
        {
            return ATMPCelsiusType.COOL;
        }
        else if ( 5 <= ATMPCelsius)
        {
            return ATMPCelsiusType.COLD;
        }
        else
        {
            return ATMPCelsiusType.VERY_COLD;
        }
    }

    // 체감온도 일교차 타입 설정
    private ATMPCelsiusSDType createATMPCelsiusSDType (WeatherRepresentHour weatherRepresentHour){

        final double ATMPCelsiusSD = weatherRepresentHour.getATMPCelsiusSD();

        if (ATMPCelsiusSD >= 4)
        {
            return ATMPCelsiusSDType.BIG;
        }
        else
        {
            return ATMPCelsiusSDType.NORMAL;
        }
    }


    // 불쾌지수 타입 설정
    private THIType createTHIType (WeatherRepresentHour weatherRepresentHour){
        
        final Double THI = weatherRepresentHour.getTHIMean();

        if (THI == null)
        {
            return THIType.NOT_DIFINED;
        }
        else if (80 <= THI)
        {
            return THIType.VERY_DISCOMFORT;
        }
        else if (75 <= THI)
        {
            return THIType.DISCOMFORT;
        }
        else if (68 <= THI)
        {
            return THIType.LITTLE_DISCOMFORT;
        }   
        else
        {
            return THIType.COMFORT;
        }
    }

    // 불쾌지수 차이 타입 설정
    private THISDType createTHISDType (WeatherRepresentHour weatherRepresentHour){
        
        final Double THISD = weatherRepresentHour.getTHISD();

        if (THISD == null)
        {
            return THISDType.NOT_DIFINED;
        }
        else if (THISD >= 4)
        {
            return THISDType.BIG;
        }
        else
        {
            return THISDType.NORMAL;
        }
    }

    // 바람 타입 설정 (보퍼트 풍력계급)
    private WSDType createWSDType (WeatherRepresentHour weatherRepresentHour){
        
        final double WSD = weatherRepresentHour.getWSDMean();

        if (WSD < 0.3)
        {
            return WSDType.CALM;
        }
        else if (WSD < 1.6)
        {
            return WSDType.LIGHT_AIR;
        }
        else if (WSD < 3.4)
        {
            return WSDType.LIGHT_BREEZE;
        }
        else if (WSD < 5.5)
        {
            return WSDType.GENTLE_BREEZE;
        }
        else if (WSD < 8.0)
        {
            return WSDType.MODERATE_BREEZE;
        }
        else if (WSD < 10.8)
        {
            return WSDType.FRESH_BREEZE;
        }
        else if (WSD < 13.9)
        {
            return WSDType.STRONG_BREEZE;
        }
        else if (WSD < 17.2)
        {
            return WSDType.NEAR_GALE;
        }
        else if (WSD < 20.8)
        {
            return WSDType.GALE;
        }
        else if (WSD < 24.5)
        {
            return WSDType.STRONG_GALE;
        }
        else if (WSD < 28.5)
        {
            return WSDType.STORM;
        }
        else if (WSD < 32.7)
        {
            return WSDType.VIOLENT_STORM;
        }
        else
        {
            return WSDType.HURRICANE;
        }
    }

    // 바람 차이 타입 설정
    private WSDSDType createWSDSDType (WeatherRepresentHour weatherRepresentHour){
        
        final double WSDSD = weatherRepresentHour.getWSDSD();

        if (WSDSD >= 2)
        {
            return WSDSDType.BIG;
        }
        else
        {
            return WSDSDType.NORMAL;
        }
    }

    // 강수타입 설정
    private PTYType createPTYType (WeatherRepresentHour weatherRepresentHour){
        
        final PTY PTYMode = weatherRepresentHour.getPTYMode();

        if (PTYMode.equals(PTY.SHOWER))
        {
            return PTYType.SHOWER;
        }
        else if (PTYMode.equals(PTY.SNOW))
        {
            return PTYType.SNOWY;
        }
        else if (PTYMode.equals(PTY.RAIN_SNOW))
        {
            return PTYType.RAINY_SNOWY;
        }
        else if (PTYMode.equals(PTY.RAIN))
        {
            return PTYType.RAINY;
        }
        else
        {
            return PTYType.NONE;
        }
    }

    // 강수타입 차이 설정
    private PTYValidityType createPTYSDType (WeatherRepresentHour weatherRepresentHour){
        
        final boolean PTYVaildity = weatherRepresentHour.isPTYValidity();

        if (PTYVaildity)
        {
            return PTYValidityType.TRUE;
        }
        else
        {
            return PTYValidityType.FALSE;
        }
    }

    // 강수확률 타입 설정
    private POPType createPOPType (WeatherRepresentHour weatherRepresentHour){
            
        final double POP = weatherRepresentHour.getPOPMean();

        if (75 <= POP)
        {
            return POPType.VERY_HIGH;
        }
        else if (50 <= POP)
        {
            return POPType.HIGH;
        }
        else if (25 <= POP)
        {
            return POPType.MEDIUM;
        }
        else
        {
            return POPType.LOW;
        }
    }

    // 강수확률 차이 타입 설정
    private POPSDType createPOPSDType (WeatherRepresentHour weatherRepresentHour){
        
        final double POPSD = weatherRepresentHour.getPOPSD();

        if (POPSD >= 30)
        {
            return POPSDType.BIG;
        }
        else
        {
            return POPSDType.NORMAL;
        }
    }

    // 하늘 타입 설정
    private SKYType createSKYType (WeatherRepresentHour weatherRepresentHour){
        
        final SKY SKYMode = weatherRepresentHour.getSKYMode();

        if (SKYMode.equals(SKY.VERY_CLOUDY))
        {
            return SKYType.VERY_CLOUDY;
        }
        else if (SKYMode.equals(SKY.CLOUDY))
        {
            return SKYType.CLOUDY;
        }
        else
        {
            return SKYType.SUNNY;
        }
    }

    // 하늘 타입 차이 설정
    private SKYValidityType createSKYSDType (WeatherRepresentHour weatherRepresentHour){
        
        final boolean SKYValidity = weatherRepresentHour.isSKYValidity();

        if (SKYValidity)
        {
            return SKYValidityType.TRUE;
        }
        else
        {
            return SKYValidityType.FALSE;
        }
    }

    // 강수량 타입 설정
    private PCPType createPCPType (WeatherRepresentHour weatherRepresentHour){
        
        final double PCP = weatherRepresentHour.getPCPMean();

        if (50 < PCP)
        {
            return PCPType.OVER_50MM;
        }
        else if ( 30 < PCP)
        {
            return PCPType.UNDER_50MM;
        }
        else if ( 15 < PCP)
        {
            return PCPType.UNDER_30MM;
        }
        else if (1 <  PCP)
        {
            return PCPType.UNDER_15MM;
        }
        else if ( 0 < PCP)
        {
            return PCPType.UNDER_1MM;
        }
        else
        {
            return PCPType.NONE;
        }
    }

    // 강수량 타입 차이 설정
    private PCPSDType createPCPSDType (WeatherRepresentHour weatherRepresentHour){
        
        final double PCPSD = weatherRepresentHour.getPCPSD();

        if (PCPSD >= 8)
        {
            return PCPSDType.BIG;
        }
        else
        {
            return PCPSDType.NORMAL;
        }
    }

    // 적설량 타입 설정
    private SNOType createSNOType (WeatherRepresentHour weatherRepresentHour){
            
        final double SNO = weatherRepresentHour.getSNOMean();

        if (5 < SNO)
        {
            return SNOType.OVER_5CM;
        }
        else if (1 < SNO)
        {
            return SNOType.UNDER_5CM;
        }
        else if (3 < SNO)
        {
            return SNOType.UNDER_3CM;
        }
        else if (0 < SNO)
        {
            return SNOType.UNDER_1CM;
        }
        else
        {
            return SNOType.NONE;
        }
    }

    // 적설량 타입 차이 설정
    private SNOSDType createSNOSDType (WeatherRepresentHour weatherRepresentHour){
        
        final double SNOSD = weatherRepresentHour.getSNOSD();

        if (SNOSD >= 1)
        {
            return SNOSDType.BIG;
        }
        else
        {
            return SNOSDType.NORMAL;
        }
    }




    // 드레스코드 최종 온도 타입 설정
    
    private double setATMPCelsiusForDressCode(WeatherRepresentHour weatherRepresentHour) {
        // 가독성
        final double ATMPCelsius = weatherRepresentHour.getATMPCelsiusMean();
        final SKY SKYMode = weatherRepresentHour.getSKYMode();



        final double WSDWeight = 28 / ATMPCelsius; // 28도 이상이면 작아지게

        double finalTemperature = ATMPCelsius;

        // 바람 고려
        if (20 < weatherRepresentHour.getWSDMean())
        {
            finalTemperature -= 5 * WSDWeight;
        }
        else if (13 < weatherRepresentHour.getWSDMean())
        {
            finalTemperature -= 3 * WSDWeight;
        }
        else if (9 < weatherRepresentHour.getWSDMean())
        {
            finalTemperature -= 1.7 * WSDWeight;
        }
        else if (5 < weatherRepresentHour.getWSDMean())
        {
            finalTemperature -= 1.2 * WSDWeight;
        }
        else
        {
            finalTemperature -= 0;
        }

        // 하늘 상태 고려
        if (SKYMode.equals(SKY.VERY_CLOUDY))
        {
            finalTemperature -= 0.7;
        }
        else if (SKYMode.equals(SKY.CLOUDY))
        {
            finalTemperature -= 0.5;
        }
        else
        {
            finalTemperature += 0;
        }

        return finalTemperature;
    }


    private ATMPCelsiusDressCodeType createATMPCelsiusDressCodeType (WeatherRepresentHour weatherRepresentHour) {
        
        double finalTemperature = setATMPCelsiusForDressCode(weatherRepresentHour);

        // 최종 옷추천용 체감온도 타입 설정
        if (28 <= finalTemperature)
        {
            return ATMPCelsiusDressCodeType.VERY_HOT;
        }
        else if ( 23 <= finalTemperature)
        {
            return ATMPCelsiusDressCodeType.HOT;
        }
        else if ( 20 <= finalTemperature)
        {
            return ATMPCelsiusDressCodeType.NORMAL_WARM;
        }
        else if ( 17 <= finalTemperature)
        {
            return ATMPCelsiusDressCodeType.WARM;
        }
        else if ( 12 <= finalTemperature)
        {
            return ATMPCelsiusDressCodeType.NORMAL;
        }
        else if ( 9 <= finalTemperature)
        {
            return ATMPCelsiusDressCodeType.COOL;
        }
        else if ( 5 <= finalTemperature)
        {
            return ATMPCelsiusDressCodeType.COLD;
        }
        else
        {
            return ATMPCelsiusDressCodeType.VERY_COLD;
        }
    }

    // 드레스코드 최종 날씨 타입 설정
    private WeatherStateDressCodeType createWeatherStateDressCodeType (WeatherRepresentHour weatherRepresentHour) {
        
        // 가독성
        final PTY PTYMode = weatherRepresentHour.getPTYMode();
        final double PCP = weatherRepresentHour.getPCPMean();
        final double POP = weatherRepresentHour.getPOPMean();
        final double SNO = weatherRepresentHour.getSNOMean();


        if (PTYMode.equals(PTY.NONE) && POP < 3)
        {
            return WeatherStateDressCodeType.SUNNY;
        }
        else
        {
            if (PTYMode.equals(PTY.SHOWER))
            {
                if (50 < PCP)
                {
                    return WeatherStateDressCodeType.VERY_RAINY;
                }
                else if ( 30 < PCP)
                {
                    return WeatherStateDressCodeType.VERY_RAINY;
                }
                else if ( 15 < PCP)
                {
                    return WeatherStateDressCodeType.VERY_RAINY;
                }
                else if (1 <  PCP)
                {
                    return WeatherStateDressCodeType.RAINY;
                }
                else if ( 0 < PCP)
                {
                    return WeatherStateDressCodeType.RAINY;
                }
                else
                {
                    return WeatherStateDressCodeType.RAINY;
                }
            }
            else if (PTYMode.equals(PTY.RAIN_SNOW))
            {
                if (50 < PCP)
                {
                    return WeatherStateDressCodeType.VERY_RAINY;
                }
                else if ( 30 < PCP)
                {
                    return WeatherStateDressCodeType.VERY_RAINY;
                }
                else if ( 15 < PCP)
                {
                    return WeatherStateDressCodeType.VERY_RAINY;
                }
                else if (1 <  PCP)
                {
                    return WeatherStateDressCodeType.RAINY;
                }
                else if ( 0 < PCP)
                {
                    return WeatherStateDressCodeType.RAINY;
                }
                else
                {
                    return WeatherStateDressCodeType.RAINY;
                }
            }
            else if (PTYMode.equals(PTY.RAIN))
            {
                if (50 < PCP)
                {
                    return WeatherStateDressCodeType.VERY_RAINY;
                }
                else if ( 30 < PCP)
                {
                    return WeatherStateDressCodeType.VERY_RAINY;
                }
                else if ( 15 < PCP)
                {
                    return WeatherStateDressCodeType.VERY_RAINY;
                }
                else if (1 <  PCP)
                {
                    return WeatherStateDressCodeType.RAINY;
                }
                else if ( 0 < PCP)
                {
                    return WeatherStateDressCodeType.RAINY;
                }
                else
                {
                    return WeatherStateDressCodeType.RAINY;
                }
            }
            else if (PTYMode.equals(PTY.SNOW))
            {
                if (5 < SNO)
                {       
                    return WeatherStateDressCodeType.VERY_SNOWY;
                }
                else if (3 < SNO)
                {
                    return WeatherStateDressCodeType.VERY_SNOWY;
                }
                else if (1 < SNO)
                {
                    return WeatherStateDressCodeType.SNOWY;
                }
                else
                {
                    return WeatherStateDressCodeType.SNOWY;
                }
            }
            else
            {
                return WeatherStateDressCodeType.RAINY;
            }
        } 
    }   
}