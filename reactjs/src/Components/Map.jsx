import { React, useRef, useEffect, useState } from 'react'
import mapboxgl from 'mapbox-gl';
import 'mapbox-gl/dist/mapbox-gl.css'
import axios from 'axios';
import '../css/Map.css'

const Map = (props) => {
  mapboxgl.accessToken = process.env.REACT_APP_MAPBOX_API_KEY;

  const mapContainer = useRef(null);
  const map = useRef(null);
  //longitude and latitude for the center of the map
  const [lng, setLng] = useState(-5.0315);
  const [lat, setLat] = useState(48.5841);
  const [zoom, setZoom] = useState(3.2);

  const [programmes, setProgrammes] = useState([]);

  const geojson = {
    type: 'FeatureCollection',
    features: [
      {
        type: 'Feature',
        geometry: {
          type: 'Point',
          coordinates: [7.0143, 43.5515]
        },
        properties: {
          title: 'Programme 1',
          description: 'Cannes, France'
        }
      },
      {
        type: 'Feature',
        geometry: {
          type: 'Point',
          coordinates: [-0.1086, 51.5079]
        },
        properties: {
          title: 'Programme 2',
          description: 'London, United Kingdom'
        }
      }
    ]
  };

  useEffect(() => {
    const initialiseMap = async () => {
      if (map.current) {
        return
      }

      map.current = new mapboxgl.Map({
        container: mapContainer.current,
        style: 'mapbox://styles/mapbox/streets-v12',
        center: [lng, lat],
        zoom: zoom
      });

      // Obtains the user's current location if the user has allowed it
      let geolocate = new mapboxgl.GeolocateControl({
        positionOptions: {
          enableHighAccuracy: true
        },
        trackUserLocation: true,
        showUserHeading: true
      })

      map.current.addControl(geolocate);

      geolocate.on("geolocate", (e) => {
        props.setUserLongitude(e.coords.longitude.toFixed(4));
        props.setUserLatitude(e.coords.latitude.toFixed(4));
      });

      map.current.on('move', () => {
        setLng(map.current.getCenter().lng.toFixed(4));
        setLat(map.current.getCenter().lat.toFixed(4));
        setZoom(map.current.getZoom().toFixed(2));
      });

      const response = await axios.get("http://localhost:8081/getAllProgramme", { withCredentials: true })

      for (const programme of response.data) {
        const element = document.createElement('div');
        element.className = 'marker';
        new mapboxgl.Marker(element)
          .setLngLat([programme.location.longitude, programme.location.latitude])
          .setPopup(
            new mapboxgl.Popup({ offset: 25 })
              .setHTML(
                `<p>${programme.title}</p><p>${programme.genre}</p>`
              )
          )
          .addTo(map.current);
      }
    }
    initialiseMap();
  }, []);

  return (
    <>
      <div ref={mapContainer} className='map-container' />
    </>
  )
}

export default Map