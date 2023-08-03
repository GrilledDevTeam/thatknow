package com.grileddev.thatknow.web.database.DAO;

import java.util.List;

import com.grileddev.thatknow.util.GridXY;
import com.grileddev.thatknow.util.WeatherResponse;
import com.grileddev.thatknow.util.WeatherResponseHour;
import com.grileddev.thatknow.web.entity.weatherResponseHourEntity.WeatherResponseHourEntity;

public interface WeatherResponseHourDAO  {
    public void saveWeatherResponse(WeatherResponse weatherResponse);
    public void saveWeatherResponseHours(List<WeatherResponseHour> weatherResponseHours);


    public List<WeatherResponseHourEntity> findResponseHoursByAreaAndBaseDateAndBaseTime(String state, String city, String town, String baseDate, String baseTime);
    public List<WeatherResponseHourEntity> findResponseHoursByGridXYAndBaseDateAndBaseTime(GridXY gridXY, String baseDate, String baseTime);
    public List<WeatherResponseHourEntity> findResponseHoursByXYAndBaseDateAndBaseTime(String nx, String ny, String baseDate, String baseTime);
}
