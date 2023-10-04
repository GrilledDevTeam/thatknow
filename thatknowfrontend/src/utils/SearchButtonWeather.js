import React from "react";
import "./UserStyles.css";
import {
  searchWeatherSuggestionMsgByGridXYAndDate,
  searchWeatherSuggestionMsgByAreaAndDate,
} from "../api/axios";

export default function SearchButtonWeather({
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
  const handleSearchWeatherButton = async () => {
    let response;
    let retryCount = 0;
    const maxRetry = 3;

    console.log(state);

    onLoadingChange(true);

    const performWeatherRequest = () => {
      console.log("음~ 이것이 바로 탐색 버튼이다!");

      if (type === "GPS" && item) {
        if (item.nx === 0 || item.ny === 0) {
          console.log("Empty Area Data");
          return;
        } else {
          response = searchWeatherSuggestionMsgByGridXYAndDate(
            item.nx,
            item.ny,
            startActTime,
            endActTime,
            ATMPCelsiusWeight
          );
        }
      } else if (type === "searched" && state && city && town) {
        response = searchWeatherSuggestionMsgByAreaAndDate(
          state,
          city,
          town,
          startActTime,
          endActTime,
          ATMPCelsiusWeight
        );
      }

      response
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
        날씨 탐색
      </button>
    </div>
  );
}
