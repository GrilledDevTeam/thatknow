package com.grileddev.thatknow.web.database.repository.koreaAreaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grileddev.thatknow.web.entity.areaEntity.AreaEntity;



public interface KoreaAreaRepository extends JpaRepository<AreaEntity , Integer> {
    public AreaEntity findDataByAreaCode(String areaCode);
    public AreaEntity findAllByStateAndCityAndTown(String state, String city, String town);
}