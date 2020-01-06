package com.stackroute.muzix.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.stackroute.muzix")
public class GlobalException {


    @ExceptionHandler(TrackAlreadyExistsException.class)
    public ResponseEntity<Object> message(TrackAlreadyExistsException exception) {
        System.out.println("inside Message method");
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<Object> message(TrackNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> message(Exception exception) {
        return new ResponseEntity<>("Internal Server Error", HttpStatus.CONFLICT);
    }
}

