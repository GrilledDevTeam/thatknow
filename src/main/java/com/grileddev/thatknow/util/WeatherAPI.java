package com.grileddev.thatknow.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class WeatherAPI {
    private final String apiKey;


    public WeatherAPI(String apiKey){
        this.apiKey = apiKey;
    }

    public WeatherResponse getWeatherData(WeatherAPIParameter parameter) throws UnsupportedEncodingException, IOException{
        final String strRequestUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
        final String strDivideSector = "?";
        final String strDivideOption = "&";
        final String strEqual = "=";

        StringBuilder urlStringBuilder = new StringBuilder(strRequestUrl);
        urlStringBuilder.append(strDivideSector);

        urlStringBuilder.append(URLEncoder.encode("serviceKey", "UTF-8"));
        urlStringBuilder.append(strEqual);
        urlStringBuilder.append(apiKey);

        urlStringBuilder.append(strDivideOption);

        urlStringBuilder.append(URLEncoder.encode("numOfRows", "UTF-8"));
        urlStringBuilder.append(strEqual);
        urlStringBuilder.append(URLEncoder.encode(parameter.getNumOfRows(), "UTF-8"));

        urlStringBuilder.append(strDivideOption);

        urlStringBuilder.append(URLEncoder.encode("pageNo", "UTF-8"));
        urlStringBuilder.append(strEqual);
        urlStringBuilder.append(URLEncoder.encode(parameter.getPageNo(), "UTF-8"));
        
        urlStringBuilder.append(strDivideOption);

        urlStringBuilder.append(URLEncoder.encode("dataType", "UTF-8"));
        urlStringBuilder.append(strEqual);
        urlStringBuilder.append(URLEncoder.encode(parameter.getDataType(), "UTF-8"));
        
        urlStringBuilder.append(strDivideOption);

        urlStringBuilder.append(URLEncoder.encode("base_date", "UTF-8"));
        urlStringBuilder.append(strEqual);
        urlStringBuilder.append(URLEncoder.encode(parameter.getBaseDate(), "UTF-8"));

        urlStringBuilder.append(strDivideOption);

        urlStringBuilder.append(URLEncoder.encode("base_time", "UTF-8"));
        urlStringBuilder.append(strEqual);
        urlStringBuilder.append(URLEncoder.encode(parameter.getBaseTime(), "UTF-8"));

        urlStringBuilder.append(strDivideOption);

        urlStringBuilder.append(URLEncoder.encode("nx", "UTF-8"));
        urlStringBuilder.append(strEqual);
        urlStringBuilder.append(URLEncoder.encode(parameter.getNx(), "UTF-8"));
        
        urlStringBuilder.append(strDivideOption);

        urlStringBuilder.append(URLEncoder.encode("ny", "UTF-8"));
        urlStringBuilder.append(strEqual);
        urlStringBuilder.append(URLEncoder.encode(parameter.getNy(), "UTF-8"));
        
        URL url = new URL(urlStringBuilder.toString());

        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.setRequestMethod("GET");
        httpConnection.setRequestProperty("Content-type", "application/json");
        

        BufferedReader bufferedReader;

        if (httpConnection.getResponseCode() >= 200 && httpConnection.getResponseCode() <= 300) 
        {
            bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream() , "UTF-8"));
        } 
        else 
        {
            bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream() , "UTF-8"));
        }

        StringBuilder dataStringBuilder = new StringBuilder();
        String strLine;

        while ((strLine = bufferedReader.readLine()) != null) 
        {
            dataStringBuilder.append(strLine);
        }

        bufferedReader.close();
        httpConnection.disconnect();

        return new WeatherResponse(dataStringBuilder.toString());
    }
}
