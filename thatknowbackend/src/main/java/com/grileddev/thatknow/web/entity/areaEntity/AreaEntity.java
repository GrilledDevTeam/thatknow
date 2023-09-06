package com.grileddev.thatknow.web.entity.areaEntity;

import com.grileddev.thatknow.util.Area;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "areas")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Area toDTO() {
        return Area.builder()
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