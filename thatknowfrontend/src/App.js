import "./App.css";
import React, { useState, useEffect } from "react";
import WeatherGraph from "./components/weatherGraph/WeatherGraph";
import DressCodeSuggestion from "./components/dressCode/DressCodeSuggestion";
import Header from "components/Header";
import CurrentTemp from "components/CurrentTemp";
import Loading from "Loading";

function App() {
  const [currentDate, setCurrentDate] = useState(new Date());

  const [loading, setLoading] = useState(false);

  const [areaGPS, setAreaGPS] = useState({
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

  useEffect(() => {
    console.log("바꼈어쌔끼야");
    console.log(dateTime);
  }, [dateTime]);

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

  return (
    <div
      className="backgroundImage container-fluid text-center fw-bolder"
      style={{ fontFamily: "Century Gothic, sans-serif" }}
    >
      
      {loading && <Loading />}

      {/*상단 로고 및 바로가기*/}
      <div className="row justify-content-center">
        <Header
          areaGPS={areaGPS}
          setAreaGPS={setAreaGPS}
          areaSelects={areaSelects}
          setAreaSelects={setAreaSelects}
          currentDate={currentDate}
          dateTime={dateTime}
          setDateTime={setDateTime}
          personalTemp={personalTemp}
          setPersonalTemp={setPersonalTemp}
          weatherData={weatherData}
          setWeatherData={setWeatherData}
          clothingData={clothingData}
          setClothingData={setClothingData}
          messageData={messageData}
          setMessageData={setMessageData}
          onLoadingChange={setLoading}
        />
      </div>

      {/*현재 기온, 날씨 그래프 */}
      <div className="row justify-content-sm-center">
        <div
          className="col-sm-8 col-lg-3 d-flex flex-column justify-content-center align-items-center rounded bg-light shadow-lg"
          style={{ margin: "0.5%" }}
        >
          <CurrentTemp
            currentDate={currentDate}
            weatherImgUrl={weatherImgUrl}
            weatherData={weatherData}
          />
        </div>
        <div
          className="col-sm-11 col-lg-7 rounded bg-light shadow-lg"
          style={{ margin: "0.5%" }}
        >
          <WeatherGraph weatherData={weatherData} />
        </div>
      </div>

      {/*추천 옷 띄우는 창*/}
      <div className="row justify-content-sm-center">
        <div
          className="col-sm-11 col-lg-3 rounded bg-light shadow-lg"
          style={{ margin: "0.5%" }}
        ></div>
        <div
          className="col-sm-11 col-lg-7 rounded bg-light shadow-lg"
          style={{ margin: "0.5%" }}
        >
          {clothingData && (
            <DressCodeSuggestion
              clothingData={clothingData}
              messageData={messageData}
            />
          )}
        </div>
      </div>
    </div>
  );
}

export default App;
