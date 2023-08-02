package com.grileddev.thatknow.web.controller;

import com.grileddev.thatknow.util.AreaToGridXY;
import com.grileddev.thatknow.util.DateToDate;
import com.grileddev.thatknow.util.WeatherAPI;
import com.grileddev.thatknow.util.WeatherAPIParameter;
import com.grileddev.thatknow.util.WeatherResponse;
import com.grileddev.thatknow.util.WeatherResponseHour;
import com.grileddev.thatknow.web.database.DBmanager;

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

    private final DBmanager dbManager;
    private final AreaToGridXY areaToGridXY;


    @Autowired
    public controller(DBmanager dbManager, AreaToGridXY areaToGridXY) {
        this.dbManager = dbManager;
        this.areaToGridXY = areaToGridXY;
    }
    
    @GetMapping("/")
    public String main(){
        return "main";
    }


    @PostMapping("/test")
    public String mainTest(String stateAndCityAndTown, String time, Model model) throws IOException {
        WeatherAPI api = new WeatherAPI(apiKey);
        WeatherAPIParameter parameter = new WeatherAPIParameter();

        parameter.setBaseDate(DateToDate.DateToString(DateToDate.yesterday()));
        parameter.setBaseTime(time);

        // parameter.setNumOfRowsByTime("20230731", "2300", 290);
        // parameter.setGridXY(areaToGridXY.searchByStateAndCityAndTown(stateAndCityAndTown));
        parameter.setGridXY(dbManager.findDataByArea(stateAndCityAndTown));
        
        WeatherResponse response = api.getResponse(parameter);
        WeatherResponseHour[] hoursResponse = response.getHoursResponse();
    

        List<WeatherResponseHour> result = new ArrayList<WeatherResponseHour>();
        for (int i = 0; i < 24; i++)
        {
            result.add(i, hoursResponse[i]);
        }
        model.addAttribute("responseData", result);

        return "main";
    }
}
