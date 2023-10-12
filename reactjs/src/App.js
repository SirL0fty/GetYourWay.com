
import "./App.css";
import { useState } from 'react';
import Header from "./Components/Header";
import Login from "./Components/Login";
import Footer from "./Components/Footer";
//import FlightSearch from "./Components/FlightSearch";
import Map from './Components/Map';

function App() {
  const [loggedIn, setLoggedIn] = useState(false);

  return (
    <div className="App">
      <Header />
      {!loggedIn && 
        <Login setLoggedIn={setLoggedIn} />
      }

      {loggedIn &&
        <Map />
      }
      {/* <FlightSearch /> */}
      <Footer />
    </div>

  );
}

export default App;
