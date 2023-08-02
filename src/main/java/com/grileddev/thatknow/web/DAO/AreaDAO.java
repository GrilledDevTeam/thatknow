package com.grileddev.thatknow.web.DAO;

import com.grileddev.thatknow.web.entity.areaEntity.AreaEntity;

public interface AreaDAO {
    AreaEntity saveArea(AreaEntity areaEntity);

    AreaEntity getArea(String areaId);
}
