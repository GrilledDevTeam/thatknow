package com.grileddev.thatknow.util;

import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;

import com.grileddev.thatknow.web.database.DBmanager;


public class AreaToGridXY{

    @Autowired
    private DBmanager dbManager;
    
    
    public DBmanager getDB() {
        return dbManager;
    }

    /**
     * 지역 이름으로 격자 좌표를 검색
     * @param stateAndCityAndTown state&city&town으로 구분된 지역이름
     * @return GridXY or null
     */
    public GridXY searchByStateAndCityAndTown(String stateAndCityAndTown){
        StringTokenizer tokenizer = new StringTokenizer(stateAndCityAndTown, "&");

        tokenizer.nextToken(); // state
        tokenizer.nextToken(); // city
        tokenizer.nextToken(); // town
        
        // How to use...
        // AreaEntity findedAreaEntity = repository.findAllByStateAndCityAndTown(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
        

        // 밑은 예시에 불과하고 실제로는 DB에서 데이터를 찾을때 반환되는 값이 null일때를 기준으로 나눠야겠죠?
        boolean exist = true;
        if (exist)
        {
            String x = "0";
            String y = "0";

            return new GridXY(x, y);
        }
        else
        {
            return null;
        }
    }


    /**
     * 지역 이름으로 격자 좌표를 검색
     * @param state 도/특별시/광역시
     * @param city  시/군/구
     * @param town 읍/동/면
     * @return GridXY or null
     */
    public GridXY searchByArea(String state , String city, String town){
        // 지역이름을 통해 DB를 검색

        // 밑은 예시에 불과하고 실제로는 DB에서 데이터를 찾을때 반환되는 값이 null일때를 기준으로 나눠야겠죠?

        boolean exist = true;
        if (exist)
        {
            String x = "0";
            String y = "0";

            return new GridXY(x, y);
        }
        else
        {
            return null;
        }
    }

    /**
     * 경도,위도를 이용하여 격자 좌표를 검색
     * @param longitude 경도
     * @param latitude 위도
     */
    public GridXY searchByLongitudeAndLatitude(String longitude, String latitude){
        // 경도 위도로 DBManger에서 찾은 후 x, y 반환

        // 밑은 예시에 불과하고 실제로는 DB에서 데이터를 찾을때 반환되는 값이 null일때를 기준으로 나눠야겠죠?
        boolean exist = true;
        if (exist)
        {
            String x = "0";
            String y = "0";

            return new GridXY(x, y);
        }
        else
        {
            return null;
        }
    }
}
