import React, { useState, useEffect } from 'react';
import { postWithHeader, getJwtToken } from "./httpClient";
import { useError } from './errorContext';
import { useJwt } from './jwtcontext';

export default function LoginForm({ setLoggedIn }) {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const { handleJwt } = useJwt();
    const headers = {
        'email': email
       
    }
    const handleLoginError = (er) => {
        console.log("Login failed" + JSON.stringify(er));
        handleError(er)
        setLoggedIn(false);
    }
    const { handleError } = useError();
    const handleLogin = (event) => {
        event.preventDefault();
        postWithHeader("login", headers, null, (data) => {
        }, handleLoginError, (headers) => {
            console.log("from header");
           const auth= headers.get("Authorization");
           handleJwt(auth)
           setLoggedIn(true);
        })            
    };

    return (<div>
        <table align='center'>
            <thead>
                <tr>
                    <th colSpan='2' align='center'> <h1>Login</h1></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <label>Email: </label>
                    </td>
                    <td>
                        <input name="email" type="text" value={email} onChange={(e) => setEmail(e.target.value)} />
                    </td>
                </tr>
                
                <tr>
                    <td colSpan='2' align='center'>
                        <button onClick={handleLogin} >Login</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>)
}

