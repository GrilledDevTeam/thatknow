package com.grileddev.thatknow.web.database.repository.koreaAreaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grileddev.thatknow.web.entity.areaEntity.AreaEntity;

import java.util.List;


public interface KoreaAreaRepository extends JpaRepository<AreaEntity, Integer> {

    /***
     * 두개의 값에 대한 근접치를 이용한 탐색입니다, 실제 쿼리문으로 데이터를 찾게끔 설계되었습니다.
     * @param targetLongitude
     * @param thresholdLongitude
     * @param targetLatitude
     * @param thresholdLatitude
     * @return
     */
    @Query("SELECT a FROM AreaEntity a " +
           "WHERE a.longitudeSecondsDivide100 >= :targetLongitude - :thresholdLongitude " +
           "AND a.longitudeSecondsDivide100 <= :targetLongitude + :thresholdLongitude " +
           "AND a.latitudeSecondsDivide100 >= :targetLatitude - :thresholdLatitude " +
           "AND a.latitudeSecondsDivide100 <= :targetLatitude + :thresholdLatitude")
    List<AreaEntity> findClosestByApproximateCoordinates(
        @Param("targetLongitude") double targetLongitude,
        @Param("thresholdLongitude") double thresholdLongitude,
        @Param("targetLatitude") double targetLatitude,
        @Param("thresholdLatitude") double thresholdLatitude);
        
    public List<AreaEntity> findAllByNxAndNy(int nx, int ny);
    public AreaEntity findDataByAreaCode(Long areaCode);
    public AreaEntity findAllByStateAndCityAndTown(String state, String city, String town);

    public List<AreaEntity> findAllByState(String state);

    public List<AreaEntity> findAll();
}