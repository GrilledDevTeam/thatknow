import React, { useState, useEffect } from "react";
import Loading from "../Loading";
import WeatherGraph from "../weather/WeatherGraph";
import UserInfoInterface from "../userInterface/UserInfoInterface";
import DressCodeSuggestion from "../dressCode/DressCodeSuggestion";
import CurrentTemp from "../weather/CurrentTemp";
import AppContext from "../../context";
import MessageSuggestion from "../dressCode/messageSuggestionArea/MessageSuggestion";

function Thatknow() {
  const [currentDate, setCurrentDate] = useState(new Date());

  const [loading, setOnLoading] = useState(false);

  const [areaGridXY, setAreaGridXY] = useState({
    nx: 0,
    ny: 0,
  });

  const [areaSelects, setAreaSelects] = useState({
    state: "",
    city: "",
    town: "",
  });

  const [dateTime, setDateTime] = useState({
    startActTime: "",
    endActTime: "",
  });

  const [personalTemp, setPersonalTemp] = useState({
    ATMPCelsiusWeight: 0,
  });

  const weatherImgUrl = "/weatherImages/icon-rain.png";

  const [weatherData, setWeatherData] = useState([]);
  const [clothingData, setClothingData] = useState([]);
  const [messageData, setMessageData] = useState([]);

  // 1분 주기로 현재 시간 업데이트
  useEffect(() => {
    console.log(currentDate);
    const intervalId = setInterval(() => {
      setCurrentDate(new Date());
    }, 60000); // Update every 600000ms (10 min)

    return () => {
      clearInterval(intervalId);
    };
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  const appContextValue = {
    areaGridXY,
    setAreaGridXY,
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
    setOnLoading,
  };

  return (
    <AppContext.Provider value={appContextValue}>
      <div
        className="backgroundImage container-fluid text-center fw-bolder p-3"
        style={{ fontFamily: "Century Gothic, sans-serif" }}
      >
        {loading && <Loading />}

        {/*상단 로고 및 바로가기*/}
        <div className="row gy-3 justify-content-center">
          <div className="col-2"></div>
          <UserInfoInterface />
          <div className="col-2"></div>

          {/*현재 기온, 날씨 그래프 */}
          <div
            className="col-11 col-md-3 col-xl-3 d-flex flex-column justify-content-center align-items-center rounded bg-light shadow-lg"
            style={{ marginLeft: "0.5%", marginRight: "0.5%" }}
          >
            <CurrentTemp
              currentDate={currentDate}
              weatherImgUrl={weatherImgUrl}
              weatherData={weatherData}
            />
          </div>
          <div
            className="col-11 col-md-8 col-xl-7 rounded bg-light shadow-lg"
            style={{ marginLeft: "0.5%", marginRight: "0.5%" }}
          >
            <WeatherGraph weatherData={weatherData} />
          </div>

          {/*추천 옷 띄우는 창*/}
          <div
            className="col-11 col-xl-3 rounded bg-light shadow-lg"
            style={{ marginLeft: "0.5%", marginRight: "0.5%" }}
          >
            {messageData && <MessageSuggestion messageData={messageData} />}
          </div>
          <div
            className="col-11 col-xl-7 rounded bg-light shadow-lg"
            style={{ marginLeft: "0.5%", marginRight: "0.5%" }}
          >
            {clothingData && (
              <DressCodeSuggestion clothingData={clothingData} />
            )}
          </div>
        </div>
      </div>
    </AppContext.Provider>
  );
}

export default Thatknow;
