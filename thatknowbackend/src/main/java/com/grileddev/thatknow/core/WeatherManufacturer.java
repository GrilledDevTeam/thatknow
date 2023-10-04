package com.grileddev.thatknow.core;

import java.util.List;

import java.util.ArrayList;

import com.grileddev.thatknow.util.DateToDate;
import com.grileddev.thatknow.util.WeatherResponseHour;


public class WeatherManufacturer {

    // 생성자
    private static WeatherManufacturer instance = new WeatherManufacturer();
    private WeatherManufacturer() {
    }
    public static WeatherManufacturer getInstance() {
        return instance;
    }
    //


    // weatherProductHour 생성 메서드
    public List<WeatherProductHour> getWeatherProductHours(List<WeatherResponseHour> weatherResponseHours) {

        List<WeatherProductHour> weatherProductHours = new ArrayList<>();

        for (WeatherResponseHour weatherResponseHour : weatherResponseHours)
        {
            WeatherProductHour weatherProductHour = new WeatherProductHour(weatherResponseHour);

            //2022년 여름 평균 기온(24.5도)_출처e-나라지표(기상청 기상연보, 기상자료개방포털)
            if (weatherProductHour.getTMPCelsius() > 20.0)
            {
                weatherProductHour.setATMPCelsius(calculateSummerATMPCelsius(weatherResponseHour));
                weatherProductHour.setTHI(calculateSummmerTHI(weatherResponseHour));
            }
            else
            {
                weatherProductHour.setATMPCelsius(calculateWinterATMPCelsius(weatherResponseHour));
                weatherProductHour.setTHI(null);
            }
            
            weatherProductHours.add(weatherProductHour);
        }

        return weatherProductHours;
    }

    // weatherRepresentHour 생성 메서드
    public WeatherRepresentHour getWeatherRepresentHour (List<WeatherProductHour> weatherProductHours , List<DateToDate> actTimeList, double sensoryWeight) {
        

        List<WeatherProductHour> rangedWeatherProductHours = setWeatherProductsByActTime(weatherProductHours , actTimeList);
        /* // 점검
        System.out.println("------ rangedWeatherProducts 점검------ ");
        for (WeatherProductHour weatherProductHour : rangedWeatherProductHours)
        {
            System.out.println(weatherProductHour.getFcstDate() + " " + weatherProductHour.getFcstTime());
        }
        System.out.println("-------------------------------------- "); */
        
        WeatherRepresentHour representHour = new WeatherRepresentHour();

        // 평균 값 설정
        representHour.setATMPCelsiusMean(calculateMean(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.ATMP_CELSIUS)) + sensoryWeight);
        representHour.setTHIMean(calculateMean(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.THI)));
        representHour.setWSDMean(calculateMean(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.WSD)));
        representHour.setSKYMode(calculateStateMode(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.SKY), SKY.values().length, SKY.class));
        representHour.setPTYMode(calculateStateMode(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.PTY), PTY.values().length, PTY.class));
        representHour.setPOPMean(calculateMean(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.POP)));
        representHour.setPCPMean(calculateMean(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.PCP)));
        representHour.setSNOMean(calculateMean(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.SNO)));

        
        // 표준편차 값 설정
        representHour.setATMPCelsiusSD(calculateSD(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.ATMP_CELSIUS)));
        //representHour.setTHISD(calculateSD(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.THI)));
        //representHour.setWSDSD(calculateSD(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.WSD)));
        //representHour.setSKYValidity(calculateStateValidity(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.SKY), SKY.values().length));
        //representHour.setPTYValidity(calculateStateValidity(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.PTY), PTY.values().length));
        //representHour.setPOPSD(calculateSD(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.POP)));
        //representHour.setPCPSD(calculateSD(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.PCP)));
        //representHour.setSNOSD(calculateSD(setCalculateDatas(rangedWeatherProductHours , RepresentHourType.SNO)));

        return representHour;
    }





    // ------------------------------------------------------- private method -----------------------------------------------------------




    // 수정 필요 DTO 에 들어가는 모든 시간데이터를 Date 객체로 바꾸기
    private List<WeatherProductHour> setWeatherProductsByActTime(List<WeatherProductHour> weatherProductHours , List<DateToDate> actTimeList) {
        final int APILoadDays = 3; //48시간 데이터 불러오니 이틀

        //가독성 설정
        final String today = DateToDate.now().DateToString("yyyyMMdd");
        final String tomorrow = DateToDate.tomorrow().DateToString("yyyyMMdd");
        final String afterTomorrow = DateToDate.afterTomorrow().DateToString("yyyyMMdd");
    

        // 맵형식으로 저장후 weatherProductHours 와 actTime 이 겹친다면 그것을 반환
        int[][] daysHoursCount = new int[APILoadDays][24];


        // weatherProductHours 인덱스화 
        for (WeatherProductHour weatherProductHour : weatherProductHours)
        {    
            //switch 문이 안됨
            int dayIndex = weatherProductHour.getFcstDate().equals(today) ? 0 : weatherProductHour.getFcstDate().equals(tomorrow) ? 1 : weatherProductHour.getFcstDate().equals(afterTomorrow) ? 2 : -1;
            
            int hourIndex = Integer.parseInt(weatherProductHour.getFcstTime()) / 100;

            daysHoursCount[dayIndex][hourIndex]++;
        }

        // actTime 인덱스화
        for (DateToDate actTime : actTimeList)
        {
            int dayIndex = actTime.DateToString("yyyyMMdd").equals(today) ? 0 : actTime.DateToString("yyyyMMdd").equals(tomorrow) ? 1 : actTime.DateToString("yyyyMMdd").equals(afterTomorrow) ? 2 : -1;
            
            int hourIndex = Integer.parseInt(actTime.DateToString("HH"));

            daysHoursCount[dayIndex][hourIndex]++;
        }


        // 맵 계산 후 겹치는 데이터 세트 반환
        List<WeatherProductHour> rangedWeatherProductHours = new ArrayList<>();
        
        // get(i) 에서 i를 찾기위한 ,, 맵에서 1인 가장 첫번째 인덱스 (1이 시작되는 위치에서 2가된 인덱스를 빼면 i 가 나온다)
        int startDayIndex = -1;  
        int starthourIndex = -1;
        for (int i = 0; i < daysHoursCount.length; i++)
        {
            if (startDayIndex != -1)
            {
                break;
            }

            for (int j = 0; j < daysHoursCount[i].length; j++)
            {
                if (daysHoursCount[i][j] > 0)
                {
                    startDayIndex = i;
                    starthourIndex = j;

                    break;
                }
            }
        }

        for (int i = 0; i < daysHoursCount.length; i++)
        {
            for (int j = 0; j < daysHoursCount[i].length; j++)
            {
                if (daysHoursCount[i][j] == 2)
                {
                    switch (i - startDayIndex)
                    {
                        case 0:
                            rangedWeatherProductHours.add(weatherProductHours.get(j - starthourIndex));
                            break;
                        case 1:
                            rangedWeatherProductHours.add(weatherProductHours.get(j - starthourIndex + 24));
                            break;
                        case 2:
                            rangedWeatherProductHours.add(weatherProductHours.get(j - starthourIndex + 48));
                            break;
                    }
                }
            }
        }

        return rangedWeatherProductHours;
    }



    /** 평균, 표준편차 계산전, 계산할 데이터를 모으기 위한 메서드
     * @return double[] or null 
     */ 
    private double[] setCalculateDatas(List<WeatherProductHour> weatherProductHours , RepresentHourType dataType){
        
        int index = 0;

        switch (dataType)
        {
            case ATMP_CELSIUS:
                double[] ATMPCelsiuss = new double[weatherProductHours.size()];

                for (WeatherProductHour WeatherProductHour : weatherProductHours) 
                {
                    ATMPCelsiuss[index++] = WeatherProductHour.getATMPCelsius();
                }

                return ATMPCelsiuss;

            case THI:
                try 
                {
                    double[] THIs = new double[weatherProductHours.size()];

                    for (WeatherProductHour WeatherProductHour : weatherProductHours) 
                    {
                        THIs[index++] = WeatherProductHour.getTHI();
                    }
    
                    return THIs;
                }
                catch (NullPointerException e)
                {
                    return null;
                }

            case WSD:
                double[] WSDs = new double[weatherProductHours.size()];

                for (WeatherProductHour WeatherProductHour : weatherProductHours) 
                {
                    WSDs[index++] = WeatherProductHour.getWSD();
                }

                return WSDs;

            case PTY:
                double[] PTYs = new double[weatherProductHours.size()];

                for (WeatherProductHour weatherProductHour : weatherProductHours) 
                {
                    if (weatherProductHour.getPTY() == PTY.NONE.getAPIvalue())
                    {
                        PTYs[index++] = PTY.NONE.getIndexForCalculate();
                    }
                    else if (weatherProductHour.getPTY() == PTY.RAIN.getAPIvalue())
                    {
                        PTYs[index++] = PTY.RAIN.getIndexForCalculate();
                    }
                    else if (weatherProductHour.getPTY() == PTY.RAIN_SNOW.getAPIvalue())
                    {
                        PTYs[index++] = PTY.RAIN_SNOW.getIndexForCalculate();
                    }
                    else if (weatherProductHour.getPTY() == PTY.SNOW.getAPIvalue())
                    {
                        PTYs[index++] = PTY.SNOW.getIndexForCalculate();
                    }
                    else
                    {
                        PTYs[index++] = PTY.SHOWER.getIndexForCalculate();
                    }
                }

                return PTYs;

            case SKY:
                double[] SKYs = new double[weatherProductHours.size()];

                for (WeatherProductHour weatherProductHour : weatherProductHours) 
                {
                    if (weatherProductHour.getSKY() == SKY.SUNNY.getAPIvalue())
                    {
                        SKYs[index++] = SKY.SUNNY.getIndexForCalculate();
                    }
                    else if (weatherProductHour.getSKY() == SKY.CLOUDY.getAPIvalue())
                    {
                        SKYs[index++] = SKY.CLOUDY.getIndexForCalculate();
                    }
                    else
                    {
                        SKYs[index++] = SKY.VERY_CLOUDY.getIndexForCalculate();
                    }   
                }

                return SKYs;

            case POP:
                double[] POPs = new double[weatherProductHours.size()];

                for (WeatherProductHour WeatherProductHour : weatherProductHours) 
                {
                    POPs[index++] = WeatherProductHour.getPOP();
                }

                return POPs;
            
            case PCP:
                double[] PCPs = new double[weatherProductHours.size()];

                for (WeatherProductHour WeatherProductHour : weatherProductHours)
                {
                    String temp = WeatherProductHour.getPCP();
                    switch (temp)
                    {
                        case "강수없음":
                            PCPs[index++] = PCP.NONE.getMeanValue();
                            break;
                        case "1.0mm 미만":
                            PCPs[index++] = PCP.UNDER_1MM.getMeanValue();
                            break;
                        case "30.0 mm 이상 50.0 mm 미만":
                            PCPs[index++] = PCP.UNDER_50MM.getMeanValue();
                            break;
                        case "50.0 mm 이상":
                            PCPs[index++] = PCP.OVER_50MM.getMeanValue();
                            break;
                        default :
                            // "1.0mm" ~ "29.9mm"
                            PCPs[index++] = Double.parseDouble(String.valueOf(temp.replace("mm", "")));
                            break;
                    }
                }

                return PCPs;
            
            case SNO:
                double[] SNOs = new double[weatherProductHours.size()];

                for (WeatherProductHour WeatherProductHour : weatherProductHours)
                {
                    String temp = WeatherProductHour.getSNO();
                    switch (temp)
                    {
                        case "적설없음":
                            SNOs[index++] = SNO.NONE.getMeanValue();
                            break;
                        case "1.0cm 미만":
                            SNOs[index++] = SNO.UNDER_1CM.getMeanValue();
                            break;
                        case "5.0 cm 이상":
                            SNOs[index++] = SNO.OVER_5CM.getMeanValue();
                            break;
                        default :
                            //  "1.0cm" ~ "4.9cm"
                            SNOs[index++] = Double.parseDouble(String.valueOf(temp.replace("cm", "")));
                            break;
                    }
                }

                return SNOs;
            
            default:
                return null;
        }
    }





    
    private int calculateSummerATMPCelsius(WeatherResponseHour weatherResponseHour) { 

        // 습구온도(Tw) 계산식 
        // Tw = TaATAN[0.151977(RH+8.313659)1/2] + ATAN(Ta+RH) - ATAN(RH-1.67633) + 0.00391838RH3/2ATAN(0.023101RH) - 4.686035
        
        double Tw = weatherResponseHour.getTMP() * Math.atan(0.151977 * Math.pow((weatherResponseHour.getREH() + 8.313659), 0.5))
                + Math.atan(weatherResponseHour.getTMP() + weatherResponseHour.getREH()) - Math.atan(weatherResponseHour.getREH() - 1.67633)
                + 0.00391838 * Math.pow(weatherResponseHour.getREH(), 1.5) * Math.atan(0.023101 * weatherResponseHour.getREH()) - 4.686035;


        // 여름철 체감온도 계산식 
        // 체감온도 = -0.2442 + 0.55399Tw + 0.45535Ta – 0.0022Tw2 + 0.00278TwTa + 3.0) (Ta : 기온(°C), Tw : 습구온도(Stull의 추정식** 이용), RH : 상대습도(%)
        
        return (int) Math.round(-0.2442 + 0.55399 * Tw + 0.45535 * weatherResponseHour.getTMP() - 0.0022 * Math.pow(Tw, 2)+ 0.00278 * Tw * weatherResponseHour.getTMP() + 3.0);
        
    }

    private int calculateWinterATMPCelsius(WeatherResponseHour weatherResponseHour){

        // 겨울철 체감온도 계산식
        // 체감온도 = 13.12 + 0.6215Ta - 11.37 V0.16 + 0.3965 V0.16Ta) (T : 기온(°C), V : 10분 평균 풍속(km/h)
        
        return (int) Math.round(13.12 + 0.6215 * weatherResponseHour.getTMP() - 11.37 * Math.pow(weatherResponseHour.getWSD(), 0.16)+ 0.3965 * Math.pow(weatherResponseHour.getWSD(), 0.16) * weatherResponseHour.getTMP());
    }


    private int calculateSummmerTHI(WeatherResponseHour weatherResponseHour) {

        // 여름철 불쾌지수 계산식 (불쾌지수 = 9/5Ta-0.55(1-RH)(9/5Ta-26)+32) (Ta : 건구온도 (℃), RH : 상대습도 (소수단위))
        
        return (int) Math.round(1.8 * weatherResponseHour.getTMP() - 0.55 * (1 - weatherResponseHour.getREH() / 100) * (1.8 * weatherResponseHour.getTMP() - 26) + 32);
    }



    // 평균 계산식 (값들 , 평균)
    private Double calculateMean(double[] numbers) {
        if (numbers == null)
        {
            return null;
        }

        double sum = 0;
        for (double num : numbers)
        {
            sum += num;
        }
        
        return sum / numbers.length;
    }

    // 평균계산식 (상태들 , 최빈값)
    private <T extends Enum<T>> T calculateStateMode(double[] numbers , int stateLength , Class<T> enumClass) {

        int[] state = new int[stateLength];

        for (int i = 0; i < numbers.length; i++) 
        {
            state[(int)numbers[i]]++;
        }

        int maxState = 0;
        int maxStateIndex = 0;
        for (int i = 0; i < state.length; i++) 
        {
            if (maxState < state[i]) 
            {
                maxState = state[i];
                maxStateIndex = i;
            }
        }

        T[] enumValues = enumClass.getEnumConstants();

        return enumValues[maxStateIndex];
    }

    // 표춘편차 계산식 (값들)
    private Double calculateSD(double[] numbers) {
        if (numbers == null)
        {
            return null;
        }

        double mean = calculateMean(numbers);
        
        double squaredDifferencesSum = 0;
        for (double num : numbers)
        {
            double difference = num - mean;
            squaredDifferencesSum += difference * difference;
        }
        
        double variance = squaredDifferencesSum / (numbers.length - 1);
        return Math.sqrt(variance);
    }

    
    // 얼마나 몰려있는지 타당도 계산식 (상태들)
    private boolean calculateStateValidity(double[] numbers , int stateLength) {
        int[] state = new int[stateLength];

        for (int i = 0; i < numbers.length; i++) 
        {
            state[(int)numbers[i]]++;
        }

        int maxState = 0;
        for (int i = 0; i < state.length; i++) 
        {
            if (maxState < state[i]) 
            {
                maxState = state[i];
            }
        }

        // 특정 위치에 3분의 2 보다 넘게 있다면 믿겠다고 정의
        if (maxState > numbers.length * 2 / 3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}


