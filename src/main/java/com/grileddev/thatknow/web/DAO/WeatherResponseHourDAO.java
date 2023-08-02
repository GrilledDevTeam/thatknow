package com.grileddev.thatknow.web.DAO;

import com.grileddev.thatknow.util.GridXY;
import com.grileddev.thatknow.util.WeatherResponseHour;
import com.grileddev.thatknow.web.entity.weatherResponseHourEntity.WeatherResponseHourEntity;

public interface WeatherResponseHourDAO  {
    public void saveWeatherData(WeatherResponseHour[] weatherResponseHourDatas);

    public WeatherResponseHourEntity findDataByNxAndNyAndFcstTime(String stateAndCityAndTown, String date);

    public GridXY findDataByArea(String stateAndCityAndTown);
}
