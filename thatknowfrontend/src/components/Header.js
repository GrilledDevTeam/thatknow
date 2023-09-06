import React, { useState } from "react";
import SearchSelectBox from "./user/SearchCheckBox";
import { TemperatureSlider, TimeRangeSlider } from "./user/InputRangeBar";
import SearchWeather from "./user/SearchWeather";
import { thatknowHomePath } from "config";

function Header({
  areaGPS,
  setAreaGPS,
  areaSelects,
  setAreaSelects,
  currentDate,
  dateTime,
  setDateTime,
  personalTemp,
  setPersonalTemp,
  weatherData,
  setWeatherData,
  clothingData,
  setClothingData,
  messageData,
  setMessageData,
  onLoadingChange,
}) {
  const [type, setType] = useState("GPS");
  const homePath = thatknowHomePath;

  return (
    <header
      className="col-8 col-lg-8 rounded bg-light shadow-lg"
      style={{ marginTop: "0.5%", marginBottom: "0.5%" }}
    >
      <div className="row gy-4">
        <div className="col-xl-3 d-flex justify-content-around align-items-center">
          <a
            className="fs-1 fw-bold fst-italic m-3 border-bottom border-4 border-dark p-1 text-decoration-none"
            href={homePath}
          >
            That Know ?
          </a>
          {/* 페이지가 줄어들었을때 나타나는 버튼인데.. 안에 요소는 없어요 */}
          {/* <button
                  className="navbar-toggler"
                  type="button"
                  data-bs-toggle="collapse"
                  data-bs-target="#navbarSupportedContent"
                  aria-controls="navbarSupportedContent"
                  aria-expanded="false"
                  aria-label="Toggle navigation"
                >
                  <span className="navbar-toggler-icon"></span>
                </button> */}
        </div>
        <div className="col-xl-5 d-flex flex-column justify-content-center align-items-center">
          <SearchSelectBox
            areaGPS={areaGPS}
            onAreaGPSChange={setAreaGPS}
            areaSelects={areaSelects}
            onAreaSelectsChange={setAreaSelects}
            onTypeChange={setType}
            onLoadingChange={onLoadingChange}
          />
        </div>

        <div className="col-xl-3">
          <div className="d-flex flex-column justify-content-center align-items-center">
            {/* 외출시간 슬라이더 */}
            <div>
              <label className="border border-5 border-muted rounded d-flex justify-content-around">
                외출 시간
              </label>
              <TimeRangeSlider
                currentDate={currentDate}
                onDateTimeChange={setDateTime}
              />
            </div>

            {/* 체감온도 슬라이더 */}
            <div>
              <label className="border border-5 border-muted rounded d-flex justify-content-around">
                개인별 체감 온도
              </label>
              <TemperatureSlider
                personalTemp={personalTemp}
                onPersonalTempChange={setPersonalTemp}
              />
            </div>
          </div>
        </div>
        <div className="col-xl-1 d-flex justify-content-center align-items-center mb-2">
          <SearchWeather
            type={type}
            item={areaGPS}
            state={areaSelects.state}
            city={areaSelects.city}
            town={areaSelects.town}
            startActTime={dateTime.startActTime}
            endActTime={dateTime.endActTime}
            ATMPCelsiusWeight={personalTemp.ATMPCelsiusWeight}
            weatherData={weatherData}
            setWeatherData={setWeatherData}
            clothingData={clothingData}
            setClothingData={setClothingData}
            messageData={messageData}
            setMessageData={setMessageData}
            onLoadingChange={onLoadingChange}
          />
        </div>
      </div>
    </header>
  );
}

export default Header;
