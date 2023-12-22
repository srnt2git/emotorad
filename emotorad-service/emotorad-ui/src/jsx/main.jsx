import { React, useEffect, useState } from 'react';
import { useError } from './errorContext';
import LoginForm from './loginForm';
import ContactList  from './contactList';
export default function Main() {
    const { error, handleError, clearError } = useError();
    const [isLoggedIn, setLoggedIn] = useState(false);   
  
    
    return (
        <>    {isLoggedIn ? <ContactList></ContactList> : <LoginForm setLoggedIn={setLoggedIn}></LoginForm>}  
           
       
        </>
    );
}