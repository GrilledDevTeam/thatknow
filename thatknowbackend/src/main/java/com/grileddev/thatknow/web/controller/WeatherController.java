package com.grileddev.thatknow.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grileddev.thatknow.util.Area;
import com.grileddev.thatknow.util.DateToDate;
import com.grileddev.thatknow.util.GridXY;
import com.grileddev.thatknow.util.WeatherAPIParameter;
import com.grileddev.thatknow.util.WeatherResponseHour;
import com.grileddev.thatknow.web.service.service;

@RestController
public class WeatherController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello World";
    }

    @Autowired
    private service service;
    

    @PostMapping("/api/searchAreaBylongitudeAndLatitude")
    public ResponseEntity<Object> searchArea(double longitudeSecondsDivide100, double latitudeSecondsDivide100){
        // longitudeSecondsDivide100 = 126.5092923;
        // latitudeSecondsDivide100 = 33.4649;

        List<Area> areas = service.searchByArea(longitudeSecondsDivide100, latitudeSecondsDivide100);

        if (areas == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found Area");
        }
        else
        {
            return ResponseEntity.ok(areas);
        }
    }

    
    @PostMapping("/api/searchWeatherByArea")
    @ResponseBody
    public ResponseEntity<Object> searchWeatherByArea(String state, String city, String town) {
        WeatherAPIParameter parameter = new WeatherAPIParameter();

        parameter.setRecentlyBaseTimeAndBaseDate();
        parameter.setNumOfRowsByBaseDateAfterHours(48);

        GridXY area = null;
        
        if (city == null || town == null)
        {
            area = service.searchByState(state);
            // area = new GridXY(28, 8);
        } 
        else 
        {
            area = service.searchByArea(state, city, town);
        }

        if(area == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found Area");
        }
        parameter.setGridXY(area);

        try
        {
            List<WeatherResponseHour> hoursResponse = service.requestWeatherResponse(parameter);
            return ResponseEntity.ok(hoursResponse);
        }
        catch (Exception exception)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @PostMapping("/api/searchWeatherByGridXY")
    @ResponseBody
    public ResponseEntity<Object> searchWeatherByGridXY(int nx, int ny) {
        WeatherAPIParameter parameter = new WeatherAPIParameter();

        parameter.setRecentlyBaseTimeAndBaseDate();
        parameter.setNumOfRowsByBaseDateAfterHours(48);
        parameter.setXY(nx, ny);

        try
        {
            List<WeatherResponseHour> hoursResponse = service.requestWeatherResponse(parameter);
            return ResponseEntity.ok(hoursResponse);
        }
        catch (Exception exception)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }
    

    @GetMapping("/api/loadStatesFromDB")
    public ResponseEntity<Object> loadStatesFromDB() {
        List<Area> areas = service.loadStatesFromDB();

        if (areas == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found State");
        }
        else
        {
            return ResponseEntity.ok(areas);
        }
    }

    @GetMapping("/api/loadCitiesFromDB")
    public ResponseEntity<Object> loadCitiesByStateFromDB(String state) {
        List<Area> areas = service.loadCitiesByStateFromDB(state);

        if (areas == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found City");
        }
        else
        {
            return ResponseEntity.ok(areas);
        }
    }

    @GetMapping("/api/loadTownsFromDB")
    public ResponseEntity<Object> loadTownsByStateAndCityFromDB(String state, String city) {
        List<Area> areas = service.loadTownsByStateAndCityFromDB(state, city);

        if (areas == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found Town");
        }
        else
        {
            return ResponseEntity.ok(areas);
        }
    }

    
    

    @PostMapping("/api/searchByGridXY")
    @ResponseBody
    public ResponseEntity<Object> searchByGridXY(int nx, int ny, String startActTime, String endActTime, int ATMPCelsiusWeight) {

        WeatherAPIParameter parameter = new WeatherAPIParameter();

        parameter.setRecentlyBaseTimeAndBaseDate();
        parameter.setNumOfRowsByBaseDateAfterHours(48);
        parameter.setXY(nx, ny);

        List<WeatherResponseHour> weatherResponseHours;
        try
        {
            weatherResponseHours = service.requestWeatherResponse(parameter);
        }
        catch (Exception exception)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }

        // 임시 나중에 수정예정
        List<DateToDate> actTimeList = new ArrayList<DateToDate>();
        for (DateToDate actTime = DateToDate.date(startActTime, "yyyyMMddHH"); !actTime.DateToString("yyyyMMddHH").equals(endActTime); actTime.afterHours((long)1))
        {
            actTimeList.add(DateToDate.date(actTime.DateToString("yyyyMMddHH"), "yyyyMMddHH"));
        }
        actTimeList.add(DateToDate.date(endActTime, "yyyyMMddHH"));

        HashMap<String, Object> suggestion = service.manufactureWeatherResponse(weatherResponseHours, actTimeList , ATMPCelsiusWeight);
        

        return ResponseEntity.ok(suggestion);
    }


    @PostMapping("/api/searchByArea")
    @ResponseBody
    public ResponseEntity<Object> searchByArea(String state, String city, String town, String startActTime, String endActTime, int ATMPCelsiusWeight) {
        
        WeatherAPIParameter parameter = new WeatherAPIParameter();

        parameter.setRecentlyBaseTimeAndBaseDate();
        parameter.setNumOfRowsByBaseDateAfterHours(48);

        GridXY area = service.searchByArea(state, city, town);
        if(area == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found Area");
        }
        parameter.setGridXY(area);


        List<WeatherResponseHour> weatherResponseHour;
        try 
        {
            weatherResponseHour = service.requestWeatherResponse(parameter);
        }
        catch (Exception exception)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
        
        // 임시 나중에 수정예정
        List<DateToDate> actTimeList = new ArrayList<DateToDate>();
        for (DateToDate actTime = DateToDate.date(startActTime, "yyyyMMddHH"); !actTime.DateToString("yyyyMMddHH").equals(endActTime); actTime.afterHours((long)1))
        {
            actTimeList.add(DateToDate.date(actTime.DateToString("yyyyMMddHH"), "yyyyMMddHH"));
        }
        actTimeList.add(DateToDate.date(endActTime, "yyyyMMddHH"));

        HashMap<String, Object> suggestion = service.manufactureWeatherResponse(weatherResponseHour, actTimeList, ATMPCelsiusWeight);
        

        return ResponseEntity.ok(suggestion);
    }
}
