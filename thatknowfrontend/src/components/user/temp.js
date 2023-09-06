import React, { useState } from 'react';
import axios from 'axios';
import WeatherTable from './WeatherTable';
import './UserStyles.css';


function SearchWeatherGPS({ item, weatherData, onWeatherDataChange }) {
    //const [weatherData, setWeatherData] = useState([]);
    console.log(item);
    const [nx, setNx] = useState('');
    const [ny, setNy] = useState('');

    const handleSearchWeatherButton = () => {
        if (item) {
            console.log(item)
            axios.post("/api/searchWeatherByGridXY" , {
                nx: item.nx,
                ny: item.ny
            },
            {
                headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                }
            })
            .then(response => {
                //setWeatherData(response.data);
                console.log(response.data);
                onWeatherDataChange(response.data);
                setNx(item.nx);
                setNy(item.ny);
            })
            .catch(error => {
                console.error("Error fetching area data:", error);
            });
        }
    }

    
    return (
        <div>
            <button className="searchButton" onClick={handleSearchWeatherButton}>GPS확인</button>
            
        </div>
    );
}

function SearchWeatherSelect({ state, city, town }) {
    const [weatherData, setWeatherData] = useState([]);

    const handleSearchWeatherButton = () => {
        if (state && city && town) {
            axios.post("/api/searchWeatherByArea" , {
                state: state,
                city: city,
                town: town
            },
            {
                headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                }
            })
            .then(response => {
                setWeatherData(response.data);
                console.log(weatherData);
            })
            .catch(error => {
                console.error("Error fetching area data:", error);
            });
        }
    }

    
    return (
        <div>
            <button className="searchButton" onClick={handleSearchWeatherButton}>Select확인</button>
            {/* <WeatherTable data={weatherData} /> */}
        </div>
    );
}

export { SearchWeatherGPS, SearchWeatherSelect };