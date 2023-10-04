import React, { useEffect, useState } from "react";
import axios from "axios";

import "./UserStyles.css";

export default function SelectBox({ areaSelects, onAreaSelectsChange }) {
  const [state, setState] = useState([]);
  const [city, setCity] = useState([]);
  const [town, setTown] = useState([]);

  const [selectedState, setSelectedState] = useState();
  const [selectedCity, setSelectedCity] = useState();
  const [selectedTown, setSelectedTown] = useState();

  useEffect(() => {
    axios
      .get("/api/loadOnlyStates")
      .then((response) => {
        setState(response.data);
        //console.log(response.data);
      })
      .catch((error) => {
        console.error("Error fetching area data:", error);
      });
  }, []);

  const loadCitiesByState = (state) => {
    axios
      .get("/api/loadCitiesByState", {
        params: {
          state: state,
        },
      })
      .then((response) => {
        setCity(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Error fetching area data:", error);
      });
  };

  const loadTownsByStateAndCity = (state, city) => {
    axios
      .get("/api/loadTownsByStateAndCity", {
        params: {
          state: state,
          city: city,
        },
      })
      .then((response) => {
        setTown(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Error fetching area data:", error);
      });
  };

  const handleStateChange = (event) => {
    const selectedState = event.target.value;
    setSelectedState(selectedState);
    console.log(selectedState);

    if (selectedState) {
      loadCitiesByState(selectedState);
      setCity([]);
      setTown([]);
    }
  };

  const handleCityChange = (event) => {
    const selectedCity = event.target.value;
    setSelectedCity(selectedCity);
    console.log(selectedCity);

    if (selectedCity) {
      loadTownsByStateAndCity(selectedState, selectedCity);
      setTown([]);
    }
  };

  const handleTownChange = (event) => {
    const selectedTown = event.target.value;
    setSelectedTown(selectedTown);
    console.log(selectedTown);

    if (selectedState && selectedCity && selectedTown) {
      onAreaSelectsChange({
        state: selectedState,
        city: selectedCity,
        town: selectedTown,
      });
    }
  };

  return (
    <div>
      <select
        className="stateList"
        value={selectedState}
        onChange={handleStateChange}
      >
        <option>-- state --</option>
        {state.map((item) => (
          <option key={item.state} value={item.state}>
            {item.state}
          </option>
        ))}
      </select>
      <select
        className="cityList"
        value={selectedCity}
        onChange={handleCityChange}
      >
        <option>-- city --</option>
        {city.map((item) => (
          <option key={item.city} value={item.city}>
            {item.city}
          </option>
        ))}
      </select>
      <select
        className="townList"
        value={selectedTown}
        onChange={handleTownChange}
      >
        <option>-- town --</option>
        {town.map((item) => (
          <option key={item.town} value={item.town}>
            {item.town}
          </option>
        ))}
      </select>
    </div>
  );
}
