import { React, useRef, useEffect, useState } from 'react'
import mapboxgl from 'mapbox-gl';
import { Marker } from 'mapbox-gl'
import 'mapbox-gl/dist/mapbox-gl.css'
import '../css/Map.css'

const Map = () => {
  mapboxgl.accessToken = process.env.REACT_APP_MAPBOX_API_KEY;

  const mapContainer = useRef(null);
  const map = useRef(null);
  const [lng, setLng] = useState(-5.0315);
  const [lat, setLat] = useState(48.5841);
  const [zoom, setZoom] = useState(3.2);

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
          title: 'Mapbox',
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
          title: 'Mapbox',
          description: 'London, United Kingdom'
        }
      }
    ]
  };

  useEffect(() => {
    if (map.current) return;
    map.current = new mapboxgl.Map({
      container: mapContainer.current,
      style: 'mapbox://styles/mapbox/streets-v12',
      center: [lng, lat],
      zoom: zoom
    });

    map.current.on('move', () => {
      setLng(map.current.getCenter().lng.toFixed(4));
      setLat(map.current.getCenter().lat.toFixed(4));
      setZoom(map.current.getZoom().toFixed(2));
    });

    map.current.on('load', () => {
      for (const feature of geojson.features) {
        const element = document.createElement('div');
        element.className = 'marker';
        new mapboxgl.Marker(element)
          .setLngLat(feature.geometry.coordinates)
          .addTo(map.current);
      }
    });
  });

  return (
    <>
      <div>
        Latitude: {lat}, Longitude: {lng}
      </div>
      <div ref={mapContainer} className='map-container' />
    </>
  )
}

export default Map