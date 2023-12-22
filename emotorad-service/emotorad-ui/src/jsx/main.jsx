import { React, useEffect, useState } from 'react';
import { useError } from './errorContext';
import LoginForm from './loginForm';
import Home from './home';
export default function Main() {
    const { error, handleError, clearError } = useError();
    const [isLoggedIn, setLoggedIn] = useState(false);   
  
    
    return (
        <>    {isLoggedIn ? <Home></Home> : <LoginForm setLoggedIn={setLoggedIn}></LoginForm>}  
           
       
        </>
    );
}