package com.stackroute.muzix.exceptions;

public class TrackAlreadyExistsException extends RuntimeException {
    private String message;

    public TrackAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
