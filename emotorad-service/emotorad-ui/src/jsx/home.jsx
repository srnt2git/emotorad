import React, { useEffect, useState } from 'react';
import style from './../css/dashboard.module.css';
import TabCondent from './tabCondent.jsx';
import { get,post } from "./httpClient";
import { useJwt } from './jwtcontext';
import { useError } from './errorContext';
export default function Home({ setLoggedIn }) {
    const logoutStyle = {
        float: 'right'
    }
    const [tabs, setTabs] = useState({ tabs: ["Contacts", "Messaging"] });
    const [activetab, setActivetab] = useState("Users");
    const {  getJwt } = useJwt()
    const { error, handleError, clearError } = useError();
    const handleResponse = (result) => {
        setLoggedIn(false);
    }
    const handleErr = (err) => {
        handleError(err)
    }
    const updateTabs = (tabs) => {
        setTabs(tabs);
        const tab = tabs.tabs[0];
        setActivetab(tab)
    }
    const handleLogout = async () => {
        post('logout', null, handleResponse, handleErr, getJwt());
        setLoggedIn(false);
    }
    
    useEffect(() => {
        setActivetab("Contacts")
    }, []);
    
    return (<div>
                <div className={style.tab} >
                    {tabs.tabs.filter(item => item !== "").map(tab =>
                        <button onClick={() => setActivetab(tab)}>{tab}</button>
                    )}
                    <button onClick={handleLogout} style={logoutStyle} >logout</button>
                </div>
                <TabCondent component={activetab}></TabCondent>
           </div>
  )

}