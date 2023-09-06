import React, { useState } from "react";
import GPS from "./GPS";
import SelectBox from "./SelectBox";
import "./UserStyles.css";

export default function SearchSelectBox({
  onAreaGPSChange,
  areaSelects,
  onAreaSelectsChange,
  onTypeChange,
  onLoadingChange,
}) {
  const [isGPS, setIsGPS] = useState(true);
  const [isSelectBox, setSelectBox] = useState(false);

  const handleCheckboxChange = (event) => {
    const { name, checked } = event.target;

    if (name === "searchWeatherGPS") {
      setIsGPS(checked);
      setSelectBox(false);
      onTypeChange("GPS");
      onAreaSelectsChange({
        state: "",
        city: "",
        town: "",
      });
    } else {
      // if (name === 'searchWeatherSelect') {
      setIsGPS(false);
      setSelectBox(checked);
      onTypeChange("Select");
      onAreaGPSChange({
        nx: 0,
        ny: 0,
      });
    }
  };

  return (
    <>
      <div
        className="border border-5 border-muted rounded"
        style={{ marginBottom: "5%" }}
      >
        <label className="search-swich">
          GPS 위치 탐색
          <input
            style={{ marginLeft: "3px" }}
            type="checkbox"
            name="searchWeatherGPS"
            checked={isGPS}
            onChange={handleCheckboxChange}
          />
        </label>

        <label className="search-swich">
          지역 검색
          <input
            style={{ marginLeft: "3px" }}
            type="checkbox"
            name="searchWeatherSelect"
            checked={isSelectBox}
            onChange={handleCheckboxChange}
          />
        </label>
      </div>

      <div>
        {isGPS && <GPS onAreaGPSChange={onAreaGPSChange} onLoadingChange={onLoadingChange} />}
        {isSelectBox && (
          <SelectBox
            areaSelects={areaSelects}
            onAreaSelectsChange={onAreaSelectsChange}
          />
        )}
      </div>
    </>
  );
}
