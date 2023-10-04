/* eslint-disable react-hooks/exhaustive-deps */
import React, { useEffect, useState } from "react";

export default function AreaLabel({ type, areaData }) {
  const [areaLabel, setAreaLabel] = useState("현재위치 탐색중...");

  // 지역 정보 라벨 설정
  useEffect(() => {
    if (type === "GPS" && areaData) {
      setAreaLabel(`${areaData.state} ${areaData.city}`);
    } else if (type === "searched" && areaData) {
      setAreaLabel(`${areaData.state} ${areaData.city} ${areaData.town}`);
    }
  }, [type, areaData]);

  return <label>지역 : {areaLabel}</label>;
}
