package com.grileddev.thatknow.web.controller;

import com.grileddev.thatknow.util.GridXY;
import com.grileddev.thatknow.util.DateToDate;
import com.grileddev.thatknow.util.WeatherAPIParameter;
import com.grileddev.thatknow.util.WeatherResponseHour;
import com.grileddev.thatknow.web.service.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@ComponentScan(basePackages={"com.grileddev.thatknow.util"})
public class controller {
    @Autowired
    private service service;


    @GetMapping("weather")
    public String main(){
        return "areaWeather";
    }


    @PostMapping("searchAreaWeather")
    public String loadWeather(Model model, String state, String city, String town, String baseTime) throws IOException {
        WeatherAPIParameter parameter = new WeatherAPIParameter();

        parameter.setBaseDate(DateToDate.DateToString(DateToDate.yesterday()));
        parameter.setBaseTime(baseTime);

        GridXY area = service.searchByArea(state, city, town);
        if(area == null)
        {
            System.out.println("지역을 찾을 수 없습니다.");
            return "areaWeather";
        }
        parameter.setGridXY(area);
        
        try
        {
            List<WeatherResponseHour> hoursResponse = service.weatherResponseRequest(parameter);
        
            model.addAttribute("response", hoursResponse);
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }

        return "areaWeather";
    }
}
