package com.grileddev.thatknow.web.service;

import com.grileddev.thatknow.web.database.DBmanager;
import com.grileddev.thatknow.web.entity.areaEntity.AreaEntity;
import com.grileddev.thatknow.web.entity.weatherResponseHourEntity.WeatherResponseHourEntity;
import com.grileddev.thatknow.core.DressCodeManufacturer;
import com.grileddev.thatknow.core.DressCodeSuggestion;
import com.grileddev.thatknow.core.RepresentationJudgementForDressCode;
import com.grileddev.thatknow.core.RepresentationJudgementForType;
import com.grileddev.thatknow.core.RepresentationJudger;
import com.grileddev.thatknow.core.WeatherManufacturer;
import com.grileddev.thatknow.core.WeatherProductHour;
import com.grileddev.thatknow.core.WeatherRepresentHour;
import com.grileddev.thatknow.core.WeatherTypeSuggestion;
import com.grileddev.thatknow.util.Area;
import com.grileddev.thatknow.util.AreaToGridXY;
import com.grileddev.thatknow.util.DateToDate;
import com.grileddev.thatknow.util.GridXY;
import com.grileddev.thatknow.util.WeatherAPI;
import com.grileddev.thatknow.util.WeatherAPIParameter;
import com.grileddev.thatknow.util.WeatherResponse;
import com.grileddev.thatknow.util.WeatherResponseHour;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class service {
    @Value("${Global.Data-go-kr-api-key}")
    private String apiKey;
    
    private final DBmanager dbManager;
    private final AreaToGridXY areaToGridXY;
    private WeatherAPI api;
    private List<AreaEntity> selectAreaEntities;

    @Autowired
    public service(DBmanager dbManager, AreaToGridXY areaToGridXY) {
        this.dbManager = dbManager;
        this.areaToGridXY = areaToGridXY;
        this.api = null;
    }
    
    /***
     * How to work
     * <p>Korea Area DB에 저장된 Area를 검색합니다. 데이터가 없으면 null 반환</p>
     * @param longitudeSecondsDivide100 경도
     * @param latitudeSecondsDivide100 위도
     * @return
     */
    public List<Area> searchByArea(double longitudeSecondsDivide100, double latitudeSecondsDivide100) {
        List<AreaEntity> entitys = dbManager.findAreaByLongitudeAndLatitude(longitudeSecondsDivide100, latitudeSecondsDivide100);

        if(entitys.size() == 0)
        {
            return null;
        }
        else
        {
            List<Area> areas = new ArrayList<Area>();

            for(AreaEntity entity : entitys)
            {
                if(!entity.getTown().equals(""))
                {
                    areas.add(entity.toDTO());
                }
            }

            return areas;
        }
    }

    
    public List<Area> loadStatesFromDB() {
        selectAreaEntities = dbManager.findAreasFromDB();
        if (selectAreaEntities.size() == 0)
        {
            return null;
        }
        else
        {
            List<Area> areas = new ArrayList<Area>();

            String dupicateCheck = "";
            for (AreaEntity entity : selectAreaEntities)
            {
                if (!entity.getState().equals(dupicateCheck))
                {
                    dupicateCheck = entity.getState();
                    areas.add(entity.toDTO());
                }
            }

            return areas;
        }
    }

    public List<Area> loadCitiesByStateFromDB(String state) {
        if (selectAreaEntities.size() == 0)
        {
            return null;
        }
        else
        {
            List<Area> areas = new ArrayList<Area>();

            String dupicateCheck = "";
            for (AreaEntity entity : selectAreaEntities)
            {
                if (!entity.getCity().equals(dupicateCheck) && entity.getState().equals(state))
                {
                    dupicateCheck = entity.getCity();
                    areas.add(entity.toDTO());
                }
            }

            return areas;
        }
    }

    public List<Area> loadTownsByStateAndCityFromDB(String state, String city) {
        if (selectAreaEntities.size() == 0)
        {
            return null;
        }
        else
        {
            List<Area> areas = new ArrayList<Area>();

            String dupicateCheck = "";
            for (AreaEntity entity : selectAreaEntities)
            {
                if (!entity.getTown().equals(dupicateCheck) && entity.getState().equals(state) && entity.getCity().equals(city))
                {
                    dupicateCheck = entity.getTown();
                    areas.add(entity.toDTO());
                }
            }

            return areas;
        }
    }

    public List<String> searchByGridXY(int nx, int ny) {
        return areaToGridXY.searchByGridXY(nx, ny);
    }
    
    public GridXY searchByArea(String state, String city, String town) {
        return areaToGridXY.searchByArea(state, city, town);
    }

    public GridXY searchByState(String state) {
        return areaToGridXY.searchByState(state);
    }

    /**
     * How to work
     * <p>먼저 DB를 탐색후 데이터가 없다면 API 요청합니다.</p>
     * @param WeatherAPIParameter parameter 요청 인자
     * @return WeatherResponseHour or null
     */
    public List<WeatherResponseHour> requestWeatherResponse(WeatherAPIParameter parameter) throws UnsupportedEncodingException, IOException{
        List<WeatherResponseHourEntity> responseHoursEntity = dbManager.findResponseHoursByGridXYAndBaseDateAndBaseTime(parameter.getGridXY(), parameter.getBaseDate(), parameter.getBaseTime());

        if(responseHoursEntity.size() != 0)
        { // Response Data Exist in DB
            List<WeatherResponseHour> responseHours = new ArrayList<WeatherResponseHour>();

            for (WeatherResponseHourEntity entity : responseHoursEntity)
            {
                responseHours.add(entity.toDTO());
            }

            return responseHours;
        }
        else
        { // API Request
            if(api == null)
            {
                api = new WeatherAPI(apiKey);
            }

            WeatherResponse response = api.getResponse(parameter);
            List<WeatherResponseHour> responseHours = response.getResponseHours();
            
            dbManager.saveWeatherResponseHours(responseHours);
            return responseHours;
        }
    }

    public HashMap<String,Object> manufactureWeatherResponse(List<WeatherResponseHour> weatherResponseHours , List<DateToDate> actTimeList ,double ATMPCelsiusWeight){

        HashMap<String,Object> suggestion = new HashMap<String,Object>();

        WeatherManufacturer weatherManufacturer = WeatherManufacturer.getInstance();
        RepresentationJudger representationJudger = RepresentationJudger.getInstance();
        DressCodeManufacturer dressCodeManufacturer = DressCodeManufacturer.getInstance();

        
        List<WeatherProductHour> weatherProductHours = weatherManufacturer.getWeatherProductHours(weatherResponseHours);

        WeatherRepresentHour weatherRepresentHour = weatherManufacturer.getWeatherRepresentHour(weatherProductHours, actTimeList, ATMPCelsiusWeight);
        
        RepresentationJudgementForType representationJudgementForType = representationJudger.getRepresentationJudgementForType(weatherRepresentHour);
        RepresentationJudgementForDressCode representationJudgementForDressCode = representationJudger.getRepresentationJudgementForDressCode(weatherRepresentHour);

        WeatherTypeSuggestion weatherTypeSuggestion = dressCodeManufacturer.getWeatherTypeSuggestion(representationJudgementForType);
        DressCodeSuggestion dressCodeSuggestion = dressCodeManufacturer.getDressCodeSuggestion(representationJudgementForDressCode);


        suggestion.put("WEATHER_PRODUCT_HOURS", weatherProductHours);
        suggestion.put("WEATHER_STATE", weatherTypeSuggestion);
        suggestion.put("CLOTHING", dressCodeSuggestion);
        
        return suggestion;
    }
}