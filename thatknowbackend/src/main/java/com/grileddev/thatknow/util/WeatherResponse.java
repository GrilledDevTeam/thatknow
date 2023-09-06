package com.grileddev.thatknow.util;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class WeatherResponse {
    private List<WeatherResponseHour> responseHours;
    private String resultMsg;

    private String rawData;

    public WeatherResponse(String rawData) {
        this.rawData = rawData;
        parsingData();
    }

    private void parsingData() {
        responseHours = new ArrayList<WeatherResponseHour>();

        try
        {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(rawData);
            JSONObject weatherResponse = (JSONObject)jsonObject.get("response");
            JSONObject weatherHeader = (JSONObject)weatherResponse.get("header");
            resultMsg = (String)weatherHeader.get("resultMsg");
            // "resultCode":"00","resultMsg":"NORMAL_SERVICE"

            if (resultMsg.equals("NO_DATA"))
            {
                System.out.println("No Data Error: No weather data available.");
                return;
            }
    
            JSONObject weatherBody = (JSONObject)weatherResponse.get("body");
            // "dataType":"JSON","pageNo":1,"numOfRows":300,"totalCount":882
            JSONObject weatherItems = (JSONObject)weatherBody.get("items");
            JSONArray weatherItem = (JSONArray)weatherItems.get("item");
            // baseDate, baseTime, category, fcstDate, fcstTime, fcstValue, x, y
                        
            String fcstTime = "";
            WeatherResponseHour responseHour = new WeatherResponseHour();

            for (int i = 0; i < weatherItem.size(); i++)
            {
                JSONObject itemInfo = (JSONObject) weatherItem.get(i);

                if (((String)itemInfo.get("fcstTime")).equals(fcstTime) == false)
                {
                    if(i != 0)
                    {
                        responseHours.add(responseHour);
                        responseHour = new WeatherResponseHour();
                    }
                    
                    fcstTime = (String)itemInfo.get("fcstTime");

                    // 중복되는 데이터 선별
                    responseHour.setBaseDate((String)itemInfo.get("baseDate"));
                    responseHour.setBaseTime((String)itemInfo.get("baseTime"));
                    responseHour.setFcstDate((String)itemInfo.get("fcstDate"));
                    responseHour.setFcstTime((String)itemInfo.get("fcstTime"));
                    
                    responseHour.setNx(((Long)itemInfo.get("nx")).intValue());
                    responseHour.setNy(((Long)itemInfo.get("ny")).intValue());
                }

                String fcstValue = (String)itemInfo.get("fcstValue");

                switch ((String)itemInfo.get("category"))
                {
                    case "TMP":
                        responseHour.setTMP(Double.parseDouble(fcstValue));
                        break;
                        
                    case "TMN":
                        responseHour.setTMN(Double.parseDouble(fcstValue));
                        break;

                    case "TMX":
                        responseHour.setTMX(Double.parseDouble(fcstValue));
                        break;

                    case "SKY":
                        responseHour.setSKY(Integer.parseInt(fcstValue));
                        break;

                    case "PTY":
                        responseHour.setPTY(Integer.parseInt(fcstValue));
                        break;

                    case "POP":
                        responseHour.setPOP(Integer.parseInt(fcstValue));
                        break;

                    case "PCP":
                        responseHour.setPCP(fcstValue);
                        break;

                    case "REH":
                        responseHour.setREH(Integer.parseInt(fcstValue));
                        break;

                    case "SNO":
                        responseHour.setSNO(fcstValue);
                        break;

                    case "WSD":
                        responseHour.setWSD(Double.parseDouble(fcstValue));
                        break;

                    default:
                        break;
                }
            }
            
            responseHours.add(responseHour);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<WeatherResponseHour> getResponseHours() {
        return responseHours;
    }

    public String getRawData() {
        return rawData;
    }

    public String getResultMsg() {
        return resultMsg;
    }
}