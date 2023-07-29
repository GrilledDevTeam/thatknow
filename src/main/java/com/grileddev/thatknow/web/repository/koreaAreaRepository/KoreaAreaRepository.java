package com.grileddev.thatknow.web.repository.koreaAreaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grileddev.thatknow.web.entity.areaEntity.AreaEntity;



public interface KoreaAreaRepository extends JpaRepository<AreaEntity , Integer> {

    public AreaEntity findAllByStateAndCityAndTown(String state, String city, String town);
}