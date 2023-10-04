import React, { useContext, useState } from "react";
import { TemperatureSlider, TimeRangeSlider } from "./InputRangeBar";
import SearchButtonWeather from "../../utils/SearchButtonWeather";
import AppContext from "../../context";
import Area from "./Area";
import "./UserInfoInterface.css";
// import SearchSelectBox from "./user/SearchCheckBox";

function UserInfoInterface() {
  const {
    areaGridXY,
    setAreaGridXY,
    areaSelects,
    setAreaSelects,
    currentDate,
    dateTime,
    setDateTime,
    personalTemp,
    setPersonalTemp,
    setWeatherData,
    setClothingData,
    setMessageData,
    setOnLoading,
  } = useContext(AppContext);

  const [type, setType] = useState("GPS");
  const homePath = "http://localhost:3000";

  return (
    <header className="col-8 col-lg-8 rounded bg-light shadow-lg">
      <div className="row gy-2">
        <div className="col-xl-3 d-flex justify-content-around align-items-center">
          <a
            className="fs-1 fw-bold m-3 p-2 text-decoration-none 
             border-bottom border-4 border-dark 
             bg-light rounded 
             hover-transition"
            href={homePath}
            style={{
              transition: "all 0.3s",
              whiteSpace: "nowrap",
              color: "black",
            }}
          >
            그거 알아?
          </a>
        </div>
        {/* GPS 및 위치 검색창 */}
        <div className="col-xl-5 d-flex flex-column justify-content-center align-items-center">
          <Area
            type={type}
            onTypeChange={setType}
            setAreaGridXY={setAreaGridXY}
            setAreaSelects={setAreaSelects}
            onLoadingChange={setOnLoading}
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
          <SearchButtonWeather
            type={type}
            item={areaGridXY}
            state={areaSelects.state}
            city={areaSelects.city}
            town={areaSelects.town}
            startActTime={dateTime.startActTime}
            endActTime={dateTime.endActTime}
            ATMPCelsiusWeight={personalTemp.ATMPCelsiusWeight}
            setWeatherData={setWeatherData}
            setClothingData={setClothingData}
            setMessageData={setMessageData}
            onLoadingChange={setOnLoading}
          />
        </div>
      </div>
    </header>
  );
}

export default UserInfoInterface;
