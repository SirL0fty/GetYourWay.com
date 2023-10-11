import { React, useRef, useEffect, useState } from 'react'
import mapboxgl from 'mapbox-gl';
import 'mapbox-gl/dist/mapbox-gl.css'
import '../css/Map.css'

const Map = () => {
  mapboxgl.accessToken = process.env.REACT_APP_MAPBOX_API_KEY;

  const mapContainer = useRef(null);
  const map = useRef(null);
  const [longitude, setLongitude] = useState(-3.1883);
  const [latitude, setLatitude] = useState(55.9533);
  const [zoom, setZoom] = useState(7);

  useEffect(() => {
    if (map.current) return;
    map.current = new mapboxgl.Map({
      container: mapContainer.current,
      style: 'mapbox://styles/mapbox/streets-v12',
      center: [longitude, latitude],
      zoom: zoom
    });
  });

  return (
    <>
      <div ref={mapContainer} className='map-container' />
    </>
  )
}

export default Map