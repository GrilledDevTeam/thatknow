import { useState, useEffect } from "react";

function CurrentTemp({ currentDate, weatherImgUrl, weatherData }) {
  const [pcpState, setPcpState] = useState("");
  const [snoState, setSnoState] = useState("");

  useEffect(() => {
    if (weatherData.length === 0) {
      return;
    }

    if (weatherData[0].pcp !== "강수없음") {
      setPcpState(weatherData[0]?.pcp + "mm");
    }

    if (weatherData[0].sno !== "적설없음") {
      setSnoState(weatherData[0]?.sno + "cm");
    }
  }, [weatherData]);

  return (
    <div
      className="col-sm-8 col-lg-3 d-flex flex-column justify-content-center align-items-center rounded bg-light shadow-lg"
      style={{ margin: "0.5%", padding: "10px" }}
    >
      <div className="d-flex justify-content-center">
        <img
          src={weatherImgUrl}
          alt="Weather Icon"
          className="weather-icon"
        ></img>
        <div>
          <p
            className="d-flex justify-content-center"
            style={{ fontSize: "40px" }}
          >
            {weatherData[0]?.tmpcelsius || 25}
            °C
          </p>
          <p
            className="d-flex justify-content-center"
            style={{ display: "block", fontSize: "25px", marginTop: "10px" }}
          >
            {currentDate.getHours()}시
          </p>
          <p className="d-flex justify-content-center">
            테스트 메시지 강수없음
            {pcpState}
            {snoState}
          </p>
        </div>
      </div>
    </div>
  );
}

export default CurrentTemp;
