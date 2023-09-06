package com.grileddev.thatknow.util;

import com.grileddev.thatknow.web.entity.areaEntity.AreaEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class Area {
    private Long areaCode;
 
    private String state;
    private String city;
    private String town;
    
    private int nx;
    private int ny;
    
    private int longitudeDegrees;
    private int longitudeMinutes;
    private double longitudeSeconds;
    
    private int latitudeDegrees;
    private int latitudeMinutes;
    private double latitudeSeconds;

    private double longitudeSecondsDivide100;
    private double latitudeSecondsDivide100;

    private String updateDate;

    public Area() {
    }


    public AreaEntity toEntity() {
        return AreaEntity.builder()
        .areaCode(areaCode)
        .state(state)
        .city(city)
        .town(town)
        .nx(nx)
        .ny(ny)
        .longitudeDegrees(longitudeDegrees)
        .longitudeMinutes(longitudeMinutes)
        .longitudeSeconds(longitudeSeconds)
        .latitudeDegrees(latitudeDegrees)
        .latitudeMinutes(latitudeMinutes)
        .latitudeSeconds(latitudeSeconds)
        .longitudeSecondsDivide100(longitudeSecondsDivide100)
        .latitudeSecondsDivide100(latitudeSecondsDivide100)
        .updateDate(updateDate)
        .build();
    }
}
