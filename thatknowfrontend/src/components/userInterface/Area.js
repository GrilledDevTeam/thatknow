/* eslint-disable react-hooks/exhaustive-deps */
import React, { useEffect, useState } from "react";
import SearchAreasByText from "../../utils/SearchAreasByText";
import AreaLabel from "./AreaLabel";
import { searchGPS } from "../../api/searchGPS";
import { searchAreasBylongitudeAndLatitude } from "../../api/axios";

export default function Area({
  type,
  onTypeChange,
  setAreaGridXY,
  setAreaSelects,
  onLoadingChange,
}) {
  const [onGPS, setOnGPS] = useState(true);
  const [areaData, setAreaData] = useState(null);
  const [areaGPS, setAreaGPS] = useState({});

  const searchAreaGPSByGPS = async () => {
    console.log("GPS 탐색을 시작합니다.");

    onLoadingChange(true);
    searchGPS()
      .then((response) => {
        setAreaGPS(response);
        onLoadingChange(false);

        console.log("GPS : ");
        console.log(response);
      })
      .catch((error) => {
        alert("GPS 탐색에 실패했습니다. Error:", error);
      });
  };

  const loadAreaDataByAreaGPS = async () => {
    console.log("GPS를 바탕으로 지역 정보를 가져오고 있습니다.");

    onLoadingChange(true);
    searchAreasBylongitudeAndLatitude(areaGPS.latitude, areaGPS.longitude)
      .then((response) => {
        setAreaData(response.data[0]);
        onLoadingChange(false);
      })
      .catch((error) => {
        console.error("Error fetching area data:", error);
        onLoadingChange(false);
      });
  };

  // GPS 탐색
  useEffect(() => {
    if (onGPS) {
      setOnGPS(false);
      searchAreaGPSByGPS();
    }
  }, [onGPS]);

  // GPS를 기반으로 지역 정보 로드
  useEffect(() => {
    if (areaGPS.latitude && areaGPS.longitude) {
      loadAreaDataByAreaGPS();
    }
  }, [areaGPS]);

  // 지역 정보 설정
  useEffect(() => {
    if (areaData) {
      console.log("지역 정보를 갱신했습니다.");
      console.log("AreaData :");
      console.log(areaData);

      setAreaGridXY({
        nx: areaData.nx,
        ny: areaData.ny,
      });

      setAreaSelects({
        state: areaData.state,
        city: areaData.city,
        town: areaData.town,
      });
    }
  }, [type, areaData]);

  return (
    <div>
      <AreaLabel type={type} areaData={areaData} />
      <SearchAreasByText
        setAreaData={setAreaData}
        type={type}
        onTypeChange={onTypeChange}
        setOnGPS={setOnGPS}
      />
    </div>
  );
}
