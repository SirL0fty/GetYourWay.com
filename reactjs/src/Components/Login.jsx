import React from 'react'
import 'bootstrap/dist/css/bootstrap.css';
import '../css/Login.css';
import getYourWayLogo from '../images/IMG-7504.jpg'


const Login = () => {
    // const inputStyle = {
    //     width: '200px',
    //     padding: '50px',
    // };
  return (
    <>
  
    <div className="container" >
<form className="login-form">
    <div className="box">
    <img style={{width: "20em"}} src={getYourWayLogo} alt="Get Your Way" />
    <div className="form-group">
        <label for="exampleInputEmail1">Email address </label>
        <input type="email" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" />
        <small id="emailHelp" className="form-text text-muted">We'll never share your email with anyone else.</small>
    
    </div>
    <div className="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" className="form-control" id="exampleInputPassword1" placeholder="Password" />
    </div>
     <div className="form-group form-check">
        {/* <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
        <label className="form-check-label" for="exampleCheck1">Check me out</label> */}
        <input type="checkbox" id="tfa" className="tfa" name="tfa" value="true"/>  
        <label for="accept"> Would you like to opt for Two Factor Authentication </label>
    </div>
    <button type="submit" className="btn btn-primary">Submit</button>
    </div>
</form>
</div>

</>
)



    }

export default Login