import React, { useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faPlane,
  faCalendarAlt,
  faUser,
  faLocationArrow,
} from "@fortawesome/free-solid-svg-icons";
import { faMap } from "@fortawesome/free-regular-svg-icons";
import "../css/FlightSearch.css";

const FlightList = ({ flights }) => (
  <div className="flight-list">
    <h2>Flights</h2>
    <ul>
      {flights.map((flight) => (
        <li key={flight.id}>
          {/* Display flight information here */}
          {flight.origin} to {flight.destination} on {flight.departureDate}
        </li>
      ))}
    </ul>
  </div>
);

const FlightSearchForm = () => {
  const [origin, setOrigin] = useState("");
  const [departureDate, setDepartureDate] = useState("");
  const [destination, setDestination] = useState("");
  const [adults, setAdults] = useState(1);
  const [children, setChildren] = useState(0);
  const [destinationOptions, setDestinationOptions] = useState([]);
  const [flightResults, setFlightResults] = useState([]);

  // Function to fetch the user's location
  const handleGetLocation = () => {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        (position) => {
          // Get the user's latitude and longitude
          const userLatitude = position.coords.latitude.toFixed(4);
          const userLongitude = position.coords.longitude.toFixed(4);
          setOrigin(`${userLatitude}, ${userLongitude}`);
        },
        (error) => {
          console.error(error);
          alert("Failed to fetch location. Please try again later.");
        }
      );
    } else {
      alert("Geolocation is not supported by your browser.");
    }
  };
  const handleSubmit = async (event) => {
    event.preventDefault();

    const queryParams = new URLSearchParams({
      origin,
      destination,
      departureDate,
      adults,
      children,
    });

    try {
      const response = await fetch(
        `http://localhost:8081/api/flights/search?${queryParams}`
      );
      if (response.ok) {
        const data = await response.json();
        setFlightResults(data);

        console.log(data);
      } else {
        console.error("API request failed");
      }
    } catch (error) {
      console.error("An error occurred while making the API request:", error);
    }
  };

  return (
    <>
      <form className="flight-search-form" onSubmit={handleSubmit}>
        <div className="side-by-side">
          <div className="form-group">
            <label htmlFor="origin">Origin (auto-detected)</label>
            <div className="input-icon">
              <FontAwesomeIcon icon={faMap} className="circle-icon" />
              <input
                type="text"
                name="origin"
                id="origin"
                className="input"
                placeholder="Origin"
                value={origin}
                onChange={(e) => setOrigin(e.target.value)}
                disabled
              />
              <FontAwesomeIcon
                icon={faLocationArrow} // Use the location icon here
                className="location-icon"
                onClick={handleGetLocation} // Add an onClick handler for the icon
              />
            </div>
          </div>

          <div className="form-group">
            <label htmlFor="destination">Destination</label>
            <div className="input-icon">
              <FontAwesomeIcon icon={faPlane} className="circle-icon" />
              <select
                name="destination"
                id="destination"
                className="input"
                value={destination}
                onChange={(e) => setDestination(e.target.value)}
              >
                <option value="">Select a destination</option>
                {destinationOptions.map((option) => (
                  <option key={option.id} value={option.id}>
                    {option.name}
                  </option>
                ))}
              </select>
            </div>
          </div>

          <div className="form-group">
            <label htmlFor="departure-date">Departure Date</label>
            <div className="input-icon">
              <FontAwesomeIcon icon={faCalendarAlt} className="circle-icon" />
              <input
                type="date"
                name="departure-date"
                id="departure-date"
                className="input"
                value={departureDate}
                onChange={(e) => setDepartureDate(e.target.value)}
              />
            </div>
          </div>
        </div>

        <div className="side-by-side">
          <div className="form-group">
            <label htmlFor="adults">Adults</label>
            <div className="input-icon">
              <FontAwesomeIcon icon={faUser} className="circle-icon" />
              <select
                name="adults"
                id="adults"
                className="input"
                value={adults}
                onChange={(e) => setAdults(e.target.value)}
              >
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
              </select>
            </div>
          </div>

          <div className="form-group">
            <label htmlFor="children">Children</label>
            <div className="input-icon">
              <FontAwesomeIcon icon={faUser} className="circle-icon" />
              <select
                name="children"
                id="children"
                className="input"
                value={children}
                onChange={(e) => setChildren(e.target.value)}
              >
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
              </select>
            </div>
          </div>
        </div>

        <button type="submit" className="button">
          Search Flights
        </button>
      </form>
      {flightResults.length > 0 && <FlightList flights={flightResults} />}
    </>
  );
};

export default FlightSearchForm;
