package com.grileddev.thatknow.web.entity.areaEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "areas")
@Data
public class AreaEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String areaCode;
 
    private String state;
    private String city;
    private String town; 
    
    private String nx;
    private String ny;
    
    private String longitudeDegrees;
    private String longitudeMinutes;
    private String longitudeSeconds;
    
    private String latitudeDegrees;
    private String latitudeMinutes;
    private String latitudeSeconds;

    private String longitudeSecondsDivide100;
    private String latitudeSecondsDivide100;

    private String updateDate;

}    