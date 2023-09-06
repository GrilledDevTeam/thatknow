import "App.css";
import React , { useState, useEffect } from "react";
import DressCodeSuggestion from "./components/dressCode/DressCodeSuggestion";
import User from './components/user/User';
import WeatherGraph from "./components/weatherGraph/WeatherGraph";
import APIContext from "./components/user/contexts/APIContext";
import WeatherTable from "components/user/WeatherTable";

 function Thatknow() {

    const [weatherData, setWeatherData] = useState([]);
    const [clothingData, setClothingData] = useState([]);
    const [messageData, setMessageData] = useState([]);


    return (
    <div className="container-fluid">
        <div className="row g-1">
            <div className="col-6 border border-4">
                <APIContext.Provider value={{weatherData, setWeatherData, clothingData, setClothingData, messageData, setMessageData}}>
                    <User />
                </APIContext.Provider>
            </div>
            <div className="col-6 border border-4 border-dark">
                {weatherData && <WeatherGraph />}    
            </div>
            <div className="col-6 border border-4 border-dark">    

            </div>
            <div className="col-6 border border-4 border-dark">
                {clothingData && <DressCodeSuggestion clothingData={clothingData} messageData={messageData}/>}
            </div>
        </div>
        <div>
            <WeatherTable data={weatherData} />
        </div>
    </div>
    )
 }

 export default Thatknow;