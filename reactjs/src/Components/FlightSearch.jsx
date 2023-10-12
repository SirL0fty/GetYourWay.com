import React, { useState, useEffect } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faPlane,
  faCalendarAlt,
  faUser,
} from "@fortawesome/free-solid-svg-icons";
import { faMap } from "@fortawesome/free-regular-svg-icons";
import "../css/FlightSearch.css";

const FlightSearchForm = () => {
  const [origin, setOrigin] = useState("");
  const [departureDate, setDepartureDate] = useState("");
  const [destination, setDestination] = useState("");
  const [adults, setAdults] = useState(1);
  const [children, setChildren] = useState(0);
  const [destinationOptions, setDestinationOptions] = useState([]);

  const handleSubmit = (event) => {
    event.preventDefault();
    // Submit the form data to your API
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
    </>
  );
};

export default FlightSearchForm;
