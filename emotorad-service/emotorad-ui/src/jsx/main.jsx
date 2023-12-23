import { React, useEffect, useState } from 'react';
import { useError } from './errorContext';
import LoginForm from './loginForm';
import Home from './home';
import style from './../css/main.module.css';
export default function Main() {
    const { error, handleError, clearError } = useError();
    const [isLoggedIn, setLoggedIn] = useState(false);   
  
    
    return (
        <> {error && error.errorMessage && (
            <div className={style.errorDiv}>
                <p>Error: {error.errorMessage}</p>
                <button onClick={clearError} className={style.closebutton}> &times;</button>
            </div>
        )
        }

            {isLoggedIn ? <Home setLoggedIn={setLoggedIn}></Home> : <LoginForm setLoggedIn={setLoggedIn}></LoginForm>}  
        </>
    );
}