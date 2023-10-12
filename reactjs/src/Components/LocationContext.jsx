import { createContext, useContext, useState } from "react";

const LocationContext = createContext();

export function useLocation() {
  return useContext(LocationContext);
}

export function LocationProvider({ children }) {
  const [userLatitude, setUserLatitude] = useState();
  const [userLongitude, setUserLongitude] = useState();

  const setLocation = (latitude, longitude) => {
    setUserLatitude(latitude);
    setUserLongitude(longitude);
  };

  return (
    <LocationContext.Provider
      value={{ userLatitude, userLongitude, setLocation }}
    >
      {children}
    </LocationContext.Provider>
  );
}
