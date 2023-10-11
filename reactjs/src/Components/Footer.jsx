import React from 'react'
import 'bootstrap/dist/css/bootstrap.css';
import '../css/Footer.css'

import getYourWayLogo from '../images/getyourwaylogo.png'

const Footer = () => {
  return (
    <footer className='bg-dark text-white text-center position-relative'>
        <div className="container d-flex pt-3 mb-3 ms-auto">
            <ul className='list-unstyled'>
                <li>
                    <a href="#">Home</a>
                </li>
                <li>
                    <a href="#">About Us</a>
                </li>
                <li className='mt-3'>Logged in as _</li>
                <li>
                    <a href="#">Log out</a>
                </li>
            </ul>
            <ul className='list-unstyled ms-auto'>
                <li>
                    <h5>Contact us</h5>
                </li>
                <li>
                    <a href="#">Email</a>
                </li>
                <li>Phone: +44 12345</li>
            </ul>
            
        </div>
        <div className="container">
            <p>J-KAMP &copy; Copyright All Rights Reserved</p>
        </div>
    </footer>
  )
}

export default Footer