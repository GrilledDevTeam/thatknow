import React, { useState, useEffect } from "react";
import axios from "axios";

import "./UserStyles.css";

export default function AreaListGPS({ latitude, longitude, onAreaGPSChange, onLoadingChange }) {
  const [originalData, setOriginalData] = useState([]);
  const [selectedIndex, setSelectedIndex] = useState(-1);

  useEffect(() => {
    if (latitude && longitude) {
      onLoadingChange(true);
      axios
        .post(
          "/api/searchAreaBylongitudeAndLatitude",
          {
            longitudeSecondsDivide100: longitude,
            latitudeSecondsDivide100: latitude,
          },
          {
            headers: {
              "Content-Type": "application/x-www-form-urlencoded",
            },
          }
        )
        .then((response) => {
          setOriginalData(response.data);
          onLoadingChange(false);
        })
        .catch((error) => {
          console.error("Error fetching area data:", error);
        });
    }
  }, [latitude, longitude]);

  const handleSelectChange = (e) => {
    const newIndex = parseInt(e.target.value, 10);
    setSelectedIndex(newIndex);
    if (newIndex > -1) {
      onAreaGPSChange({
        nx: originalData[newIndex].nx,
        ny: originalData[newIndex].ny,
      });
    }
  };

  return (
    <div>
      <select id="areaList" value={selectedIndex} onChange={handleSelectChange}>
        <option value={-1}> -- Area -- </option>
        {originalData.map((item, index) => (
          <option key={index} value={index}>
            {item.state} {item.city} {item.town}
          </option>
        ))}
      </select>
    </div>
  );
}
