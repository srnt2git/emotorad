import { useEffect } from "react";
import { useJwt } from './jwtcontext';
export const post = async (url, payLoad, handleResponse, handleError, jwt) => {
        const headers = {
            'Content-Type': 'application/json',
            'Authorization': jwt
        }
        invokeHttp(url, 'POST', headers, payLoad, handleResponse, handleError)
}
export const postWithHeader = async (url, headers, payLoad, handleResponse, handleError, handleHeaders) => {
     invokeHttp(url, 'POST', headers, payLoad, handleResponse, handleError, handleHeaders)
}
export const get = async (url, payLoad, handleResponse, handleError, jwt) => {
       const headers = {
            'Content-Type': 'application/json',
            'Authorization': jwt
        }
        invokeHttp(url, 'GET', headers, payLoad, handleResponse, handleError)
}
export const getJwtToken = async (url, payLoad, handleResponse, handleError, handleHeaders) => {
    const headers = {
        'Content-Type': 'application/json'
       
    }
    invokeHttp(url, 'GET', headers, payLoad, handleResponse, handleError, handleHeaders)
}

export const del = async (url, payLoad, handleResponse, handleError, jwt) => {
        const headers = {
            'Content-Type': 'application/json',
            'Authorization': jwt
        }
    invokeHttp(url, 'DELETE', headers, payLoad, handleResponse, handleError)
    }
export const put = async (url, payLoad, handleResponse, handleError, jwt) => {
            const headers = {
            'Content-Type': 'application/json',
            'Authorization': jwt
        }
        invokeHttp(url, 'PUT', headers, payLoad, handleResponse, handleError)
    }
export const useFetch = async (url, handleResponse, handleErr, render) => {
    const { getJwt } = useJwt()
    useEffect(() => {
        get(url, null, handleResponse, handleErr, getJwt())
    }, [render]);

}

const invokeHttp = async (url, method, headers, payLoad, handleResponse, handleError,handleHeaders) => {

        try {
            const CONTEXT = process.env.REACT_APP_CONTEXT;
            var response;
           // console.log("The PayLoad " + JSON.stringify(payLoad))
            if (payLoad) {
                 response = await fetch(CONTEXT + url, {
                    method: method,
                    headers:headers,
                    body: JSON.stringify(payLoad),
                });
            } else {
               
                 response = await fetch(CONTEXT + url, {
                    method: method,
                     headers: headers,
                    body:null
                  
                });
            }
            if (handleHeaders) {
                const headers = await response.headers;
                handleHeaders(headers);

            }
            if (response.ok) {
                const contentType = await response.headers.get('content-type');
                if (contentType) {
                    if (contentType.includes('application/json')) {
                        const result = await response.json();
                        handleResponse(result);
                    } else if (contentType.includes('application/text')) {
                        //console.log("The Response is not in JSON format" + contentType);
                        handleResponse(response);
                    }
                } else {
                    // console.log("The Response is not in JSON format" + response);
                    // handleResponse(response);
                }

            } else if (response.status === 400) {
                throw new Error("Bad Request Valid Values for submitting the form");
            } else if (response.status === 401) {
                throw new Error("Failed to Authendicate the request login again");
            }

        } catch (error) {
            console.log('Error:', error);
            const err = { 'errorMessage': error.message }
            handleError(err)
        }

       
    }
