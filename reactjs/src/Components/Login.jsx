import React from 'react'
import 'bootstrap/dist/css/bootstrap.css';
import '../css/Login.css';
import { useState } from 'react'
import getYourWayLogo from '../images/IMG-7504.jpg'

// const salt = bcrypt.genSaltSync(10);

const Login = (props) => {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();

        const body = new FormData();
        body.append("username", username);
        body.append("password", password);
        
        try {
            const response = await fetch('http://localhost:8081/login', {
                method: 'POST',
                body,
                credentials: "include"
            })

            if (response.ok) {
                props.setLoggedIn(true);
            } else {
                setMessage('Authentication failed');
            }
        } catch (error) {
            console.error('Error', error);
        }
    };

    return (
        <>

            <div className="container" >
                <form className="login-form" onSubmit={handleSubmit}>
                    <div className="box">
                        <img style={{ width: "20em" }} src={getYourWayLogo} alt="Get Your Way" />
                        <div className="form-group">
                            <label for="exampleInputEmail1">Email address </label>
                            <input type="text" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter username"
                                value={username}
                                onChange={(e) => setUsername(e.target.value)} />
                        </div>
                        <div className="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" className="form-control" id='password'
                                value={password}
                                onChange={(e) => setPassword(e.target.value)} />
                        </div>
                        <div className="form-group form-check">
                            {/* <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
        <label className="form-check-label" for="exampleCheck1">Check me out</label> */}
                            <input type="checkbox" id="tfa" className="tfa" name="tfa" value="true" />
                            <label for="accept"> Would you like to opt for Two Factor Authentication </label>
                        </div>
                        <button type="submit" className="btn btn-primary">
                            Submit
                        </button>
                        <span>{message}</span>
                        {/* <span>Your saltcheck:{salt}</span> */}

                    </div>
                </form>
            </div>

        </>
    )



}

export default Login




// const [password, setPassword] = useState('');

// const emailref = useRef()
// //    const passref=useRef()

// function handleLoginForm() {

//     const email = emailref.current.value
//     const password = passref.current.value
//     const hashedpass = bcrypt.hashSync(password, '$2a$10$pvg0k6JXbHnDHyt7TggehO')
//     fetch('https://api.sampleapis.com/codingresources/codingResources', {
//         method: 'POST',
//         headers: {
//             Accept: 'application/json',
//             'Content-Type': 'application/json',
//         },
//         body: JSON.stringify({
//             email: email,
//             password: hashedpass,
//         }),
//     })

// }