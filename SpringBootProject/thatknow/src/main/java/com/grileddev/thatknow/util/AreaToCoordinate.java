package com.grileddev.thatknow.util;

import com.grileddev.thatknow.web.entity.areaEntity.AreaEntity;
import com.grileddev.thatknow.web.repository.koreaAreaRepository.KoreaAreaRepository;

import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AreaToCoordinate{
    @Autowired
    private KoreaAreaRepository repository;

    private String nx;
    private String ny;

    public AreaToCoordinate(){
        this.nx = "NONE DATA";
        this.ny = "NONE DATA";
    }

    public void setCoordinateByAreaName(String stateAndCityAndTown){

        StringTokenizer tokenizer = new StringTokenizer(stateAndCityAndTown, "&");

        AreaEntity findedAreaEntity = repository.findAllByStateAndCityAndTown(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());

        this.nx = findedAreaEntity.getNx();
        this.ny = findedAreaEntity.getNy();
    }

    public void setCoordinateByGPS(String longitude, String latitude){
        return;
    }

    public String getNx() {
        return nx;
    }

    public String getNy() {
        return ny;
    }
}
