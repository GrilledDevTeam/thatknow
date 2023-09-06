package com.grileddev.thatknow.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;


public class WeatherAPI {
    private final String strAPIKey;

    private final String strRequestUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
    private final String strDivideSector = "?";
    private final String strDivideOption = "&";
    private final String strEqueal = "=";

    /***
     * API 통신시 사용할 버퍼 사이즈
     * 기본값 16384 (char : 2bytes, 32KB)
     */
    private final int bufferSize;

    public WeatherAPI(String strAPIKey){
        this.strAPIKey = strAPIKey;
        this.bufferSize = 16384;
    }

    public WeatherAPI(String strAPIKey, int charBufferSize){
        this.strAPIKey = strAPIKey;
        this.bufferSize = charBufferSize;
    }

    /**
     * API 통신 후 JSON/XML 형태의 String 데이터 반환
     * 
     * @param parameter weather API 통신용 파라미터 클래스 입력
     * @return String 반환
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    public WeatherResponse getResponse(WeatherAPIParameter parameter) throws UnsupportedEncodingException, IOException {
        StringBuilder urlStringBuilder = new StringBuilder(strRequestUrl);
        urlStringBuilder.append(strDivideSector);

        urlStringBuilder.append("serviceKey");
        urlStringBuilder.append(strEqueal);
        urlStringBuilder.append(strAPIKey);

        urlStringBuilder.append(strDivideOption);

        urlStringBuilder.append("numOfRows");
        urlStringBuilder.append(strEqueal);
        urlStringBuilder.append(parameter.getNumOfRows());

        urlStringBuilder.append(strDivideOption);

        urlStringBuilder.append("pageNo");
        urlStringBuilder.append(strEqueal);
        urlStringBuilder.append(parameter.getPageNo());

        urlStringBuilder.append(strDivideOption);

        urlStringBuilder.append("dataType");
        urlStringBuilder.append(strEqueal);
        urlStringBuilder.append(parameter.getDataType());

        urlStringBuilder.append(strDivideOption);

        urlStringBuilder.append("base_date");
        urlStringBuilder.append(strEqueal);
        urlStringBuilder.append(parameter.getBaseDate());

        urlStringBuilder.append(strDivideOption);

        urlStringBuilder.append("base_time");
        urlStringBuilder.append(strEqueal);
        urlStringBuilder.append(parameter.getBaseTime());

        urlStringBuilder.append(strDivideOption);

        urlStringBuilder.append("nx");
        urlStringBuilder.append(strEqueal);
        urlStringBuilder.append(parameter.getNx());

        urlStringBuilder.append(strDivideOption);

        urlStringBuilder.append("ny");
        urlStringBuilder.append(strEqueal);
        urlStringBuilder.append(parameter.getNy());   
        
        URL url = new URL(urlStringBuilder.toString());

        HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
        httpConnection.setRequestMethod("GET");

        if(parameter.getDataType().equals("JSON"))
        {
            httpConnection.setRequestProperty("Content-type", "application/json");
        }
        else if(parameter.getDataType().equals("XML"))
        {
            httpConnection.setRequestProperty("Content-type", "application/xml");
        }
        
        BufferedReader bufferedReader;
        if (httpConnection.getResponseCode() >= 200 && httpConnection.getResponseCode() <= 300) 
        {
            InputStreamReader inputStreamReader = new InputStreamReader(httpConnection.getInputStream(), "UTF-8");

            bufferedReader = new BufferedReader(inputStreamReader, bufferSize);
        } 
        else 
        {
            InputStreamReader inputStreamReader = new InputStreamReader(httpConnection.getErrorStream(), "UTF-8");

            bufferedReader = new BufferedReader(inputStreamReader, bufferSize);
        }

        StringBuilder responseStringBuilder = new StringBuilder();
        String strLine;

        while ((strLine = bufferedReader.readLine()) != null) 
        {
            responseStringBuilder.append(strLine);
        }

        bufferedReader.close();
        httpConnection.disconnect();

        return new WeatherResponse(responseStringBuilder.toString());
    }
}
