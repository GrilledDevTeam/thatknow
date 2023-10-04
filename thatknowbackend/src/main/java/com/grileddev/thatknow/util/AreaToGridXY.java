package com.grileddev.thatknow.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.grileddev.thatknow.web.database.DBmanager;
import com.grileddev.thatknow.web.entity.areaEntity.AreaEntity;

import java.util.List;
import java.util.ArrayList;

public class AreaToGridXY{

    @Autowired
    private DBmanager dbManager;
    

    /**
     * 지역 이름으로 격자 좌표를 검색
     * @param state 도/특별시/광역시
     * @param city  시/군/구
     * @param town 읍/동/면
     * @return GridXY or null
     */
    public GridXY searchAreaByStateAndCityAndTown(String state , String city, String town){
        AreaEntity area = dbManager.findAreaByArea(state, city, town);

        if (area == null)
        {
            return null;
        }
        else
        {
            return new GridXY(area.getNx(), area.getNy());
        }
    }

    public GridXY searchAreaByState(String state){
        List<AreaEntity> area = dbManager.findAreaByState(state);

        if (area == null)
        {
            return null;
        }
        else
        {
            int x = 0;
            int y = 0;

            for (int i = 0; i < area.size(); i++)
            {
                x = area.get(i).getNx();
                y = area.get(i).getNy();
            }

            return new GridXY(x, y);
        }
    }

    public List<String> searchAreaByGridXY(int nx, int ny){
        List<AreaEntity> area = dbManager.findAreaByNxNy(nx, ny);

        if (area == null)
        {
            return null;
        }
        else
        {
            List<String> areas = new ArrayList<String>();
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < area.size(); i++)
            {
                stringBuilder.setLength(0);

                stringBuilder.append(area.get(i).getState());
                stringBuilder.append(" ");

                stringBuilder.append(area.get(i).getCity());
                stringBuilder.append(" ");

                stringBuilder.append(area.get(i).getTown());

                areas.add(stringBuilder.toString());
            }

            return areas;
        }
    }

    /**
     * 경도,위도를 이용하여 격자 좌표를 검색
     * @param longitude 경도
     * @param latitude 위도
     */
    public GridXY searchAreaByLongitudeAndLatitude(String longitude, String latitude){
        // 경도 위도로 DBManger에서 찾은 후 x, y 반환

        // 밑은 예시에 불과하고 실제로는 DB에서 데이터를 찾을때 반환되는 값이 null일때를 기준으로 나눠야겠죠?
        boolean exist = true;
        if (exist)
        {
            int x = 0;
            int y = 0;

            return new GridXY(x, y);
        }
        else
        {
            return null;
        }
    }
}
