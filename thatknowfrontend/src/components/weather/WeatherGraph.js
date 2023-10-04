import React from "react";
import "./WeatherGraph.css";

function WeatherGraph({weatherData}) {
  return (
    <div className="weatherContainerWrapper">
      <div className="scroll-button left" onClick={() => scrollContainer(-200)}>
        &#8249;
      </div>

      <div className="weatherContainer">
        <div className="weatherRow">
          <div className="weatherCell">오늘</div>
          {weatherData.length > 0 &&
            weatherData.map((item, index) => (
              <div className="weatherCell" key={index + "-fcstTime"}>
                {item.fcstTime}
              </div>
            ))}
        </div>

        <div className="weatherRow">
          <div className="weatherCell">
            <div className="value">기온</div>
            <div className="unit">(°C)</div>
          </div>

          {weatherData.length > 0 &&
            weatherData.map((item, index) => (
              <div className="weatherCell" key={index + "-tmpcelsius"}>
                {item.tmpcelsius}
              </div>
            ))}
        </div>

        <div className="weatherRow">
          <div className="weatherCell">
            <div className="value">강수</div>
            <div className="unit">(mm)</div>
          </div>
          {weatherData.length > 0 &&
            weatherData.map((item, index) => (
              <div className="weatherCell" key={index + "-pcp"}>
                {item.pcp === "강수없음" ? "0" : item.pcp}
              </div>
            ))}
        </div>

        <div className="weatherRow">
          <div className="weatherCell">
            <div className="value">바람</div>
            <div className="unit">(m/s)</div>
          </div>

          {weatherData.length > 0 &&
            weatherData.map((item, index) => (
              <div className="weatherCell" key={index + "-wsd"}>
                {item.wsd}
              </div>
            ))}
        </div>

        <div className="weatherRow">
          <div className="weatherCell">
            <div className="value">습도</div>
            <div className="unit">(%)</div>
          </div>
          {weatherData.length > 0 &&
            weatherData.map((item, index) => (
              <div className="weatherCell" key={index + "-reh"}>
                {item.reh}
              </div>
            ))}
        </div>
      </div>

      <div className="scroll-button right" onClick={() => scrollContainer(200)}>
        &#8250;
      </div>
    </div>
  );
}

function scrollContainer(scrollAmount) {
  const weatherContainer = document.querySelector(".weatherContainer");
  weatherContainer.scrollLeft += scrollAmount;
}

export default WeatherGraph;
