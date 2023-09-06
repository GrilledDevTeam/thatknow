import React, { useState, useEffect } from "react";
import Slider from "rc-slider";
import "rc-slider/assets/index.css";
import "./CustomSlider.css";
import "./UserStyles.css";

function TimeRangeSlider({ currentDate, onDateTimeChange }) {
  const [range, setRange] = useState([
    currentDate.getHours(),
    currentDate.getHours() + 8,
  ]);
  const [selectedRangeText, setSelectedRangeText] = useState("None");
  const [formattedDateStart, setFormattedDateStart] = useState("0");
  const [formattedDateEnd, setFormattedDateEnd] = useState("0");

  function rangeController(range_1, range_2) {
    var selectedStartHour = range_1;
    var selectedEndHour = range_2;

    var tomorrowTextStart = "";
    var tomorrowTextEnd = "";

    var currentYearStart = currentDate.getFullYear();
    var currentMonthStart = currentDate.getMonth() + 1;
    var currentDayStart = currentDate.getDate();
    var startHour = selectedStartHour;

    var currentYearEnd = currentDate.getFullYear();
    var currentMonthEnd = currentDate.getMonth() + 1;
    var currentDayEnd = currentDate.getDate();
    var endHour = selectedEndHour;

    if (selectedStartHour > 23) {
      selectedStartHour -= 24;
      tomorrowTextStart = "내일 ";
      currentDayStart += 1;

      if (
        (currentMonthStart === 1 ||
          currentMonthStart === 3 ||
          currentMonthStart === 5 ||
          currentMonthStart === 7 ||
          currentMonthStart === 8 ||
          currentMonthStart === 10 ||
          currentMonthStart === 12) &&
        currentDayStart > 31
      ) {
        currentMonthStart += 1;

        if (currentMonthStart > 12) {
          currentYearStart += 1;
        }
      }

      if (
        (currentMonthStart === 2 ||
          currentMonthStart === 4 ||
          currentMonthStart === 6 ||
          currentMonthStart === 9 ||
          currentMonthStart === 11) &&
        currentDayStart > 30
      ) {
        currentMonthStart += 1;

        if (currentMonthStart > 12) {
          currentYearStart += 1;
        }
      }
    }

    if (selectedEndHour > 23) {
      selectedEndHour -= 24;
      tomorrowTextEnd = "내일 ";
      currentDayEnd += 1;

      if (
        (currentMonthEnd === 1 ||
          currentMonthEnd === 3 ||
          currentMonthEnd === 5 ||
          currentMonthEnd === 7 ||
          currentMonthEnd === 8 ||
          currentMonthEnd === 10 ||
          currentMonthEnd === 12) &&
        currentDayEnd > 31
      ) {
        currentMonthEnd += 1;

        if (currentMonthEnd > 12) {
          currentYearEnd += 1;
        }
      }

      if (
        (currentMonthEnd === 2 ||
          currentMonthEnd === 4 ||
          currentMonthEnd === 6 ||
          currentMonthEnd === 9 ||
          currentMonthEnd === 11) &&
        currentDayEnd > 30
      ) {
        currentMonthEnd += 1;

        if (currentMonthEnd > 12) {
          currentYearEnd += 1;
        }
      }
    }

    const rangeText = `${tomorrowTextStart}${selectedStartHour}시 ~ ${tomorrowTextEnd}${selectedEndHour}시`;
    setSelectedRangeText(rangeText);

    currentMonthStart = String(currentMonthStart).padStart(2, "0");
    currentDayStart = String(currentDayStart).padStart(2, "0");
    currentMonthStart = String(currentMonthStart).padStart(2, "0");

    currentMonthEnd = String(currentMonthEnd).padStart(2, "0");
    currentDayEnd = String(currentDayEnd).padStart(2, "0");
    currentMonthEnd = String(currentMonthEnd).padStart(2, "0");

    startHour = String(selectedStartHour).padStart(2, "0");
    endHour = String(selectedEndHour).padStart(2, "0");

    setFormattedDateStart(
      `${currentYearStart}${currentMonthStart}${currentDayStart}${startHour}`
    );
    setFormattedDateEnd(
      `${currentYearEnd}${currentMonthEnd}${currentDayEnd}${endHour}`
    );
  }

  const handleRangeChange = (newRange) => {
    setRange(newRange);
  };

  useEffect(() => {
    onDateTimeChange({
      startActTime: formattedDateStart,
      endActTime: formattedDateEnd,
    });
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [formattedDateStart, formattedDateEnd]);

  useEffect(() => {
    rangeController(range[0], range[1]);
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [range]);

  const currentHour = currentDate.getHours();
  const maxHour = currentHour + 24;

  return (
    <div className="slider-container">
      <Slider
        min={currentHour}
        max={maxHour}
        range
        value={range}
        onChange={handleRangeChange}
        allowCross={false}
        className="custom-slider"
      />
      <p>{selectedRangeText}</p>
    </div>
  );
}

function TemperatureSlider({ onPersonalTempChange }) {
  const [selectedTemperature, setSelectedTemperature] = useState(0);
  var textTemperature =
    selectedTemperature > 0 ? `+${selectedTemperature}` : selectedTemperature;

  const singleHandlerChange = (value) => {
    setSelectedTemperature(value);
    onPersonalTempChange({
      ATMPCelsiusWeight: value,
    });
  };

  return (
    <div className="slider-container">
      <Slider
        min={-5}
        max={5}
        value={selectedTemperature}
        onChange={singleHandlerChange}
        className="custom-slider"
      />
      <div>
        <p>{textTemperature}℃</p>
      </div>
    </div>
  );
}

export { TimeRangeSlider, TemperatureSlider };
