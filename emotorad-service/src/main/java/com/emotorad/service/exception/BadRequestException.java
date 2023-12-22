package com.emotorad.service.exception;

import org.apache.http.HttpHeaders;

public class BadRequestException extends RuntimeException {

    private final int status;
    private final HttpHeaders headers;
    private final String body;


    public BadRequestException(int status, HttpHeaders headers, String body) {
        super("Bad request");
        this.status = status;
        this.headers = headers;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

// Getters for errorMessage and errorCode
}
