package com.grileddev.thatknow.web.entity.weatherResponseHourEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "responsehour")
@Data
@Builder
public class WeatherResponseHourEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nx;
    private String ny;

    private String baseDate;
    private String baseTime;

    private String fcstDate;
    private String fcstTime;

    private String TMP;
    private String TMN;
    private String TMX;
    
    private String REH;

    private String SKY;
    private String POP;
    private String PTY;
    private String PCP;
    private String SNO;

    private String WSD;
}
