package com.osprey.exception;

import com.osprey.aircraft.Aircraft;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.ZonedDateTime;

@ControllerAdvice
public class AircraftNotFoundHandler {

    @ResponseBody
    @ExceptionHandler(AircraftNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleAircraftNotFoundException(AircraftNotFoundException e){

        AircraftNotFound exception = new AircraftNotFound(
                e.getMessage(),
                e,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );

        return new ResponseEntity(exception, HttpStatus.NOT_FOUND);

    }
}
