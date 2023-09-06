import React, { useState, useEffect } from 'react';
import AreaListGPS from './AreaListGPS';
import './UserStyles.css';


export default function GPS({ onAreaGPSChange, onLoadingChange }) {
    const [latitude, setLatitude] = useState('');
    const [longitude, setLongitude] = useState('');
    
    useEffect(() => {
        if ("geolocation" in navigator) {
            navigator.geolocation.getCurrentPosition(function (position) {
                const newLatitude = position.coords.latitude.toFixed(6);
                const newLongitude = position.coords.longitude.toFixed(6);

                setLatitude(newLatitude);
                setLongitude(newLongitude);

            });
        } else {
            alert("Geolocation is not available on this device.");
        }
    }, []);

    return (
        <div>
            <AreaListGPS 
                latitude={latitude} 
                longitude={longitude} 
                onAreaGPSChange={onAreaGPSChange}
                onLoadingChange={onLoadingChange}
            /> 
        </div>
    );
};
