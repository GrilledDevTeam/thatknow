package com.grileddev.thatknow.web.database.repository.koreaWeatherRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grileddev.thatknow.web.entity.weatherResponseHourEntity.WeatherResponseHourEntity;

import java.util.List;


public interface KoreaWeatherRepository extends JpaRepository<WeatherResponseHourEntity, String> {
    public List<WeatherResponseHourEntity> findAllByNxAndNyAndBaseDateAndBaseTime(Integer nx, Integer ny, String baseDate, String baseTime);
    // public int countByNxAndNyAndBaseDateAndBaseTime(String nx, String ny, String baseDate, String baseTime); 
}