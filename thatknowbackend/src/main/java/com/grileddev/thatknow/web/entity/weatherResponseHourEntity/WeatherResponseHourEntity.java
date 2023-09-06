package com.grileddev.thatknow.web.entity.weatherResponseHourEntity;

import com.grileddev.thatknow.util.WeatherResponseHour;

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
@Table(name = "responsehour")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponseHourEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int nx;
    private int ny;

    private String baseDate;
    private String baseTime;

    private String fcstDate;
    private String fcstTime;

    private double TMP;
    private double TMN;
    private double TMX;
    
    private int REH;

    private int SKY;
    private int POP;
    private int PTY;

    private String PCP;
    private String SNO;

    private double WSD;
    
    public WeatherResponseHour toDTO() {
        return WeatherResponseHour.builder()
        .nx(nx)
        .ny(ny)
        .baseDate(baseDate)
        .baseTime(baseTime)
        .fcstDate(fcstDate)
        .fcstTime(fcstTime)
        .TMP(TMP)
        .TMN(TMN)
        .TMX(TMX)
        .REH(REH)
        .SKY(SKY)
        .POP(POP)
        .PTY(PTY)
        .PCP(PCP)
        .SNO(SNO)
        .WSD(WSD)
        .build();
    }
}
