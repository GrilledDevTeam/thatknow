import React, { useState, useEffect } from "react";
import "./UserStyles.css";
import AreaGPS from "./AreaGPS";

export default function GPS({ onGPSDataChange, onLoadingChange }) {
  const [latitude, setLatitude] = useState("");
  const [longitude, setLongitude] = useState("");

  useEffect(() => {
    if ("geolocation" in navigator) {
      navigator.geolocation.getCurrentPosition(function (position) {
        const newLatitude = position.coords.latitude.toFixed(6);
        const newLongitude = position.coords.longitude.toFixed(6);

        setLatitude(newLatitude);
        setLongitude(newLongitude);
      });
    } else {
      alert("Geolocation is not available on this device.");
    }
  }, []);

  return (
    <div>
      {/* <AreaListGPS
        latitude={latitude}
        longitude={longitude}
        // onAreaGPSChange={onAreaGPSChange}
        onLoadingChange={onLoadingChange}
      /> */}
      <AreaGPS
        latitude={latitude}
        longitude={longitude}
        onGPSDataChange={onGPSDataChange}
        onLoadingChange={onLoadingChange}
      />
    </div>
  );
}
