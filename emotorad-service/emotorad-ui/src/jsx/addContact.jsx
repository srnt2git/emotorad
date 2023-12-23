import React, { useState, useEffect } from 'react';
import { postWithHeader, getJwtToken, post } from "./httpClient";
import { useError } from './errorContext';
import { useJwt } from './jwtcontext';
export default function AddContact({ closeDialog }) {
    const [email, setEmail] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const { getJwt } = useJwt();
    const [user, setUser] = useState({
        email: '',
        phoneNumber: 1,
        contacts: [{
            email: '',
            phoneNumber: 1
        }]
    });
   
    const handleSubmit = () => {
        console.log(phoneNumber)
        console.log(email)
        const us = {            
            'email': email,
                'phoneNumber': phoneNumber,
                    'contacts': [
                        {
                            'id': 0,
                            'email': email,
                            'phoneNumber': phoneNumber
                        }
                    ]
        
        }
       
    
        post("user/saveUser", us, (data) => {
            closeDialog()
        }, (err) => { }, getJwt())
        closeDialog();
    }
    return (<div>
        <table align='center'>
            <thead>
                <tr>
                    <th colSpan='2' align='center'> <h1>Enter Details</h1></th>
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
                    <td>
                        <label>phoneNumber: </label>
                    </td>
                    <td>
                        <input name="phoneNumber" type="text" value={phoneNumber} onChange={(e) => setPhoneNumber(e.target.value)} />
                    </td>
                </tr>

                <tr>
                    <td colSpan='2' align='center'>
                        <button onClick={handleSubmit} >Submit</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>)

}