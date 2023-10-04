import React, { useState, useEffect } from "react";
import { loadAllArea } from "../api/axios";
import "./UserStyles.css";
import "App.css";

export default function SearchAreasByText({
  setAreaData,
  type,
  onTypeChange,
  setOnGPS,
}) {
  const [searchTerm, setSearchTerm] = useState("");
  const [allAreaData, setAllAreaData] = useState([]);
  const [showCurrentLocation, setShowCurrentLocation] = useState(false);

  useEffect(() => {
    loadAllArea()
      .then((response) => {
        setAllAreaData(response.data);
      })
      .catch((error) => {
        console.error("Area data get error", error);
      });
  }, []);

  const handleSearchTermChange = (event) => {
    const newSearchTerm = event.target.value;
    setSearchTerm(newSearchTerm);
    setShowCurrentLocation(false);
  };

  const filterSuggestions = () => {
    const filteredSuggestions = allAreaData.filter((suggestion) => {
      const suggestionText = `${suggestion.state} ${suggestion.city} ${suggestion.town}`;
      return suggestionText.toLowerCase().includes(searchTerm.toLowerCase());
    });

    return filteredSuggestions;
  };

  const handleDataSelect = (selected, index) => {
    if (index === -1) {
      console.log("탐색 지역을 현재 위치로 선택했습니다.");
      setAreaData(selected);
      onTypeChange("GPS");
      setShowCurrentLocation(false);
      setOnGPS(true);
    } else {
      console.log("탐색 지역을 선택했습니다.");
      setAreaData(selected);
      setSearchTerm(`${selected.state} ${selected.city} ${selected.town}`);
      onTypeChange("searched");
    }

    setSearchTerm("");
  };

  const handleInputClick = () => {
    setShowCurrentLocation(true);
  };

  return (
    <div>
      <input
        className="searchArea"
        type="text"
        placeholder="지역을 입력하세요"
        value={searchTerm}
        onChange={handleSearchTermChange}
        onClick={handleInputClick}
        style={{ textAlign: "center", width: "80%" }}
      />

      <div className="searchArea-list">
        <ul>
          {type !== "GPS" && showCurrentLocation && (
            <li
              key={-1}
              onClick={() =>
                handleDataSelect({ state: "", city: "", town: "" }, -1)
              }
            >
              현재 위치
            </li>
          )}
          {searchTerm.length > 0 && (
            <>
              {filterSuggestions().map((suggestion, index) => (
                <li
                  key={index}
                  onClick={() => handleDataSelect(suggestion, index)}
                >
                  {suggestion.state} {suggestion.city} {suggestion.town}
                </li>
              ))}
            </>
          )}
        </ul>
      </div>
    </div>
  );
}
