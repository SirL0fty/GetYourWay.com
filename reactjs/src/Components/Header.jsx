import React from "react";
import "bootstrap/dist/css/bootstrap.css";
import "../css/Header.css";
import "bootstrap/dist/js/bootstrap.min.js";
import { useState, useEffect } from "react";

import getYourWayLogo from "../images/logo.png";
import profilePicture from "../images/Avatar.png";

const Header = () => {
  const [username, setUsername] = useState("");

  useEffect(() => {
    fetch("http://localhost:8081/users/user") // Make a GET request to the endpoint
      .then((response) => response.text())
      .then((data) => setUsername(data))
      .catch((error) => console.error(error));
  }, []);

  return (
    <nav className="navbar navbar-expand-lg">
      <div className="container mt-2">
        <a className="navbar-brand" href="#">
          <img
            style={{ width: "10em" }}
            src={getYourWayLogo}
            alt="Get Your Way"
          />
        </a>

        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#menu"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="menu">
          <ul className="navbar-nav ms-auto">
            <li className="nav-item">
              <a style={{ color: "black" }} href="#" className="nav-link">
                Home
              </a>
            </li>
            <li className="nav-item">
              <a style={{ color: "black" }} href="#" className="nav-link">
                About Us
              </a>
            </li>
            <li className="nav-item">
              <a
                style={{
                  pointerEvents: "none",
                  cursor: "default",
                  color: "black",
                }}
                className="nav-link"
              >
                Welcome, {username}
              </a>
            </li>
            <li className="nav-item" style={{ float: "right" }}>
              <img
                className="mt-2"
                style={{ width: "2em" }}
                src={profilePicture}
                alt="Profile picture"
              />
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Header;
