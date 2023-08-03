package com.grileddev.thatknow.web.database;

import com.grileddev.thatknow.web.database.DAO.AreaDAO;
import com.grileddev.thatknow.web.database.DAO.WeatherResponseHourDAO;
import com.grileddev.thatknow.web.database.repository.koreaAreaRepository.KoreaAreaRepository;
import com.grileddev.thatknow.web.database.repository.koreaWeatherRepository.KoreaWeatherRepository;
import com.grileddev.thatknow.web.entity.areaEntity.AreaEntity;
import com.grileddev.thatknow.web.entity.weatherResponseHourEntity.WeatherResponseHourEntity;
import com.grileddev.thatknow.util.GridXY;
import com.grileddev.thatknow.util.WeatherResponse;
import com.grileddev.thatknow.util.WeatherResponseHour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class DBmanager implements WeatherResponseHourDAO, AreaDAO {
    @Autowired
    private KoreaAreaRepository koreaAreaRepository;

    @Autowired
    private KoreaWeatherRepository koreaWeatherRepository;


    //*** AreaDAO */
    @Override
    public void saveArea(AreaEntity areaEntity){
        koreaAreaRepository.save(areaEntity);
    }

    @Override
    public AreaEntity findAreaByAreaId(String areaCode){
        return koreaAreaRepository.findDataByAreaCode(areaCode);
    }

    @Override
    public AreaEntity findAreaByArea(String state, String city, String town){
        AreaEntity areaEntity = koreaAreaRepository.findAllByStateAndCityAndTown(state, city, town);
        return areaEntity;
    }
    

    //*** WeatherResponseHourDAO */
    @Override
    public void saveWeatherResponse(WeatherResponse weatherResponse){
        saveWeatherResponseHours(weatherResponse.getResponseHours());
    }

    @Override
    public void saveWeatherResponseHours(List<WeatherResponseHour> weatherResponseHours){
        for (int i = 0; i < weatherResponseHours.size(); i++)
        {
            koreaWeatherRepository.save(weatherResponseHours.get(i).toEntity());
        }
    }

    @Override
    public List<WeatherResponseHourEntity> findResponseHoursByAreaAndBaseDateAndBaseTime(String state, String city, String town, String baseDate, String baseTime){
        AreaEntity areaEntity = koreaAreaRepository.findAllByStateAndCityAndTown(state, city, town);
        return findResponseHoursByXYAndBaseDateAndBaseTime(areaEntity.getNx(), areaEntity.getNy(), baseDate, baseTime);
    }
    
    @Override
    public List<WeatherResponseHourEntity> findResponseHoursByGridXYAndBaseDateAndBaseTime(GridXY gridXY, String baseDate, String baseTime){
        return findResponseHoursByXYAndBaseDateAndBaseTime(gridXY.getX(), gridXY.getY(), baseDate, baseTime);
    }

    @Override
    public List<WeatherResponseHourEntity> findResponseHoursByXYAndBaseDateAndBaseTime(String nx, String ny, String baseDate, String baseTime){
        return koreaWeatherRepository.findAllByNxAndNyAndBaseDateAndBaseTime(nx, ny, baseDate, baseTime);
    }
}