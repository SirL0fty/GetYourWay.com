import "./App.css";
import Header from "./Components/Header";
import Login from "./Components/Login";
import Footer from "./Components/Footer";
import FlightSearch from "./Components/FlightSearch";

function App() {
  return (
    <div className="App">
      <Header />
      <Login />
      <FlightSearch />
      <Footer />
    </div>
  );
}

export default App;
