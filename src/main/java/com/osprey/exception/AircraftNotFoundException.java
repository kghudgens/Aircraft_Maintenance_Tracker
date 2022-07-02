package com.osprey.exception;

import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Map to only not found http statuses
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class AircraftNotFoundException extends RuntimeException{

    AircraftNotFoundException(String message) {
        super(message);
    }

    AircraftNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
