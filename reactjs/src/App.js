import "./App.css";
import { useState } from "react";
import Header from "./Components/Header";
import Login from "./Components/Login";
import Footer from "./Components/Footer";
import FlightSearch from "./Components/FlightSearch";
import Weather from "./Components/Weather";
import Map from "./Components/Map";

function App() {
  const [loggedIn, setLoggedIn] = useState(false);
  // State for user coordinates is set to invalid coordinates as initial values
  const [userLongitude, setUserLongitude] = useState(999.00);
  const [userLatitude, setUserLatitude] = useState(999.00);

  return (
    <div className="App">
      <Header />
      {!loggedIn && 
        <Login setLoggedIn={setLoggedIn} />
      }

      {loggedIn &&
        <Weather userLatitude={userLatitude} userLongitude={userLongitude} />
      }

      {loggedIn &&
        <Map userLatitude={userLatitude} setUserLatitude={setUserLatitude} userLongitude={userLongitude} setUserLongitude={setUserLongitude} />
      }

      {loggedIn &&
        <FlightSearch />
      }
      <Footer />
    </div>
  );
}

export default App;
