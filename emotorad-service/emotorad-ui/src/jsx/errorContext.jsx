// ErrorContext.js
import React, { createContext, useState, useContext } from 'react';

const ErrorContext = createContext();

export const useError = () => {
    return useContext(ErrorContext);
};

export const ErrorProvider = ({ children }) => {
    const [error, setError] = useState();

    const handleError = (err) => {
        setTimeout(() => {
            clearError();
        }, 5000);
        setError(err);
       
    };

    const clearError = () => {
        setError(null);
    };

    return (
        <ErrorContext.Provider value={{ error, handleError, clearError }}>
            {children}
        </ErrorContext.Provider>
    );
};
