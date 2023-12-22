// JWTContext.js
import React, { createContext, useState, useContext } from 'react';

const JWTContext = createContext();

export const useJwt = () => {
    return useContext(JWTContext);
};
export const UseJwt = () => {
    return useContext(JWTContext);
};
export const JwtProvider = ({ children }) => {
    const [jwt, setJwt] = useState(null);
    const clearJwt = () => {
        setJwt(null);
    };
    const handleJwt=(jwt)=>{
        setJwt(jwt);
    }
    const getJwt = () => {
        return jwt;
    };
    
    return (
        <JWTContext.Provider value={{handleJwt, getJwt }}>
            {children}
        </JWTContext.Provider>
    );
};
