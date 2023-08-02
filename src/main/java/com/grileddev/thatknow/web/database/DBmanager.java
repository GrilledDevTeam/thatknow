package com.grileddev.thatknow.web.database;

import com.grileddev.thatknow.web.DAO.WeatherResponseHourDAO;
import com.grileddev.thatknow.web.entity.areaEntity.AreaEntity;
import com.grileddev.thatknow.web.entity.weatherResponseHourEntity.WeatherResponseHourEntity;
import com.grileddev.thatknow.web.repository.koreaAreaRepository.KoreaAreaRepository;
import com.grileddev.thatknow.web.repository.koreaWeatherRepository.KoreaWeatherRepository;
import com.grileddev.thatknow.util.GridXY;
import com.grileddev.thatknow.util.WeatherResponseHour;

import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;



public class DBmanager implements WeatherResponseHourDAO {
    @Autowired
    private KoreaAreaRepository koreaAreaRepository;

    @Autowired
    private KoreaWeatherRepository koreaWeatherRepository;

    private WeatherResponseHourEntity[] weatherResponseHourEntityList;
    
    
    public DBmanager() {
        weatherResponseHourEntityList = new WeatherResponseHourEntity[24];
    }

    @Override
    public void saveWeatherData(WeatherResponseHour[] weatherResponseHourList) {
        for (int i = 0; i < weatherResponseHourList.length; i++)
        {
            weatherResponseHourEntityList[i] = weatherResponseHourList[i].toEntity();

            // pk 설정
            String keyX = weatherResponseHourEntityList[i].getNx();
            String keyY = weatherResponseHourEntityList[i].getNy();
            String keyDate = weatherResponseHourEntityList[i].getBaseDate();
            String keyTime = weatherResponseHourEntityList[i].getBaseTime();

            int primaryKey = Integer.parseInt(keyX + keyY + keyDate + keyTime) + i;
            // ID = x + y + baseDate + baseTime + i(인덱스)   ex) (53 37 20230725 2300) + 1   1시 예측 데이터 키

            weatherResponseHourEntityList[i].setId(primaryKey); 

            koreaWeatherRepository.save(weatherResponseHourEntityList[i]);
        }
    }

    @Override
    public WeatherResponseHourEntity findDataByNxAndNyAndFcstTime(String stateAndCityAndTown, String fcstDate) {
        StringTokenizer tokenizer = new StringTokenizer(stateAndCityAndTown, "&");

        AreaEntity areaEntity = koreaAreaRepository.findAllByStateAndCityAndTown(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());

        return koreaWeatherRepository.findDataByNxAndNyAndFcstTime(areaEntity.getNx(), areaEntity.getNy(), fcstDate);
    }
    
    @Override
    public GridXY findDataByArea(String stateAndCityAndTown){

        StringTokenizer tokenizer = new StringTokenizer(stateAndCityAndTown, "&");

        AreaEntity findedAreaEntity = koreaAreaRepository.findAllByStateAndCityAndTown(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());

        return new GridXY(findedAreaEntity.getNx(), findedAreaEntity.getNy());
    }
}