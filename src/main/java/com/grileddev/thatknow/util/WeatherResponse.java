package com.grileddev.thatknow.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WeatherResponse {
    private WeatherResponseHour[] responseHours;
    private String rawData;

    public WeatherResponse(String rawData) {
        this.rawData = rawData;
        parsingData(rawData);
    }

    private void parsingData(String ApiData) {
        responseHours = new WeatherResponseHour[24];
        String[] hourDataList = new String [24];

        for (int i = 0; i < hourDataList.length; i++) 
        {
            hourDataList[i] = "";
        }

        try
        {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(ApiData);
            JSONObject weatherResponse = (JSONObject)jsonObject.get("response");
            // JSONObject weatherHeader = (JSONObject)weatherResponse.get("header");
            // "resultCode":"00","resultMsg":"NORMAL_SERVICE"
    
            JSONObject weatherBody = (JSONObject)weatherResponse.get("body");
            // "dataType":"JSON","pageNo":1,"numOfRows":300,"totalCount":882
            JSONObject weatherItems = (JSONObject)weatherBody.get("items");
            JSONArray weatherItem = (JSONArray)weatherItems.get("item");
            // baseDate, baseTime, category, fcstDate, fcstTime, fcstValue, x, y
            
            StringBuilder dataStringBuilder = new StringBuilder();
            
            String temp = "0000";
            for (int i = 0; i < weatherItem.size(); i++)
            {
                JSONObject itemInfo = (JSONObject) weatherItem.get(i);

                if ((String)itemInfo.get("fcstTime") == temp)
                {
                    dataStringBuilder.append((String)itemInfo.get("baseDate"));
                    dataStringBuilder.append("/");
                    dataStringBuilder.append((String)itemInfo.get("baseTime"));
                    dataStringBuilder.append("/");
                    dataStringBuilder.append((String)itemInfo.get("fcstDate"));
                    dataStringBuilder.append("/");
                    dataStringBuilder.append((String)itemInfo.get("fcstTime"));
                    dataStringBuilder.append("/");
                    dataStringBuilder.append(String.valueOf(itemInfo.get("nx")));
                    dataStringBuilder.append("/");
                    dataStringBuilder.append(String.valueOf(itemInfo.get("ny")));
                    dataStringBuilder.append("/");
                    dataStringBuilder.append((String)itemInfo.get("category"));
                    dataStringBuilder.append("/");
                    dataStringBuilder.append((String)itemInfo.get("fcstValue"));
                    dataStringBuilder.append("/");

                    // fcstTime(temp) 데이터가 100 단위로 파싱되므로 100으로 나눠 한 자리수의 정수로 바꿔줌
                    int index = Integer.parseInt(temp) / 100; 
                    hourDataList[index] += dataStringBuilder.toString();

                    temp = (String)itemInfo.get("fcstTime");
                }
                else
                {
                    dataStringBuilder.setLength(0);

                    temp = (String)itemInfo.get("fcstTime");

                    dataStringBuilder.append((String)itemInfo.get("baseDate"));
                    dataStringBuilder.append("/");
                    dataStringBuilder.append((String)itemInfo.get("baseTime"));
                    dataStringBuilder.append("/");
                    dataStringBuilder.append((String)itemInfo.get("fcstDate"));
                    dataStringBuilder.append("/");
                    dataStringBuilder.append((String)itemInfo.get("fcstTime"));
                    dataStringBuilder.append("/");
                    dataStringBuilder.append(String.valueOf(itemInfo.get("nx")));
                    dataStringBuilder.append("/");
                    dataStringBuilder.append(String.valueOf(itemInfo.get("ny")));
                    dataStringBuilder.append("/");
                    dataStringBuilder.append((String)itemInfo.get("category"));
                    dataStringBuilder.append("/");
                    dataStringBuilder.append((String)itemInfo.get("fcstValue"));
                    dataStringBuilder.append("/");

                    int index = Integer.parseInt(temp) / 100;
                    hourDataList[index] += dataStringBuilder.toString();
                }
            }

            for (int i = 0; i < hourDataList.length; i++) 
            {
                if (!hourDataList[i].isEmpty())
                {
                    responseHours[i] = new WeatherResponseHour(hourDataList[i]);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public WeatherResponseHour[] getHoursResponse() {
        return responseHours;
    }

    public String getRawData() {
        return rawData;
    }
}