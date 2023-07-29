package com.grileddev.thatknow.web.controller;

import com.grileddev.thatknow.util.AreaToCoordinate;
import com.grileddev.thatknow.util.DateToDate;
import com.grileddev.thatknow.util.WeatherAPI;
import com.grileddev.thatknow.util.WeatherAPIParameter;
import com.grileddev.thatknow.util.WeatherResponse;
import com.grileddev.thatknow.util.WeatherResponseHour;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Value;


@Controller
@ComponentScan(basePackages={"com.grileddev.thatknow.util"})
public class controller {
    @Value("${Global.Data-go-kr-api-key}")
    private String apiKey;

    @Autowired
    AreaToCoordinate areaToCoordinate;

    @GetMapping("/")
    public String main(){
        return "main";
    }


    @PostMapping("/test")
    public String mainTest(String stateAndCityAndTown, String time, Model model) throws IOException {

        DateToDate dateToDate = new DateToDate();
        dateToDate.setTimeForAPIParameter(time);

        areaToCoordinate.setCoordinateByAreaName(stateAndCityAndTown);


        WeatherAPI api = new WeatherAPI(apiKey);
        WeatherAPIParameter apiParameter = new WeatherAPIParameter();
        
        apiParameter.setNumOfRows("290");
        apiParameter.setNx(areaToCoordinate.getNx());
        apiParameter.setNy(areaToCoordinate.getNy());

        
        WeatherResponse response = api.getWeatherData(apiParameter);
        WeatherResponseHour[] result = response.getResponseDataList();
        

        //response 데이터를 Model 에 넘기기
        //thymeleaf each 문 사용하려면 컬렉션으로 넘겨야 한다네요
        List<WeatherResponseHour> result2 = new ArrayList<WeatherResponseHour>();
        for (int i = 0; i < 24; i++)
        {
           result2.add(i,result[i]);
        }

        model.addAttribute("responseData", result2);

        return "main";
    }
}
