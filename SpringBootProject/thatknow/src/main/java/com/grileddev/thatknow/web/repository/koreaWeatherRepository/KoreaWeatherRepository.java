package com.grileddev.thatknow.web.repository.koreaWeatherRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grileddev.thatknow.web.entity.weatherResponseHourEntity.WeatherResponseHourEntity;



public interface KoreaWeatherRepository extends JpaRepository<WeatherResponseHourEntity, String> {

}