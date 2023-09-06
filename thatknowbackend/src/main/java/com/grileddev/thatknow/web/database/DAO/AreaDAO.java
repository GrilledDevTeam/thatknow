package com.grileddev.thatknow.web.database.DAO;

import com.grileddev.thatknow.web.entity.areaEntity.AreaEntity;

import java.util.List;

public interface AreaDAO {
    public void saveArea(AreaEntity areaEntity);

    public List<AreaEntity> findAreaByLongitudeAndLatitude(double longitudeSecondsDivide100, double latitudeSecondsDivide100);
    public List<AreaEntity> findAreaByNxNy(int nx, int ny);
    public AreaEntity findAreaByAreaId(Long areaId);
    public AreaEntity findAreaByArea(String state, String city, String town);

    public List<AreaEntity> findAreaByState(String state);

    public List<AreaEntity> findAreasFromDB();
}
