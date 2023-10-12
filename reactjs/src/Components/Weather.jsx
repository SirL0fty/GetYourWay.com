import { React, useState } from 'react'
import axios from 'axios';

const Weather = (props) => {
    const [temperature, setTemperature] = useState(0.0)

    const fetchTemperature = async () => {
        if (props.userLatitude === 999.00 || props.userLongitude === 999.00) return;

        const result = await axios.get("http://localhost:8081/getCurrentWeatherByCoordinates?latitude=" + props.userLatitude + "&longitude=" + props.userLongitude, { withCredentials: true });

        setTemperature(result.data.data[0].coordinates[0].dates[0].value);
    };

    fetchTemperature();
    
    return (
        <>
            {temperature != 0.0 && 
                <h4>Temperature in your location: {temperature}°C</h4>
            }
        </>
    )
}

export default Weather