package com.example.server.service.CustomException;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{
    private String message;
    private HttpStatus status;

    public CustomException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public CustomException(String message, HttpStatus status, Exception error) {
        super(error);
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
