package com.grileddev.thatknow.web.database.DAO;

import com.grileddev.thatknow.web.entity.areaEntity.AreaEntity;

public interface AreaDAO {
    public void saveArea(AreaEntity areaEntity);

    public AreaEntity findAreaByAreaId(String areaId);
    public AreaEntity findAreaByArea(String state, String city, String town);
}
