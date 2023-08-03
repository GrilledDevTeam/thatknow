package com.grileddev.thatknow.web.service;

import com.grileddev.thatknow.web.database.DBmanager;
import com.grileddev.thatknow.web.entity.weatherResponseHourEntity.WeatherResponseHourEntity;
import com.grileddev.thatknow.util.AreaToGridXY;
import com.grileddev.thatknow.util.GridXY;
import com.grileddev.thatknow.util.WeatherAPI;
import com.grileddev.thatknow.util.WeatherAPIParameter;
import com.grileddev.thatknow.util.WeatherResponse;
import com.grileddev.thatknow.util.WeatherResponseHour;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class service {
    @Value("${Global.Data-go-kr-api-key}")
    private String apiKey;
    
    private final DBmanager dbManager;
    private final AreaToGridXY areaToGridXY;
    private WeatherAPI api;

    @Autowired
    public service(DBmanager dbManager, AreaToGridXY areaToGridXY) {
        this.dbManager = dbManager;
        this.areaToGridXY = areaToGridXY;
        this.api = null;
    }

    
    public GridXY searchByArea(String state, String city, String town) {
        return areaToGridXY.searchByArea(state, city, town);
    }

    /**
     * How to work
     * <p>먼저 DB를 탐색후 데이터가 없다면 API 요청합니다.</p>
     * @param WeatherAPIParameter parameter 요청 인자
     * @return WeatherResponseHour or null
     */
    public List<WeatherResponseHour> weatherResponseRequest(WeatherAPIParameter parameter) throws UnsupportedEncodingException, IOException{
        List<WeatherResponseHourEntity> responseHoursEntity = dbManager.findResponseHoursByGridXYAndBaseDateAndBaseTime(parameter.getGridXY(), parameter.getBaseDate(), parameter.getBaseTime());

        if(responseHoursEntity.size() != 0)
        { // Response Data Exist in DB
            List<WeatherResponseHour> responseHours = new ArrayList<WeatherResponseHour>();

            for (WeatherResponseHourEntity entity : responseHoursEntity)
            {
                responseHours.add(entity.toResponseDTO());
            }

            return responseHours;
        }
        else
        { // API Request
            if(api == null)
            {
                api = new WeatherAPI(apiKey);
            }

            WeatherResponse response = api.getResponse(parameter);
            dbManager.saveWeatherResponse(response);
            
            List<WeatherResponseHour> responseHours = response.getResponseHours();
            return responseHours;
        }
    }
}
