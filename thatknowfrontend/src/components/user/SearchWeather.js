import React from "react";
import axios from "axios";
import "./UserStyles.css";

export default function SearchWeather({
  type,
  item,
  state,
  city,
  town,
  startActTime,
  endActTime,
  ATMPCelsiusWeight,
  setWeatherData,
  setClothingData,
  setMessageData,
  onLoadingChange,
}) {
  const handleSearchWeatherButton = () => {
    let requestData = {};
    let retryCount = 0;
    const maxRetry = 3;

    onLoadingChange(true);
    if (type === "GPS" && item) {
      requestData = {
        nx: item.nx,
        ny: item.ny,
        startActTime: startActTime,
        endActTime: endActTime,
        ATMPCelsiusWeight: ATMPCelsiusWeight,
      };
    } else if (type === "Select" && state && city && town) {
      requestData = {
        state: state,
        city: city,
        town: town,
        startActTime: startActTime,
        endActTime: endActTime,
        ATMPCelsiusWeight: ATMPCelsiusWeight,
      };
    }

    const performWeatherRequest = () => {

      axios
        .post(`/api/searchBy${item.nx && item.ny && type === "GPS" ? "GridXY" : "Area"}`, null, {
          params: requestData,
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
          },
        })
        .then((response) => {
          console.log("success response");
          console.log(response.data);
          setWeatherData(response.data["WEATHER_PRODUCT_HOURS"]);
          setClothingData(response.data["CLOTHING"]);
          setMessageData(response.data["WEATHER_STATE"]);
          onLoadingChange(false);
        })
        .catch((error) => {
          console.error("Error fetching area data:", error);
          retryCount++;
          if (retryCount <= maxRetry) {
            setTimeout(performWeatherRequest, 2000);
          } else {
            console.log("재시도 3회 초과");
            alert("요청에 실패하였습니다.");
          }
        });
    };

    performWeatherRequest();
  };

  return (
    <div>
      <button className="btn btn-dark" onClick={handleSearchWeatherButton}>
        {type === "GPS" ? "GPS확인" : "Select확인"}
      </button>
    </div>
  );
}
